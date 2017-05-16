package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test //delete from empty calendar
	public void test01()  throws Throwable  {
		//generate a calendar
		CalDay CalendarDay = new CalDay();
		TimeTable Table = new TimeTable();

		//generate an appointment
		Appt appt = new Appt(18,25, 17, 4,
				1995, "My Actual Birthday", "Birthday");

		//don't add the appointment

		//retrieve the calendar appointments
		LinkedList<Appt> list = CalendarDay.getAppts();

		//check to see if empty after deleting
		assertNull(Table.deleteAppt(list , appt));
	}

	@Test //generate Time Table range
	public void test02()  throws Throwable  {
		//generate a calendar table
		GregorianCalendar Calendar = new GregorianCalendar();
		CalDay CalendarDay = new CalDay(Calendar);
		TimeTable Table = new TimeTable();

		//generate an appointment
		Appt appt = new Appt(7,3, 17, 4,
				1995, "My Actual Birthday", "Birthday");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);
		appt = new Appt(100,100, 100, 100,
				2027, "My sister's Bday", "Party and gifts!");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);

		//retrieve the calendar appointments
		LinkedList<Appt> list = CalendarDay.getAppts();

		//Today
		GregorianCalendar Today = new GregorianCalendar();

		//One week later
		GregorianCalendar lastday = (GregorianCalendar)Today.clone();
		lastday.add(Calendar.DAY_OF_MONTH,7);

		LinkedList<CalDay> range = Table.getApptRange(list,Today,lastday);

		System.out.print(range);
	}

	@Test
	public void test03()  throws Throwable  {
		//generate a calendar and table
		GregorianCalendar Calendar = new GregorianCalendar();
		CalDay CalendarDay = new CalDay(Calendar);
		TimeTable Table = new TimeTable();

		//generate an appointment
		Appt appt = new Appt(7,17, 17, 4,
				1995, "My Actual Birthday", "Party till we drop!");

		//insert appointment to calendar
		CalendarDay.addAppt(appt);
		appt = new Appt(10,21, 7, 7,
				1997, "My sister's Bday", "Party and gifts!");

		//insert appointment to calendar
		CalendarDay.addAppt(appt);

		//retrieve the calendar appointments
		LinkedList<Appt> list = CalendarDay.getAppts();

		//Today
		GregorianCalendar Today = new GregorianCalendar();

		//two months from Today
		GregorianCalendar lastday = (GregorianCalendar)Today.clone();
		lastday.add(Calendar.DAY_OF_MONTH,60);

		LinkedList<CalDay> Range = Table.getApptRange(list,Today, lastday);

		System.out.print(Range);
	}

	@Test
	public void test04()  throws Throwable {
		//generate a calendar and table
		GregorianCalendar Calendar = new GregorianCalendar();
		CalDay CalendarDay = new CalDay(Calendar);
		TimeTable Table = new TimeTable();

		//generate an appointment
		Appt appt = new Appt(10, 30, 20, 4,
				2017, "Real", "Birthday");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);
		appt = new Appt(10, 30, 5, 4,
				2017, "Fake", "Birthday");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);

		//retrieve the calendar appointments
		LinkedList<Appt> list = CalendarDay.getAppts();

		//get rid of a value
		LinkedList<Appt> delete = Table.deleteAppt(list, appt);

		System.out.print(delete);
	}

	@Test
	public void test05()  throws Throwable  {
		//generate a calendar and table
		GregorianCalendar Calendar = new GregorianCalendar();
		CalDay CalendarDay = new CalDay(Calendar);
		TimeTable Table = new TimeTable();

		//generate an appointment
		Appt appt = new Appt(11, 30, 10, 4,
				2017, "My Birthday", "Come, enjoy, party till we shleep!");

		//insert appointment into calendar
		CalendarDay.addAppt(appt);
		appt = new Appt(8, 30,15, 7,
				2017, "My Birthday", "Come, enjoy, party till we shleep!");

		CalendarDay.addAppt(appt);
		
		LinkedList<Appt> list = CalendarDay.getAppts();
		
		GregorianCalendar Today = new GregorianCalendar();
		
		GregorianCalendar lastday = (GregorianCalendar)Today.clone();
		
		lastday.add(Calendar.DAY_OF_MONTH,20);

		LinkedList<CalDay> range = Table.getApptRange(list,Today,lastday);

		System.out.print(range);
	}

	@Test //test Appointment ranges
	public void test06() {
		TimeTable timeTable = new TimeTable();
		int year = 2019;

		int firstDay = 26;
		int firstMonth = 3;

		GregorianCalendar firstDayCalendar = new GregorianCalendar(year, firstMonth, firstDay);

		Appt firstAppt = new Appt(7, 30,
				firstDay, firstMonth, year, "First", null);

		int secondDay = 17;
		int secondMonth = 4;

		Appt secondAppt = new Appt(4, 30,
				secondDay, secondMonth, year, "Second", null);

		GregorianCalendar secondDayCalendar = new GregorianCalendar(year, secondMonth, secondDay+1);

		LinkedList<Appt> appts = new LinkedList<Appt>();

		appts.add(firstAppt);
		appts.add(secondAppt);

		LinkedList<CalDay> calDayList = timeTable.getApptRange(appts, firstDayCalendar, secondDayCalendar);

		// Days are a ten days apart (exclude additional day)
		assertEquals(22, calDayList.size());

		// Appts should match, and other CalDays should have no Appts
		for (CalDay day : calDayList) {
			if (day.getDay() == firstDay) {
				assertEquals(firstAppt, day.getAppts().getFirst());
			} else if (day.getDay() == secondDay) {
				assertEquals(secondAppt, day.getAppts().getFirst());
			} else
				assertEquals(0, day.getSizeAppts());
		}

		// Try with an invalid Appt
		Appt invalidAppt = new Appt(27, 69, 77, 13, 0, null, null);
		appts.add(invalidAppt);
		calDayList = timeTable.getApptRange(appts, firstDayCalendar, secondDayCalendar);

		// There should still be only two appointments
		int count = 0;
		for (CalDay day : calDayList)
			count += day.getSizeAppts();
		assertEquals(2, count);
	}




	//______________________________________________FROM EVOSUITE________________________________________

	//there were errors, so I couldn't add them



}
