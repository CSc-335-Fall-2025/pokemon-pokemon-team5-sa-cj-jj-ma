package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreaturePool {

    private static final Creature[] CREATURES = {
  
        new Creature("Pikachu",      90,  55, 40, new Move[4]),
        new Creature("Bulbasaur",   100, 50, 45, new Move[4]),
        new Creature("Charmander",   95,  52, 38, new Move[4]),
        new Creature("Squirtle",    105, 48, 55, new Move[4]),
        new Creature("Jigglypuff",  130, 45, 20, new Move[4]),
        new Creature("Yoshi",       115, 50, 35, new Move[4]),
        new Creature("Poliwhirl",   110, 53, 50, new Move[4]),
        new Creature("Gloom",       100, 55, 40, new Move[4]),
        new Creature("Psyduck",     95,  50, 35, new Move[4]),
        new Creature("Goldeen",     90,  60, 30, new Move[4]),
        new Creature("Dratini",     105, 60, 45, new Move[4]),
        new Creature("Meowth",      85,  55, 30, new Move[4])
    };

    /**
     * Returns the full list of all available creatures.
     */
    public Creature[] getAllCreatures() {
        return CREATURES;
        
    }
    
    public void setMoves() {
    	Move[] moveArray = {new healMove(40), new attackMove(50), new ShieldMove(25), new healMove(45)};
    	
    	CREATURES[0].setMoves(moveArray);
    	
    	CREATURES[1].setMoves(moveArray);
    	
    	CREATURES[2].setMoves(moveArray);
    	
    	CREATURES[3].setMoves(moveArray);
    	
    	CREATURES[4].setMoves(moveArray);
    	
    	CREATURES[5].setMoves(moveArray);
    	
    	CREATURES[6].setMoves(moveArray);
    	
    	CREATURES[7].setMoves(moveArray);
    	
    	CREATURES[8].setMoves(moveArray);
    	
    	CREATURES[9].setMoves(moveArray);
    	
    	CREATURES[10].setMoves(moveArray);
    	
    	CREATURES[11].setMoves(moveArray);
    	
//    	CREATURES[12].setMoves(moveArray);
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
