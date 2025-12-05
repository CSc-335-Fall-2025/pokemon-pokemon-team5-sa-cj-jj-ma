package controller;

import java.util.List;

import model.Creature;
import model.PokemonModel;
import model.Trainer;

public class PokemonController {
	private PokemonModel model;
	private Trainer trainer1;
	private Trainer[] trainer2;
	private Trainer[] trainer3;
	
	public PokemonController(PokemonModel model) {
		this.model = new PokemonModel();
		this.trainer1 = new Trainer();
	}
	
	public boolean createSelfTeam(String name, List<String> creatureStrs) {
		
		model.initializeSelfTeam(trainer1, name, creatureStrs);
		
		
		return false;
	}
	
//	public boolean createTeammateTeam() {
//		return false;
//	}
	
	public boolean createComputerTeam() {
		return false;
	}

	
	
}
