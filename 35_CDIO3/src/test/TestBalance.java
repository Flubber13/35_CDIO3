package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import game.Player;

public class TestBalance {

	private Player player;
	private String name;


	// Preconditions
	@Before
	public void setUp() throws Exception {
		player = new Player(30000, name);
	}

	@Test
	public void test() {
		player.getAccount().addBalance(-40000);
	}

	@After
	public void tearDown() throws Exception {
		Assert.assertEquals(0, player.getAccount().getBalance());
	}


}
