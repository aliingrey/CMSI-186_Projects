/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  Ali Ingrey
 *  Date          :  1/25/2018
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-01-25  Ali Ingrey    Submitted for Homework 01 in Spring 2018
 
 public static long CountTheDays( long month1, long day1, long year1, long month2, long day2, long year2) {
      long dayCount = 0; //used in CountTheDays program
      int numLeaps = 0; //calculate number of leap years
      int highYear = 0;
      int highMonth = 0;
      int highDay = 0;
      int lowYear = 0;
      int lowMonth = 0;
      int lowDay = 0;

      if (compareDate(year1, month1, day1, year2, month2, day2) == 1) { //year 1 is later
        highYear = (int)year1;
        highMonth = (int)month1;
        highDay = (int)day1;
        lowYear = (int)year2;
        lowMonth = (int)month2;
        lowDay = (int)day2;

      } else if (compareDate(year1, month1, day1, year2, month2, day2) == -1) { //year 2 is later
        highYear = (int)year2;
        highMonth = (int)month2;
        highDay = (int)day2;
        lowYear = (int)year1;
        lowMonth = (int)month1;
        lowDay = (int)day1;

      } else {
        dayCount = 0;
      }
      
      for (int i = lowYear; i < highYear; i++) {
        if (isLeapYear(i)) {
          numLeaps++;
        }
      }

      long differenceyear = (highYear - lowYear);
      dayCount += (differenceyear*365) + numLeaps;
  
      for (int i = 1; i < highMonth; i++) {
        if (isLeapYear(highYear)) {
          dayCount += leapdays[i];
        } else {
          dayCount += days[i];
        }
      }
      for (int i = 1; i < lowMonth; i++) {
        if (isLeapYear(lowYear)) {
          dayCount -= leapdays[i];
        } else {
          dayCount -= days[i];
        }
      }
      dayCount = dayCount + Math.abs(highDay - lowDay);
      dayCount = Math.abs(dayCount); 
    return dayCount;
  }
