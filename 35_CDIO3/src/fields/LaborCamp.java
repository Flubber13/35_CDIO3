package fields;

import desktop_resources.GUI;
import game.DiceCup;
import game.Player;
import game.Text;

public class LaborCamp extends AbstractOwnables {
	
	int rent = 100;
	int price = 2500;
	int newRent;
	
	@Override
	public String toString() {
		return  Text.fieldName[place] + " LaborCamp [rent=" + rent + ", newRent=" + newRent + ", price=" + price + ", owner=" + owner + ", place=" + place + "]";
	}

	@Override
	public int getRent() {
		return rent;
	}

	public LaborCamp(int place){
		this.place=place;
	}
	
	@Override
	public void setOwner(Player player){
		this.owner = player;
		player.addNumLaborOwned(1);
	}
	
	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){
			GUI.showMessage(player.getName() + Text.landedOn + Text.fieldName[place]);
			if(owner == null){
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion + price, Text.yes, Text.no);
				if(answer == true){
					setOwner(player);
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-price);
				}
			}
			else if(player==owner){
				GUI.showMessage(owner.getName()+ Text.landedOn + Text.fieldName[place]+ ". " + Text.youOwn);
			}
			
			// Player has to pay rent to the owner. depending on dice values and number of Labor Camps owned by owner
			else if(player!=owner){
				DiceCup dicecup = new DiceCup();
				GUI.showMessage(player.getName()+Text.rentRoll);	// Tells player to roll again
				player.setLastRoll(dicecup.roll());		// Rolls the dice and saves it to player
				GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());		// Shows dice on screen
				
				newRent = owner.getNumLaborOwned()*player.getLastRoll()*rent; // calculates and sets new rent
				
				GUI.showMessage(Text.laborRent + player.getLastRoll()+ " x "+ owner.getNumLaborOwned() +" = " + newRent); // Shows new rent on screen
				player.getAccount().addBalance(- newRent);	// Player pays rent
				owner.getAccount().addBalance(newRent);		// Owner gets rent		
			} 
		}
	}


	// 11. Huts in the Mountain – Labor Camp
	// 19. The Pit – Labor camp

}	