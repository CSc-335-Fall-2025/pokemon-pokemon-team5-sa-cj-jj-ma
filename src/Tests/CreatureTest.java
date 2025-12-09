package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Creature;
import model.Move;
import model.Move.Category;
import model.PokeType;

class CreatureTest {
	private Creature testCreature;
	private List<Move> testMoves;
	@BeforeEach
	void setup() throws IOException {
		testMoves = new ArrayList<Move>();
		testMoves.add(new Move("TEST1", Category.PHYSICAL, PokeType.ELECTRIC, 60));
		testMoves.add(new Move("TEST2", Category.PHYSICAL, PokeType.FIRE, 60));
		testMoves.add(new Move("TEST3", Category.STATUS, PokeType.WATER, 60));
		testMoves.add(new Move("TEST4", Category.STATUS, PokeType.DRAGON, 60));

		testCreature = new Creature("TEST", 100, 100, 100, PokeType.NORMAL, testMoves, "EMPTY_PATH");
	}

	@Test
	void testConstructor() {
		assertEquals("TEST",testCreature.getName());
		assertEquals(100,testCreature.getDefense());
		assertEquals(100,testCreature.getBaseHealth());
		assertEquals(100,testCreature.getAttack());
		assertEquals(100,testCreature.getHealth());
		assertEquals(testMoves,testCreature.getMoves());
		assertEquals("EMPTY_PATH",testCreature.getPath());
	}
	
	@Test
	void testSetters() {
		testCreature.setAttack(0);
		testCreature.setCounter(0);
		testCreature.setDefense(0);
		testCreature.setHealth(0);
		testCreature.setCounter(10);
		
		assertEquals(0,testCreature.getDefense());
		assertEquals(0,testCreature.getAttack());
		assertEquals(0,testCreature.getHealth());
		assertEquals(10,testCreature.getCounter());
		
	}
	
	@Test
	void testSetMoves() {
		List<Move> newMoveList= new ArrayList<Move>();
		Move moveToAdd = new Move("TEST404", Category.PHYSICAL, PokeType.ELECTRIC, 60);
		newMoveList.add(moveToAdd);
		newMoveList.add(moveToAdd);
		newMoveList.add(moveToAdd);
		newMoveList.add(moveToAdd);
		testCreature.getType();
		testCreature.getBaseAttack();
		testCreature.getBaseDefense();
		testCreature.setMoves(newMoveList);
		
		assertEquals(testCreature.getMoves().get(0).getName(), "TEST404");
	}
	
	@Test
	void testToString() {
		assertEquals("Poke Name: TEST", testCreature.toString());
	}
	
	@Test
	void testIncrementCounter() {
		testCreature.setCounter(0);
		testCreature.incrementCounter();
		testCreature.setCounter(10);
		testCreature.incrementCounter();
		assertEquals(9,testCreature.getCounter());
		
	}
	
	@Test
	void testIsFainted() {
		assertEquals(false, testCreature.isCreatureFainted());
		testCreature.setHealth(0);
		assertEquals(true, testCreature.isCreatureFainted());
	}

}
