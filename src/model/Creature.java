package model;

/**
 * Creature class for representing a Pokemon-like character.
 * 
 * NOTE (Safwan – Sprint Fix):
 *  - Added the isFainted() method because Trainer and Team require it.
 *    Without this method, the entire project would not compile.
 */
public class Creature {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private Move[] moves;
    private int counter;

    public Creature(String name, int health, int attack, int defense, Move[] moveArray) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.moves = moveArray;
        this.counter = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int newhealth) {
        this.health = newhealth;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public Move[] getMoves() {
        return this.moves;
    }

    public void setMoves(Move[] newMoves) {
        this.moves = newMoves;
    }

    public int getCounter(){
        return this.counter;
    }

    public void setCounter(int number) {
        this.counter = number;
    }

    public void incrementCounter() {
        if (this.counter >= 1) {
            this.counter--;
        }
    }

    /**
     * ADDED BY SAFWAN (Critical Fix):
     * Trainer, Team, and Battle all call isFainted(),
     * but it did not exist in the Creature class.
     * 
     * This method is required for the project to compile
     * and for swapping/faint logic to work.
     */
    public boolean isFainted() {
        return this.health <= 0;
    }
    
    public void setDefense(int newDef) {
        this.defense = newDef;
    }

}
