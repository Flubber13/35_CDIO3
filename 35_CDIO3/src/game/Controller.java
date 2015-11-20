package game;

import desktop_codebehind.Car;
import desktop_resources.GUI;
import fields.Fleet;
import fields.LaborCamp;
import fields.Refuge;
import fields.Tax;
import fields.Territory;
import game.GameBoard;

public class Controller {

	int numOfPlayers;
	int activePlayers;

	Player[] player = new Player[6];
	DiceCup dicecup = new DiceCup();
	Car[] car;  
	GameBoard gameboard = new GameBoard();

	Territory f2 = new Territory(2, 100, 1000);
	Territory f4 = new Territory(4,300,1500);
	Territory f6 = new Territory(6,500,2000);
	Territory f8 = new Territory(8,700,3000);
	Territory f10 = new Territory(10,1000,4000);
	Territory f12 = new Territory(12,1300,4300);
	Territory f14 = new Territory(14,1600,4750);
	Territory f16 = new Territory(16,2000,5000);
	Territory f18 = new Territory(18,2600,5500);
	Territory f20 = new Territory(20,3200,6000);
	Territory f22 = new Territory(22,4000,8000);
	LaborCamp f11 = new LaborCamp(11);
	LaborCamp f19 = new LaborCamp(19);
	Fleet f5 = new Fleet(5);
	Fleet f9 = new Fleet(9);
	Fleet f15 = new Fleet(15);
	Fleet f21 = new Fleet(21);	
	Refuge f7 = new Refuge(7,500);
	Refuge f17 = new Refuge(17,5000);
	Tax f3 = new Tax(3);
	Tax f13 = new Tax(13);


	public void run() {

		// Set up the fields on the game board 
		gameboard.initialize();

		// Determines the number of players in the game
		numOfPlayers = GUI.getUserInteger(Text.howManyPlayers, 2, 6);
		activePlayers = numOfPlayers;

		// This loop adds the determined number of players to the game
		for (int i = 0; i < numOfPlayers; i++) {
			player[i] = new Player(30000,GUI.getUserString(Text.enterName[i]));		// Player gets balance and a name chosen by user
			GUI.addPlayer(player[i].getName(), player[i].getAccount().getBalance());	// Player is added to board
			GUI.setCar(1, player[i].getName());	// Players car is added to board
		}

		// This loop gives all active players a turn
		while(activePlayers>1){
			for (int i = 0; i < numOfPlayers; i++){
				playerTurn(player[i]);
				for (int j = 0; j < numOfPlayers; j++){	// inner loop will update the balance of all players after every turn
					GUI.setBalance(player[j].getName(),player[j].getAccount().getBalance());
				}
				if(activePlayers==1)break;
			}	
			for (int i = 0; i < numOfPlayers; i++){
				setWinner(player[i]);
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
			GUI.showMessage(player.getName() + Text.landedOn + Text.fieldName[player.getPosition()]);	// Displays which player landed on the field

			// player is asked to roll dice again, if they landed on a Labor Camp, f11 or f19
			labourRoll(player,f11,11);
			labourRoll(player,f19,19);

			// Runs through the operation for the field the player landed on
			landedOnOperations(player);
			
			// Shows current player balance on GUI game board
			GUI.setBalance(player.getName(), player.getAccount().getBalance());
			
			// Here the player is removed from the game if their balance is 0, after their turn.
			if (player.getAccount().getBalance()==0){
				bankRupt(player);
			}
		}
	}

	/* If the player landed on the Labor Camp and the labor camp is not owned by the player, 
	   but owned by another player, the player will be asked to roll the dice again */
	private void labourRoll(Player player, LaborCamp f, int place){
		if( player.getPosition() == place && player!=f.getOwner() && f.getOwner() != null){
			GUI.showMessage(player.getName()+Text.rentRoll);	// Tells player to roll again
			player.setLastRoll(dicecup.roll());		// Rolls the dice and saves it to player
			GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());		// Shows dice on screen
			GUI.showMessage(Text.laborRent+ player.getLastRoll()+ " = " + (player.getLastRoll()*100));
		}
	}
	
	// Removes all properties and cars from player
	private void bankRupt(Player player){
		GUI.showMessage(player.getName()+Text.bankRobed);
		GUI.removeAllCars(player.getName());
		removeOwnership(player); 
		activePlayers -= 1;
	}

	// Removes player ownership, both from AbstractOwnables Class and from the GUI game board
	private void removeOwnership(Player player) {
		if(player==f2.getOwner()){
			f2.setOwner(null);
			GUI.removeOwner(2);}
		if(player==f4.getOwner()){
			f4.setOwner(null);
			GUI.removeOwner(4);}
		if(player==f6.getOwner()){
			f6.setOwner(null);
			GUI.removeOwner(6);}
		if(player==f8.getOwner()){
			f8.setOwner(null);
			GUI.removeOwner(8);}
		if(player==f10.getOwner()){
			f10.setOwner(null);
			GUI.removeOwner(10);}
		if(player==f12.getOwner()){
			f12.setOwner(null);
			GUI.removeOwner(12);}
		if(player==f14.getOwner()){
			f14.setOwner(null);
			GUI.removeOwner(14);}
		if(player==f16.getOwner()){
			f16.setOwner(null);
			GUI.removeOwner(16);}
		if(player==f18.getOwner()){
			f18.setOwner(null);
			GUI.removeOwner(18);}
		if(player==f20.getOwner()){
			f20.setOwner(null);
			GUI.removeOwner(20);}
		if(player==f22.getOwner()){
			f22.setOwner(null);
			GUI.removeOwner(22);}
		if(player==f11.getOwner()){
			f11.setOwner(null);
			GUI.removeOwner(11);}
		if(player==f19.getOwner()){
			f19.setOwner(null);
			GUI.removeOwner(19);}
		if(player==f5.getOwner()){
			f5.setOwner(null);
			GUI.removeOwner(5);}
		if(player==f9.getOwner()){
			f9.setOwner(null);
			GUI.removeOwner(9);}
		if(player==f15.getOwner()){
			f15.setOwner(null);
			GUI.removeOwner(15);}
		if(player==f21.getOwner()){
			f21.setOwner(null);
			GUI.removeOwner(21);}
	}

	/* Here we run through all landedOn operations. The operation only works if 
	 * the player actually lands on the field that corresponds to the operation */
	private void landedOnOperations(Player player){
		f2.landedOn(player);
		f3.landedOn(player);
		f4.landedOn(player);
		f5.landedOn(player);
		f6.landedOn(player);
		f7.landedOn(player);
		f8.landedOn(player);
		f9.landedOn(player);
		f10.landedOn(player);
		f11.landedOn(player);
		f12.landedOn(player);
		f13.landedOn(player);
		f14.landedOn(player);
		f15.landedOn(player);
		f16.landedOn(player);
		f17.landedOn(player);
		f18.landedOn(player);
		f19.landedOn(player);
		f20.landedOn(player);
		f21.landedOn(player);
		f22.landedOn(player);
	}

	private void setWinner(Player player){
		if(player.getAccount().getBalance()!=0 && activePlayers==1){
			while(true)GUI.showMessage(">>> "+player.getName()+Text.winner+" <<<");
		}
	}
}

