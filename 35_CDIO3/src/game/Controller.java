package game;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Ownable;
import desktop_resources.GUI;
import fields.AbstractField;
import fields.AbstractOwnables;
import fields.Fleet;
import fields.LaborCamp;
import fields.Refuge;
import fields.Tax;
import fields.Territory;
import game.GameBoard;

public class Controller {

	int numOfPlayers;
	int activePlayers;
	String[] name = new String[6];

	Player[] player = new Player[6];
	DiceCup dicecup = new DiceCup(); 
	GameBoard gameboard = new GameBoard();
	AbstractField[] logicField = new AbstractField[23];
	Car[] car = new Car[6];

	public void run() {

		createCars();

		// Set up the fields on the game board 
		gameboard.createGuiFields();
		createLogicFields();
		

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

			player[i] = new Player(30000,name[i]);		// Player gets balance and a name chosen by user

			GUI.addPlayer(player[i].getName(), player[i].getAccount().getBalance(),car[i]);	// Player is added to board	
			GUI.setCar(1, player[i].getName());	// Players car is added to board
		}

		// This loop gives all active players a turn
		while(activePlayers>1){
			for (int i = 0; i < numOfPlayers; i++){
				playerTurn(player[i]);
				for (int j = 0; j < numOfPlayers; j++)	
					GUI.setBalance(player[j].getName(),player[j].getAccount().getBalance());// Updates everybody's balance after every turn
				if(activePlayers==1)break; // Breaks out of the loop, if only one active player is left
			}
			for (int i = 0; i < numOfPlayers; i++){
				setWinner(player[i]);	// Checks if only one player is left, and sets the player as winner
			}			
		}	
	}

	// Method for the player turn - The player can only use the turn if their balance is not 0
	private void playerTurn(Player player) {
		if(player.getAccount().getBalance()!=0){
			GUI.showMessage(player.getName() + Text.roll );		// The player is asked to roll the dice									
			GUI.removeCar(player.getPosition(), player.getName());		// car is removed from previous position
			player.setPosition(dicecup.roll());		// Dice is rolled, and the players position is saved
			GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());	// Dice is shown on screen
			GUI.setCar(player.getPosition(), player.getName());		// Car is moved to field
			logicField[player.getPosition()].landedOn(player);	// Runs through the operation for the field the player landed on
			GUI.setBalance(player.getName(), player.getAccount().getBalance()); // Shows current player balance on GUI game board
			if (player.getAccount().getBalance()==0) 
				bankRupt(player);	// Player is removed from the game if their balance is 0, after their turn.
		}
	}

	// Removes all properties and cars from player
	private void bankRupt(Player player){
		GUI.showMessage(player.getName()+Text.bankrupt);
		GUI.removeAllCars(player.getName());
		removeOwnership(player); 
		activePlayers -= 1;
	}

	// Removes player ownership, both from AbstractOwnables Class and from the GUI game board
	private void removeOwnership(Player player) {
		for (int i = 1; i < logicField.length; i++) {
			if(player==logicField[i].getOwner()){
				GUI.removeOwner(i);
				logicField[i].removeOwner();
				AbstractField abstractField = logicField[i];
				abstractField.removeOwner();
			}
		}	
	}


	// This method set a player to be the winner if he/she is the only active player in the game
	private void setWinner(Player player){
		if(player.getAccount().getBalance()!=0 && activePlayers==1){
			while(true)GUI.showMessage(">>> "+player.getName()+Text.winner+" <<<");
		}
	}

	// This method creates 6 cars, one for every possible player
	private void createCars(){
		car[0] =  new Car.Builder()			// Car is saved in car array index 0
				.typeRacecar()				// Type is set 
				.patternFill()				// Color pattern is set 
				.primaryColor(Color.RED)	// Color is set 
				.build();					// Car is build
		car[1] =  new Car.Builder()
				.typeTractor()
				.patternFill()
				.primaryColor(Color.GREEN)
				.build();
		car[2] =  new Car.Builder()
				.typeUfo()
				.patternFill()
				.primaryColor(Color.ORANGE)
				.build();
		car[3] =  new Car.Builder()
				.typeRacecar()
				.patternFill()
				.primaryColor(Color.YELLOW)
				.build();
		car[4] =  new Car.Builder()
				.typeTractor()
				.patternFill()
				.primaryColor(Color.BLUE)
				.build();
		car[5] =  new Car.Builder()
				.typeUfo()
				.patternFill()
				.primaryColor(Color.BLACK)
				.build();
	}

	private void createLogicFields(){
		
		logicField[2] = new Territory(2, 100, 1000);
		logicField[4] = new Territory(4,300,1500);
		logicField[6] = new Territory(6,500,2000);
		logicField[8] = new Territory(8,700,3000);
		logicField[10] = new Territory(10,1000,4000);
		logicField[12] = new Territory(12,1300,4300);
		logicField[14] = new Territory(14,1600,4750);
		logicField[16] = new Territory(16,2000,5000);
		logicField[18] = new Territory(18,2600,5500);
		logicField[20] = new Territory(20,3200,6000);
		logicField[22] = new Territory(22,4000,8000);
		logicField[11] = new LaborCamp(11);
		logicField[19] = new LaborCamp(19);
		logicField[5] = new Fleet(5);
		logicField[9] = new Fleet(9);
		logicField[15] = new Fleet(15);
		logicField[21] = new Fleet(21);	
		logicField[7] = new Refuge(7,500);
		logicField[17] = new Refuge(17,5000);
		logicField[3] = new Tax(3);
		logicField[13] = new Tax(13);
		
	}
}

