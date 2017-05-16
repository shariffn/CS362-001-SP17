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


	@Test //testing isValid start hour <0
	public void test05()  throws Throwable {
		//create an appointment
		int startHour=35;
		int startMinute=59;
		int startDay=31;
		int startMonth=12;
		int startYear=-2017;
		String title="Birthday Party";
		String description="This is my birthday party.";

		//make the appointment
		Appt appt = new Appt(startHour, startMinute , startDay , startMonth ,
				startYear , title, description);

		//check that the appointment is invalid

		assertFalse(appt.getValid());
		assertEquals(35, appt.getStartHour());
		assertEquals(59, appt.getStartMinute());
	}

	@Test //Test that startHour, startDay, etc, must be valid
	public void test06() throws Throwable {
		int startHour=23;
		int startMinute=13;
		int startDay=2;
		int startMonth=12;
		int startYear=2021;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				"Futuristic Next Level",
				"It's in the future mate!");
		// Initially valid
		assertTrue(appt.getValid());

		// Hour greater than 23
		appt.setStartHour(25);
		assertFalse(appt.getValid());
		appt.setStartHour(23);

		// Hour less than 0
		appt.setStartHour(-5);
		assertFalse(appt.getValid());

		// Minute greater than 59
		appt.setStartMinute(66);
		assertFalse(appt.getValid());
		appt.setStartMinute(13);

		// Minute less than 0
		appt.setStartMinute(-1);
		assertFalse(appt.getValid());

		// Day greater than 31
		appt.setStartDay(43);
		assertFalse(appt.getValid());
		appt.setStartDay(2);

		// Day less than 1
		appt.setStartDay(0);
		assertFalse(appt.getValid());
	}

	@Test //test toString
	public void test07() throws Throwable {
		int startHour=19;
		int startMinute=00;
		int startDay=7;
		int startMonth=4;
		int startYear=3021;
		String title="Date";
		String description="Got a date with the best lady in the world";
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
		assertEquals("	4/7/3021 at 7:0pm ,Date, Got a date with the best lady in the world\n", appt.toString());

		// Test with invalid appointment
		appt.setStartHour(35);
		assertFalse(appt.getValid());
		assertEquals(null, appt.toString());
	}

	@Test // startMonth
	public void test09() throws Throwable {
		int startHour = 23;
		int startMinute = 13;
		int startDay = 2;
		int startMonth = 12;
		int startYear = 2021;
		String title = "Month Test";
		String description = "Using this appt to test invalid months";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// Initially valid
		assertTrue(appt.getValid());

		// Month greater than 12
		appt.setStartMonth(18);
		assertFalse(appt.getValid());
		appt.setStartMonth(12);

		// Month less than 1
		appt.setStartMonth(0);
		assertFalse(appt.getValid());
	}


	//______________________________________________FROM EVOSUITE________________________________________
