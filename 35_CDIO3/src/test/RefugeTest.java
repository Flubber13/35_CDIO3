package test;

import org.junit.*;

import game.Player;
import fields.Refuge;

public class RefugeTest {
	
	private Player Donald;
	private Refuge refuge200;
	private Refuge refuge0;
	private Refuge refugeNeg200;
	
	@Before
	public void setUp() throws Exception {
		this.Donald = new Player(1000, "Donald Duck");
		this.refuge200 = new Refuge(1, 200);
		this.refuge0 = new Refuge(2, 0);
		this.refugeNeg200 = new Refuge(3, -200);
	}
	
	@After
	public void tearDown() throws Exception {
		this.Donald = new Player(1000, "Donald Duck");
		//The fields are unaltered
	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.Donald);
		
		Assert.assertNotNull(this.refuge200);
		Assert.assertNotNull(this.refuge0);
		Assert.assertNotNull(this.refugeNeg200);
		
		Assert.assertTrue(this.refuge200 instanceof Refuge);
		Assert.assertTrue(this.refuge0 instanceof Refuge);
		Assert.assertTrue(this.refugeNeg200 instanceof Refuge);
	}
	
	@Test //Tests if you get points by landing on a Refuge field
	public void testLandOnField() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		//Perform the action to be tested
		this.refuge200.landedOn(this.Donald);
		expected = 1000 + 200;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests if you get points by landing on a Refuge field twice in a row
	public void testLandOnFieldTwice() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		this.refuge200.landedOn(this.Donald);
		this.refuge200.landedOn(this.Donald);
		expected = 1000 + 200 + 200;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests what happens when you land on a Refuge that awards 0 points
	public void testLandOnField0() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		this.refuge0.landedOn(this.Donald);
		
		expected = 1000;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests what happens when you land on a Refuge that awards 0 points
	public void testLandOnField0Twice() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		this.refuge0.landedOn(this.Donald);
		this.refuge0.landedOn(this.Donald);
		
		expected = 1000;
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests whether or not a negative amount of points can be awarded when you land on a Refuge
	public void testLandOnFieldNeg() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested
		this.refugeNeg200.landedOn(this.Donald);
		
		//It is not possible to deposit a negative amount
		expected = 1000; //We expect balance to be unchanged
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test //Tests whether or not a negative amount of points can be awarded when you land on a Refuge twice in a row
	public void testLandOnFieldNegTwice() {
		int expected = 1000;
		int actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//Perform the action to be tested.
		this.refugeNeg200.landedOn(this.Donald);
		this.refugeNeg200.landedOn(this.Donald);
		
		//It is still not possible to deposit a negative amount
		expected = 1000; //We expect balance to be unchanged
		actual = this.Donald.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
}
