package model;

/**
 * Base Move class.
 * 
 * Added by Safwan:
 *   - Added name field (CreaturePool uses names)
 *   - Added constructor
 *   - Added getName()
 *   - Added abstract execute method for consistency
 *   - Kept simple so teammates can extend functionality later
 */
public abstract class Move {

    protected String name;

    public Move(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // All concrete moves will override this
    public abstract void doMove(Creature attacker, Creature defender);
}
