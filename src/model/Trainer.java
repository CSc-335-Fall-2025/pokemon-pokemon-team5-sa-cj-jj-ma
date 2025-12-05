package model;

import java.util.List;

public class Trainer {

    private String name;
    private List<Creature> team;     // the trainer's 3 creatures
    private Creature activeCreature;
    private int activeIndex;     // index of the activeent fighting creature

    public Trainer() {
        this.name = null;
        this.team = null;
        this.activeCreature = null;
        this.activeIndex = 0; // start with the first creature
    }

    public String getName() {
        return name;
    }

    public Creature getActiveCreature() {
        return activeCreature;
    }

    public List<Creature> getTeam() {
        return team;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setTeam(List<Creature> creatures) {
        this.team = creatures;
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
		for (Creature c : team) {
			if (!isCreatureFainted(c)) {
				return false;
			}
		}
		return true;
	}
	
//    /**
//     * Swap to another creature if it is alive.
//     */
//    public void swapTo(int index) {
//        if (index >= 0 && index < team.length && team[index].getHealth() > 0) {
//            activeIndex = index;
//        }
//    }
    
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

//    /**
//     * Automatically choose the next living creature after a faint.
//     */
//    public void autoSwap() {
//        for (int i = 0; i < team.length; i++) {
//            if (team[i].getHealth() > 0) {
//                activeIndex = i;
//                return;
//            }
//        }
//    }
    
	/**
	 * Automatically swaps the active creature in battle with the next one in list, as long as it is able to battle
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
