package model;

public class ShieldMove extends Move {
	private int shield;
	
	public ShieldMove(int number) {
		this.shield = number;
	}
	
	public void doMove(Creature attacker, Creature Defender) {
		attacker.setHealth(attacker.getHealth()+this.shield);
	}
}
