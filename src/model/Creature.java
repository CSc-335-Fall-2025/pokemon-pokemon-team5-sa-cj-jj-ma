/**
 * @author - Conor, Jett, Safwan, Mohammad
 * File: Creature.java
 * Prupose define the creature class for our pokemon game.
 * This creature will have different stats and a collection of moves.
 */
package model;

import java.util.List;

public class Creature {
	private String name;
	private int baseHealth;
	private int attack;
	private int defense;
	private int currHealth;
	private List<Move> moves;
	private int counter;
	private String path;
	
	/**
	 * 
	 * @param name
	 * @param health
	 * @param attack
	 * @param defense
	 */
	public Creature(String name, int health, int attack, int defense, List<Move> moveArray, String path) {
		this.name = name;
		this.baseHealth = health;
		this.attack = attack;
		this.defense = defense;
		this.currHealth = health;
		this.moves = moveArray;
		this.counter = 0;
		this.path = path;
	}
	

	public String getName() {
		return this.name;
	}
	
	public int getBaseHealth() {
		return this.baseHealth;
	}
	
	public int getHealth() {
		if (currHealth<=0) {
			return 0;
		}
		return this.currHealth;
	}
	public void setHealth(int newHealth) {
		this.currHealth = newHealth;
	}
	public int getAttack() {
		return this.attack;
	}
	
	public void setAttack(int newAttack) {
		this.attack = newAttack;
	}
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int newDefense) {
		this.defense = newDefense;
	}
	public List<Move> getMoves() {
		return this.moves;
	}
	public void setMoves(List<Move> newMoves) {
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
//	public int getHeal() {
//		return this.heal;
//	}

	
	public String toString() {
		return "Poke Name: " + name;
	}
	
	public boolean isCreatureFainted() {
		return getHealth() <= 0;
	}
}
