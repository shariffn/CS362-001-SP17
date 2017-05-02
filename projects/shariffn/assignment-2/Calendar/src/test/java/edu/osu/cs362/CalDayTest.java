package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalDayTest {

	@Test //check adding appointments
	public void test01()  throws Throwable {
		//generate a calendar
		GregorianCalendar Calendar = new GregorianCalendar();
		CalDay CalendarDay = new CalDay(Calendar);

		//generate an appointment
		Appt appt = new Appt(7, 21, 17, 4,
				1995, "NbZ", "Party!!!");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);

		appt = new Appt(5, 19, 29, 2,
				2007, "NbZ", "Party!!!");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);

		appt = new Appt(27, 3, 27,4,
				2017, "NbZ", "Party!!!");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);

		appt = new Appt(2, 1, 17, 7,
				1994, "NbZ", "Party!!!");

		String print = CalendarDay.toString();
		System.out.print(print);
	}

	@Test //check empty appointments
	public void test02()  throws Throwable  {
		//empty constructor
		CalDay CalendarDay = new CalDay();
		assertFalse(CalendarDay.isValid());

		String test = CalendarDay.toString();
		assertEquals("",test);
	}

	@Test //check iterator
	public void test03()  throws Throwable  {
		//generate a calendar
		GregorianCalendar Calendar = new GregorianCalendar();
		CalDay CalendarDay = new CalDay(Calendar);

		//generate an appointment
		Appt appt = new Appt(15,28, 17, 4,
				1995, "NbZ", "Party!!!");

		//add the appointment to the calendar
		CalendarDay.addAppt(appt);

		Iterator move = CalendarDay.iterator();

		//valid should be set to true
		assertTrue(CalendarDay.isValid());

		//assert that the iterator has a value
		assertTrue(move.hasNext());

		Object hold = move.next();

		assertEquals(hold, appt);
	}


}
