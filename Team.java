
public class Team {
	private List<Creature> creatures;
	private Creature currCreature;
	private int currIndex;
	
	public Team() {
		creatures = new ArrayList<>();
		currCreature = null;
		currIndex = -1;
	}
	
	public void addCreature(Creature c) {
		if (creatures.size() < 3) {
			creatures.add(c);
			
			if (currIndex == -1) {
				currIndex = 0;
				currCreature = c;
			}
		}
	}
	
	public boolean isCreatureFainted(Creature c) {
		return c.getHealth() == 0;
	}
	
	public boolean isTeamFainted() {
		for (Creature c : creatures) {
			if (!isCreatureFainted(c)) {
				return false;
			}
		}
		return true;
	}
	
	
	public void autoSwap() {
		if (isCreatureFainted(currCreature)) {
			currCreature = creatures.get(++currIndex);
		}
	}
	
	public void manualSwap(Creature swapCreature) {
		if (creatures.contains(swapCreature)) {
			currCreature = swapCreature;
			currIndex = creatures.indexOf(swapCreature);
		}
	}
}
