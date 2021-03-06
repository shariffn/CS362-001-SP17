/*
 * This file was automatically generated by EvoSuite
 * Mon May 15 02:36:53 GMT 2017
 */

package edu.osu.cs362;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.osu.cs362.Appt;
import edu.osu.cs362.CalDay;
import edu.osu.cs362.TimeTable;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Locale;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.System;
import org.evosuite.runtime.TooManyResourcesException;
import org.evosuite.runtime.mock.java.util.MockGregorianCalendar;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class TimeTable_ESTest extends TimeTable_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(3, 3, 3, 3, 3, ":QDRDnE=ljD]!p", ":QDRDnE=ljD]!p");
      linkedList0.add(appt0);
      linkedList0.offerLast(appt0);
      timeTable0.deleteAppt(linkedList0, appt0);
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar((-4372), (-4372), 2409);
      MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar();
      // Undeclared exception!
      try { 
        timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
        fail("Expecting exception: TooManyResourcesException");
      
      } catch(TooManyResourcesException e) {
         //
         // Loop has been executed more times than the allowed 10000
         //
         assertThrownBy("org.evosuite.runtime.LoopCounter", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      // Undeclared exception!
      try { 
        timeTable0.getApptRange((LinkedList<Appt>) null, (GregorianCalendar) null, (GregorianCalendar) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      linkedList0.add((Appt) null);
      Appt appt0 = new Appt(1, 1, 1, 1, 1, "Second date specified is not before the first date specified.", (String) null);
      // Undeclared exception!
      try { 
        timeTable0.deleteAppt(linkedList0, appt0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("edu.osu.cs362.TimeTable", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(1161, 1161, 1161, 6, 1161, "f([3FP", "f([3FP");
      linkedList0.add(appt0);
      Appt appt1 = new Appt(6, 6, 6, 6, 6, "f([3FP", "f([3FP");
      timeTable0.deleteAppt(linkedList0, appt1);
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(3, 3, 3, 3, 3, ":QDRDnE=ljD]!p", ":QDRDnE=ljD]!p");
      linkedList0.add(appt0);
      timeTable0.deleteAppt(linkedList0, appt0);
      assertEquals(0, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt((-2640), (-2640), (-2640), (-2640), (-2640), "\"#!^", "\"#!^");
      LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, appt0);
      assertNull(linkedList1);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, (Appt) null);
      assertNull(linkedList1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      Appt appt0 = new Appt(1161, 1161, 1161, 6, 1161, "f([3FP", "f([3FP");
      LinkedList<Appt> linkedList0 = timeTable0.deleteAppt((LinkedList<Appt>) null, appt0);
      assertNull(linkedList0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(3, 3, 3, 3, 3, ")<&CKWvm", ")<&CKWvm");
      System.setCurrentTimeMillis(3);
      linkedList0.add(appt0);
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      System.setCurrentTimeMillis(3219);
      Locale locale0 = new Locale(")<&CKWvm", ")<&CKWvm", ")<&CKWvm");
      MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar(locale0);
      LinkedList<CalDay> linkedList1 = timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
      assertEquals(1, linkedList1.size());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(3, 3, 3, 3, 3, "", "");
      System.setCurrentTimeMillis((-20L));
      linkedList0.add(appt0);
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar(3, 3, 3);
      LinkedList<CalDay> linkedList1 = timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=?,YEAR=3,MONTH=3,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=3,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]", mockGregorianCalendar1.toString());
      assertEquals(1, linkedList1.size());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(3, 3, 3, 3, 3, "", "");
      System.setCurrentTimeMillis((-20L));
      linkedList0.add(appt0);
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      System.setCurrentTimeMillis(3);
      Locale locale0 = new Locale("", "", "");
      MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar(locale0);
      // Undeclared exception!
      try { 
        timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 1, Size: 1
         //
         assertThrownBy("java.util.LinkedList", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt((-2640), (-2640), (-2640), (-2640), (-2640), "\"#!^", "\"#!^");
      System.setCurrentTimeMillis((-2640));
      linkedList0.add(appt0);
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar();
      MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar((-2640), (-2640), (-2640), (-2640), (-2640), (-2640));
      LinkedList<CalDay> linkedList1 = timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
      assertEquals(1, linkedList1.size());
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=?,YEAR=-2640,MONTH=-2640,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=-2640,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=-2640,HOUR_OF_DAY=-2640,MINUTE=-2640,SECOND=-2640,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]", mockGregorianCalendar1.toString());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(3, 3, 3, 3, 3, ":QDRDnE=ljD]!p", ":QDRDnE=ljD]!p");
      linkedList0.add(appt0);
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(3219, 3, 3);
      Locale locale0 = new Locale(":QDRDnE=ljD]!p", ":QDRDnE=ljD]!p", ":QDRDnE=ljD]!p");
      MockGregorianCalendar mockGregorianCalendar1 = new MockGregorianCalendar(locale0);
      timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=?,YEAR=3219,MONTH=3,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=3,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]", mockGregorianCalendar0.toString());
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=1392409281320,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2014,MONTH=1,WEEK_OF_YEAR=7,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=45,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=8,HOUR_OF_DAY=20,MINUTE=21,SECOND=21,MILLISECOND=320,ZONE_OFFSET=0,DST_OFFSET=0]", mockGregorianCalendar1.toString());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      MockGregorianCalendar mockGregorianCalendar0 = new MockGregorianCalendar(1161, 6, 1161, 1161, 1161, 6);
      // Undeclared exception!
      try { 
        timeTable0.getApptRange((LinkedList<Appt>) null, mockGregorianCalendar0, mockGregorianCalendar0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Second date specified is not before the first date specified.
         //
         assertThrownBy("edu.osu.cs362.TimeTable", e);
      }
  }
}
