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
	
	Player[] player = new Player[6];
	DiceCup dicecup = new DiceCup();
	
	Car[] car;  
	
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

	Refuge f7 = new Refuge(7,5000);
	Refuge f17 = new Refuge(17,500);
	Tax f3_f13 = new Tax();


	public void run() {

		// Set up the fields on the game board 
		GameBoard.initialize();

		// Determines the number of players in the game
		numOfPlayers = GUI.getUserInteger(Text.howManyPlayers, 2, 6);

		// This loop adds the determined number of players to the game
		for (int i = 0; i < numOfPlayers; i++) {
			player[i] = new Player(30000,GUI.getUserString(Text.enterName[i]));
			GUI.addPlayer(player[i].getName(), player[i].getAccount().getBalance());
			GUI.setCar(1, player[i].getName());
		}
		
		// This loop gives all active players a turn  
		while(1==1){
			for (int i = 0; i < numOfPlayers; i++){
				playerTurn(player[i]);
				for (int j = 0; j < numOfPlayers; j++){
				GUI.setBalance(player[j].getName(),player[j].getAccount().getBalance());
				}
			}	
		}
	}

	// Method for the player turn
	private void playerTurn(Player player) {
		GUI.showMessage(player.getName() + Text.roll );		// The player is asked to roll the dice									
		GUI.removeCar(player.getPosition(), player.getName());		// car is removed from previous position
		player.setPosition(dicecup.roll());		// Dice is rolled, and the players position is saved
		player.setLastRoll(dicecup.getDie1().getLastRoll() + dicecup.getDie2().getLastRoll()); // Saves the last roll to player
		GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());	// Dice is shown on screen
		GUI.setCar(player.getPosition(), player.getName());		// Car is moved to field
		GUI.showMessage(player.getName() + Text.landedOn + Text.fieldName[player.getPosition()]);	// Displays which player landed on the field

		// Rolls the dice again if the player lands on a Labor Camp f11 or f19
		labourRoll(player,f11,11);
		labourRoll(player,f19,19);
		
		//runs through all landedOn possibilities
		f2.landedOn(player);
		f3_f13.landedOn(player);
		f4.landedOn(player);
		f5.landedOn(player);
		f6.landedOn(player);
		f7.landedOn(player);
		f8.landedOn(player);
		f9.landedOn(player);
		f10.landedOn(player);
		f11.landedOn(player);
		f12.landedOn(player);
		f14.landedOn(player);
		f15.landedOn(player);
		f16.landedOn(player);
		f17.landedOn(player);
		f18.landedOn(player);
		f19.landedOn(player);
		f20.landedOn(player);
		f21.landedOn(player);
		f22.landedOn(player);		
		
		if (player.getAccount().getBalance()==0){
			
		}
	}

	

	// If the labor camp is not owned by the player, but another, the player will be asked to roll again
	private void labourRoll(Player player, LaborCamp f, int place){
		if(player!=f.getOwner() && ((player.getPosition() == place && f.getOwner() != null))){
			GUI.showMessage(player.getName()+Text.rentRoll);	// Tells player to roll again
			player.setLastRoll(dicecup.roll());		// Rolls the dice and saves it to player
			GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());		// Shows dice on screen
		}
	}
}

