package model;

import java.util.Random;

/**
 * Basic Battle Engine
 *
 * Updated by Safwan:
 *   - Removed references to speed, maxHealth, boost systems that don't exist yet
 *   - Adjusted move execution so it works with current Move subclasses
 *   - Added safe null checks and faint checks
 *   - Kept AI very simple so Jett can improve it later
 *   - Left GUI integration + battle log formatting for Mohammad
 */
public class Battle {

    private Trainer player;
    private Trainer opponent;
    private Random random = new Random();

    public Battle(Trainer player, Trainer opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    /**
     * Executes ONE turn of battle.
     * - Player always attacks first for now (speed not implemented)
     * - Jett will expand this later.
     */
    public String takeTurn(Move playerMove) {

        Creature p = player.getActiveCreature();
        Creature o = opponent.getActiveCreature();

        Move aiMove = chooseAIMove(o);

        StringBuilder log = new StringBuilder();

        // PLAYER MOVE
        log.append(player.getName())
           .append("'s ")
           .append(p.getName())
           .append(" used ")
           .append(playerMove.getName())
           .append("!\n");

        playerMove.doMove(p, o);

        if (o.isFainted()) {
            log.append(opponent.getName())
               .append("'s ")
               .append(o.getName())
               .append(" fainted!\n");
            opponent.autoSwap();
            return log.toString();
        }

        // AI MOVE
        log.append(opponent.getName())
           .append("'s ")
           .append(o.getName())
           .append(" used ")
           .append(aiMove.getName())
           .append("!\n");

        aiMove.doMove(o, p);

        if (p.isFainted()) {
            log.append(player.getName())
               .append("'s ")
               .append(p.getName())
               .append(" fainted!\n");
            player.autoSwap();
        }

        return log.toString();
    }

    /**
     * Very basic AI:
     * - Uses first attackMove if it has one
     * - Otherwise random move
     *
     * Jett will upgrade this in Sprint 4.
     */
    private Move chooseAIMove(Creature c) {
        for (Move m : c.getMoves()) {
            if (m instanceof attackMove) return m;
        }
        Move[] moves = c.getMoves();
        return moves[random.nextInt(moves.length)];
    }

    public boolean isBattleOver() {
        return !player.hasLivingCreature() || !opponent.hasLivingCreature();
    }

    public Trainer getWinner() {
        if (!player.hasLivingCreature()) return opponent;
        if (!opponent.hasLivingCreature()) return player;
        return null;
    }
}
