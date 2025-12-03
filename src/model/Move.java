package model;

/**
 * Abstract Move class.
 *
 * ADDED BY SAFWAN (Critical Fix):
 *  - This class was originally empty, causing ALL move subclasses 
 *    (attackMove, healMove, ShieldMove) to break.
 *  - Battle expects moves to have a doMove(...) method.
 *  - Making Move abstract forces all children to implement that method.
 */
public abstract class Move {

    /**
     * Every move must be able to act on attacker / defender.
     * Subclasses override with their specific effects.
     */
    public abstract void doMove(Creature attacker, Creature defender);
}
