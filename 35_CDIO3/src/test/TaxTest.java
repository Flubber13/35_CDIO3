package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import fields.Tax;
import game.Player;

public class TaxTest {

	private Player minieMouse;
	private Tax tax3;
	private Tax tax13;

	@Before
	public void setUp() throws Exception {
		this.minieMouse = new Player(10000,"Mini");
		this.tax3 = new Tax(3);
		this.tax13 = new Tax(13);
	}

	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.minieMouse);

		Assert.assertNotNull(this.tax3);
		Assert.assertNotNull(this.tax13);

		Assert.assertTrue(this.tax3 instanceof Tax);
		Assert.assertTrue(this.tax13 instanceof Tax);
	}
	
	@Test
	public void testPosition3() {
		// Performs the action to be tested
		this.minieMouse.setPosition(3);
		
		int expected = 3;
		int actual = minieMouse.getPosition();
		assertEquals(expected, actual);
	}

	@Test
	public void testPosition13() {
		// Performs the action to be tested
		this.minieMouse.setPosition(13);
		
		int expected = 13;
		int actual = minieMouse.getPosition();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTaxAdded3() {
		int expected = 10000; 
		int actual = this.minieMouse.getAccount().getBalance();
		assertEquals(expected, actual);	

		// Performs the action to be tested
		this.minieMouse.setPosition(3);
		this.tax3.landedOn(minieMouse); 

		expected = 10000 - 2000;
		actual = minieMouse.getAccount().getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void testTax13_10procent() {
		int expected = 10000; 
		int actual = this.minieMouse.getAccount().getBalance();
		assertEquals(expected, actual);	

		// Performs the action to be tested
		this.tax13.pay10procent(minieMouse);

		expected = 10000 - 1000;
		actual = minieMouse.getAccount().getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void testTax13_4000() {
		int expected = 10000; 
		int actual = this.minieMouse.getAccount().getBalance();
		assertEquals(expected, actual);	

		// Performs the action to be tested.
		this.tax13.pay4000(minieMouse);
		

		expected = 10000 - 4000;
		actual = minieMouse.getAccount().getBalance();
		assertEquals(expected, actual);
	}

}
