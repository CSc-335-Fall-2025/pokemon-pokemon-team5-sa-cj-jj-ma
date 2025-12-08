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
	
	/**
	 * 
	 * @param model: it is for model variable form passing
	 * 
	 */
	public PokemonController(PokemonModel model) {
		this.model = new PokemonModel();

	}
	
	/**
	 * This method to reset all health for pokemon creature
	 */
	public void resetAllHealth() {
		model.resetHealth();
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
	}

	/**
	 * this method will handel move for the trainer where it will use the move string
	 * @param attacker: this instance will the attacker
	 * @param defender: this instance will be the target player
	 * @param moveStr: this instance will be the move string
	 */
    private void doMove(Creature attacker, Creature defender, String moveStr) {
    	for (Move m : attacker.getMoves()) {
			if (m.getName().toLowerCase().equals(moveStr)) {
				if (m.getMoveCategory().equals(Move.Category.PHYSICAL)) {
					int damageAmt = m.getPower() * attacker.getAttack() / defender.getDefense();
					
					defender.setHealth(defender.getHealth() - damageAmt);

					System.out.println(attacker.getName() + " attacked " + defender.getName() + " for " + damageAmt + " damage.");
				}
				
				if (m.getMoveCategory().equals(Move.Category.STATUS)) {

					int changedTotal;
					
					switch (m.getEffect()) {
					case HP_UP:
						changedTotal = attacker.getHealth() + (attacker.getHealth() / 2);
						attacker.setHealth(Math.min(changedTotal, attacker.getBaseHealth()));
						break;
					case ATTACK_UP:
						changedTotal = setAttackChange(attacker, m.getEffectLevel());
						attacker.setAttack(changedTotal);
						System.out.println(attacker.getName() + " changed " + attacker.getName() + "'s attack to " + changedTotal);
						break;
					case ATTACK_DOWN:
						changedTotal = setAttackChange(defender, -m.getEffectLevel());
						defender.setAttack(changedTotal);
						System.out.println(attacker.getName() + " changed " + defender.getName() + "'s attack to " + changedTotal);
						break;
					case DEFENSE_UP:
						changedTotal = setDefenseChange(attacker, m.getEffectLevel());
						attacker.setAttack(changedTotal);
						System.out.println(attacker.getName() + " changed " + attacker.getName() + "'s defense to " + changedTotal);
						break;
					case DEFENSE_DOWN:
						changedTotal = setDefenseChange(defender, -m.getEffectLevel());
						defender.setDefense(changedTotal);
						System.out.println(attacker.getName() + " changed " + defender.getName() + "'s defense to " + changedTotal);

						break;
					case NO_EFFECT:
						break;
					}
				}
			}
		}
    }
    
    /**
     * This method will handle status for the creature move for the attacker
     * @param affected: target pokemon creature
     * @param level: to use the calculation of status
     * @return it returns the calculation of status
     */
    public int setAttackChange(Creature affected, int level) {
    	int numerator = 2;
    	int denominator = 2;
    	
    	if (level > 0) {
			numerator = 2 + level;
		} else if (level < 0) {
			denominator = 2 - level;
		}
		
		return affected.getAttack() * numerator / denominator;
	}
	
    /**
     * This method will handle status for the creature move for the defender
     * @param affected: target pokemon creature
     * @param level: to use the calculation of status
     * @return it returns the calculation of status
     */
    public int setDefenseChange(Creature affected, int level) {
    	int numerator = 2;
    	int denominator = 2;
    	
    	if (level > 0) {
			numerator = 2 + level;
		} else if (level < 0) {
			denominator = 2 - level;
		}
		
		return affected.getDefense() * numerator / denominator;
	}
    
    /**
     * Returns true when a trainer has no living creatures left.
     */
    public boolean isBattleOver() {
        return !model.getTrainer1().hasLivingCreature() || !model.getTrainer2().hasLivingCreature();
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
