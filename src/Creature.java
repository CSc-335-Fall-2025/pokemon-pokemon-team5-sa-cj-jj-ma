
public class Creature {
	private String name;
	private int health;
	private int attack;
	private int defense;
	private Move[] moves;
	
	public Creature(String name, int health, int attack, int defense) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}
}
