package model;

/**
 * ShieldMove – temporarily increases a creature's defense.
 *
 * Added by Safwan:
 *   - Reworked logic (previous version healed HP which made it duplicate healMove)
 *   - Introduced a simple defense buff mechanic
 *   - Added comments for teammates to expand on later
 */
public class ShieldMove extends Move {

    private int boostAmount;

    public ShieldMove(int amount) {
        this.boostAmount = amount;
    }

    public int getBoostAmount() {
        return boostAmount;
    }

    @Override
    public void doMove(Creature attacker, Creature defender) {
        // TEMP FIX: Increase defense permanently (teammates can turn this into temp buff)
        attacker.setDefense(attacker.getDefense() + boostAmount);
    }
}
