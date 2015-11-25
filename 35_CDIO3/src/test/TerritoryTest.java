package test;

import org.junit.*;
import game.Player;
import fields.Territory;

public class TerritoryTest {
	
	private Player Donald;
	private Player Mickey;
	private Territory Territory200;
	private Territory Territory0;
	private Territory TerritoryNeg200;
	private Territory TerritoryOwned;
	private Territory TerritoryNotOwned;
	
	@Before
	public void setUp() throws Exception {
		this.Donald = new Player(1000, "Donald Duck");
		this.Mickey = new Player(2000, "Mickey Mouse");
		this.Territory200 = new Territory(1, 200, 400);
		this.Territory0 = new Territory(2, 0, 0);
		this.TerritoryNeg200 = new Territory(3, -100, -200);
		this.TerritoryOwned = new Territory(3, -100, -200);
		this.TerritoryNotOwned = new Territory(3, -100, -200);
	}
	
	@After
	public void tearDown() throws Exception {
		this.Donald = new Player(1000, "Donald Duck");
		this.Mickey = new Player(2000, "Mickey Mouse");
		//The fields are unaltered
	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.Donald);
		
		Assert.assertNotNull(this.Territory200);
		Assert.assertNotNull(this.Territory0);
		Assert.assertNotNull(this.TerritoryNeg200);
		Assert.assertNotNull(this.TerritoryOwned);
		Assert.assertNotNull(this.TerritoryNotOwned);
		
		Assert.assertTrue(this.Territory200 instanceof Territory);
		Assert.assertTrue(this.Territory0 instanceof Territory);
		Assert.assertTrue(this.TerritoryNeg200 instanceof Territory);
		Assert.assertTrue(this.TerritoryOwned instanceof Territory);
		Assert.assertTrue(this.TerritoryNotOwned instanceof Territory);
	}
	
	@Test //Tests if a territory that is NOT owned actually is NOT owned
	public void testLandOnFieldNotOwned() {
		
		//Have Donald land on field not owned
		this.TerritoryNotOwned.landedOn(this.Donald);
		
		Object expected = null;
		Object actual = this.TerritoryNotOwned.getOwner();
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests if a territory that IS owned actually IS owned
	public void testLandOnFieldOwned() {
		
		//Set Mickey as owner
		this.TerritoryOwned.setOwner(this.Mickey);
		
		//Have Donald land on field that is owned
		this.TerritoryOwned.landedOn(this.Donald);
		
		Object expected = this.Mickey;
		Object actual = this.TerritoryOwned.getOwner();
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test //Tests whether or not points are deducted from a player landing on a field that is already owned
	public void testLandOnField200() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Territory200.setOwner(this.Mickey);
		
		//Then have Donald land on this field
		this.Territory200.landedOn(this.Donald);
		expected = 1000 - 200;
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
		this.Territory200.setOwner(this.Mickey);
		
		//Then have Donald land on this field (TWICE IN A ROW! AWWW MAN THATS BAD LUCK!)
		this.Territory200.landedOn(this.Donald);
		this.Territory200.landedOn(this.Donald);
		expected = 1000 - 200 - 200;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests what happens when you land on a field Territory that IS owned and doesn't have rent
	public void testLandOnField0() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Territory0.setOwner(this.Mickey);
		
		//Then have Donald land on this field
		this.Territory0.landedOn(this.Donald);
		
		expected = 1000; //We expect this unchanged
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests what happens when you land on a field Territory that IS owned and doesn't have rent. Twice in a row.
	public void testLandOnField0Twice() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.Territory0.setOwner(this.Mickey);
		
		//Then have Donald land on this field (TWICE IN A ROW! NOT TOO BAD THO, RENT IS 0)
		this.Territory0.landedOn(this.Donald);
		this.Territory0.landedOn(this.Donald);
		
		expected = 1000;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests what happens when you land on a field Territory that IS owned and has negative rent
	public void testLandOnFieldNeg200() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.TerritoryNeg200.setOwner(this.Mickey);
		
		//Then have Donald land on this field
		this.TerritoryNeg200.landedOn(this.Donald);
		
		//It is not possible to deposit a negative amount? **WHAT IS ACTUALLY GOING ON HERE?**
		expected = 1000;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests what happens when you land on a field Territory that IS owned and has negative rent. Twice in a row.
	public void testLandOnFieldNeg200Twice() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		
		//First set Mickey as owner
		this.TerritoryNeg200.setOwner(this.Mickey);
		
		//Then have Donald land on this field (TWICE IN A ROW! NOT TOO BAD THO, NOTHING SHOULD HAPPEN RIGHT?)
		this.TerritoryNeg200.landedOn(this.Donald);
		this.TerritoryNeg200.landedOn(this.Donald);
		
		//It is not possible to deposit a negative amount? **WHAT IS ACTUALLY GOING ON HERE?**
		expected = 1000;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
}
