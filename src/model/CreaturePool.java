package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreaturePool {

    private static final Creature[] CREATURES = {
  
        new Creature("Pikachu",      90,  55, 40, 50, new Move[4], "/sprites/pokemon/pickachu.png"),
        new Creature("Bulbasaur",   100, 50, 45, 50, new Move[4], "/sprites/pokemon/bulbasaur.png"),
        new Creature("Charmander",   95,  52, 38, 50, new Move[4], "/sprites/pokemon/charmander.png"),
        new Creature("Squirtle",    105, 48, 55, 50, new Move[4], "/sprites/pokemon/squirtle.png"),
        new Creature("Jigglypuff",  130, 45, 20, 50, new Move[4], "/sprites/pokemon/jigglypuff.png"),
        new Creature("Yoshi",       115, 50, 35, 50, new Move[4], "/sprites/pokemon/yoshi.png"),
        new Creature("Poliwhirl",   110, 53, 50, 50, new Move[4], "/sprites/pokemon/poliwhirl.png"),
        new Creature("Gloom",       100, 55, 40, 50, new Move[4], "/sprites/pokemon/gloom.png"),
        new Creature("Psyduck",     95,  50, 35, 50, new Move[4], "/sprites/pokemon/psyduck.png"),
        new Creature("Goldeen",     90,  60, 30, 50, new Move[4], "/sprites/pokemon/goldeen.png"),
        new Creature("Dratini",     105, 60, 45, 50, new Move[4], "/sprites/pokemon/dratini.png"),
        new Creature("Meowth",      85,  55, 30, 50, new Move[4], "/sprites/pokemon/meowth.png")
    };

    /**
     * Returns the full list of all available creatures.
     */
    public Creature[] getAllCreatures() {
        return CREATURES;
        
    }
    
    public void setMoves() {
//    	Move[] moveArray = {new healMove(40), new attackMove(50), new ShieldMove(25), new healMove(45)};
//    	CREATURES[0].setMoves(moveArray);
//    	
//    	CREATURES[1].setMoves(moveArray);
//    	
//    	CREATURES[2].setMoves(moveArray);
//    	
//    	CREATURES[3].setMoves(moveArray);
//    	
//    	CREATURES[4].setMoves(moveArray);
//    	
//    	CREATURES[5].setMoves(moveArray);
//    	
//    	CREATURES[6].setMoves(moveArray);
//    	
//    	CREATURES[7].setMoves(moveArray);
//    	
//    	CREATURES[8].setMoves(moveArray);
//    	
//    	CREATURES[9].setMoves(moveArray);
//    	
//    	CREATURES[10].setMoves(moveArray);
//    	
//    	CREATURES[11].setMoves(moveArray);
//    	
//    	CREATURES[12].setMoves(moveArray);
    	for (int i = 0; i<12;i++) {
    		Move Move1 = new attackMove(CREATURES[i].getAttack());
    		Move Move2 = new ShieldMove(CREATURES[i].getDefense());
    		Move Move3 = new healMove(CREATURES[i].getHeal());
    		Move Move4 = new attackMove(CREATURES[i].getAttack());
    		Move[] moveArray = {Move1,Move2,Move3,Move4};
    		CREATURES[i].setMoves(moveArray);
    	}
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
