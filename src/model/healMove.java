package model;

/**
 * Healing move.
 *
 * Updated by Safwan:
 *   - Added (String name, int amount) constructor to match CreaturePool
 *   - Added real healing logic
 *   - Left maxHealth logic for Conor to implement later
 */
public class healMove extends Move {

    private int healAmount;

    public healMove(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void doMove(Creature attacker, Creature defender) {
        attacker.setHealth(attacker.getHealth() + healAmount);
    }
}
