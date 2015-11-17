package fields;

import game.Player;

public class Refuge extends AbstractField {

	int bonus;
	int place;

	public Refuge(int place,int bonus){
		this.place=place;
		this.bonus=bonus;
	}

	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){
			player.getAccount().addBalance(bonus);	
		}
	}

	//	7.	Monastery - Refuge
	//	17.	Walled City – refuge

}
