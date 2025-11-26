package Model;

public class attackMove extends Move{
	public int power;
	
	public attackMove(int power) {
		this.power = power;
	}
	public int getPower() {
		return this.power;
	}
}
