package model;

import java.util.List;
/**
 * @author conorjanesky, mohammed, jett, safwan
 * File: Trainer.java
 * Class: CSC 335 Fall 2025
 * Purpose: 
 * This creates the trainer class 
 * for the pokemon model. Thet rainer has a name
 * and a team attached to it, as 
 * well as an active creature and its index in the list
 */
public class Trainer {
    private String name;
    private List<Creature> team;     // the trainer's 3 creatures
    private Creature activeCreature;
    private int activeIndex;     // index of the active fighting creature
    
    /** This is the constructor for the trainer
     * this initially sets the 
     * trainers attributes ot be null to be changed later
     */
    public Trainer() {
        this.name = null;
        this.team = null;
        this.activeCreature = null;
        this.activeIndex = 0; // start with the first creature
        
    }
    
    /**
     * this is the getter for the trainers name
     * @return - name, string for trainers name
     */
    public String getName() {
        return name;
    }
    
    /**
     * getter of this trainers active creature
     * @return - activeCreature
     */
    public Creature getActiveCreature() {
        return activeCreature;
    }
    
    /**
     * This is the getTeam() and returns this trainers
     * team as a list of creatures
     * @return - team - list of creatures
     */
    public List<Creature> getTeam() {
        return team;
    }
    
    /**
     * This returns the first creature in the creature team
     * @return
     */
    public Creature getCreature1() {
    	return team.get(0);
    }
    
    /** 
     * this returns the second creature in the creature team
     * @return
     */
    public Creature getCreature2() {
    	return team.get(1);

    }
    
    /**
     * this returns the third creature in the creature team
     * @return
     */
    public Creature getCreature3() {
    	return team.get(2);
    }
    
    /**
     * this sets the name of the trainer to the parameter
     * @param name - name that we want to change the trainer to
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This sets the team of the 
     * trainer to the inputed list of creatures
     * @param creatures - list of new creatures
     */
    public void setTeam(List<Creature> creatures) {
        this.team = creatures;
        this.activeCreature = team.get(activeIndex);
    }
    
    
	/**
	 * Returns whether or not a given creature's HP is zero
	 * @param c
	 * @return
	 */
	public boolean isCreatureFainted(Creature c) {
		return c.getHealth() <= 0;
	}
	
	/**
	 * this checks if the entire team
	 * is fainted(unable to play) or not
	 * @return
	 */
	public boolean isTeamFainted() {
		for (Creature c : team) {
			if (!isCreatureFainted(c)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Swaps the active creature with the given creature chosen by the player
	 * 
	 * @param swapCreature
	 * @return
	 */
	public boolean manualSwap(Creature swapCreature) {
		if (team.contains(swapCreature) && !isCreatureFainted(swapCreature)) {
			activeCreature = swapCreature;
			activeIndex = team.indexOf(swapCreature);
			return true;
		} else {
			return false;
		}
	}
    
	/**
	 * Automatically swaps the active creature in battle with the next one in list, as long as it is able to battle
	 * @return
	 */
	public boolean autoSwap() {
		// Can't swap if all creatures have fainted
		if (isTeamFainted()) {
			return false;
		}
		
		// Loop through creature list and swap with the next non-fainted creature
		while (true) {
			activeIndex = (activeIndex + 1) % 3; // Loop in a circular manner
			Creature possibleSwap = team.get(activeIndex);
			
			if (!isCreatureFainted(possibleSwap)) {
				activeCreature = possibleSwap;
				return true;
			}
		}
	}

    /**
     * Returns true if at least one creature is still alive.
     */
    public boolean hasLivingCreature() {
        for (Creature c : team) {
            if (!isCreatureFainted(c)) return true;
        }
        return false;
    }
 
}
