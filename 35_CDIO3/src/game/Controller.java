package game;

import desktop_resources.GUI;
import fields.AbstractOwnables;
import game.GameBoard;

public class Controller {

	int numOfPlayers;
	int activePlayers;
	String[] name = new String[6];

	Player[] player = new Player[6];
	DiceCup dicecup = new DiceCup(); 
	GameBoard gameboard = new GameBoard();

	public void run() { 

		// Set up the game board 
		gameboard.setupGuiFields();
		//createCars();

		// Determines the number of players in the game
		numOfPlayers = GUI.getUserInteger(Text.howManyPlayers, 2, 6);
		activePlayers = numOfPlayers;	

		// This loop adds the determined number of players to the game
		for (int i = 0; i < numOfPlayers; i++) {
			name[i] = GUI.getUserString(Text.enterName[i]);

			while ((name[i].equals("")) || name[i].equals(" ")){
				GUI.showMessage(Text.nameInvalid);
				name[i] = GUI.getUserString(Text.enterName[i]);
			}
			for (int j = 1; j <= i; j++){
				while(name[i].equals(name[i-j])) {
					GUI.showMessage(Text.nameTaken);
					name[i] = GUI.getUserString(Text.enterName[i]);
				}
			}
			player[i] = new Player(30000,name[i]);		// Player gets a balance and the name chosen by the user
			GUI.addPlayer(player[i].getName(), player[i].getAccount().getBalance(),gameboard.getCar()[i]);	// Player is added to board	
			GUI.setCar(1, player[i].getName());	// Players car is added to board
		}

		// This loop gives all active players a turn, until only one player is left
		while(activePlayers>1){
			for (int i = 0; i < numOfPlayers; i++){
				playerTurn(player[i]);
				for (int j = 0; j < numOfPlayers; j++)	
					GUI.setBalance(player[j].getName(),player[j].getAccount().getBalance());// Updates everybody's balance after every turn
				if(activePlayers==1)break; // Breaks out of the loop, if only one active player is left
			}
			for (int i = 0; i < numOfPlayers; i++){
				setWinner(player[i]);	// Checks if only one player is left, then sets the player as winner
			}			
		}	
	}

	// Method for the player turn - The player can only use the turn if their balance is not 0
	private void playerTurn(Player player) {
		if(player.getAccount().getBalance()!=0){
			GUI.showMessage(player.getName() + Text.roll );		// The player is asked to roll the dice									
			GUI.removeCar(player.getPosition(), player.getName());		// car is removed from previous position
			player.addPosition(dicecup.roll());		// Dice is rolled, and the players position is saved
			GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());	// Dice is shown on screen
			GUI.setCar(player.getPosition(), player.getName());		// Car is moved to field
			landedOnField(player);	// Runs the operation for the field the player landed on
			GUI.setBalance(player.getName(), player.getAccount().getBalance()); // Shows current player balance on GUI game board
			if (player.getAccount().getBalance()==0) 
				bankRupt(player);	// Player is removed from the game if their balance is 0, after their turn.
		}
	}
	// Makes sure that that landedOn method does not run on Start field
	private void landedOnField(Player player) {
		if(player.getPosition()!=1)	// If position is not 1, landedOn operation will run
			gameboard.getLogicField()[player.getPosition()].landedOn(player);
		else // If position is 1, player landed on start and no landedOn operation will run
			GUI.showMessage(player.getName()+Text.startField); 
	}

	// Removes all properties and cars from player, and subtracts 1 from the variable activePlayers
	private void bankRupt(Player player){
		GUI.showMessage(player.getName()+Text.bankrupt);
		GUI.removeAllCars(player.getName());
		removeOwnership(player); 
		activePlayers -= 1;
	}

	// Removes player ownership, both from logic fields and GUI fields, if the player is the owner
	private void removeOwnership(Player player) {
		for (int i=1; i<=22; i++){
			if(gameboard.getLogicField()[i] instanceof AbstractOwnables){
				if (gameboard.getLogicField()[i].getOwner() == player){
					gameboard.getLogicField()[i].removeOwner();
					GUI.removeOwner(i);
				}
			}
		}		
	}

	// This method set a player to be the winner if he/she is the only active player in the game
	private void setWinner(Player player){
		if(player.getAccount().getBalance()!=0 && activePlayers==1){
			while(true)GUI.showMessage(">>> "+player.getName()+Text.winner+" <<<");
		}
	}

	public String toString(){
		String returnString = null;
		for (int i = 2 ; i < gameboard.getLogicField().length ; i++)
			returnString += "[" + gameboard.getLogicField()[i].toString() + "] ";
		return returnString;
	}

}


