package game;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;
import fields.AbstractField;
import fields.Fleet;
import fields.LaborCamp;
import fields.Refuge;
import fields.Tax;
import fields.Territory;

public class GameBoard {
	
	
	public void initialize(){
		
		Field[] fields = new Field[23];
		
		fields[2]= new Street.Builder()
				.setTitle("Tribe Encampment")
				.setDescription("Desctribtion text")
				.setSubText("Sub text")
				.setBgColor(Color.YELLOW)
				.build();
		
		fields[3]= new Street.Builder()
				.setTitle("Gold Mine")
				.setDescription("Desctribtion text")
				.setSubText("Sub text")
				.setBgColor(Color.GREEN)
				.build();
		
		GUI.create(fields);
	
		
		 // Start skal ikke umiddelbart have nogen text, og Title er allerede "START"
		
//		GUI.setTitleText(2, "Tribe Encampment");
//		GUI.setSubText(2, "");
//		GUI.setDescriptionText(2,"Tribe Encampmetn \nPrice: $1000 \nRent: $100");
//		
////		GUI.setTitleText(3, "Gold Mine");
////		GUI.setSubText(3, "");
//		
//		GUI.setTitleText(4, "Crater");
//		GUI.setSubText(4, "");
//		
//		GUI.setTitleText(5, "Second Sail");
//		GUI.setSubText(5, "");
//		
//		GUI.setTitleText(6, "Mountain");
//		GUI.setSubText(6, "");
//		
//		GUI.setTitleText(7, "Monastery");
//		GUI.setSubText(7, "");
//		
//		GUI.setTitleText(8, "Cold Dessert");
//		GUI.setSubText(8, "");
//		
//		GUI.setTitleText(9, "Sea Grover");
//		GUI.setSubText(9, "");
//		
//		GUI.setTitleText(10, "Black Cave");
//		GUI.setSubText(10, "");
//		
//		GUI.setTitleText(11, "Huts in the Mountain");
//		GUI.setSubText(11, "");
//		
//		GUI.setTitleText(12, "The Warewall");
//		GUI.setSubText(12, "");
//		
//		GUI.setTitleText(13, "Caraven");
//		GUI.setSubText(13, "");
//		
//		GUI.setTitleText(14, "Mountain Village");
//		GUI.setSubText(14, "");
//		
//		GUI.setTitleText(15, "The Buccaneers");
//		GUI.setSubText(15, "");
//		
//		GUI.setTitleText(16, "Sounth Citadel");
//		GUI.setSubText(16, "");
//		
//		GUI.setTitleText(17, "Walled City");
//		GUI.setSubText(17, "");
//		
//		GUI.setTitleText(18, "Palace Gates");
//		GUI.setSubText(18, "");
//		
//		GUI.setTitleText(19, "The Pit");
//		GUI.setSubText(19, "");
//		
//		GUI.setTitleText(20, "Tower");
//		GUI.setSubText(20, "");
//		
//		GUI.setTitleText(21, "Privateer Armade");
//		GUI.setSubText(21, "");
//		
//		GUI.setTitleText(22, "Castle");
//		GUI.setSubText(22, "");
//	
//		for (int i = 23; i < 40; i++) {
//			GUI.setTitleText(i, "");
//			GUI.setSubText(i, "");	
//		}
	
	}

	public static AbstractField[] getFields() {
		// TODO make some fields!!!
		AbstractField[] field = new AbstractField[23];
		
		field[2] = new Territory(2, 100, 1000);
		field[4] = new Territory(4,300,1500);
		field[6] = new Territory(6,500,2000);
		field[8] = new Territory(8,700,3000);
		field[10] = new Territory(10,1000,4000);
		field[12] = new Territory(12,1300,4300);
		field[14] = new Territory(14,1600,4750);
		field[16] = new Territory(16,2000,5000);
		field[18] = new Territory(18,2600,5500);
		field[20] = new Territory(20,3200,6000);
		field[22] = new Territory(22,4000,8000);
		field[11] = new LaborCamp(11);
		field[19] = new LaborCamp(19);
		field[5] = new Fleet(5);
		field[9] = new Fleet(9);
		field[15] = new Fleet(15);
		field[21] = new Fleet(21);	
		field[7] = new Refuge(7,5000);
		field[17] = new Refuge(17,500);
		field[3] = new Tax(3);
		field[13] = new Tax(13);
		
		return field;
	}

	
}