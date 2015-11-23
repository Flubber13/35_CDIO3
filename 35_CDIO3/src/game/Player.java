package game;


public class Player {

	private String name;
	private BankAccount account;
	private int position = 1;
	private int numFleetOwned;
	private int lastRoll;

	// A player constructor with a balance and a name
	public Player(int startBalance, String name) {
		this.account = new BankAccount(startBalance);
		this.name = name;
	}

	public BankAccount getAccount() {
		return account;
	}

	public String getName() {
		return name;
	}

	//sets the position of the player
	public void setPosition(int faceValue) {
		if(position + faceValue > 22)
			position = position + faceValue -22;
		else
			position += faceValue;
	}

	public int getPosition() {
		return position;
	}

	public int getNumFleetOwned() {
		return numFleetOwned;
	}

	public void addNumFleetOwned(int numFleetOwned) {
		this.numFleetOwned += numFleetOwned;
	}

	public int getLastRoll() {
		return lastRoll;
	}

	public void setLastRoll(int lastRoll) {
		this.lastRoll = lastRoll;
	}



}
