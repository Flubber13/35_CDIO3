package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fields.AbstractField;
import fields.Territory;
import game.Player;

public class TestOwner {
	
	Player goofy;
	AbstractField field;
	
	@Before
	public void setUp() throws Exception {
		goofy = new Player(1000, "Goofy");
		field = new Territory(1, 50, 500);
		field.setOwner(goofy);
	}

	@Test
	public void testOwner() {
		Player expected = goofy;
		Player actual = field.getOwner();
		assertEquals(expected, actual); // tests if Goofy is the owner
		
	}
	@Test
	public void testRemoveOwner() {
		field.removeOwner();
		Player expected = null;
		Player actual = field.getOwner();
		assertEquals(expected, actual); // tests if the owner is removed
		
	}

}
