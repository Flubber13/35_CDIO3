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

		// The first field is created
		fields[0] = new Start.Builder()		// Field is of type 'Start'
				.setBgColor(Color.RED)		// Background color is set to 'red'
				.setDescription("")			// The default description is replaced by an empty description
				.setSubText("")				// The default subText is replaced by an empty subText
				.setFgColor(Color.WHITE)	// Text color is set to 'white'
				.setTitle("START")			// Filed title is set to "START"
				.build();					// The field is finally build
		fields[1] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[2] = new Street.Builder()
				.setBgColor(Color.BLACK)
				.setDescription("Gold Mine -2000")
				.setSubText("")
				.setFgColor(Color.WHITE)
				.setTitle("Goldmine")
				.build();
		fields[3] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[4] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Second Sail. Pris: 4000 Leje: 500-4000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("Second Sail")
				.build();
		fields[5] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[6] = new Street.Builder()
				.setBgColor(Color.GREEN)
				.setDescription("Monastry. Modtag 500")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("Monastry")
				.build();
		fields[7] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("700")
				.setTitle("Cold Dessert. Pris: 3000, Leje: 700")
				.build();
		fields[8] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Sea Grover. Pris: 4000 Leje: 500-4000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("Sea Grover")
				.build();
		fields[9] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[10] = new Street.Builder()
				.setBgColor(Color.ORANGE)
				.setDescription("Huts in the Mountain. Pris: 2500, Leje:100 x antal øjne")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent("100 x antal øjne")
				.setTitle("Huts in the Mountain")
				.build();
		fields[11] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[12] = new Street.Builder()
				.setBgColor(Color.BLACK)
				.setDescription("Caravan. Betal skat: 4000 eller 10%")
				.setSubText("")
				.setFgColor(Color.WHITE)
				.setTitle("Caravan")
				.build();
		fields[13] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[14] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("The Buccaneers. Pris: 4000 Leje: 500-4000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setTitle("The Buccaneers")
				.build();
		fields[15] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[16] = new Street.Builder()
				.setBgColor(Color.GREEN)
				.setDescription("Walled City. Modtag: 5000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent("100")
				.setTitle("Walled City")
				.build();		
		fields[17] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[18] = new Street.Builder()
				.setBgColor(Color.ORANGE)
				.setDescription("The Pit. Pris 2500, Leje 100 x antal øjne")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent("100 x antal øjne")
				.setTitle("The Pit")
				.build();
		fields[19] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		fields[20] = new Shipping.Builder()
				.setBgColor(Color.WHITE)
				.setDescription("Privateer Armade. Pris 4000, Leje 500-4000")
				.setSubText("")
				.setFgColor(Color.BLACK)
				.setRent("500-4000")
				.setTitle("Privateer Armade")
				.build();
		fields[21] = new Street.Builder()
				.setBgColor(Color.BLUE)
				.setDescription("description")
				.setSubText(null)
				.setFgColor(Color.CYAN)
				.setRent("100")
				.setTitle("Title")
				.build();
		GUI.create(fields);

	}

}