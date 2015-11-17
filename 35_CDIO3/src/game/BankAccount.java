package game;


public class BankAccount {
	
	private int balance;
	
	//definition of a bank account
	public BankAccount(int balance){
		this.balance = balance;
	}
	
	//Method to get the balance
	public int getBalance(){
		return balance;
	}
	
	/*The following method addBalance adds the points from the field which the player landed on. 
	  If the balance becomes negative, after the addition, the balance will be set to 0.*/
	
	public int addBalance(int input){
		if (this.balance + input < 0)
			this.balance = 0;
		else this.balance = this.balance + input;
		return input;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	static int player1Balance = 1000;
//	static int player2Balance = 1000;
//	
//	
//	public int player1Balance(){
//		return player1Balance();
//	}
//	
//	public int player2Balance(){
//		return player2Balance();
//	}
}
