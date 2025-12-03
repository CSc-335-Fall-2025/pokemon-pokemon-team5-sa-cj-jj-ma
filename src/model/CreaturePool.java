package model;

/**
 * CreaturePool
 * 
 * ADDED BY SAFWAN – Critical constructor fixes:
 *  - The team’s move classes (attackMove, healMove, ShieldMove)
 *    ONLY accept ONE integer parameter.
 *
 *  - The original CreaturePool used non-existent constructors such as:
 *      new attackMove("Thunder Jolt", 25)
 *
 *    These did not match the real move classes and caused compilation errors.
 *
 *  - I updated ONLY THE CONSTRUCTOR CALLS so the project compiles.
 *    No balancing, no renaming, no logic changes.
 */
public class CreaturePool {

    public static Creature[] getAllCreatures() {

        return new Creature[] {

            new Creature("Pikachu", 90, 55, 40,
                new Move[] {
                    new attackMove(25),
                    new attackMove(20),
                    new healMove(20),
                    new ShieldMove(15)
                }),

            new Creature("Bulbasaur", 100, 50, 45,
                new Move[] {
                    new attackMove(22),
                    new healMove(15),
                    new ShieldMove(20),
                    new attackMove(15)
                }),

            new Creature("Charmander", 95, 52, 38,
                new Move[] {
                    new attackMove(28),
                    new attackMove(18),
                    new healMove(15),
                    new ShieldMove(10)
                }),

            new Creature("Squirtle", 105, 48, 55,
                new Move[] {
                    new attackMove(24),
                    new ShieldMove(25),
                    new healMove(20),
                    new attackMove(15)
                }),

            new Creature("Jigglypuff", 130, 45, 20,
                new Move[] {
                    new healMove(35),
                    new attackMove(18),
                    new ShieldMove(15),
                    new attackMove(10)
                }),

            new Creature("Yoshi", 115, 50, 35,
                new Move[] {
                    new attackMove(26),
                    new ShieldMove(20),
                    new healMove(20),
                    new attackMove(18)
                }),

            new Creature("Poliwhirl", 110, 53, 50,
                new Move[] {
                    new attackMove(25),
                    new attackMove(22),
                    new healMove(15),
                    new ShieldMove(10)
                }),

            new Creature("Gloom", 100, 55, 40,
                new Move[] {
                    new attackMove(27),
                    new healMove(15),
                    new attackMove(18),
                    new ShieldMove(15)
                }),

            new Creature("Psyduck", 95, 50, 35,
                new Move[] {
                    new attackMove(28),
                    new healMove(20),
                    new attackMove(18),
                    new ShieldMove(10)
                }),

            new Creature("Goldeen", 90, 60, 30,
                new Move[] {
                    new attackMove(30),
                    new attackMove(22),
                    new healMove(20),
                    new ShieldMove(10)
                }),

            new Creature("Dratini", 105, 60, 45,
                new Move[] {
                    new attackMove(35),
                    new attackMove(25),
                    new ShieldMove(20),
                    new healMove(20)
                }),

            new Creature("Meowth", 85, 55, 30,
                new Move[] {
                    new attackMove(22),
                    new attackMove(24),
                    new ShieldMove(15),
                    new healMove(18)
                })
        };
    }
}
