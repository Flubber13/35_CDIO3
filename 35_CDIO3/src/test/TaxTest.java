package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import desktop_resources.GUI;
import fields.AbstractField;
import fields.Refuge;
import fields.Tax;
import fields.Territory;
import game.Player;

public class TaxTest {

	private Player miniMouse;
	private Tax tax3;
	private Tax tax13;

	@Before
	public void setUp() throws Exception {
		this.miniMouse = new Player(10000,"Mini");
		this.tax3 = new Tax(3);
		this.tax13 = new Tax(13);
	}

	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.miniMouse);

		Assert.assertNotNull(this.tax3);
		Assert.assertNotNull(this.tax13);

		Assert.assertTrue(this.tax3 instanceof Tax);
		Assert.assertTrue(this.tax13 instanceof Tax);
	}
	
	@Test
	public void testPositiont() {
		// Performs the action to be tested
		this.miniMouse.setPosition(3);
		
		int expected = 3;
		int actual = miniMouse.getPosition();
		assertEquals(expected, actual);
	}


	@Test
	public void testTaxAdded3() {
		int expected = 10000; 
		int actual = this.miniMouse.getAccount().getBalance();
		assertEquals(expected, actual);	

		// Performs the action to be tested
		this.miniMouse.setPosition(3);
		this.tax3.landedOn(miniMouse); 

		expected = 10000 - 2000;
		actual = miniMouse.getAccount().getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void testTax13_10procent() {
		int expected = 10000; 
		int actual = this.miniMouse.getAccount().getBalance();
		assertEquals(expected, actual);	

		// Performs the action to be tested
		this.tax13.pay10procent(miniMouse);

		expected = 10000 - 1000;
		actual = miniMouse.getAccount().getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void testTax13_4000() {
		int expected = 10000; 
		int actual = this.miniMouse.getAccount().getBalance();
		assertEquals(expected, actual);	

		// Performs the action to be tested
		this.tax13.pay4000(miniMouse);
		

		expected = 10000 - 4000;
		actual = miniMouse.getAccount().getBalance();
		assertEquals(expected, actual);
	}

}
