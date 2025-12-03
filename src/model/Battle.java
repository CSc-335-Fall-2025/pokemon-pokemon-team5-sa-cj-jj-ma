package model;

public class Battle {

    private Trainer player1;
    private Trainer player2;
    private Trainer player3;

    public Battle(Trainer player1, Trainer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public Battle(Trainer player1, Trainer player2, Trainer player3) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
    }

    /**
     * Runs one turn of combat.
     * Simple rule:
     *  damage = attacker.attack - defender.defense
     * if damage < 1, set to 1.
     */
    public String takeTurn() {

        Creature p = player1.getActiveCreature();
        Creature a = player2.getActiveCreature();

        boolean playerFirst = p.getAttack() >= a.getAttack();

        // FIRST ATTACKER
        if (playerFirst) {

            attack(p, a);
            if (a.getHealth() <= 0) {
                player2.autoSwap();
                return player1.getName() + "'s " + p.getName() + " knocked out " + a.getName();
            }

            // player2 attacks second
            attack(a, p);
            if (p.getHealth() <= 0) {
                player1.autoSwap();
                return player2.getName() + "'s " + a.getName() + " knocked out " + p.getName();
            }

        } else {

            attack(a, p);
            if (p.getHealth() <= 0) {
                player1.autoSwap();
                return player2.getName() + "'s " + a.getName() + " knocked out " + p.getName();
            }

            attack(p, a);
            if (a.getHealth() <= 0) {
                player2.autoSwap();
                return player1.getName() + "'s " + p.getName() + " knocked out " + a.getName();
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
        return !player1.hasLivingCreature() || !player2.hasLivingCreature();
    }

    /**
     * Returns the winner if the battle has ended.
     */
    public Trainer getWinner() {
        if (!player1.hasLivingCreature()) return player2;
        if (!player2.hasLivingCreature()) return player1;
        return null;
    }
}
