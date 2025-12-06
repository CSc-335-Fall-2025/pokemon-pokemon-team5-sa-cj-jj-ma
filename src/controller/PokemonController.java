package controller;

import java.util.List;

import model.Creature;
import model.PokemonModel;
import model.Trainer;

public class PokemonController {
	private PokemonModel model;
	private Trainer trainer1;
	private Trainer trainer2;
	private Trainer trainer3;
	
	public PokemonController(PokemonModel model) {
		this.model = new PokemonModel();
		this.trainer1 = new Trainer();
		this.trainer2 = new Trainer();
		this.trainer3 = new Trainer();
	}
	
	public boolean createSelfTeam(String name, List<String> creatureStrs) {
		System.out.println("controller - creating self team");
		model.initializeSelfTeam(name, creatureStrs);
		
		
		return true;
	}
	
//	public boolean createTeammateTeam() {
//		return false;
//	}
	
	public boolean createComputerTeam() {
		System.out.println("controller - creating computer team");
		model.initializeComputerTeam();
		return true;
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
	
}
