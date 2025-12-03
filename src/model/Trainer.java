package model;

public class Trainer {

    private String name;
    private Creature[] team;
    private int activeIndex;

    public Trainer(String name, Creature[] team) {
        this.name = name;
        this.team = team;
        this.activeIndex = 0;
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

    public int getActiveIndex() {
        return activeIndex;
    }

    public void swapTo(int index) {
        if (index >= 0 && index < team.length && !team[index].isFainted()) {
            activeIndex = index;
        }
    }

    public void autoSwap() {
        for (int i = 0; i < team.length; i++) {
            if (!team[i].isFainted()) {
                activeIndex = i;
                return;
            }
        }
    }

    public boolean hasLivingCreature() {
        for (Creature c : team) {
            if (!c.isFainted()) return true;
        }
        return false;
    }
}
