package fields;

import desktop_resources.GUI;
import game.Player;
import game.Text;

public class Territory extends AbstractOwnables {

	
	@Override
	public String toString() {
		return Text.fieldName[place] + " Territory [price=" + price + ", owner=" + owner + ", rent=" + rent + ", place=" + place + "]";
	}

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
			// There is no owner, player can choose to buy field
			if(owner == null){
				GUI.showMessage(player.getName()+Text.landedOn+Text.fieldName[place]);
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion + price, Text.yes, Text.no);
				if(answer == true){
					setOwner(player);
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-price);
				}
			}
			// Player landed on his own field
			else if(owner == player){
				GUI.showMessage(owner.getName()+ Text.landedOn + Text.fieldName[place]+ ". " + Text.youOwn);
			}	
			
			// Player pays rent to the owner 
			else{
				GUI.showMessage(player.getName() + Text.landedOn + Text.fieldName[place]+ ". " +Text.pay + rent + Text.to + owner.getName());
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
