package Model;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Creature> creatures;
	private Creature currCreature;
	private int currIndex;
	
	public Team() {
		creatures = new ArrayList<>();
		currCreature = null;
		currIndex = -1;
	}
	
	/**
	 * Adds a given creature to a team of 3
	 * 
	 * @param c
	 */
	public void addCreature(Creature c) {
		if (creatures.size() < 3) {
			creatures.add(c);
			
			if (currIndex == -1) {
				currIndex = 0;
				currCreature = c;
			}
		}
	}
	
	/**
	 * Returns whether or not a given creature's HP is zero
	 * 
	 * @param c
	 * @return
	 */
	public boolean isCreatureFainted(Creature c) {
		return c.getHealth() <= 0;
	}
	
	public boolean isTeamFainted() {
		for (Creature c : creatures) {
			if (!isCreatureFainted(c)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Automatically swaps the current creature in battle with the next one in list, as long as it is able to battle
	 * 
	 * @return
	 */
	public boolean autoSwap() {
		// Can't swap if all creatures have fainted
		if (isTeamFainted()) {
			return false;
		}
		
		// Loop through creature list and swap with the next non-fainted creature
		while (true) {
			currIndex = (currIndex + 1) % 3; // Loop in a circular manner
			Creature possibleSwap = creatures.get(currIndex);
			
			if (!isCreatureFainted(possibleSwap)) {
				currCreature = possibleSwap;
				return true;
			}
		}
	}
	
	/**
	 * Swaps the current creature with the given creature chosen by the player
	 * 
	 * @param swapCreature
	 * @return
	 */
	public boolean manualSwap(Creature swapCreature) {
		if (creatures.contains(swapCreature) && !isCreatureFainted(swapCreature)) {
			currCreature = swapCreature;
			currIndex = creatures.indexOf(swapCreature);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the creatures in a team
	 */
	public List<Creature> getCreatures() {
		return creatures;
	}

	/**
	 * @return the currCreature
	 */
	public Creature getCurrCreature() {
		return currCreature;
	}

	/**
	 * @return the currIndex
	 */
	public int getCurrIndex() {
		return currIndex;
	}
	
}
