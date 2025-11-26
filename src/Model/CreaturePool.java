package Model;

public class CreaturePool {

    private static final Creature[] CREATURES = {
    	
    		
        new Creature("Pikachu",      90,  55, 40),
        new Creature("Bulbasaur",   100, 50, 45),
        new Creature("Charmander",   95,  52, 38),
        new Creature("Squirtle",    105, 48, 55),
        new Creature("Jigglypuff",  130, 45, 20),
        new Creature("Yoshi",       115, 50, 35),
        new Creature("Poliwhirl",   110, 53, 50),
        new Creature("Gloom",       100, 55, 40),
        new Creature("Psyduck",     95,  50, 35),
        new Creature("Goldeen",     90,  60, 30),
        new Creature("Dratini",     105, 60, 45),
        new Creature("Meowth",      85,  55, 30)
    };

    /**
     * Returns the full list of all available creatures.
     */
    public static Creature[] getAllCreatures() {
        return CREATURES;
    }
}
