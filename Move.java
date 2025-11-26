
public class Move {
	public enum Category {
		PHYSICAL, STATUS
	}
	
	public enum Type {
		NORMAL, FIRE, WATER, GRASS, ELECTRIC, POISON, DRAGON, FAIRY
	}
	
	public enum StatusEffect {
		HP_UP, ATTACK_UP, ATTACK_DOWN, DEFENSE_UP, DEFENSE_DOWN
	}
	
	private String name;
	private Category moveCategory;
	private Type moveType;
	private StatusEffect effect;
	private int power; 
	private int effectAmt;
	
	// Constructor for moves under the "PHYSICAL" category which inflict damage on the opponent
	public Move(String name, Category moveCategory, Type moveType, int power) {
		this.name = name;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		this.power = power;
	}	
	
	// Constructor for moves under the "STATUS" category which affects the stats of either self or the opponent
	public Move(String name, Category moveCategory, Type moveType, StatusEffect effect, effectAmt) {
		this.name = name;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		this.effect = effect;
		this.effectAmt = effectAmt;
	}
	
	
	
	
	
	
}
