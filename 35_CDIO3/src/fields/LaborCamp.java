package fields;

import desktop_resources.GUI;
import game.DiceCup;
import game.Player;
import game.Text;

public class LaborCamp extends AbstractOwnables {

	int baseRent = 100;
	int price = 2500;
	int place;


	@Override
	public int getRent() {
		return baseRent;
	}

	public LaborCamp(int place){
		this.place=place;
	}

	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){
			if(owner == null){
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion + price, Text.yes, Text.no);
				if(answer == true){
					this.owner = player;
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-price);
				}
			}
			else if(player!=owner){
				DiceCup dicecup = new DiceCup();
				GUI.showMessage(player.getName()+Text.rentRoll);	// Tells player to roll again
				player.setLastRoll(dicecup.roll());		// Rolls the dice and saves it to player
				GUI.setDice(dicecup.getDie1().getLastRoll(), dicecup.getDie2().getLastRoll());		// Shows dice on screen
				GUI.showMessage(Text.laborRent+ player.getLastRoll()+ " = " + (player.getLastRoll()*100)); // Shows new rent on screen
				player.getAccount().addBalance(- player.getLastRoll()*baseRent);	
				owner.getAccount().addBalance(player.getLastRoll()*baseRent);				
			} 
		}
	}


	// 11. Huts in the Mountain – Labor Camp
	// 19. The Pit – Labor camp

}	