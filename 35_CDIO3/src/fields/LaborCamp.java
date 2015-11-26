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
		return  Text.fieldName[place] + " LaborCamp [rent=" + rent + ", price=" + price + ", owner=" + owner + ", place=" + place + "]";
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
			
			else if(player!=owner){
				DiceCup dicecup = new DiceCup();
				GUI.showMessage(player.getName()+Text.rentRoll);	// Tells player to roll again
				player.setLastRoll(dicecup.roll());		// Rolls the dice and saves it to player
				GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());		// Shows dice on screen
				
				newRent = player.getNumLaborOwned()*player.getLastRoll()*rent;
				GUI.showMessage(Text.laborRent + player.getLastRoll()+ " = " + newRent); // Shows new rent on screen
				player.getAccount().addBalance(- newRent);	
				owner.getAccount().addBalance(newRent);				
			} 
		}
	}


	// 11. Huts in the Mountain – Labor Camp
	// 19. The Pit – Labor camp

}	