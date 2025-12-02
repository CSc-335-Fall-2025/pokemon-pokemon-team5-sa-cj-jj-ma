package model;

public class healMove extends Move {
	public int power;
	
	public healMove(int power) {
		this.power = power;
	}
	public int getPower() {
		return this.power;
	}
	
	public void doMove(Creature attacker, Creature Defender) {
		
	}
}

