package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CreaturePool;
import model.Move;
import model.Move.Category;
import model.Move.StatusEffect;
import model.Move.Type;

class MoveTest {

	Move move;
	@Test
	void getMoves() {
		move = new Move("Thunderbolt", Category.PHYSICAL, Type.ELECTRIC, 60);
		assertEquals(move.getName(), "Thunderbolt");
		assertEquals(move.getMoveCategory(), Category.PHYSICAL);
		assertEquals(move.getMoveType(), Type.ELECTRIC);
		assertEquals(move.getPower(), 60);
	}
	
	@Test
	void test2() {
		move = new Move("Tail Whip", Category.STATUS, StatusEffect.DEFENSE_DOWN, 1);
		assertEquals(move.getName(), "Tail Whip");
		assertEquals(move.getMoveCategory(), Category.STATUS);
		assertEquals(move.getEffect(), StatusEffect.DEFENSE_DOWN);
		assertEquals(move.getEffectLevel(), 1);
	}
}
