package test;

import org.junit.*;
import game.Player;
import fields.LaborCamp;

public class LaborCampTest { //*** IN PROGRESS ***
	
	private Player Donald;
	private Player Mickey;
	private LaborCamp LaborCamp;


	
	@Before
	public void setUp() throws Exception {
		this.Donald = new Player(5000, "Donald Duck");
		this.Mickey = new Player(2000, "Mickey Mouse");
		this.LaborCamp = new LaborCamp(1);
	}
	
	@After
	public void tearDown() throws Exception {
		this.Donald = new Player(5000, "Donald Duck");
		this.Mickey = new Player(2000, "Mickey Mouse");
		this.LaborCamp.removeOwner();
		//The fields are unaltered
	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.Donald);
		Assert.assertNotNull(this.Mickey);
		Assert.assertNotNull(this.LaborCamp);
		Assert.assertTrue(this.LaborCamp instanceof LaborCamp);
	}
	
	@Test //Tests if a Fleet that IS owned actually IS owned
	public void testIfOwned() {
		
		//Set Mickey as owner
		this.LaborCamp.setOwner(this.Mickey);
		
		//Have Donald land on field that is owned
		this.LaborCamp.landedOn(this.Donald);
		
		Object expected = this.Mickey;
		Object actual = this.LaborCamp.getOwner();
		Assert.assertEquals(expected, actual);
		
	}
	@Test //Tests whether or not points are deducted from player that lands on a field whose owner owns ONE Labor Camp.
	public void testLandOnFieldOwned() {
		
		int actual = this.Donald.getAccount().getBalance();
		int expected = 5000;
		Assert.assertEquals(expected, actual);
		
		//Have Mickey own a LaborCamp
		this.LaborCamp.setOwner(Mickey); 
		
		//Have Donald land on field not owned
		this.LaborCamp.landedOn(this.Donald);
		
		actual = this.Donald.getAccount().getBalance();
		expected = 5000 - (this.Donald.getLastRoll() * 100 * this.Mickey.getNumLaborOwned());
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests whether or not points are deducted from player that lands on a field whose owner owns ONE Labor Camp. Twice in a row.
	public void testLandOnFieldOwnedTwice() {
	
		int expected = 5000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Have Mickey own a LaborCamp
		this.LaborCamp.setOwner(Mickey); 
		
		//Have Donald land on field not owned
		this.LaborCamp.landedOn(this.Donald);
		int firstroll = this.Donald.getLastRoll();
		this.LaborCamp.landedOn(this.Donald);
		
		actual = this.Donald.getAccount().getBalance();
		expected = 5000 - (this.Donald.getLastRoll() * 100 * this.Mickey.getNumLaborOwned()) - (firstroll * 100 * this.Mickey.getNumLaborOwned());
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests whether or not points are deducted from player that lands on a field whose owner owns TWO Labor Camps.
	public void testLandOnFieldOwnerOwnsTwo() {
	
		int expected = 5000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Have Mickey own a LaborCamp
		this.LaborCamp.setOwner(Mickey); 
		this.Mickey.setNumFleetOwned(2);
		
		//Have Donald land on a field owned
		this.LaborCamp.landedOn(this.Donald);
		
		
		actual = this.Donald.getAccount().getBalance();
		expected = 5000 - (this.Donald.getLastRoll() * 100 * this.Mickey.getNumLaborOwned());
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests whether or not points are paid to owner who owns ONE Labor Camp when another player lands on his field.
	public void testGetMoneyOnFieldOwned() {
		
		int actual = this.Mickey.getAccount().getBalance();
		int expected = 2000;
		Assert.assertEquals(expected, actual);
		
		//Have Mickey own a LaborCamp
		this.LaborCamp.setOwner(Mickey); 
		
		//Have Donald land on field not owned
		this.LaborCamp.landedOn(this.Donald);
		
		actual = this.Mickey.getAccount().getBalance();
		expected = 2000 + (this.Donald.getLastRoll() * 100 * this.Mickey.getNumLaborOwned());
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests whether or not points are paid to owner who owns TWO Labor Camps when another player lands on one of his fields.
	public void testGetMoneyOnTwoFieldsOwned() {
		
		int actual = this.Mickey.getAccount().getBalance();
		int expected = 2000;
		Assert.assertEquals(expected, actual);
		
		//Have Mickey own a LaborCamp
		this.LaborCamp.setOwner(Mickey); 
		this.Mickey.setNumFleetOwned(2);
		
		//Have Donald land on this field
		this.LaborCamp.landedOn(this.Donald);
		
		actual = this.Mickey.getAccount().getBalance();
		expected = 2000 + (this.Donald.getLastRoll() * 100 * this.Mickey.getNumLaborOwned());
		Assert.assertEquals(expected, actual);
		
	}

}