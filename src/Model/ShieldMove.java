package Model;

public class ShieldMove extends Move {
	private int shield;
	
	public ShieldMove(int number) {
		this.shield = number;
	}
	
	public void doMove(Creature attacker) {
		attacker.setShield(this.shield);
	}
}
