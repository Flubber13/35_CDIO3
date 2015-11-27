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
		DonaldDuck.getAccount().addBalance(-4000);
		Assert.assertEquals(0,DonaldDuck.getAccount().getBalance());
	}


	@Test
	public void positiveTest(){
		DonaldDuck.getAccount().addBalance(-1000);
		Assert.assertEquals(2000,DonaldDuck.getAccount().getBalance());
	}
}
