package edu.osu.cs362;


import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 50 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"setTitle","setDescription"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void myRandTest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

			 Random random = new Random();
			 GregorianCalendar myCal = new GregorianCalendar();
			 myCal.set(
					 ValuesGenerator.getRandomIntBetween(random, 1995, 2100),        //year
					 ValuesGenerator.getRandomIntBetween(random, 1, 12),            //month
					 ValuesGenerator.getRandomIntBetween(random, 1, 7),            //day
					 ValuesGenerator.getRandomIntBetween(random, 1, 24),            //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60),            //minute
					 ValuesGenerator.getRandomIntBetween(random, 1, 60)            //second
			 );

			 CalDay calDay = new CalDay(myCal);

			 Appt appt = new Appt(
					 ValuesGenerator.getRandomIntBetween(random, 1, 23), //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
					 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
					 ValuesGenerator.getRandomIntBetween(random, 1995, 2110),
					 ValuesGenerator.getString(random), //title
					 ValuesGenerator.getString(random) //description
			 );

			 calDay.addAppt(appt);

			 assertEquals(calDay.getSizeAppts(), 1);

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			 if ((iteration % 10000) == 0 && iteration != 0)
				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		 }

		 System.out.println("Done testing...");
	 }
}
