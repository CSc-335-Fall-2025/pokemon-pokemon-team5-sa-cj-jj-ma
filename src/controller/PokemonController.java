package controller;

import java.util.List;

import model.Creature;
import model.PokemonModel;

public class PokemonController {
	private PokemonModel model;
	private Creature[] trainer1;
	private Creature[] trainer2;
	private Creature[] trainer3;
	
	public PokemonController(String name1, String name2, List<String> team1, List<String> team2) {
		this.model = new PokemonModel(name1, name2, team1, team2);
	}
	
	public PokemonController(String name1, String name2, String name3, List<String> team1, List<String> team2, List<String> team3) {
		this.model = new PokemonModel(name1, name2, name3, team1, team2, team3);
	}
	
	
}
