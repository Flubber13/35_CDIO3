package fields;

import game.Player;

public abstract class AbstractOwnables extends AbstractField{
	
	int price;
	Player owner;
	
	public void setPrice(int price){
		this.price=price;
	}
	
	public void setOwner(Player owner){
		this.owner=owner;
	}
	
	public Player getOwner() {
		return owner;
	}
	

	public abstract int getRent();

	
	/*
	2.	Tribe Encampment -  Territory
	4.	Crater - Territory
	5.	Second Sail - Fleet
	6.	Mountain – Territory
	8.	Cold Dessert – Territory
	9.	Sea Grover – Fleet
	10.	Black Cave – Territory
	11.	Huts in the Mountain – Labor Camp
	12.	The Warewall - Territory
	14.	Mountain Village– Territory 
	15.	The Buccaneers – Fleet
	16.	South Citadel - Territory
	18.	Palace Gates – Territory
	19.	The Pit – Labor camp
	20.	Tower – Territory
	21.	Privateer Armade – Fleet
	22.	Castle - Territory
	 */
	
}
