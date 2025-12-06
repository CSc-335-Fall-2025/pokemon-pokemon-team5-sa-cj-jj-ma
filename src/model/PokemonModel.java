package model;

import java.util.ArrayList;
import java.util.List;

public class PokemonModel {
	
	private Trainer trainer1;
	private Trainer trainer2;
	private Trainer trainer3;
	private Battle battle;
	private CreaturePool pool;
	
	public PokemonModel() {
		this.trainer1 = new Trainer();
		this.trainer2 = new Trainer();
		this.trainer3 = new Trainer();
		this.battle = null;
		this.pool = new CreaturePool();
		
	}
	
	
	public boolean initializeSelfTeam(String name, List<String> strTeam) {
		System.out.println("model - initializing self team");
		trainer1.setName(name.toUpperCase());
		System.out.println("\tself name: " + trainer1.getName());
		System.out.println("\tself team strings: " + strTeam);

		trainer1.setTeam(convertStringToTeam(strTeam));
		return true;
	}
	
	public boolean initializeComputerTeam() {
		System.out.println("model - initializing self team");
		trainer3.setName("COMPUTER");
		List<String> randTeam = new ArrayList<>(pool.generateRandom());
		trainer3.setTeam(convertStringToTeam(randTeam));
		System.out.println("\tcomputer name: " + trainer3.getName());
		System.out.println("\tcomputer team strings: " + randTeam);
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
	
	
	
}
