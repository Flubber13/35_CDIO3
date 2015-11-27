package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Refuge extends AbstractField {
	
	int bonus;
	
	public Refuge(int place,int bonus){
		this.place=place;
		this.bonus=bonus;
	}
	
	@Override
	public String toString(){
		return Text.fieldName[place] + " Refuge [place=" + place + ", bonus=" + bonus + "]";
	}
	
	/*	This method will only run if the position of the player is the same as the position decided in the Refuge constructor. 
	 	The player is rewarded with a bonus, when landing on this field */
	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){
			GUI.showMessage(player.getName() + Text.landedOn + Text.fieldName[place]+ ". " + Text.recieve + " " + bonus);
			player.getAccount().addBalance(bonus);	
		}
	}



	//	7.	Monastery - Refuge
	//	17.	Walled City – refuge

}
