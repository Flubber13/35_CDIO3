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
	public String toString() {
		return Text.fieldName[place] + " Territory [price=" + price + ", owner=" + owner + ", rent=" + rent + ", place=" + place + "]";
	}

	@Override
	public int getRent() {
		return rent;
	}

	/*	This method will only run if the position of the player is the same as the position decided in the LaborCamp constructor.
		First it checks if the field is not owned. If so the player will be asked to buy it (player gets YES/No choice).
		If the field is owned the player has to pay the rent decided in the constructor	*/
	@Override
	public void landedOn(Player player) {
		if(player.getPosition()==place){	
			
			if(owner == null){		// There is no owner, player can choose to buy field
				GUI.showMessage(player.getName()+Text.landedOn+Text.fieldName[place]);
				boolean answer = GUI.getUserLeftButtonPressed(Text.buyQuestion + price, Text.yes, Text.no); // player gets yes/no choice
				if(answer == true){		// If player selects yes, boolean is true, and player buys the field
					setOwner(player);
					GUI.setOwner(place, player.getName());
					player.getAccount().addBalance(-price);
				}
			}
			// Player landed on his own field, a message is shown
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
