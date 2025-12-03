package model;

/**
 * healMove – heals the attacker by a fixed amount.
 * 
 * Added by Safwan:
 *   - Implemented doMove() logic (was empty)
 *   - Added comments so teammates know what is left
 */
public class healMove extends Move {

    private int amount;

    public healMove(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public void doMove(Creature attacker, Creature defender) {
        // Heal the attacker but not above some soft cap (teammates can refine)
        attacker.setHealth(attacker.getHealth() + this.amount);
    }
}
