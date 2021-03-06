package fields;

import game.Player;

public abstract class AbstractField {
	
	int place;
	
	public abstract void landedOn(Player player);
	public Player getOwner(){
		return null;
	};
	
	// These empty methods will only be overridden in the sub-class AbstractOwnables
	public void setOwner(Player owner){};
	public void removeOwner(){};
	
	/*
	1.	START
	2.	Tribe Encampment -  Territory
	3.	Gold Mine – Tax
	4.	Crater - Territory
	5.	Second Sail - Fleet
	6.	Mountain – Territory
	7.	Monastery - Refuge
	8.	Cold Dessert – Territory
	9.	Sea Grover – Fleet
	10.	Black Cave – Territory
	11.	Huts in the Mountain – Labor Camp
	12.	The Warewall - Territory
	13.	Caravan – Tax
	14.	Mountain Village– Territory 
	15.	The Buccaneers – Fleet
	16.	South Citadel - Territory
	17.	Walled City – refuge
	18.	Palace Gates – Territory
	19.	The Pit – Labor camp
	20.	Tower – Territory
	21.	Privateer Armade – Fleet
	22.	Castle - Territory
	
	 */
	
	
	
}
