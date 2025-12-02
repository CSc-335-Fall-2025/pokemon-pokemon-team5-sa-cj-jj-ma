package model;

public class Trainer {

    private String name;
    private Creature[] team;     // the trainer's 3 creatures
    private int activeIndex;     // index of the current fighting creature

    public Trainer(String name, Creature[] team) {
        this.name = name;
        this.team = team;
        this.activeIndex = 0; // start with the first creature
    }

    public String getName() {
        return name;
    }

    public Creature getActiveCreature() {
        return team[activeIndex];
    }

    public Creature[] getTeam() {
        return team;
    }

    /**
     * Swap to another creature if it is alive.
     */
    public void swapTo(int index) {
        if (index >= 0 && index < team.length && team[index].getHealth() > 0) {
            activeIndex = index;
        }
    }

    /**
     * Automatically choose the next living creature after a faint.
     */
    public void autoSwap() {
        for (int i = 0; i < team.length; i++) {
            if (team[i].getHealth() > 0) {
                activeIndex = i;
                return;
            }
        }
    }

    /**
     * Returns true if at least one creature is still alive.
     */
    public boolean hasLivingCreature() {
        for (Creature c : team) {
            if (c.getHealth() > 0) return true;
        }
        return false;
    }
}
