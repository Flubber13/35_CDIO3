package test;

import org.junit.*;
import game.Player;
import fields.Fleet;

public class FleetTest { //*** IN PROGRESS ***
	
	private Player Donald;
	private Player Mickey;
	private Fleet Fleet;
	private Fleet Fleet2;
	private Fleet Fleet3;
	private Fleet Fleet4;

	
	@Before
	public void setUp() throws Exception {
		this.Donald = new Player(1000, "Donald Duck");
		this.Mickey = new Player(2000, "Mickey Mouse");
		this.Fleet = new Fleet(1);
		this.Fleet2 = new Fleet(2);
		this.Fleet3 = new Fleet(3);
		this.Fleet4 = new Fleet(4);
	}
	
	@After
	public void tearDown() throws Exception {
		this.Donald = new Player(1000, "Donald Duck");
		this.Mickey = new Player(2000, "Mickey Mouse");
		this.Fleet.removeOwner();
		this.Fleet2.removeOwner();
		this.Fleet3.removeOwner();
		this.Fleet4.removeOwner();
		//The fields are unaltered
	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.Donald);
		Assert.assertNotNull(this.Fleet);
		Assert.assertTrue(this.Fleet instanceof Fleet);
	}
	
	@Test //Tests if a Fleet that is NOT owned actually is NOT owned
	public void testLandOnFieldNotOwned() {
		
		//Have Donald land on field not owned
		this.Fleet.landedOn(this.Donald);
		this.Fleet.setOwner(null); //*** THIS IS CHEATING, HOW  DO I PROPERLY FORCE PLAYER ANSWER?!?! ***
		
		Object expected = null;
		Object actual = this.Fleet.getOwner();
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests if a Fleet that IS owned actually IS owned
	public void testLandOnFieldOwned() {
		
		//Set Mickey as owner
		this.Fleet.setOwner(this.Mickey);
		
		//Have Donald land on field that is owned
		this.Fleet.landedOn(this.Donald);
		
		Object expected = this.Mickey;
		Object actual = this.Fleet.getOwner();
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests whether or not points are deducted from a player landing on a field that is already owned
	public void testLandOnField200() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Fleet.setOwner(this.Mickey);
		
		//Then have Donald land on this field
		this.Fleet.landedOn(this.Donald);
		expected = 1000 - 500;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests whether or not points are deducted from a player landing on a field that is already owned. Twice in a row.
	public void testLandOnField200Twice() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Fleet.setOwner(this.Mickey);
		
		//Then have Donald land on this field (TWICE IN A ROW! AWWW MAN THATS BAD LUCK!)
		this.Fleet.landedOn(this.Donald);
		this.Fleet.landedOn(this.Donald);
		expected = 1000 - 500 - 500;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests whether or not points are awarded to owner of field after another player lands on this field.
	public void testGetPointsField200() {
		int expected = 2000;
		int actual = this.Mickey.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Fleet.setOwner(this.Mickey);
		
		//Then have Donald land on this field
		this.Fleet.landedOn(this.Donald);
		expected = 2000 + 500;
		actual = this.Mickey.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests whether or not points are awarded to owner of field after another player lands on this field. Twice in a row.
	public void testGetPointsField200Twice() {
		int expected = 2000;
		int actual = this.Mickey.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Fleet.setOwner(this.Mickey);
		
		//Then have Donald land on this field (TWICE IN A ROW! AWWW MAN THATS BAD LUCK!)
		this.Fleet.landedOn(this.Donald);
		this.Fleet.landedOn(this.Donald);
		
		expected = 2000 + 500 + 500;
		actual = this.Mickey.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests whether or not points are deducted from player that lands on a field whose owner owns TWO Fleets.
	public void testLandOnFieldOwnerOwns2() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Fleet.setOwner(this.Mickey);
		this.Mickey.addNumFleetOwned(3);
		
		//Then have Donald land on one of the fields
		this.Fleet.landedOn(this.Donald);
		
		expected = 1000 - 500 - 500;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}

}
