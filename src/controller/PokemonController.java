package controller;

import java.util.List;
import java.util.Random;

import model.Creature;
import model.Move;
import model.PokemonModel;
import model.Trainer;

public class PokemonController {
	private PokemonModel model;

	
	public PokemonController(PokemonModel model) {
		this.model = new PokemonModel();

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

    /**
     * Runs one turn of combat.
     * Simple rule:
     *  damage = attacker.attack - defender.defense
     * if damage < 1, set to 1.
     */
    public void playerTurn(String moveStr) {
    	System.out.println("player turn: " + moveStr);
        Creature attacker = model.getTrainer1().getActiveCreature();
        Creature defender = model.getTrainer3().getActiveCreature();

        doMove(attacker, defender, moveStr.toLowerCase());
        
        if (defender.getHealth() <= 0) {
            model.getTrainer3().autoSwap();
            System.out.println(model.getTrainer1() + "'s " + attacker.getName() + " knocked out " + defender.getName());
        }

    }

	public void computerTurn() {
		
        Creature attacker = model.getTrainer3().getActiveCreature();
        Creature defender = model.getTrainer1().getActiveCreature();
        
		Random rand = new Random();
		int randMoveIndex = rand.nextInt(4);
		System.out.println(randMoveIndex);
		String randMoveStr = attacker.getMoves().get(randMoveIndex).getName().toLowerCase();
    	System.out.println("computer turn: " + randMoveStr);

		doMove(attacker, defender, randMoveStr);
		
        if (defender.getHealth() <= 0) {
            model.getTrainer1().autoSwap();
            System.out.println(model.getTrainer3() + "'s " + attacker.getName() + " knocked out " + defender.getName());
        }
	}

    /**
     * Damage formula for Sprint 1.
     */
    private void doMove(Creature attacker, Creature defender, String moveStr) {
    	for (Move m : attacker.getMoves()) {
			if (m.getName().toLowerCase().equals(moveStr)) {
				if (m.getMoveCategory().equals(Move.Category.PHYSICAL)) {
					defender.setHealth(defender.getHealth() - m.getPower());
					System.out.println(attacker.getName() + "attacked" + defender.getName());
				}
				
				if (m.getMoveCategory().equals(Move.Category.STATUS)) {
					break;
				}
			}
		}
    }
	
    /**
     * Returns true when a trainer has no living creatures left.
     */
    public boolean isBattleOver() {
        return !model.getTrainer1().hasLivingCreature() || !model.getTrainer3().hasLivingCreature();
    }

    /**
     * Returns the winner if the battle has ended.
     */
    public Trainer getWinner() {
        if (!model.getTrainer1().hasLivingCreature()) return model.getTrainer3();
        if (!model.getTrainer3().hasLivingCreature()) return model.getTrainer1();
        return null;
    }


	public Trainer getTrainer1() {
		return model.getTrainer1();
	}
	
	public Trainer getTrainer2() {
		return model.getTrainer2();
	}
	
	public Trainer getTrainer3() {
		return model.getTrainer3();
	}
	
}
