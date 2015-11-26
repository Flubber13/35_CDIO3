package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Tax extends AbstractField{

	@Override
	public String toString() {
		return "Tax [taxAmount3=" + taxAmount3 + ", taxAmount13=" + taxAmount13 + ", taxRate=" + taxRate + ", place="
				+ place + "]";
	}


	int taxAmount3 = 2000;
	int taxAmount13 = 4000;
	int taxRate = 10;

	public Tax(int place){
		this.place=place;
	}
	
	
	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){
			if (player.getPosition() == 3){ //gold mine tax
				GUI.showMessage(player.getName()+Text.landedOn+Text.fieldName[place]+" "+Text.payTax+": "+taxAmount3);
				player.getAccount().addBalance(-taxAmount3); //removes 2000 from balance
			}
			if (player.getPosition() == 13){ //caravan tax
				GUI.showMessage(player.getName()+Text.landedOn+Text.fieldName[place]);
				boolean Buttonpressed = GUI.getUserLeftButtonPressed(Text.taxChoice, "-10%", "-4000");{
					if (Buttonpressed == true){ //We make a boolean called "Buttonpressed" and set it to true or false (decided by GUI input)
						player.getAccount().addBalance(-player.getAccount().getBalance()/taxRate); //If true "-10%" was pressed, we then remove 10% from balance
					}
					else 
						player.getAccount().addBalance(-taxAmount13); // -4000 was pressed, removes 4000 from balance
				}
			}
	
		}
	}


	@Override
	public Player getOwner() {
		// Returns nothing because Tax can not have an owner
		return null;
	}


	@Override
	public void setOwner(Player owner) {
		// Does nothing because Tax can not have an owner
		
	}



	//	3.	Gold mine Tax Pay 2000  
	//	13.	Caravan Tax Pay 4000 or 10% of total assets
}
