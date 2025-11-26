package Model;

public class Battle {

    private Trainer player;
    private Trainer opponent;

    public Battle(Trainer player, Trainer opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    /**
     * Runs one turn of combat.
     * Simple rule:
     *  damage = attacker.attack - defender.defense
     * if damage < 1, set to 1.
     */
    public String takeTurn() {

        Creature p = player.getActiveCreature();
        Creature a = opponent.getActiveCreature();

        boolean playerFirst = p.getAttack() >= a.getAttack();

        // FIRST ATTACKER
        if (playerFirst) {

            attack(p, a);
            if (a.getHealth() <= 0) {
                opponent.autoSwap();
                return player.getName() + "'s " + p.getName() + " knocked out " + a.getName();
            }

            // Opponent attacks second
            attack(a, p);
            if (p.getHealth() <= 0) {
                player.autoSwap();
                return opponent.getName() + "'s " + a.getName() + " knocked out " + p.getName();
            }

        } else {

            attack(a, p);
            if (p.getHealth() <= 0) {
                player.autoSwap();
                return opponent.getName() + "'s " + a.getName() + " knocked out " + p.getName();
            }

            attack(p, a);
            if (a.getHealth() <= 0) {
                opponent.autoSwap();
                return player.getName() + "'s " + p.getName() + " knocked out " + a.getName();
            }
        }

        return "Both creatures attacked!";
    }

    /**
     * Damage formula for Sprint 1.
     */
    private void attack(Creature attacker, Creature defender) {
        int damage = attacker.getAttack() - defender.getDefense();
        if (damage < 1) damage = 1;

        defender.setHealth(defender.getHealth() - damage);
    }

    /**
     * Returns true when a trainer has no living creatures left.
     */
    public boolean isBattleOver() {
        return !player.hasLivingCreature() || !opponent.hasLivingCreature();
    }

    /**
     * Returns the winner if the battle has ended.
     */
    public Trainer getWinner() {
        if (!player.hasLivingCreature()) return opponent;
        if (!opponent.hasLivingCreature()) return player;
        return null;
    }
}
