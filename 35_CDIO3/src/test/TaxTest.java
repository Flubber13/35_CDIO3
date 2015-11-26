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

	private Player mini;
	private AbstractField tax3;
	private AbstractField tax13;

	@Before
	public void setUp() throws Exception {
		this.mini = new Player(10000,"Mini");
		this.tax3 = new Tax(3);
		this.tax13 = new Tax(13);
		this.mini.setPosition(3);
	}

	@After
	public void tearDown() throws Exception {


	}
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.mini);

		Assert.assertNotNull(this.tax3);
		Assert.assertNotNull(this.tax13);

		Assert.assertTrue(this.tax3 instanceof Tax);
		Assert.assertTrue(this.tax13 instanceof Tax);
	}
	
	@Test
	public void tesPositiont() {
		int expected = 3;
		int actual = mini.getPosition();
		assertEquals(expected, actual);
	}


	@Test
	public void testTaxAdded3() {
		int expected = 10000; 
		int actual = this.mini.getAccount().getBalance();
		assertEquals(expected, actual);	

		// Performs the action to be tested
		this.tax3.landedOn(mini); 

		expected = 10000 - 2000;
		actual = mini.getAccount().getBalance();
		assertEquals(expected, actual);
	}

//	@Test
//	public void testTaxAdded13() {
//		int expected = 10000; 
//		int actual = this.mini.getAccount().getBalance();
//		assertEquals(expected, actual);	
//
//		// Performs the action to be tested
//		this.tax13.landedOn(mini); 
//
//		expected = 10000 - 4000;
//		actual = mini.getAccount().getBalance();
//		assertEquals(expected, actual);
//	}



}
