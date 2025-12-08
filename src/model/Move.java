package model;

/**
 * @author conorjanesky, mohammed, jett, safwan
 * File: Move.java
 * Class: CSC 335 Fall 2025
 * Purpose: This is the moves
 * for all of the pokemon.
 * Our Pokemons moves are taken 
 * from a ppol of moves 
 * to create a combination of moves
 * that is unique to that pokemon.
 * This is that pool.
 */
public class Move {
	/**
	 * this is the enum for the category of moves
	 */
	public enum Category {
		PHYSICAL, STATUS
	}
	
	/**
	 * This is the enum for the
	 * type of pokemon.
	 */
	public enum Type {
		NORMAL, FIRE, WATER, GRASS, ELECTRIC, POISON, ICE, DRAGON, FAIRY
	}
	
	/**
	 * this is the enum for the type of move (status)
	 */
	public enum StatusEffect {
		HP_UP, ATTACK_UP, ATTACK_DOWN, DEFENSE_UP, DEFENSE_DOWN, NO_EFFECT
	}
	
	private String name;
	private Category moveCategory;
	private Type moveType;
	private StatusEffect effect;
	private int power; 
	private int effectLevel;
	
	/**
	 * Constructor for moves under the "PHYSICAL" category which inflict damage on the opponent
	 * 
	 * @param name
	 * @param moveCategory
	 * @param moveType
	 * @param power
	 */
	public Move(String name, Category moveCategory, Type moveType, int power) {
		this.name = name;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		this.power = power;
	}	
	
	/**
	 * Constructor for moves under the "STATUS" category which affects the stats of either self or the opponent
	 * 
	 * @param name
	 * @param moveCategory
	 * @param moveType
	 * @param effect
	 * @param effectAmt
	 */
	public Move(String name, Category moveCategory, StatusEffect effect, int effectLevel) {
		this.name = name;
		this.moveCategory = moveCategory;
		this.effect = effect;
		this.effectLevel = effectLevel;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the move's category
	 */
	public Category getMoveCategory() {
		return moveCategory;
	}

	/**
	 * @return the move's type
	 */
	public Type getMoveType() {
		return moveType;
	}

	/**
	 * @return a status move's effect 
	 */
	public StatusEffect getEffect() {
		return effect;
	}

	/**
	 * @return a physical move's power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @return the amount of change from a status move's effect
	 */
	public int getEffectLevel() {
		return effectLevel;
	}
	
}
