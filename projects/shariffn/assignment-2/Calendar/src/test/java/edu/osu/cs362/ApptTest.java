package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }

	@Test //testing all of the setters
	public void test02()  throws Throwable {
		//create an appointment
		int startHour=7;
		int startMinute=21;
		int startDay=17;
		int startMonth=4;
		int startYear=1995;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);
		//change all of the appointment values using the setter
		appt.setStartHour(9);
		appt.setStartMinute(7);
		appt.setStartDay(14);
		appt.setStartMonth(12);
		appt.setStartYear(2007);
		appt.setTitle("This is");
		appt.setDescription("my birthday?");

		//assert that the appointment is still valid with the new values instead of the old
		assertTrue(appt.getValid());
		assertEquals(9, appt.getStartHour());
		assertEquals(7, appt.getStartMinute());
		assertEquals(14, appt.getStartDay());
		assertEquals(12, appt.getStartMonth());
		assertEquals(2007, appt.getStartYear());
		assertEquals("This is", appt.getTitle());
		assertEquals("my birthday?", appt.getDescription());
	}

	@Test
	public void test03() throws Throwable {

		//Construct a new Appointment object with the initial data
		int startHour=0;
		int startMinute=0;
		int startDay=0;
		int startMonth=0;
		int startYear=0;
		String title = null;
		String description=  null;

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

		appt.setStartDay(28);

		assertEquals(false, appt.getValid());
		assertNull(appt.toString());
	}

	@Test //testing isValid start hour <0
	public void test04()  throws Throwable {
		//create an appointment
		int startHour=-7;
		int startMinute=28;
		int startDay=14;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

		//check that the appointment is invalid

		assertFalse(appt.getValid());
		assertEquals(-7, appt.getStartHour());

	}
}
