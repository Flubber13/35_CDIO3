package fields;

import desktop_resources.GUI;
import game.Player;

public class Tax extends AbstractField{
	
	int taxAmount3 = 2000;
	int taxAmount13 = 4000;
	int taxRate = 10;
	int place;
	
	@Override
	public void landedOn(Player player) {
		if (player.getPosition() == 3){ //gold mine tax
			player.getAccount().addBalance(-taxAmount3); //removes 2000 from balance
		}
		if (player.getPosition() == 13){ //caravan tax
			boolean Buttonpressed = GUI.getUserLeftButtonPressed(player.getName() + "You landed on the caravan tax field!, choose between -10% of overall balance or -4000 total!", "-10%", "-4000");{
			if (Buttonpressed == true){ //We make a boolean called "Buttonpressed" and set it to true or false (decided by GUI input)
				player.getAccount().addBalance(-player.getAccount().getBalance()/taxRate); //If true "-10%" was pressed, we then remove 10% from balance
			}
			else 
				player.getAccount().addBalance(-taxAmount13); // -4000 was pressed, removes 4000 from balance
			}
	}
}
	
	
	
	//	3.	Gold mine Tax Pay 2000  
	//	13.	Caravan Tax Pay 4000 or 10% of total assets
}
