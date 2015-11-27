package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Tax extends AbstractField{
	
	int taxAmount3 = 2000;
	int taxAmount13 = 4000;
	int taxRate = 10;
	
	public Tax(int place){
		this.place=place;
	}
	
	@Override
	public String toString() {
		return Text.fieldName[place] + " Tax [taxAmount3=" + taxAmount3 + ", taxAmount13=" + taxAmount13 + ", taxRate=" + taxRate + ", place="
				+ place + "]";
	}
	
	/*	This method contains two different parts. First part is for a tax field that collects a certain fixed tax. 
	 	The second part is for the tax field where the player gets a choice, to either pay 10% or 4000
	 	The first part only runs if the player position is 3, and the second i its 13 */
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
					if (Buttonpressed){ //We make a boolean called "Buttonpressed"  if the boolean is true, the player pressed 10%
						pay10procent(player); // 10% is remove from balance
					}
					else 
						pay4000(player); // -4000 was pressed, 4000 is removed from balance
				}
			}
	
		}
	}

	public void pay10procent(Player player){
		player.getAccount().addBalance(-player.getAccount().getBalance()/taxRate);
	}
	
	public void pay4000(Player player){
		player.getAccount().addBalance(-taxAmount13);
	}



	//	3.	Gold mine Tax Pay 2000  
	//	13.	Caravan Tax Pay 4000 or 10% of total assets
}
