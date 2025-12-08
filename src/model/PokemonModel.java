package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PokemonModel extends Observable{
	
	private Trainer trainer1;
	private Trainer trainer2;
	private CreaturePool pool;
	
	public PokemonModel() {
		this.trainer1 = new Trainer();
		this.trainer2 = new Trainer();
		this.pool = new CreaturePool();
		pool.setMoves();
		
	}
	
	public void resetHealth() {
		for (Creature c : pool.getAllCreatures()) {
			c.setHealth(c.getBaseHealth());
			c.setAttack(c.getBaseAttack());
			c.setDefense(c.getBaseDefense());
		}
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
	
	public void callMove(Creature attacker, Creature defender, String moveStr) {
		for (Move m : attacker.getMoves()) {
			if (m.getName().toLowerCase().equals(moveStr)) {
				if (m.getMoveCategory().equals(Move.Category.PHYSICAL)) {
					int damageAmt = m.getPower() * attacker.getAttack() / defender.getDefense();
					
					defender.setHealth(defender.getHealth() - damageAmt);

					System.out.println(attacker.getName() + " attacked " + defender.getName() + " for " + damageAmt + " damage.");
				}
				
				if (m.getMoveCategory().equals(Move.Category.STATUS)) {

					int changedTotal;
					
					switch (m.getEffect()) {
					case HP_UP:
						changedTotal = attacker.getHealth() + (attacker.getHealth() / 2);
						attacker.setHealth(Math.min(changedTotal, attacker.getBaseHealth()));
						break;
					case ATTACK_UP:
						changedTotal = setAttackChange(attacker, m.getEffectLevel());
						attacker.setAttack(changedTotal);
						System.out.println(attacker.getName() + " changed " + attacker.getName() + "'s attack to " + changedTotal);
						break;
					case ATTACK_DOWN:
						changedTotal = setAttackChange(defender, -m.getEffectLevel());
						defender.setAttack(changedTotal);
						System.out.println(attacker.getName() + " changed " + defender.getName() + "'s attack to " + changedTotal);
						break;
					case DEFENSE_UP:
						changedTotal = setDefenseChange(attacker, m.getEffectLevel());
						attacker.setAttack(changedTotal);
						System.out.println(attacker.getName() + " changed " + attacker.getName() + "'s defense to " + changedTotal);
						break;
					case DEFENSE_DOWN:
						changedTotal = setDefenseChange(defender, -m.getEffectLevel());
						defender.setDefense(changedTotal);
						System.out.println(attacker.getName() + " changed " + defender.getName() + "'s defense to " + changedTotal);

						break;
					case NO_EFFECT:
						break;
					}
				}
			}
		}
	}
	
	public int setAttackChange(Creature affected, int level) {
    	int numerator = 2;
    	int denominator = 2;
    	
    	if (level > 0) {
			numerator = 2 + level;
		} else if (level < 0) {
			denominator = 2 - level;
		}
		
		return affected.getAttack() * numerator / denominator;
	}
	
    public int setDefenseChange(Creature affected, int level) {
    	int numerator = 2;
    	int denominator = 2;
    	
    	if (level > 0) {
			numerator = 2 + level;
		} else if (level < 0) {
			denominator = 2 - level;
		}
		
		return affected.getDefense() * numerator / denominator;
	}
	
	public Trainer getTrainer1() {
		return trainer1;
	}
	
	public Trainer getTrainer2() {
		return trainer2;
	}
	
//	public Trainer getTrainer3() {
//		return trainer3;
//	}
	
	public boolean setDifficulty(int diff) {
		if (diff == 0) {
			for (Creature c : trainer2.getTeam()) {
				c.setHealth((int) Math.round(c.getHealth()*.8));
			}
		} else if (diff == 2) {
			for (Creature c : trainer2.getTeam()) {
				c.setHealth((int) Math.round(c.getHealth()*1.2));
			}
		}
		setChanged();
		notifyObservers();
		return true;
	}
	
	public void resetAll() {
		trainer1 = new Trainer();
		trainer2 = new Trainer();
		pool = new CreaturePool();
		pool.setMoves();
		setChanged();
		notifyObservers();
	}
}
