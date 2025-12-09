package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.CreaturePool;

class CreaturePoolTest {
	
	CreaturePool cp;
	
	@Test
	void getCreature() {
		cp = new CreaturePool();
		assertEquals(cp.getAllCreatures()[0].getName(), "Pikachu");
	}
	
	@Test
	void getMoves() {
		cp = new CreaturePool();
		cp.setMoves();
		assertEquals(cp.getAllCreatures()[0].getMoves().get(0).getName(), "Thunderbolt");
	}
	
	@Test
	void randomPok() {
		cp = new CreaturePool();
		List<String> l = new ArrayList<>();
		l.add("Pikachu");
		l.add("Bulbasaur");
		l.add("Charmander");
		cp.generateRandom(l);
	}

}
