package game;


public class DiceCup {
	
	//The following creates two dice with six sides.
	private Dice die1 = new Dice(6); 
	private Dice die2 = new Dice(6);
	
	//this method rolls die 1 and die 2 and sums the outcome
	public int roll(){
		getDie1().roll();
		getDie2().roll();
		return getDie1().getLastRoll() + getDie2().getLastRoll();
	}

	public Dice getDie1() {
		return die1;
	}

	public void setDie1(Dice die1) {
		this.die1 = die1;
	}

	public Dice getDie2() {
		return die2;
	}

	public void setDie2(Dice die2) {
		this.die2 = die2;
	}
}
