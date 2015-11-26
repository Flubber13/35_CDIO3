package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Fleet extends AbstractOwnables{

	int rent = 500;
	final int PRICE = 4000;

	@Override
	public String toString() {
		return "Fleet [rent=" + rent + ", PRICE=" + PRICE + ", owner=" + owner + ", place=" + place + "]";
	}
	
	@Override
	public int getRent() {
		return rent; 
	}

	// Fleet constructor with a parameter for its place on the game board 
	public Fleet(int place){
		this.place = place;
	}

	/*	This method will only run if the position of the player is the same as the position decided in the constructor
	 	First it checks if the field is not owned. If so the player will be asked to buy it(player gets YES/No choice)
	 	If the field is owned the player has to pay rent depending on the number of Fleets owned by that same player
	 	this is shown below in four different cases. */

	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){	
			if(owner == null){
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion  + PRICE, Text.yes, Text.no);
				if(answer == true){
					this.owner = player;
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-PRICE);
					player.addNumFleetOwned(1);
				}
			}
			// Proceeds to these 4 possibilities if property is not owned
			// Rent that will be charge if 1 Fleet is owned
			else if (owner == player){
				GUI.showMessage(owner + Text.owned);
			}
			else {
				GUI.showMessage(Text.owned + owner.getName() + ", " +  player.getName() + Text.mustPay + (rent*Math.pow(2, player.getNumFleetOwned())) + Text.to + owner.getName());
				player.getAccount().addBalance(-rent*Math.pow(2, player.getNumFleetOwned()));
				owner.getAccount().addBalance(rent*Math.pow(2, player.getNumFleetOwned()));
			}
		}
	}
	/*
	5.	Second Sail - Fleet
	9.	Sea Grover – Fleet
	15.	The Buccaneers – Fleet
	21.	Privateer Armade – Fleet
	 */
}
