package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
/**
 * This class extends Observable and will be connected to a javaFX prgram by the MVC model
 * @author conorjanesky, mohammed, safwan, and jett
 * File: PokemonModel.java
 * Class: CSC 335 Fall 2025
 * Purpose: This is the model for the pokemon game
 * It keeps track of all of the trainers
 * and the pokemon teams that are inside of those trainers.
 * It will also manage the moves that each pokemon does and update the gui
 * accordingly.
 * 
 */
public class PokemonModel extends Observable{
	
	private Trainer trainer1;
	private Trainer trainer2;
	private Trainer trainer3;
	private CreaturePool pool;
	
	/**
	 * this is the consutructor for the PokemonModel
	 * It creates a creature pool and 
	 * sets trainer1 and 2 to null values to 
	 * be filled in by the GUI later
	 */
	public PokemonModel() {
		this.trainer1 = new Trainer();
		this.trainer2 = new Trainer();
		this.pool = new CreaturePool();
		pool.setMoves();
		
	}
	
	/**
	 * this resets the health of all of the
	 * pokemon for when the game resets
	 * to a base state awaiting a new battle. 
	 * 
	 */
	public void resetHealth() {
		// does this for the okemon on trainer one team and trainer 2 team
		for (Creature c : trainer1.getTeam()) {
			c.setHealth(c.getBaseHealth());
		}
		for (Creature c : trainer2.getTeam()) {
			c.setHealth(c.getBaseHealth());
		}
	}
	/**
	 * This initiliazes a team given the input from the GUI by changing this models' trainer
	 * @param name - this is the name of the team so that we can determine who had one and 
	 * it adds a fun oart of customization for the user
	 * @param strTeam - this is a list of the pokemon sleected by the user
	 * @param playerNum - determines which player the tainer the team attributes should be added to
	 * @return true if it successfuly changed each trainer in this model without
	 * running into errors
	 */
	public boolean initializeTeam(String name, List<String> strTeam, int playerNum) {
		Trainer currTrainer = null;
		System.out.println("model - initializing self team for player " + playerNum);
		if (playerNum == 1) {
			currTrainer = trainer1;
		} else if (playerNum == 2) {
			currTrainer = trainer2;
		} else {
			return false;
		}
		
		currTrainer.setName(name.toUpperCase());
		System.out.println("\tself name: " + trainer1.getName());
		System.out.println("\tself team strings: " + strTeam);
		currTrainer.setTeam(convertStringToTeam(strTeam));
		
		for (Creature c : currTrainer.getTeam()) {
			System.out.println(c);
		}
		System.out.println("Active: " + currTrainer.getActiveCreature());
		
		setChanged();
		notifyObservers();
		return true;
	}
	
	/**
	 * This initiliazes a computer team for when
	 * the use selects singleplayer
	 * @param pokeStrs - these are a string that will be used to amke the team
	 * the difference is that the string will be "computer" instead
	 * of whatever the computer input
	 * @return - true if it successfully create a computer team
	 */
	public boolean initializeComputerTeam(List<String> pokeStrs) {
		System.out.println("model - initializing computer team");
		trainer2.setName("Computer");
		List<String> randTeam = new ArrayList<>(pool.generateRandom(pokeStrs));
		trainer2.setTeam(convertStringToTeam(randTeam));
		for (Creature c : trainer2.getTeam()) {
			System.out.println(c);
		}
		System.out.println("\tcomputer name: " + trainer2.getName());
		System.out.println("\tcomputer team strings: " + randTeam);
		
		System.out.println("Active: " + trainer2.getActiveCreature());

		setChanged();
		notifyObservers();
		return true;
	}
	
	/**
	 * This converts the strings taken in
	 * from the GUI to a list of the actual creatures, with all
	 * of thier attributes, and returns it
	 * @param strTeam - list of strings given by the gui through user input
	 * @return - true if it successfuly converted the team
	 */
	public List<Creature> convertStringToTeam(List<String> strTeam) {
		List<Creature> retTeam = new ArrayList<>();
		for (String str : strTeam) {
			switch (str) {
				case "pikachu":
					retTeam.add(pool.getAllCreatures()[0]);
					break;
				case "bulbasaur":
					retTeam.add(pool.getAllCreatures()[1]);
					break;
				case "charmander":
					retTeam.add(pool.getAllCreatures()[2]);
					break;
				case "squirtle":
					retTeam.add(pool.getAllCreatures()[3]);
					break;
				case "jigglypuff":
					retTeam.add(pool.getAllCreatures()[4]);
					break;
				case "yoshi":
					retTeam.add(pool.getAllCreatures()[5]);
					break;
				case "poliwhirl":
					retTeam.add(pool.getAllCreatures()[6]);
					break;
				case "gloom":
					retTeam.add(pool.getAllCreatures()[7]);
					break;
				case "psyduck":
					retTeam.add(pool.getAllCreatures()[8]);
					break;
				case "goldeen":
					retTeam.add(pool.getAllCreatures()[9]);
					break;
				case "dratini":
					retTeam.add(pool.getAllCreatures()[10]);
					break;
				case "meowth":
					retTeam.add(pool.getAllCreatures()[11]);
					break;
				}
		}		
		return retTeam;
	}
	
	/**
	 * this returns trainer 1
	 * @return trainer1
	 */
	public Trainer getTrainer1() {
		return trainer1;
	}
	/**
	 * this is the getter for trainer 2
	 * @return trainer 2
	 */
	public Trainer getTrainer2() {
		return trainer2;
	}
	
	/**
	 * this changes the difficulty of the enemy pokemon depending on what
	 * mode that they chose in the GUI
	 * it changes the difficulty by changing the health of the 
	 * pokemon
	 * @param diff - integer that determines the difficulty
	 * @return - true if it properly changed the difficulty
	 */
	public boolean setDifficulty(int diff) {
		// iterates over each creature of the team and modifies its currenthealth
		if (diff == 0) {
			for (Creature c : trainer2.getTeam()) {
				c.setHealth((int) Math.round(c.getHealth()*.7));
			}
		} else if (diff == 2) {
			for (Creature c : trainer2.getTeam()) {
				c.setHealth((int) Math.round(c.getHealth()*1.5));
			}
		}
		setChanged();
		notifyObservers();
		return true;
	}
	
	/**
	 * This resets the health of all the pokemon
	 * so that the game can create a new battle with the creatures
	 * and they will all be full health for the new battle
	 * It basically clears the creature pool/trainers and makes new ones
	 */
	public void resetAll() {
		trainer1 = new Trainer();
		trainer2 = new Trainer();
		pool = new CreaturePool();
		pool.setMoves();
		setChanged();
		notifyObservers();
	}
}
