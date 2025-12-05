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
		trainer1 = null;
		trainer2 = null;
		trainer3 = null;
		battle = null;
		pool = null;
		
	}
	
	
	
	public Creature[] convertStringToTeam(List<String> strTeam) {
		List<Creature> retTeam = new ArrayList<>();
		for (String str : strTeam) {
			System.out.println("iterating\n\n");
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
		
		Creature[] retTeamArr = new Creature[3];
		for (int i = 0; i < 3; i++) {
			retTeamArr[i] = retTeam.get(i);
		}
		
		return retTeamArr;

	}
	
	
	
}
