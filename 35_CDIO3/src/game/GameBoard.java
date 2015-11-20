package game;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_resources.GUI;

public class GameBoard {

	// This method creates 22 new fields for the game board, and places them in the array 'Field[] fields'
	public void initialize(){

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
				.setDescription("Tribe Encampment. Pris: 1000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("100")
				.setTitle("Tribe Encampment")
				.build();
		fields[2] = new Street.Builder()
				.setBgColor(Color.BLACK)
				.setDescription("Goldmine. Betal skat: 2000")
				.setSubText("")
				.setFgColor(Color.WHITE)
				.setTitle("Goldmine")
				.build();
		fields[3] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Crater. Pris: 1500")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("300")
				.setTitle("Crater")
				.build();
		fields[4] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Second Sail. Pris: 4000")
				.setSubText("")
				.setRent("500-4000")
				.setFgColor(Color.BLACK)
				.setTitle("Second Sail")
				.build();
		fields[5] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Mountain. Pris: 2000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("500")
				.setTitle("Mountain")
				.build();
		fields[6] = new Street.Builder()
				.setBgColor(Color.GREEN)
				.setDescription("Monastry. Modtag: 500")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("Monastry")
				.build();
		fields[7] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Cold Dessert. Pris: 3000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("700")
				.setTitle("Cold Dessert")
				.build();
		fields[8] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Sea Grover. Pris: 4000")
				.setSubText("")
				.setRent("500-4000")
				.setFgColor(Color.BLACK)
				.setTitle("Sea Grover")
				.build();
		fields[9] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Black Cave. Pris: 4000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("1000")
				.setTitle("Black Cave")
				.build();
		fields[10] = new Street.Builder()
				.setBgColor(Color.MAGENTA)
				.setDescription("Huts in the Mountain. Pris: 2500")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent("100 x antal øjne")
				.setTitle("Huts in the Mountain")
				.build();
		fields[11] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("The Warewall. Pris: 4300")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("1300")
				.setTitle("The Warewall")
				.build();
		fields[12] = new Street.Builder()
				.setBgColor(Color.BLACK)
				.setDescription("Caravan. Betal skat: 4000 eller 10%")
				.setSubText("")
				.setFgColor(Color.WHITE)
				.setTitle("Caravan")
				.build();
		fields[13] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Mountain Village. Pris: 4750")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("1600")
				.setTitle("Mountain Village")
				.build();
		fields[14] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("The Buccaneers. Pris: 4000")
				.setSubText("")
				.setRent("500-4000")
				.setFgColor(Color.BLACK)
				.setTitle("The Buccaneers")
				.build();
		fields[15] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("South Citadel. Pris: 5000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("2000")
				.setTitle("South Citadel")
				.build();
		fields[16] = new Street.Builder()
				.setBgColor(Color.GREEN)
				.setDescription("Walled City. Modtag: 5000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("Walled City")
				.build();		
		fields[17] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Tribe Encampment. Pris: 5500")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("2600")
				.setTitle("Palace Gates")
				.build();
		fields[18] = new Street.Builder()
				.setBgColor(Color.MAGENTA)
				.setDescription("The Pit. Pris 2500")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent("100 x antal øjne")
				.setTitle("The Pit")
				.build();
		fields[19] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Tower. Pris: 6000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("3200")
				.setTitle("Tower")
				.build();
		fields[20] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Privateer Armade. Pris 4000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent("500-4000")
				.setTitle("Privateer Armade")
				.build();
		fields[21] = new Street.Builder()
				.setBgColor(Color.LIGHT_GRAY)
				.setDescription("Castle. Pris: 8000")
				.setSubText(null)
				.setFgColor(Color.BLACK)
				.setRent("4000")
				.setTitle("Castle")
				.build();
		GUI.create(fields);

	}

}
