package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.Move.Category;
import model.Move.StatusEffect;
import model.Move.Type;
import model.Move.StatusEffect;

public class CreaturePool {

    private static final Creature[] CREATURES = {
  
        new Creature("Pikachu",      180,  103, 76, new ArrayList<Move>(), "/sprites/pokemon/pikachu.png"),
        new Creature("Bulbasaur",   200, 92, 92, new ArrayList<Move>(), "/sprites/pokemon/bulbasaur.png"),
        new Creature("Charmander",   188,  98, 81, new ArrayList<Move>(), "/sprites/pokemon/charmander.png"),
        new Creature("Squirtle",    198, 90, 121, new ArrayList<Move>(), "/sprites/pokemon/squirtle.png"),
        new Creature("Jigglypuff",  340, 85, 40, new ArrayList<Move>(), "/sprites/pokemon/jigglypuff.png"),
        new Creature("Yoshi",       350, 170, 170, new ArrayList<Move>(), "/sprites/pokemon/yoshi.png"),
        new Creature("Poliwhirl",   110, 53, 50, new ArrayList<Move>(), "/sprites/pokemon/poliwhirl.png"),
        new Creature("Gloom",       230, 121, 130, new ArrayList<Move>(), "/sprites/pokemon/gloom.png"),
        new Creature("Psyduck",     210,  98, 90, new ArrayList<Move>(), "/sprites/pokemon/psyduck.png"),
        new Creature("Goldeen",     200,  125, 112, new ArrayList<Move>(), "/sprites/pokemon/goldeen.png"),
        new Creature("Dratini",     192, 119, 85, new ArrayList<Move>(), "/sprites/pokemon/dratini.png"),
        new Creature("Meowth",      190,  85, 67, new ArrayList<Move>(), "/sprites/pokemon/meowth.png")
    };
    
    private static final Move[] MOVES = {
    		  
            new Move("Thunderbolt", Category.PHYSICAL, Type.ELECTRIC, 60),
            new Move("Surf", Category.PHYSICAL, Type.WATER, 60),
            new Move("Solar Beam", Category.PHYSICAL,  Type.GRASS, 80),
            new Move("Sludge Wave", Category.PHYSICAL,  Type.POISON, 65),
            new Move("Flare Blitz", Category.PHYSICAL,  Type.FIRE, 80),
            new Move("Dragon Rush", Category.PHYSICAL,  Type.DRAGON, 70),
            new Move("Hydro Pump", Category.PHYSICAL,  Type.WATER, 75),
            new Move("Ice Punch", Category.PHYSICAL,  Type.ICE, 50),
            new Move("Take Down", Category.PHYSICAL,  Type.NORMAL, 40),
            new Move("Disarming Voice", Category.PHYSICAL,  Type.FAIRY, 25),
            new Move("Hyper Beam", Category.PHYSICAL,  Type.NORMAL, 100),
            new Move("Draco Meteor", Category.PHYSICAL,  Type.DRAGON, 85),
            new Move("Bubble Beam", Category.PHYSICAL, Type.WATER, 45),
            new Move("Body Slam", Category.PHYSICAL, Type.NORMAL, 55),
            new Move("Energy Ball", Category.PHYSICAL, Type.GRASS, 60),
            new Move("Scratch", Category.PHYSICAL, Type.NORMAL, 25),
            new Move("Poison Jab", Category.PHYSICAL, Type.POISON, 60),
            new Move("Ice Beam", Category.PHYSICAL, Type.ICE, 60),
            new Move("Outrage", Category.PHYSICAL, Type.DRAGON, 80),
            new Move("Slash", Category.PHYSICAL, Type.NORMAL, 45),
            new Move("Play Rough", Category.PHYSICAL, Type.FAIRY, 60),
            //21
            new Move("Tail Whip", Category.STATUS, StatusEffect.DEFENSE_DOWN, 1),
            new Move("Charm", Category.STATUS, StatusEffect.ATTACK_DOWN, 2),
            new Move("Protect", Category.STATUS, StatusEffect.NO_EFFECT, 0),
            new Move("Work Up", Category.STATUS, StatusEffect.ATTACK_UP, 1),
            new Move("Swords Dance", Category.STATUS, StatusEffect.ATTACK_UP, 2),
            new Move("Defense Curl", Category.STATUS, StatusEffect.DEFENSE_UP, 1),
            new Move("Recover", Category.STATUS, StatusEffect.HP_UP, 0),
            new Move("Iron Defense", Category.STATUS, StatusEffect.DEFENSE_UP, 2)
           
        };
    /**
     * Returns the full list of all available creatures.
     */
    public Creature[] getAllCreatures() {
        return CREATURES;
        
    }
    
    public void setMoves() {    
    	List<Move> moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[21], MOVES[22]);
    	CREATURES[0].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[2], MOVES[3], MOVES[23], MOVES[24]);
    	CREATURES[1].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[4], MOVES[5], MOVES[25], MOVES[26]);
    	CREATURES[2].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[6], MOVES[7], MOVES[23], MOVES[24]);
    	CREATURES[3].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[8], MOVES[9], MOVES[22], MOVES[27]);
    	CREATURES[4].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[10], MOVES[11], MOVES[27], MOVES[28]);
    	CREATURES[5].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[12], MOVES[13], MOVES[23], MOVES[26]);
    	CREATURES[6].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[14], MOVES[3], MOVES[24], MOVES[27]);
    	CREATURES[7].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[15], MOVES[7], MOVES[21], MOVES[22]);
    	CREATURES[8].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[16], MOVES[17], MOVES[25], MOVES[21]);
    	CREATURES[9].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[18], MOVES[23], MOVES[26]);
    	CREATURES[10].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[19], MOVES[20], MOVES[22], MOVES[21]);
    	CREATURES[11].setMoves(moveSet);

    }
    
    public List<String> generateRandom(List<String> pokeStrs) {
    	List<String> retRand = new ArrayList<>();
    	Random rand = new Random();
    	
    	while (retRand.size() < 3) {
    		int currRand = rand.nextInt(12);
    		String currName = CREATURES[currRand].getName().toLowerCase();
    		if (!retRand.contains(currName) && !pokeStrs.contains(currName)) {
    			retRand.add(currName);
    		}
    	}
    	
    	return retRand;
    }

}
