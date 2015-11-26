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
		DonaldDuck = new Player(30000, "DonaldDuck");
	}

	@Test
	public void negativeTest() {
		DonaldDuck.getAccount().addBalance(-40000);
		Assert.assertEquals(0, DonaldDuck.getAccount().getBalance());	
	}

}
