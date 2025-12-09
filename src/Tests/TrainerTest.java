package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Creature;
import model.CreaturePool;
import model.Trainer;

class TrainerTest {
	private Trainer testTrainer;

	@BeforeEach
	void setUp() throws Exception {
		testTrainer = new Trainer();
	}

	@Test
	void testConstructorAndGetters() {
		assertEquals(null, testTrainer.getName());
		assertEquals(null, testTrainer.getTeam());
		assertEquals(null, testTrainer.getActiveCreature());
	}
	
	@Test
	void testTeam() {
		List<Creature> testTeam = new ArrayList<Creature>();
		CreaturePool cp = new CreaturePool();
		testTeam.add(cp.getAllCreatures()[1]);
		testTeam.add(cp.getAllCreatures()[2]);
		testTeam.add(cp.getAllCreatures()[4]);
		testTrainer.setTeam(testTeam);
		testTrainer.manualSwap(cp.getAllCreatures()[4]);
		assertEquals(cp.getAllCreatures()[1],testTrainer.getTeam().get(0));
		assertEquals(cp.getAllCreatures()[1],testTrainer.getCreature1());
		assertEquals(cp.getAllCreatures()[2],testTrainer.getCreature2());
		assertEquals(cp.getAllCreatures()[4],testTrainer.getCreature3());
	}
	
	@Test
	void testSetName() {
		testTrainer.setName("Billy");
		assertEquals("Billy", testTrainer.getName());
	}
	
	@Test
	void testIsCreatureFained() {
		CreaturePool cp = new CreaturePool();
		Creature testCreature = cp.getAllCreatures()[0];
		assertFalse(testTrainer.isCreatureFainted(testCreature));
		testCreature.setHealth(0);
		assertTrue(testTrainer.isCreatureFainted(testCreature));
	}
	
	@Test
	void testManualSwap() {
		List<Creature> testTeam = new ArrayList<Creature>();
		CreaturePool cp = new CreaturePool();
		testTeam.add(cp.getAllCreatures()[4]);
		testTeam.add(cp.getAllCreatures()[5]);
		testTeam.add(cp.getAllCreatures()[6]);
		Creature testCreature = cp.getAllCreatures()[10];
		testTrainer.setTeam(testTeam);
		testTrainer.manualSwap(testCreature);
		System.out.println(testTrainer.getActiveCreature().getName());
		assertEquals(testTrainer.getActiveCreature().getName(),"Jigglypuff");
		testTrainer.manualSwap(cp.getAllCreatures()[1]);
		System.out.println(testTrainer.getActiveCreature().getName());
		assertNotEquals(testTrainer.getActiveCreature().getName(), "Yoshi");
	}
	
	@Test
	void testAutoSwap() {
		List<Creature> testTeam = new ArrayList<Creature>();
		CreaturePool cp = new CreaturePool();
		testTeam.add(cp.getAllCreatures()[1]);
		testTeam.add(cp.getAllCreatures()[2]);
		testTeam.add(cp.getAllCreatures()[3]);
		testTrainer.setTeam(testTeam);
		testTrainer.autoSwap();
		assertEquals(testTrainer.getActiveCreature().getName(),"Charmander");
		testTrainer.getCreature1().setHealth(0);
		testTrainer.getCreature2().setHealth(0);
		testTrainer.getCreature3().setHealth(0);
		testTrainer.autoSwap();
		
	}
	
	@Test
	void testHasLivingCreature() {
		List<Creature> testTeam = new ArrayList<Creature>();
		CreaturePool cp = new CreaturePool();
		testTeam.add(cp.getAllCreatures()[7]);
		testTeam.add(cp.getAllCreatures()[8]);
		testTeam.add(cp.getAllCreatures()[9]);
		testTrainer.setTeam(testTeam);
		assertEquals(true ,testTrainer.hasLivingCreature());
		testTrainer.getCreature1().setHealth(0);
		testTrainer.getCreature2().setHealth(0);
		testTrainer.getCreature3().setHealth(0);
		assertFalse(testTrainer.hasLivingCreature());
	}
	
	
	
}