/*
	@Test(timeout = 4000)
	public void test00()  throws Throwable  {
		Appt appt0 = new Appt(11, 11, 31, 12, (-4597), "$ wH", "$ wH");
		String string0 = appt0.toString();
		assertNotNull(string0);
		assertEquals("\t12/31/-4597 at 11:11am ,$ wH, $ wH\n", string0);
	}

	@Test(timeout = 4000)
	public void test1()  throws Throwable  {
		Appt appt0 = new Appt(23, 104, 23, 23, 23, "am", "+>'");
		assertEquals(23, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(23, appt0.getStartYear());
		assertEquals("+>'", appt0.getDescription());
		assertEquals(23, appt0.getStartHour());
		assertEquals(23, appt0.getStartMonth());
		assertEquals(104, appt0.getStartMinute());
		assertEquals("am", appt0.getTitle());
	}

	@Test(timeout = 4000)
	public void test2()  throws Throwable  {
		Appt appt0 = new Appt(8, 8, 8, 8, 8, "D", "D");
		boolean boolean0 = appt0.getValid();
		assertTrue(boolean0);
		assertEquals("D", appt0.getDescription());
		assertEquals(8, appt0.getStartDay());
		assertEquals(8, appt0.getStartMonth());
		assertEquals(8, appt0.getStartMinute());
		assertEquals(8, appt0.getStartHour());
		assertEquals(8, appt0.getStartYear());
	}

	@Test(timeout = 4000)
	public void test3()  throws Throwable  {
		Appt appt0 = new Appt(1089, 1089, 1089, 1089, 1089, "", "");
		appt0.getTitle();
		assertEquals(1089, appt0.getStartHour());
		assertEquals(1089, appt0.getStartYear());
		assertEquals(1089, appt0.getStartMonth());
		assertEquals(1089, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(1089, appt0.getStartMinute());
	}

	@Test(timeout = 4000)
	public void test4()  throws Throwable  {
		Appt appt0 = new Appt(0, (-3144), 2023, 0, 0, "", "");
		int int0 = appt0.getStartYear();
		assertEquals(0, appt0.getStartHour());
		assertEquals(2023, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(0, appt0.getStartMonth());
		assertEquals(-3144, appt0.getStartMinute());
		assertEquals(0, int0);
	}

	@Test(timeout = 4000)
	public void test5()  throws Throwable  {
		Appt appt0 = new Appt((-2276), 0, 1725, (-2276), 59, "#getXMLSchemaType() :", "org.apache.xerces.jaxp.datatype.DurationImpl");
		int int0 = appt0.getStartYear();
		assertEquals(-2276, appt0.getStartHour());
		assertEquals(-2276, appt0.getStartMonth());
		assertEquals("org.apache.xerces.jaxp.datatype.DurationImpl", appt0.getDescription());
		assertEquals(1725, appt0.getStartDay());
		assertEquals(0, appt0.getStartMinute());
		assertFalse(appt0.getValid());
		assertEquals(59, int0);
		assertEquals("#getXMLSchemaType() :", appt0.getTitle());
	}

	@Test(timeout = 4000)
	public void test6()  throws Throwable  {
		Appt appt0 = new Appt(100, 0, (-1969), (-1969), (-1969), "\t", "F5gHfD1$H1");
		assertEquals(-1969, appt0.getStartMonth());

		appt0.setStartMonth(0);
		int int0 = appt0.getStartMonth();
		assertEquals(0, int0);
	}

	@Test(timeout = 4000)
	public void test7()  throws Throwable  {
		Appt appt0 = new Appt(1, 1, 1, (-525), (-525), "=`UX'S<", "!,Wx@L/-sKcp");
		int int0 = appt0.getStartMonth();
		assertEquals("!,Wx@L/-sKcp", appt0.getDescription());
		assertEquals(1, appt0.getStartDay());
		assertEquals(-525, appt0.getStartYear());
		assertEquals(1, appt0.getStartMinute());
		assertFalse(appt0.getValid());
		assertEquals((-525), int0);
		assertEquals(1, appt0.getStartHour());
		assertEquals("=`UX'S<", appt0.getTitle());
	}

	@Test(timeout = 4000)
	public void test08()  throws Throwable  {
		Appt appt0 = new Appt(100, 0, (-1969), (-1969), (-1969), "\t", "F5gHfD1$H1");
		int int0 = appt0.getStartMinute();
		assertEquals(-1969, appt0.getStartYear());
		assertEquals("F5gHfD1$H1", appt0.getDescription());
		assertEquals(100, appt0.getStartHour());
		assertFalse(appt0.getValid());
		assertEquals(-1969, appt0.getStartDay());
		assertEquals(0, int0);
		assertEquals(-1969, appt0.getStartMonth());
		assertEquals("\t", appt0.getTitle());
	}

	@Test(timeout = 4000)
	public void test9()  throws Throwable  {
		Appt appt0 = new Appt((-246), (-246), (-246), (-246), (-584), "am", "%Y-%M%z");
		int int0 = appt0.getStartMinute();
		assertEquals("%Y-%M%z", appt0.getDescription());
		assertEquals("am", appt0.getTitle());
		assertEquals(-246, appt0.getStartDay());
		assertEquals((-246), int0);
		assertFalse(appt0.getValid());
		assertEquals(-246, appt0.getStartMonth());
		assertEquals(-584, appt0.getStartYear());
		assertEquals(-246, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test10()  throws Throwable  {
		Appt appt0 = new Appt(100, 0, (-1969), (-1969), (-1969), "\t", "F5gHfD1$H1");
		int int0 = appt0.getStartHour();
		assertEquals(-1969, appt0.getStartMonth());
		assertEquals("\t", appt0.getTitle());
		assertFalse(appt0.getValid());
		assertEquals(-1969, appt0.getStartYear());
		assertEquals(100, int0);
		assertEquals("F5gHfD1$H1", appt0.getDescription());
		assertEquals(0, appt0.getStartMinute());
		assertEquals(-1969, appt0.getStartDay());
	}

	@Test(timeout = 4000)
	public void test11()  throws Throwable  {
		Appt appt0 = new Appt(2032, (-629), 0, 2112, 0, "/", "/");
		int int0 = appt0.getStartDay();
		assertEquals("/", appt0.getTitle());
		assertEquals(2112, appt0.getStartMonth());
		assertEquals(0, int0);
		assertFalse(appt0.getValid());
		assertEquals(2032, appt0.getStartHour());
		assertEquals(0, appt0.getStartYear());
		assertEquals(-629, appt0.getStartMinute());
		assertEquals("/", appt0.getDescription());
	}

	@Test(timeout = 4000)
	public void test12()  throws Throwable  {
		Appt appt0 = new Appt((-2854), (-2854), (-2854), (-2854), (-2854), "", "");
		int int0 = appt0.getStartDay();
		assertEquals(-2854, appt0.getStartMonth());
		assertEquals(-2854, appt0.getStartMinute());
		assertEquals(-2854, appt0.getStartYear());
		assertEquals(-2854, appt0.getStartHour());
		assertFalse(appt0.getValid());
		assertEquals((-2854), int0);
	}

	@Test(timeout = 4000)
	public void test13()  throws Throwable  {
		Appt appt0 = new Appt(0, 0, 0, 0, 0, "", "");
		appt0.getDescription();
		assertEquals(0, appt0.getStartDay());
		assertEquals(0, appt0.getStartHour());
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartMonth());
		assertFalse(appt0.getValid());
		assertEquals(0, appt0.getStartYear());
	}

	@Test(timeout = 4000)
	public void test14()  throws Throwable  {
		Appt appt0 = new Appt((-1872), (-1872), (-1872), 1099, 194, "6/zNO_m]", "6/zNO_m]");
		assertEquals("6/zNO_m]", appt0.getDescription());

		appt0.setDescription("");
		assertEquals(1099, appt0.getStartMonth());
	}

	@Test(timeout = 4000)
	public void test15()  throws Throwable  {
		Appt appt0 = new Appt(0, 2461, (-695), (-695), 0, "&s:A_xpg*$", "&s:A_xpg*$");
		assertEquals("&s:A_xpg*$", appt0.getDescription());

		appt0.setDescription((String) null);
		assertEquals(-695, appt0.getStartMonth());
	}

	@Test(timeout = 4000)
	public void test16()  throws Throwable  {
		Appt appt0 = new Appt(0, 0, 59, 0, 0, "My}C ", "My}C ");
		appt0.setTitle("My}C ");
		assertEquals("My}C ", appt0.getDescription());
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartMonth());
		assertEquals(0, appt0.getStartYear());
		assertEquals(0, appt0.getStartHour());
		assertFalse(appt0.getValid());
		assertEquals(59, appt0.getStartDay());
		assertEquals("My}C ", appt0.getTitle());
	}

	@Test(timeout = 4000)
	public void test17()  throws Throwable  {
		Appt appt0 = new Appt(2844, 2844, 2844, 2844, 31, "", "");
		appt0.setTitle((String) null);
		assertFalse(appt0.getValid());
		assertEquals(2844, appt0.getStartMinute());
		assertEquals(2844, appt0.getStartDay());
		assertEquals(2844, appt0.getStartHour());
		assertEquals(31, appt0.getStartYear());
		assertEquals(2844, appt0.getStartMonth());
	}

	@Test(timeout = 4000)
	public void test18()  throws Throwable  {
		Appt appt0 = new Appt(0, 0, 0, 70, 70, "UnknownField", "UnknownField");
		String string0 = appt0.getTitle();
		assertEquals("UnknownField", string0);
		assertEquals("UnknownField", appt0.getDescription());
		assertEquals(0, appt0.getStartHour());
		assertEquals(0, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(70, appt0.getStartYear());
		assertEquals(70, appt0.getStartMonth());
		assertEquals(0, appt0.getStartMinute());
	}

	@Test(timeout = 4000)
	public void test19()  throws Throwable  {
		Appt appt0 = new Appt((-1002), 870, 473, 1822, 0, ", ", ", ");
		int int0 = appt0.getStartDay();
		assertEquals(", ", appt0.getDescription());
		assertEquals(-1002, appt0.getStartHour());
		assertEquals(0, appt0.getStartYear());
		assertFalse(appt0.getValid());
		assertEquals(870, appt0.getStartMinute());
		assertEquals(1822, appt0.getStartMonth());
		assertEquals(473, int0);
		assertEquals(", ", appt0.getTitle());
	}

	@Test(timeout = 4000)
	public void test20()  throws Throwable  {
		Appt appt0 = new Appt(3529, 3529, 3529, (-2394), (-2394), " at ", " at ");
		boolean boolean0 = appt0.getValid();
		assertEquals(-2394, appt0.getStartMonth());
		assertEquals(3529, appt0.getStartDay());
		assertEquals(3529, appt0.getStartMinute());
		assertFalse(boolean0);
		assertEquals(3529, appt0.getStartHour());
		assertEquals(" at ", appt0.getTitle());
		assertEquals(-2394, appt0.getStartYear());
		assertEquals(" at ", appt0.getDescription());
	}

	@Test(timeout = 4000)
	public void test21()  throws Throwable  {
		Appt appt0 = new Appt((-913), 59, 59, 999, 59, "z+ M", "z+ M");
		int int0 = appt0.getStartHour();
		assertEquals("z+ M", appt0.getDescription());
		assertEquals(999, appt0.getStartMonth());
		assertEquals(59, appt0.getStartYear());
		assertEquals(59, appt0.getStartMinute());
		assertEquals(59, appt0.getStartDay());
		assertEquals((-913), int0);
		assertFalse(appt0.getValid());
		assertEquals("z+ M", appt0.getTitle());
	}

	@Test(timeout = 4000)
	public void test22()  throws Throwable  {
		Appt appt0 = new Appt(1, 1, 1, (-525), (-525), "=`UX'S<", "!,Wx@L/-sKcp");
		int int0 = appt0.getStartYear();
		assertEquals(1, appt0.getStartDay());
		assertEquals(-525, appt0.getStartMonth());
		assertFalse(appt0.getValid());
		assertEquals("=`UX'S<", appt0.getTitle());
		assertEquals("!,Wx@L/-sKcp", appt0.getDescription());
		assertEquals(1, appt0.getStartMinute());
		assertEquals((-525), int0);
		assertEquals(1, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test23()  throws Throwable  {
		Appt appt0 = new Appt(1, 1, 1, (-525), (-525), "=`UX'S<", "!,Wx@L/-sKcp");
		int int0 = appt0.getStartMinute();
		assertFalse(appt0.getValid());
		assertEquals("=`UX'S<", appt0.getTitle());
		assertEquals(-525, appt0.getStartYear());
		assertEquals(1, appt0.getStartDay());
		assertEquals(-525, appt0.getStartMonth());
		assertEquals(1, int0);
		assertEquals(1, appt0.getStartHour());
		assertEquals("!,Wx@L/-sKcp", appt0.getDescription());
	}

	@Test(timeout = 4000)
	public void test24()  throws Throwable  {
		Appt appt0 = new Appt(8, 8, 8, 8, 8, "D", "D");
		String string0 = appt0.getDescription();
		assertEquals(8, appt0.getStartYear());
		assertEquals(8, appt0.getStartHour());
		assertEquals("D", appt0.getTitle());
		assertEquals(8, appt0.getStartMinute());
		assertEquals(8, appt0.getStartMonth());
		assertTrue(appt0.getValid());
		assertEquals("D", string0);
		assertEquals(8, appt0.getStartDay());
	}

	@Test(timeout = 4000)
	public void test25()  throws Throwable  {
		Appt appt0 = new Appt(8, 8, 8, 8, 8, "D", "D");
		int int0 = appt0.getStartMonth();
		assertEquals(8, int0);
		assertEquals("D", appt0.getDescription());
		assertEquals(8, appt0.getStartDay());
		assertEquals("D", appt0.getTitle());
		assertEquals(8, appt0.getStartYear());
		assertEquals(8, appt0.getStartMinute());
		assertEquals(8, appt0.getStartHour());
		assertTrue(appt0.getValid());
	}

	@Test(timeout = 4000)
	public void test26()  throws Throwable  {
		Appt appt0 = new Appt(1120, 1120, 12, 12, 12, "S]v;ent*9W})wMW!5", "S]v;ent*9W})wMW!5");
		appt0.setStartHour(12);
		appt0.setStartMinute(12);
		appt0.toString();
		assertEquals(12, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test27()  throws Throwable  {
		Appt appt0 = new Appt(1, 1, 1, (-525), (-525), "=`UX'S<", "!,Wx@L/-sKcp");
		String string0 = appt0.toString();
		assertEquals(1, appt0.getStartHour());
		assertEquals(1, appt0.getStartMinute());
		assertEquals(-525, appt0.getStartYear());
		assertEquals("=`UX'S<", appt0.getTitle());
		assertEquals("!,Wx@L/-sKcp", appt0.getDescription());
		assertNull(string0);
		assertEquals(1, appt0.getStartDay());
		assertEquals(-525, appt0.getStartMonth());
	}

	@Test(timeout = 4000)
	public void test28()  throws Throwable  {
		Appt appt0 = new Appt(15, 15, 15, 15, 15, (String) null, (String) null);
		assertEquals(15, appt0.getStartMonth());
		assertEquals(15, appt0.getStartMinute());
		assertEquals(15, appt0.getStartYear());
		assertEquals(15, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(15, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test29()  throws Throwable  {
		Appt appt0 = new Appt(0, 0, 115, (-3350), 115, "", "DN2`~zUR6Y9UivE)Z");
		int int0 = appt0.getStartHour();
		assertEquals("DN2`~zUR6Y9UivE)Z", appt0.getDescription());
		assertEquals(-3350, appt0.getStartMonth());
		assertEquals(115, appt0.getStartYear());
		assertFalse(appt0.getValid());
		assertEquals(115, appt0.getStartDay());
		assertEquals("", appt0.getTitle());
		assertEquals(0, int0);
		assertEquals(0, appt0.getStartMinute());
	}

	@Test(timeout = 4000)
	public void test30()  throws Throwable  {
		Appt appt0 = new Appt(1, 1, 1, (-525), (-525), "=`UX'S<", "!,Wx@L/-sKcp");
		assertEquals(-525, appt0.getStartYear());

		appt0.setStartYear(1);
		assertEquals(1, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test31()  throws Throwable  {
		Appt appt0 = new Appt(3529, 3529, 3529, (-2394), (-2394), " at ", " at ");
		appt0.setStartDay(3529);
		assertEquals(" at ", appt0.getTitle());
		assertFalse(appt0.getValid());
		assertEquals(3529, appt0.getStartDay());
		assertEquals(-2394, appt0.getStartMonth());
		assertEquals(3529, appt0.getStartMinute());
		assertEquals(-2394, appt0.getStartYear());
		assertEquals(" at ", appt0.getDescription());
		assertEquals(3529, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test32()  throws Throwable  {
		Appt appt0 = new Appt(0, 59, 0, 0, 0, "_@P8n-;cYs2yZg_Ec*", (String) null);
		assertEquals(0, appt0.getStartMonth());

		appt0.setStartMonth(59);
		assertEquals(0, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test33()  throws Throwable  {
		Appt appt0 = new Appt(8, 8, 8, 8, 8, "D", "D");
		String string0 = appt0.toString();
		assertEquals("\t8/8/8 at 8:8am ,D, D\n", string0);
		assertNotNull(string0);
	}*/
}
