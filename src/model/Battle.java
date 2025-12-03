package model;

import java.util.Random;

/**
 * Basic Battle Engine
 * 
 * Added by Safwan:
 *   - Simplified version using only the fields our Creature class has
 *   - Enough for GUI + Controller testing
 *   - Advanced features left for teammates (critical hits, turn order, types, etc.)
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
     * Executes one turn of battle.
     * Player always goes first (team can improve later).
     */
    public String takeTurn(Move playerMove) {

        Creature p = player.getActiveCreature();
        Creature o = opponent.getActiveCreature();

        Move aiMove = chooseAIMove(o);

        StringBuilder log = new StringBuilder();

        // Player attacks first
        log.append("Player's " + p.getName() + " used " + playerMove.getClass().getSimpleName() + "!\n");
        playerMove.doMove(p, o);

        if (o.isFainted()) {
            opponent.autoSwap();
            log.append("Opponent's creature fainted! They swapped.\n");
            return log.toString();
        }

        // Opponent attacks
        log.append("Opponent's " + o.getName() + " used " + aiMove.getClass().getSimpleName() + "!\n");
        aiMove.doMove(o, p);

        if (p.isFainted()) {
            player.autoSwap();
            log.append("Your creature fainted! Auto-swapped.\n");
        }

        return log.toString();
    }

    /**
     * Very simple AI:
     *  - Attack if possible
     *  - Otherwise random move
     */
    private Move chooseAIMove(Creature c) {
        for (Move m : c.getMoves()) {
            if (m instanceof attackMove) {
                return m;
            }
        }
        // fallback
        Move[] moves = c.getMoves();
        return moves[random.nextInt(moves.length)];
    }
}
