package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.time.MockZonedDateTime;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.evosuite.runtime.EvoAssertions.assertThrownBy;
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

	@Test
	public void test04() {
		CalDay calendarDay = new CalDay();

		// Invalid before initialization
		assertFalse(calendarDay.isValid());
	}

	@Test
	public void test05() {
		int year=2021;
		int month=4;
		int day=7;

		GregorianCalendar gregCalendar = new GregorianCalendar(year, month, day);
		CalDay calendarDay = new CalDay(gregCalendar);

		Appt appointment1 = new Appt(12,30,
				day, month, year, "First", null);

		Appt appointment2 = new Appt(14, 45,
				day, month, year, "Second", null);

		Appt invalidAppointment = new Appt(3000, 0,
				day, month, year, "Invalid", null);

		// Ensure appointments are valid
		assertTrue(appointment1.getValid());
		assertTrue(appointment2.getValid());

		// There are no existing Appts
		assertEquals(0, calendarDay.getSizeAppts());

		// One appointment added
		calendarDay.addAppt(appointment1);
		assertEquals(appointment1, calendarDay.getAppts().getFirst());

		// Two appointments added
		calendarDay.addAppt(appointment2);
		assertEquals(appointment2, calendarDay.getAppts().getLast());

		// Adding invalid Appts should not affect CalDay size
		int size = calendarDay.getSizeAppts();
		calendarDay.addAppt(invalidAppointment);
		assertEquals(size, calendarDay.getSizeAppts());
	}

	@Test
	public void test06() {
		int year=1995;
		int month=4;
		int day=17;

		GregorianCalendar gregCalendar = new GregorianCalendar(year, month, day);
		CalDay calendarDay = new CalDay(gregCalendar);

		Appt appointment1 = new Appt(19,0,
				day, month, year, "Care", null);

		Appt appointment2 = new Appt(5, 20,
				day, month, year, "Birth", null);

		calendarDay.addAppt(appointment1);
		calendarDay.addAppt(appointment2);

		// Appointsments added successfully
		assertEquals(2, calendarDay.getSizeAppts());

		// String is correct
		assertEquals(
				"\t --- 4/17/1995 --- \n" +
						" --- -------- Appointments ------------ --- \n" +
						"\t4/17/1995 at 5:20am ,Birth, \n" +
						" \t4/17/1995 at 7:0pm ,Care, \n" +
						" \n",
				calendarDay.toString());

		// Invalid CalDay should print nothing
		calendarDay.valid = false;
		assertEquals("", calendarDay.toString());
	}



	//______________________________________________FROM EVOSUITE________________________________________

	@Test(timeout = 4000)
	public void test00()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-3248), 1, 1, (-3248), 1);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		Appt appt0 = new Appt((-3248), (-3248), 1, (-3248), 1, "C", "C");
		Appt appt1 = new Appt(1, 1, 1, 1, 1, "C", "C");
		LinkedList<Appt> linkedList0 = calDay0.appts;
		linkedList0.add(appt0);
		calDay0.addAppt(appt1);
	}

	@Test(timeout = 4000)
	public void test1()  throws Throwable {
		CalDay calDay0 = new CalDay();
		calDay0.isValid();
	}

	@Test(timeout = 4000)
	public void test2()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0, 0, 0);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		calDay0.year = 0;
		calDay0.getYear();
	}

	@Test(timeout = 4000)
	public void test3()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.year = (-3086);
		calDay0.getYear();
	}

	@Test(timeout = 4000)
	public void test4()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		calDay0.getSizeAppts();
	}

	@Test(timeout = 4000)
	public void test5()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
		calDay0.appts = linkedList0;
		Appt appt0 = new Appt(1491, 0, 622, 57, 622, "", "");
		linkedList0.add(appt0);
		calDay0.getSizeAppts();
	}

	@Test(timeout = 4000)
	public void test6()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.getMonth();
	}

	@Test(timeout = 4000)
	public void test7()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.month = (-2968);
		calDay0.getMonth();
	}

	@Test(timeout = 4000)
	public void test8()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.getDay();
	}

	@Test(timeout = 4000)
	public void test09()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.day = (-1);
		calDay0.getDay();
	}

	@Test(timeout = 4000)
	public void test10()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.getAppts();
	}

	@Test(timeout = 4000)
	public void test11()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.valid = true;
		// Undeclared exception!
		try {
			calDay0.toString();
			fail("Expecting exception: NullPointerException");

		} catch(NullPointerException e) {
			//
			// no message in exception (getMessage() returned null)
			//
			assertThrownBy("edu.osu.cs362.CalDay", e);
		}
	}

	@Test(timeout = 4000)
	public void test12()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.valid = true;
		// Undeclared exception!
		try {
			calDay0.iterator();
			fail("Expecting exception: NullPointerException");

		} catch(NullPointerException e) {
			//
			// no message in exception (getMessage() returned null)
			//
			assertThrownBy("edu.osu.cs362.CalDay", e);
		}
	}

	@Test(timeout = 4000)
	public void test13()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		// Undeclared exception!
		try {
			calDay0.addAppt((Appt) null);
			fail("Expecting exception: NullPointerException");

		} catch(NullPointerException e) {
			//
			// no message in exception (getMessage() returned null)
			//
			assertThrownBy("edu.osu.cs362.CalDay", e);
		}
	}

	@Test(timeout = 4000)
	public void test14()  throws Throwable  {
		CalDay calDay0 = null;
		try {
			calDay0 = new CalDay((GregorianCalendar) null);
			fail("Expecting exception: NullPointerException");

		} catch(NullPointerException e) {
			//
			// no message in exception (getMessage() returned null)
			//
			assertThrownBy("edu.osu.cs362.CalDay", e);
		}
	}

	@Test(timeout = 4000)
	public void test15()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(276, 2723, 2723, 2723, 2723);
		mockGregorianCalendar0.setLenient(false);
		CalDay calDay0 = null;
		try {
			calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
			fail("Expecting exception: IllegalArgumentException");

		} catch(IllegalArgumentException e) {
			//
			// MONTH
			//
			assertThrownBy("java.util.GregorianCalendar", e);
		}
	}

	@Test(timeout = 4000)
	public void test16()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0, 0, 0);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		calDay0.getYear();
	}

	@Test(timeout = 4000)
	public void test17()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0, 0, 0);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		calDay0.getDay();
	}

	@Test(timeout = 4000)
	public void test18()  throws Throwable  {
		ZoneOffset zoneOffset0 = ZoneOffset.MAX;
		ZonedDateTime zonedDateTime0 = MockZonedDateTime.now((ZoneId) zoneOffset0);
		MockGregorianCalendar mockGregorianCalendar0 = (MockGregorianCalendar)MockGregorianCalendar.from(zonedDateTime0);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		calDay0.getMonth();
	}

	@Test(timeout = 4000)
	public void test19()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0, 0, 0);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		LinkedList<Appt> linkedList0 = calDay0.getAppts();
		Appt appt0 = new Appt((-44), (-44), (-3205), 0, (-44), (String) null, (String) null);
		linkedList0.add(appt0);
		calDay0.getAppts();
	}

	@Test(timeout = 4000)
	public void test20()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0, 0, 0);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		calDay0.isValid();
	}

	@Test(timeout = 4000)
	public void test21()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-3248), 1, 1, (-3248), 1);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		Appt appt0 = new Appt(1, 1, 1, 1, 1, "C", "C");
		calDay0.addAppt(appt0);
		calDay0.toString();
		assertEquals(1, calDay0.getSizeAppts());
	}

	@Test(timeout = 4000)
	public void test22()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		String string0 = calDay0.toString();
		assertEquals("", string0);
	}

	@Test(timeout = 4000)
	public void test23()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(0, 0, 0, 0, 0);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		Iterator<?> iterator0 = calDay0.iterator();
		assertNotNull(iterator0);
		assertEquals(2, calDay0.getYear());
		assertEquals(11, calDay0.getMonth());
		assertEquals(31, calDay0.getDay());
	}

	@Test(timeout = 4000)
	public void test24()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		Iterator<?> iterator0 = calDay0.iterator();
		assertNull(iterator0);
	}

	@Test(timeout = 4000)
	public void test25()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(1, 2, 1, 1, 2, 1);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		Appt appt0 = new Appt(2, 2, 1, 2, 1, "^De?w`cBs:A", "^De?w`cBs:A");
		calDay0.addAppt(appt0);
		Appt appt1 = new Appt(1, 1, 1, 1, 1, "^De?w`cBs:A", "^De?w`cBs:A");
		calDay0.addAppt(appt1);
		assertEquals(2, calDay0.getSizeAppts());
	}

	@Test(timeout = 4000)
	public void test26()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-3248), 1, 1, (-3248), 1);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		Appt appt0 = new Appt((-3248), (-3248), 1, (-3248), 1, "C", "C");
		calDay0.addAppt(appt0);
		assertEquals(18, calDay0.getDay());
		assertEquals(8, calDay0.getMonth());
		assertEquals(0, calDay0.getSizeAppts());
		assertEquals(3250, calDay0.getYear());
		assertTrue(calDay0.isValid());
	}

	@Test(timeout = 4000)
	public void test27()  throws Throwable  {
		MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-3248), 1, 1, (-3248), 1);
		CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
		Appt appt0 = new Appt(1, 1, 1, 1, 1, "C", "C");
		calDay0.addAppt(appt0);
		calDay0.addAppt(appt0);
		assertEquals(2, calDay0.getSizeAppts());
	}

	@Test(timeout = 4000)
	public void test28()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		// Undeclared exception!
		try {
			calDay0.getSizeAppts();
			fail("Expecting exception: NullPointerException");

		} catch(NullPointerException e) {
			//
			// no message in exception (getMessage() returned null)
			//
			assertThrownBy("edu.osu.cs362.CalDay", e);
		}
	}
}
