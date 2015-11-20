package game;

import java.awt.Color;

import desktop_fields.Field;
import desktop_fields.Shipping;
import desktop_fields.Start;
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

		Field[] fields = new Field[22];

		fields[0] = new Start.Builder()
				.setBgColor(Color.RED)
				.setDescription("")
				.setSubText("")
				.setFgColor(Color.WHITE)
				.setTitle("START")
				.build();
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