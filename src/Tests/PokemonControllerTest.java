package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PokemonController;
import model.PokemonModel;

class PokemonControllerTest {
	private PokemonController controller;
	private PokemonModel model;
	private ArrayList<String> testList;

	@BeforeEach
	void setUp() throws Exception {
		model = new PokemonModel();
		controller = new PokemonController(model);
		model = controller.getModel();
		testList = new ArrayList<String>();
		testList.add("bulbasaur");
		testList.add("pikachu");
		testList.add("gloom");
		model.initializeTeam("TEAM1", testList, 1);
		model.initializeComputerTeam(testList);
	}

	@Test
	void test() {
		controller.getTrainer1().getCreature1().setHealth(0);
		controller.getTrainer2().getCreature1().setHealth(0);
		assertEquals(controller.getTrainer1().getCreature1().getHealth(), 0);
		assertEquals(controller.getTrainer2().getCreature1().getHealth(), 0);
		controller.resetAllHealth();
		assertEquals(controller.getTrainer1().getCreature1().getHealth(), 200);
	}
	
	@Test
	void testResetAll() {
		controller.resetAll();
		assertEquals(null, controller.getTrainer1().getActiveCreature());
		controller.createComputerTeam(testList);
		controller.createTeam("TEST5", testList, 1);
		
	}
	
	@Test
	void testComputerTurn() {
		controller.computerTurn();
		assertEquals(controller.getTrainer1().getActiveCreature().getHealth(),controller.getTrainer1().getActiveCreature().getHealth());
		controller.getTrainer1().getCreature1().setHealth(0);
		controller.getTrainer1().getCreature2().setHealth(0);
		controller.getTrainer1().getCreature3().setHealth(0);
		controller.computerTurn();
	}
	
	@Test
	void testPlayerTurn() {
		controller.playerTurn(controller.getTrainer1(), controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
		assertEquals(controller.getCurrTurn(), 2);
		controller.playerTurn(controller.getTrainer2(), controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
		controller.getTrainer1().getCreature1().setHealth(0);
		controller.getTrainer1().getCreature2().setHealth(0);
		controller.getTrainer1().getCreature3().setHealth(0);
		controller.playerTurn(controller.getTrainer2(), controller.getTrainer1().getActiveCreature().getMoves().get(0).getName());
		assertTrue(controller.isBattleOver());
		assertEquals("Computer won!", controller.getWinner());
	}
	
	@Test
	void testDifficulty() {
		Integer health = controller.getTrainer2().getCreature1().getBaseHealth();
		controller.setDifficulty(2);
		assertNotEquals(health, controller.getTrainer2().getCreature1().getHealth());
	}
	
	@Test
	void testPlayer1Win() {
		model.getTrainer1().getCreature1().setHealth(100);
		model.getTrainer1().getCreature2().setHealth(100);
		model.getTrainer1().getCreature3().setHealth(100);
		controller.getWinner();
		controller.isBattleOver();
		model.getTrainer2().getCreature1().setHealth(0);
		model.getTrainer2().getCreature2().setHealth(0);
		model.getTrainer2().getCreature3().setHealth(0);
		
		controller.isBattleOver();
		controller.getWinner();
	}
	
}
