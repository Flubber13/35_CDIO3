package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Fleet extends AbstractOwnables{

	final int RENT_1 = 500;
	final int RENT_2 = 1000;
	final int RENT_3 = 2000;
	final int RENT_4 = 4000;
	final int PRICE = 4000;
	int place;

	@Override
	public int getRent() {
		return 0;
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
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion + price, Text.yes, Text.no);
				if(answer == true){
					this.owner = player;
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-PRICE);
					player.setNumFleetOwned(1);
				}
			}
			// Proceeds to these 4 possibilities if property is not owned
			// Rent that will be charge if 1 Fleet is owned
			if(owner.getNumFleetOwned()==1){
				player.getAccount().addBalance(-RENT_1);
				owner.getAccount().addBalance(RENT_1);
			}
			// Rent that will be charge if 2 Fleets are owned
			if(owner.getNumFleetOwned()==2){
				player.getAccount().addBalance(-RENT_2);
				owner.getAccount().addBalance(RENT_2);
			}
			// Rent that will be charge if 3 Fleets are owned
			if(owner.getNumFleetOwned()==3){
				player.getAccount().addBalance(-RENT_3);
				owner.getAccount().addBalance(RENT_3);
			}
			// Rent that will be charge if 4 Fleets are owned
			if(owner.getNumFleetOwned()==4){
				player.getAccount().addBalance(-RENT_4);
				owner.getAccount().addBalance(RENT_4);
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
