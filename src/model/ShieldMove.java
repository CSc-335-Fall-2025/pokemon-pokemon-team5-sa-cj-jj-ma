package model;

/**
 * Shield move – basic defense boost.
 *
 * Updated by Safwan:
 *   - Constructor updated to (String name, int boostAmount)
 *   - Added call to super(name)
 *   - Added setDefense() requirement (added in Creature.java)
 *   - Left temporary-buff logic for teammates
 */
public class ShieldMove extends Move {

    private int boostAmount;

    public ShieldMove(String name, int boostAmount) {
        super(name);
        this.boostAmount = boostAmount;
    }

    public int getBoostAmount() {
        return boostAmount;
    }

    @Override
    public void doMove(Creature attacker, Creature defender) {
        attacker.setDefense(attacker.getDefense() + boostAmount);
    }
}
