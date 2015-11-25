package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Territory extends AbstractOwnables {

	
	public Territory(int place, int rent, int price){
		this.place=place;
		this.rent=rent;
		this.price=price;
	}

	@Override
	public int getRent() {
		return rent;
	}

	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){	
			if(owner == null){		// Checks if the Territory is owned
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion + price, Text.yes, Text.no);
				if(answer == true){
					setOwner(player);
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-price);
				}
			}
			else if(owner == player){
				GUI.showMessage(owner + Text.owned);
			}	
			
			else{
				GUI.showMessage(Text.owned + owner.getName() + ", " +  player.getName() + Text.mustPay + rent + Text.to + owner.getName());
				player.getAccount().addBalance(-rent);
				owner.getAccount().addBalance(rent);
				}
			}
		}
}

	/*
	2.	Tribe Encampment - Territory
	4.	Crater - Territory
	6.	Mountain – Territory
	8.	Cold Dessert – Territory
	10.	Black Cave – Territory
	12.	The Warewall - Territory
	14.	Mountain Village – Territory 
	16.	South Citadel - Territory
	18.	Palace Gates – Territory
	20.	Tower – Territory
	22.	Castle - Territory
	 */
