/**
 * @author - Conor, Jett, Safwan, Mohammad
 * File: Creature.java
 * Prupose define the creature class for our pokemon game.
 * This creature will have different status and a collection of moves.
 */
package model;

import java.util.List;

public class Creature {
	private String name;
	private int baseHealth;
	private int attack;
	private int defense;
	private int currHealth;
	private PokeType type;
	private List<Move> moves;
	private int counter;
	private String path;
	private int baseAttack;
	private int baseDefense;
	
	/**
	 * 
	 * this is a constructor for Creature class
	 * @param name: string of the creature
	 * @param health: integer health
	 * @param attack: integer attack
	 * @param defense: integer defense
	 * @param moveArray: moves array
	 * @param path: a path of creature picture
	 */
	public Creature(String name, int health, int attack, int defense, PokeType type, List<Move> moveArray, String path) {
		this.name = name;
		this.baseHealth = health;
		this.baseAttack = attack;
		this.baseDefense = defense;
		this.attack = attack;
		this.defense = defense;
		this.currHealth = health;
		this.type = type;
		this.moves = moveArray;
		this.counter = 0;
		this.path = path;
	}
	

	/**
	 * @return it returns of creature pokemon name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return it returns the base health of pokemon creature
	 */
	public int getBaseHealth() {
		return this.baseHealth;
	}
	
	/**
	 * @return it returns the base attack of pokemon creature
	 */
	public int getBaseAttack() {
		return this.baseAttack;
	}
	
	/**
	 * @return it returns the base defense of pokemon creature
	 */
	public int getBaseDefense() {
		return this.baseDefense;
	}
	
	/**
	 * @return it returns the health of creature with changes
	 */
	public int getHealth() {
		if (currHealth<=0) {
			return 0;
		}
		return this.currHealth;
	}
	
	/**
	 * to change the health after attacking or healing
	 * @param newHealth: integer of new health
	 */
	public void setHealth(int newHealth) {
		this.currHealth = newHealth;
	}
	/**
	 * @return it returns the attack integer
	 */
	public int getAttack() {
		return this.attack;
	}
	
	/**
	 * to set new attack
	 * @param newAttack: new integer attack
	 */
	public void setAttack(int newAttack) {
		this.attack = newAttack;
	}
	
	/**
	 * to get a defense
	 * @return it retruns integer of defense
	 */
	public int getDefense() {
		return this.defense;
	}
	
	/**
	 * to change the defense
	 * @param newDefense: it returns integer of defense
	 */
	public void setDefense(int newDefense) {
		this.defense = newDefense;
	}
	
	/**
	 * to get all moves in the list
	 * @return it returns the list of moves
	 */
	public List<Move> getMoves() {
		return this.moves;
	}
	
	/**
	 * to set of new moves
	 * @param newMoves: a list of new moves
	 */
	public void setMoves(List<Move> newMoves) {
		this.moves = newMoves;
	}
	
	/**
	 * 
	 * @return it returns integer of counter
	 */
	public int getCounter(){
		return this.counter;
	}
	
	/**
	 * to set a new counter
	 * @param number: integer of number
	 */
	public void setCounter(int number) {
		this.counter = number;
	}
	
	/**
	 * to increment the counter
	 */
	public void incrementCounter() {
		if (this.counter>=1) {
			this.counter--;
		}
	}
	
	/**
	 * to get file path of creature picture
	 * @return: it returns the string of the file path
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * This method will make string for the Creature class
	 */
	public String toString() {
		return "Poke Name: " + name;
	}
	
	/**
	 * to check if the creature is died
	 * @return boolean if the creature died
	 */
	public boolean isCreatureFainted() {
		return getHealth() <= 0;
	}


	public PokeType getType() {
		return type;
	}
}
