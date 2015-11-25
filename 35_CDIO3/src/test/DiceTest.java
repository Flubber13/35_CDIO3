package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import game.DiceCup;

public class DiceTest {

	DiceCup dicecup;
	// Index 1 and 2 will not be used throughout; because then the index number is the same as the dice number
	double[] calProb = new double[13];	
	double[] theoreticalProb = {0, 0 ,1.0/36, 2.0/36, 3.0/36, 4.0/36, 5.0/36, 6.0/36, 5.0/36, 4.0/36, 3.0/36, 2.0/36, 1.0/36};;
	
	
	@Before
	public void setUp() throws Exception {
		dicecup = new DiceCup();
		
		/* This loop rolls the dice 1,000,000 times, and adds one millions of a point 
		   to the corresponding array index in calProb[] after every roll */
		for(int i=0;i<1000000;i++){
			int value = dicecup.roll();
			calProb[value]+=(1.0/1000000);
		}
			
		// This loop prints the calculated and expected probabilities for easy comparison 
				for (int i=2; i<13; i++){
					System.out.println("C"+i+" = "+calProb[i]);
					System.out.println("T"+i+" = "+theoreticalProb[i]);
					System.out.println();
				}	
	}

	@Test
	public void test() {
		for(int j=2; j<13; j++){
			// Tests if probability for every instance matches with the theoretical probability, with an uncertainty of 0.001
			Assert.assertEquals(theoreticalProb[j], calProb[j], 0.001); 
		}
	}
}
