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
  
        new Creature("Pikachu",      90,  55, 40, 100, new ArrayList<Move>(), "/sprites/pokemon/pikachu.png"),
        new Creature("Bulbasaur",   100, 50, 45, 50, new ArrayList<Move>(), "/sprites/pokemon/bulbasaur.png"),
        new Creature("Charmander",   95,  52, 38, 50, new ArrayList<Move>(), "/sprites/pokemon/charmander.png"),
        new Creature("Squirtle",    105, 48, 55, 120, new ArrayList<Move>(), "/sprites/pokemon/squirtle.png"),
        new Creature("Jigglypuff",  130, 45, 20, 50, new ArrayList<Move>(), "/sprites/pokemon/jigglypuff.png"),
        new Creature("Yoshi",       115, 50, 35, 50, new ArrayList<Move>(), "/sprites/pokemon/yoshi.png"),
        new Creature("Poliwhirl",   110, 53, 50, 50, new ArrayList<Move>(), "/sprites/pokemon/poliwhirl.png"),
        new Creature("Gloom",       100, 55, 40, 50, new ArrayList<Move>(), "/sprites/pokemon/gloom.png"),
        new Creature("Psyduck",     95,  50, 35, 50, new ArrayList<Move>(), "/sprites/pokemon/psyduck.png"),
        new Creature("Goldeen",     90,  60, 30, 50, new ArrayList<Move>(), "/sprites/pokemon/goldeen.png"),
        new Creature("Dratini",     105, 60, 45, 50, new ArrayList<Move>(), "/sprites/pokemon/dratini.png"),
        new Creature("Meowth",      85,  55, 30, 50, new ArrayList<Move>(), "/sprites/pokemon/meowth.png")
    };
    
    private static final Move[] MOVES = {
    		  
            new Move("Physical1", Category.PHYSICAL,  Type.NORMAL, 40),
            new Move("Physical2", Category.PHYSICAL,  Type.FIRE, 40),
            new Move("Physical3", Category.PHYSICAL,  Type.WATER, 40),
            new Move("Physical4", Category.PHYSICAL,  Type.GRASS, 40),
            new Move("Physical5", Category.PHYSICAL,  Type.ELECTRIC, 40),
            new Move("Physical6", Category.PHYSICAL,  Type.POISON, 40),
            new Move("Physical7", Category.PHYSICAL,  Type.DRAGON, 40),
            new Move("Physical8", Category.PHYSICAL,  Type.FAIRY, 40),
            new Move("Physical9", Category.PHYSICAL,  Type.NORMAL, 40),
            new Move("Physical10", Category.PHYSICAL,  Type.NORMAL, 40),
            new Move("Physical11", Category.PHYSICAL,  Type.NORMAL, 40),
            new Move("Physical12", Category.PHYSICAL,  Type.NORMAL, 40),
            new Move("Status1", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status2", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status3", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status4", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status5", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status6", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status7", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status8", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status9", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status10", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status11", Category.STATUS, StatusEffect.HP_UP, 10),
            new Move("Status12", Category.STATUS, StatusEffect.HP_UP, 10)

           
        };
    /**
     * Returns the full list of all available creatures.
     */
    public Creature[] getAllCreatures() {
        return CREATURES;
        
    }
    
    public void setMoves() {    
    	List<Move> moveSet = Arrays.asList(MOVES[0], MOVES[4], MOVES[12], MOVES[13]);
    	CREATURES[0].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);
    	CREATURES[1].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);
    	CREATURES[2].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);
    	CREATURES[3].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[4].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[5].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[6].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[7].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[8].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[9].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[10].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

    	CREATURES[11].setMoves(moveSet);
    	moveSet = Arrays.asList(MOVES[0], MOVES[1], MOVES[12], MOVES[13]);

  

    }
    
    public List<String> generateRandom() {
    	List<String> retRand = new ArrayList<>();
    	Random rand = new Random();
    	
    	while (retRand.size() < 3) {
    		int currRand = rand.nextInt(12);
    		String currName = CREATURES[currRand].getName().toLowerCase();
    		if (!retRand.contains(currName)) {
    			retRand.add(currName);
    		}
    	}
    	
    	return retRand;
    }
    
}
