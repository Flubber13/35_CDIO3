package game;


public class Dice {

	private int lastRoll; 
	
	private int sides;
	
	//Method so we can decide on how many sides the dice consists of
	public Dice(int sides){ 
		this.sides = sides;
	}
	
	// The method roll randomizes a value(roll). +1 because we don't want the value 0
	public int roll(){
		setLastRoll((int)Math.floor( (Math.random())*sides ) +1);
		return getLastRoll();
	}
	
	public int getLastRoll(){
		return lastRoll;
	}
	
	public void setLastRoll(int lastRoll){
		this.lastRoll = lastRoll;
	}
	
	
}

