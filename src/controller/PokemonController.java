package controller;

import java.util.List;
import java.util.Random;

import model.Creature;
import model.Move;
import model.PokemonModel;
import model.Trainer;
/**
 * @author - Conor, Jett, Safwan, Mohammad
 * File: PokemonControlle.java
 * Class: CSC 335 Fall 2025
 * Prupose: This class will deal to the model class to 
 * change for of the input and have output
 */
public class PokemonController {
	private PokemonModel model;  // this is a model instance
	private int currTurn;
	
	/**
	 * 
	 * @param model: it is for model variable form passing
	 * 
	 */
	public PokemonController(PokemonModel model) {
		this.model = new PokemonModel();
		this.currTurn = 1;
	}
	
	/**
	 * This method to reset all health for pokemon creature
	 */
	public void resetAllHealth() {
		model.resetHealth();
	}
	
	public PokemonModel getModel() {
		return this.model;
	}
	
	/**
	 * 
	 * @param name: this is for name of team
	 * @param creatureStrs: this is for pokemoon creature in string
	 * @param playerNum: to create a number for the model to know which player
	 * @return it returns true when it create the team
	 */
	public boolean createTeam(String name, List<String> creatureStrs, int playerNum) {
		System.out.println("controller - creating self team");
		model.initializeTeam(name, creatureStrs, playerNum);
		return true;
	}
	
	/**
	 * 
	 * @param pokeStrs: it will take a random pokemons from model
	 * @return it returns true when it create the team
	 */
	public boolean createComputerTeam(List<String> pokeStrs) {
		System.out.println("controller - creating computer team");
		model.initializeComputerTeam(pokeStrs);
		return true;
	}
	
	/**
	 * 
	 * @param attackingTrainer: this is a trainer class where it target the attack player
	 * @param moveStr: this is a move string
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

    
    /**
     * This method when the computer get the turn, and this will get 
     * random attack from creature pool and use it here in this method.
     */
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
	 * Allows an attacker to execute a given move on the defender
	 * @param attacker
	 * @param defender
	 * @param moveStr
	 */
    private void doMove(Creature attacker, Creature defender, String moveStr) {
    	model.executeMove(attacker, defender, moveStr);
    }
    
    /**
     * Returns true when a trainer has no living creatures left.
     */
    public boolean isBattleOver() {
        return !model.getTrainer1().hasLivingCreature() || !model.getTrainer2().hasLivingCreature();
    }
    
    /**
     * 
     * @return Returns the integer corresponding to which player can currently call a move
     */
    public int getCurrTurn() {
    	return currTurn;
    }
    
    /**
     * 
     * @return Returns the string of the winner if the battle has ended. 
     * Otherwise, it return the null
     */
    public String getWinner() {
        if (!model.getTrainer1().hasLivingCreature()) return model.getTrainer2().getName()+" won!";
        if (!model.getTrainer2().hasLivingCreature()) return model.getTrainer1().getName()+" won!!!";
        return null;
    }

    /** 
     * @return it return trainer 1
     */
	public Trainer getTrainer1() {
		return model.getTrainer1();
	}
	
	/** 
     * @return it return trainer 2
     */
	public Trainer getTrainer2() {
		return model.getTrainer2();
	}
	
	/**
	 * This mothod to set the difficulty wither easy, medium, or hard
	 * @param diff: the difficulty integer
	 */
	public void setDifficulty(int diff) {
		model.setDifficulty(diff);
		System.out.println("GOT HERE");
	}
	
	/**
	 * This method to rest all game like trainer and creature and make a new game
	 */
	public void resetAll() {
		model.resetAll();
	}
	
}
