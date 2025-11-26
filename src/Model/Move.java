package Model;

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
	
	/**
	 * Constructor for moves under the "PHYSICAL" category which inflict damage on the opponent
	 * 
	 * @param name
	 * @param moveCategory
	 * @param moveType
	 * @param power
	 */
	public Move(String name, Category moveCategory, Type moveType, int power) {
		this.name = name;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		this.power = power;
	}	
	
	/**
	 * Constructor for moves under the "STATUS" category which affects the stats of either self or the opponent
	 * 
	 * @param name
	 * @param moveCategory
	 * @param moveType
	 * @param effect
	 * @param effectAmt
	 */
	public Move(String name, Category moveCategory, Type moveType, StatusEffect effect, int effectAmt) {
		this.name = name;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		this.effect = effect;
		this.effectAmt = effectAmt;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the move's category
	 */
	public Category getMoveCategory() {
		return moveCategory;
	}

	/**
	 * @return the move's type
	 */
	public Type getMoveType() {
		return moveType;
	}

	/**
	 * @return a status move's effect 
	 */
	public StatusEffect getEffect() {
		return effect;
	}

	/**
	 * @return a physical move's power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @return the amount of change from a status move's effect
	 */
	public int getEffectAmt() {
		return effectAmt;
	}
	
}
