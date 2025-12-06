/**
 * @author - Conor, Jett, Safwan, Mohammad
 * File: Creature.java
 * Prupose define the creature class for our pokemon game.
 * This creature will have different stats and a collection of moves.
 */
package model;

public class Creature {
	private String name;
	private int health;
	private int attack;
	private int defense;
	private int heal;
	private Move[] moves;
	private int counter;
	private String path;
	private int basehealth;
	
	/**
	 * 
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 */
	public Creature(String name, int health, int attack, int defense, int heal, Move[] moveArray, String path) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.health = heal;
		this.moves = moveArray;
		this.counter = 0;
		this.path = path;
		this.basehealth = health;
	}
	public String getName() {
		return this.name;
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int newhealth) {
		this.health = newhealth;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getDefense() {
		return this.defense;
	}
	public Move[] getMoves() {
		return this.moves;
	}
	public void setMoves(Move[] newMoves) {
		this.moves = newMoves;
	}
	public int getCounter(){
		return this.counter;
	}
	public void setCounter(int number) {
		this.counter = number;
	}
	public void incrementCounter() {
		if (this.counter>=1) {
			this.counter--;
		}
	}
	public String getPath() {
		return this.path;
	}
	public int getHeal() {
		return this.heal;
	}
	public int getBaseHealth() {
		return this.basehealth;
	}
	public boolean isFainted() {
	    return this.health <= 0;
	}

	/**
	 * Added by Safwan:
	 * Needed for ShieldMove.
	 */
	public void setDefense(int newDefense) {
	    this.defense = newDefense;
	}

	
}
