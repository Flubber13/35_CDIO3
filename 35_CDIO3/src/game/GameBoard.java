package game;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_resources.GUI;
import fields.AbstractField;
import fields.AbstractOwnables;
import fields.Fleet;
import fields.LaborCamp;
import fields.Refuge;
import fields.Tax;
import fields.Territory;

public class GameBoard {

	// This method creates 22 new fields for the game board, and places them in the array 'Field[] fields'
	public void createGuiFields(){

		Field[] fields = new Field[22];
		//The first field is created
		fields[0] = new Start.Builder()		// Field is of type 'Start'
				.setBgColor(Color.RED) 		// Background color is set to 'red'
				.setDescription("")			// The default description is replaced by an empty description
				.setSubText("")				// The default subText is replaced by an empty subText
				.setFgColor(Color.WHITE)	// Text color is set to 'white'
				.setTitle("START")			// Field title is set to "Start"
				.build();					// The field is finally built
		fields[1] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Tribe Encampment. "+Text.price+": 1000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 100")
				.setTitle("Tribe Encampment")
				.build();
		fields[2] = new Street.Builder()
				.setBgColor(Color.BLACK)
				.setDescription("Goldmine. "+ Text.payTax+": 2000")
				.setSubText("")
				.setFgColor(Color.WHITE)
				.setTitle("Goldmine")
				.build();
		fields[3] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Crater. "+Text.price+": 1500")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 300")
				.setTitle("Crater")
				.build();
		fields[4] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Second Sail. "+Text.price+": 4000")
				.setSubText("")
				.setRent(Text.rent+": 500-4000")
				.setFgColor(Color.BLACK)
				.setTitle("Second Sail")
				.build();
		fields[5] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Mountain. "+Text.price+": 2000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 500")
				.setTitle("Mountain")
				.build();
		fields[6] = new Street.Builder()
				.setBgColor(Color.GREEN)
				.setDescription("Monastry. "+Text.recieve+": 500")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("Monastry")
				.build();
		fields[7] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Cold Dessert. "+Text.price+": 3000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 700")
				.setTitle("Cold Dessert")
				.build();
		fields[8] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Sea Grover. "+Text.price+": 4000")
				.setSubText("")
				.setRent(Text.rent+": 500-4000")
				.setFgColor(Color.BLACK)
				.setTitle("Sea Grover")
				.build();
		fields[9] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Black Cave. "+Text.price+": 4000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 1000")
				.setTitle("Black Cave")
				.build();
		fields[10] = new Street.Builder()
				.setBgColor(Color.MAGENTA)
				.setDescription("Huts in the Mountain. "+Text.price+": 2500")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 100 x "+Text.numEyes)
				.setTitle("Huts in the Mountain")
				.build();
		fields[11] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("The Warewall. "+Text.price+": 4300")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 1300")
				.setTitle("The Warewall")
				.build();
		fields[12] = new Street.Builder()
				.setBgColor(Color.BLACK)
				.setDescription("Caravan. "+Text.payTax+": 4000 eller 10%")
				.setSubText("")
				.setFgColor(Color.WHITE)
				.setTitle("Caravan")
				.build();
		fields[13] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Mountain Village. "+Text.price+": 4750")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 1600")
				.setTitle("Mountain Village")
				.build();
		fields[14] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("The Buccaneers. "+Text.price+": 4000")
				.setSubText("")
				.setRent(Text.rent+": 500-4000")
				.setFgColor(Color.BLACK)
				.setTitle("Buccaneers")
				.build();
		fields[15] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("South Citadel. "+Text.price+": 5000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 2000")
				.setTitle("South Citadel")
				.build();
		fields[16] = new Street.Builder()
				.setBgColor(Color.GREEN)
				.setDescription("Walled City. +Text.recieve+: 5000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("Walled City")
				.build();		
		fields[17] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Tribe Encampment. "+Text.price+": 5500")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 2600")
				.setTitle("Palace Gates")
				.build();
		fields[18] = new Street.Builder()
				.setBgColor(Color.MAGENTA)
				.setDescription("The Pit. "+Text.price+": 2500")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 100 x "+Text.numEyes)
				.setTitle("The Pit")
				.build();
		fields[19] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Tower. "+Text.price+": 6000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 3200")
				.setTitle("Tower")
				.build(); 
		fields[20] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Privateer Armade. "+Text.price+": 4000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 500-4000")
				.setTitle("Privateer Armade")
				.build();
		fields[21] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Castle. "+Text.price+": 8000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent(Text.rent+": 4000")
				.setTitle("Castle")
				.build();
		GUI.create(fields);

	} 


	
//	public void createLogicFields(){
//		AbstractField[] logicField = new AbstractField[23];
//		
//		logicField[2] = new Territory(2, 100, 1000);
//		logicField[4] = new Territory(4,300,1500);
//		logicField[6] = new Territory(6,500,2000);
//		logicField[8] = new Territory(8,700,3000);
//		logicField[10] = new Territory(10,1000,4000);
//		logicField[12] = new Territory(12,1300,4300);
//		logicField[14] = new Territory(14,1600,4750);
//		logicField[16] = new Territory(16,2000,5000);
//		logicField[18] = new Territory(18,2600,5500);
//		logicField[20] = new Territory(20,3200,6000);
//		logicField[22] = new Territory(22,4000,8000);
//		logicField[11] = new LaborCamp(11);
//		logicField[19] = new LaborCamp(19);
//		logicField[5] = new Fleet(5);
//		logicField[9] = new Fleet(9);
//		logicField[15] = new Fleet(15);
//		logicField[21] = new Fleet(21);	
//		logicField[7] = new Refuge(7,500);
//		logicField[17] = new Refuge(17,5000);
//		logicField[3] = new Tax(3);
//		logicField[13] = new Tax(13);
//		
//	}

}
