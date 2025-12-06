package model;

/**
 * Attack move.
 * 
 * Updated by Safwan:
 *   - Added (String name, int power) constructor to match CreaturePool
 *   - Added call to super(name)
 *   - Left damage formula simple so Jett can expand later
 */
public class attackMove extends Move {

    private int power;

    public attackMove(String name, int power) {
        super(name);   // NEW: ensures Move has a name
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void doMove(Creature attacker, Creature defender) {
        int damage = Math.max(1, attacker.getAttack() + power - defender.getDefense());
        defender.setHealth(defender.getHealth() - damage);
    }
}
