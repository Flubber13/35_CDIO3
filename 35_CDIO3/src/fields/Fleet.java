package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Fleet extends AbstractOwnables{

	int rent = 500;
	final int PRICE = 4000;
	int newRent;

	@Override
	public String toString() {
		return Text.fieldName[place] + " Fleet [rent=" + rent + ", PRICE=" + PRICE +", newRent=" + newRent +", owner=" + owner + ", place=" + place + "]";
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
	public void setOwner(Player player){
		this.owner=player;
		player.addNumFleetOwned(1);
	}
	
	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){	
			if(owner == null){
				GUI.showMessage(player.getName()+Text.landedOn+Text.fieldName[place]);
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion  + PRICE, Text.yes, Text.no);
				if(answer == true){
					setOwner(player);
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-PRICE);	
				}
			}
			// Proceeds to these 4 possibilities if property is not owned
			// Rent that will be charge if 1 Fleet is owned
			else if (owner == player){
				GUI.showMessage(owner.getName()+ Text.landedOn + Text.fieldName[place]+ ". " + Text.youOwn);
			}
			else {
				newRent =(int)(rent*Math.pow(2, (owner.getNumFleetOwned()-1))); // The rent the player depending on number of fleet owned
				
				GUI.showMessage(Text.owned + owner.getName() + ", " +  player.getName() + Text.mustPay + newRent + Text.to + owner.getName());
				
				player.getAccount().addBalance(-newRent);
				owner.getAccount().addBalance(newRent);
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
