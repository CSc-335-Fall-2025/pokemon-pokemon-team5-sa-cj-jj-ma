/**
 * @author - Conor, Jett, Safwan, Mohammad
 * File: Creature.java
 * Prupose define the creature class for our pokemon game.
 * This creature will have different stats and a collection of moves.
 */
package Model;

public class Creature {
	private String name;
	private int health;
	private int attack;
	private int defense;
	private Move[] moves;
	private int counter;
	
	/**
	 * 
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 */
	public Creature(String name, int health, int attack, int defense, Move[] moveArray) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.moves = moveArray;
		this.counter = 0;
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
	
}
