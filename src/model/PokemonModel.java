package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PokemonModel extends Observable{
	
	private Trainer trainer1;
	private Trainer trainer2;
	private Trainer trainer3;
//	private Battle battle;
	private CreaturePool pool;
	
	public PokemonModel() {
		this.trainer1 = new Trainer();
		this.trainer2 = new Trainer();
		this.trainer3 = new Trainer();
//		this.battle = null;
		this.pool = new CreaturePool();
		pool.setMoves();
		
	}
	
	
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
	
	public boolean initializeComputerTeam(List<String> pokeStrs) {
		System.out.println("model - initializing computer team");
		trainer3.setName("COMPUTER");
		List<String> randTeam = new ArrayList<>(pool.generateRandom(pokeStrs));
		trainer3.setTeam(convertStringToTeam(randTeam));
		for (Creature c : trainer3.getTeam()) {
			System.out.println(c);
		}
		System.out.println("\tcomputer name: " + trainer3.getName());
		System.out.println("\tcomputer team strings: " + randTeam);
		
		System.out.println("Active: " + trainer3.getActiveCreature());

		setChanged();
		notifyObservers();
		return true;
	}
	
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
		
//		Creature[] retTeamArr = new Creature[3];
//		for (int i = 0; i < 3; i++) {
//			retTeamArr[i] = retTeam.get(i);
//		}
		
		return retTeam;

	}
	
	public Trainer getTrainer1() {
		return trainer1;
	}
	
	public Trainer getTrainer2() {
		return trainer2;
	}
	
	public Trainer getTrainer3() {
		return trainer3;
	}
	
	public boolean setDifficulty(int diff) {
		if (diff == 0) {
			for (Creature c : trainer3.getTeam()) {
				c.setHealth((int) Math.round(c.getHealth()*.8));
			}
		} else if (diff == 2) {
			for (Creature c : trainer3.getTeam()) {
				c.setHealth((int) Math.round(c.getHealth()*1.2));
			}
		}
		setChanged();
		notifyObservers();
		return true;
	}
}
