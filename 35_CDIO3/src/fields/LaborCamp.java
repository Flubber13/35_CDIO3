package fields;

import desktop_resources.GUI;
import game.Player;

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
				boolean selection = GUI.getUserLeftButtonPressed("Vil du købe denne grund? Pris: $"+price, "Ja", "Nej");
				if(selection == true){
					this.owner = player;
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-price);
				}
			}
			else{
				player.getAccount().addBalance(- player.getLastRoll()*baseRent);
				owner.getAccount().addBalance(player.getLastRoll()*baseRent);
			} 
		}
	}

	
	// 11. Huts in the Mountain – Labor Camp
	// 19. The Pit – Labor camp
	
}	