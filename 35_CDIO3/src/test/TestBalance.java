package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import game.Player;

public class TestBalance {

	private Player DonaldDuck;


	// Preconditions
	@Before
	public void setUp() throws Exception {
		this.DonaldDuck = new Player(3000, "Donald Duck");

	}

	@After
	public void tearDown()  {
		this.DonaldDuck = new Player(3000, "Donald Duck");
	}


	@Test
	public void negativTest(){
		
		// Performs the action to be tested
		DonaldDuck.getAccount().addBalance(-4000);
		
		int expected = 0;
		int actual = DonaldDuck.getAccount().getBalance();
		
		
		Assert.assertEquals(expected,actual);
	}


	@Test
	public void positiveTest(){
		
		// Performs the action to be tested
		DonaldDuck.getAccount().addBalance(-1000);
		
		int expected = 2000;
		int actual = DonaldDuck.getAccount().getBalance();
		
		Assert.assertEquals(expected, actual);
	}
}
