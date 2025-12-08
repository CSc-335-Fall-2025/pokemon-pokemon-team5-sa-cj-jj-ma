package controller;

import java.util.List;
import java.util.Random;

import model.Creature;
import model.Move;
import model.PokemonModel;
import model.Trainer;

public class PokemonController {
	private PokemonModel model;
	private int currTurn;

	
	public PokemonController(PokemonModel model) {
		this.model = new PokemonModel();
		currTurn = 1;
		
	}
	
	public void resetAllHealth() {
		model.resetHealth();
	}
	
	public boolean createTeam(String name, List<String> creatureStrs, int playerNum) {
		System.out.println("controller - creating self team");
		model.initializeTeam(name, creatureStrs, playerNum);
		return true;
	}
	
//	public boolean createTeammateTeam() {
//		return false;
//	}
	
	public boolean createComputerTeam(List<String> pokeStrs) {
		System.out.println("controller - creating computer team");
		model.initializeComputerTeam(pokeStrs);
		return true;
	}

    /**
     * Runs one turn of combat.
     * Simple rule:
     *  damage = attacker.attack - defender.defense
     * if damage < 1, set to 1.
     */
    public void playerTurn(Trainer attackingTrainer, String moveStr) {
    	System.out.println("player turn: " + moveStr);

    	Trainer defendingTrainer = null;
    	if (attackingTrainer.equals(model.getTrainer1()) ) {
    		defendingTrainer = model.getTrainer2();
    	} else if (attackingTrainer.equals(model.getTrainer2()) ) {
        	defendingTrainer = model.getTrainer1();
    	}
    	
        Creature attacker = attackingTrainer.getActiveCreature();
        Creature defender = defendingTrainer.getActiveCreature();

        doMove(attacker, defender, moveStr.toLowerCase());
        
        if (defender.getHealth() <= 0) {
            defendingTrainer.autoSwap();
            System.out.println(model.getTrainer1() + "'s " + attacker.getName() + " knocked out " + defender.getName());
        }
        
        if (currTurn == 1) {
        	currTurn = 2;
        } else if (currTurn == 2) {
        	currTurn = 1;
        }
    }

    
	public void computerTurn() {
		
        Creature attacker = model.getTrainer2().getActiveCreature();
        Creature defender = model.getTrainer1().getActiveCreature();
        
		Random rand = new Random();
		int randMoveIndex = rand.nextInt(4);
		System.out.println(randMoveIndex);
		String randMoveStr = attacker.getMoves().get(randMoveIndex).getName().toLowerCase();
    	System.out.println("computer turn: " + randMoveStr);

		doMove(attacker, defender, randMoveStr);
		
        if (defender.isCreatureFainted()) {
            model.getTrainer1().autoSwap();
            System.out.println(model.getTrainer2() + "'s " + attacker.getName() + " knocked out " + defender.getName());
        }
        
        currTurn = 1;
	}

    /**
     * Damage formula for Sprint 1.
     */
    private void doMove(Creature attacker, Creature defender, String moveStr) {
    	model.callMove(attacker, defender, moveStr);
    }
    
    
    
    /**
     * Returns true when a trainer has no living creatures left. 
     */
    public boolean isBattleOver() {
        return !model.getTrainer1().hasLivingCreature() || !model.getTrainer2().hasLivingCreature();
    }

    /**
     * Returns the winner if the battle has ended.
     */
    public String getWinner() {
        if (!model.getTrainer1().hasLivingCreature()) return model.getTrainer2().getName()+" won!";
        if (!model.getTrainer2().hasLivingCreature()) return model.getTrainer1().getName()+" won!";
        return null;
    }


	public Trainer getTrainer1() {
		return model.getTrainer1();
	}
	
	public Trainer getTrainer2() {
		return model.getTrainer2();
	}
	
//	public Trainer getTrainer3() {
//		return model.getTrainer3();
//	}
	
	public void setDifficulty(int diff) {
		model.setDifficulty(diff);
		System.out.println("GOT HERE");
	}
	
	public void resetAll() {
		model.resetAll();
	}

	public int getCurrTurn() {
		// TODO Auto-generated method stub
		return currTurn;
	}
	
}
