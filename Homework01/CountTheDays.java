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
        lowMonth = (int)month2;
        lowDay = (int)day2;



      } else {
        dayCount = 0;
      }

      for (int i = lowYear; i <= highYear; i++) {
        if (isLeapYear(i) == true) {
            numLeaps++;
        }
      }

      int differenceyear = (Math.abs(highYear - lowYear));
      dayCount += (differenceyear*365) + numLeaps;


    if (highYear > lowYear) {
    //12-30-2005 and 01-02-2006 (3 days later)
      //push dec 30 forward a year + 365// - (days and months)
      if (lowMonth > highMonth) {
        if (isLeapYear(highYear) == false) {
          for (int i = lowMonth; i < highMonth; i++) {
            dayCount -= days[i];
          }
        }
         dayCount += (lowDay + 365) - highDay;

      } else if (highMonth == lowMonth && lowDay == highDay) { 
        dayCount += 0; //already added leap days and number of years

      } else if (highMonth == lowMonth && highDay < lowDay) {
        //08-15-2001 and 08-14-2002 (364 days later)
        dayCount += lowDay + (differenceyear)*365 - highDay;

      } else if (highMonth > lowMonth && lowDay > highDay) {
        //03-15-2006 and 08-05-2007 (month bigger, day smaller) 
        //03-15-2005 and 08-05-2008 (month bigger, day smaller * includes a leap year)
        dayCount += lowDay + (differenceyear)*365 - numLeaps; 

        //subtract months from 07 to 04
        for (int i = lowMonth; i < highMonth; i++) {
          if (isLeapYear(i) == true) {
            dayCount -= leapdays[i];
          } else {
            dayCount -= days[i];
          }
        }
        dayCount += ((highYear - lowYear)*365 - numLeaps); //left off hHERE
      } else if (lowMonth > highMonth && lowDay < highDay) {
      //11-15-2005 and 10-10-2008 (month smaller, day smaller)
      //11-15-2001 and 07-10-2025 (month smaller, day smaller * with leap year)
        for (int i = lowMonth; i < highMonth; i++) {
          dayCount -= days[i];
        }
        dayCount += (differenceyear*365 + numLeaps) - (Math.abs(lowDay - highDay));
      }

    } else if (lowYear > highYear) {

    } else { //if the years are equal

      for (int i = lowYear; i <= highYear; i++) {
        if (isLeapYear(i) == true) {
            numLeaps++;
        }
      }

      dayCount += (differenceyear*365) + numLeaps;

      
      for (int i = lowMonth; i < highMonth; i++) {
        dayCount += days[i - 1];
      }
      if (highMonth > lowMonth) {
        //04/05/2002 and 02/05/2002
        if (highDay > lowDay) {
          dayCount = highDay - lowDay;
        } else if (highDay < lowDay) { //05/10/2001 and 07/02/2001
          dayCount = lowDay + ( days[lowMonth] + days[lowMonth + 1] - (highDay);

        } else { //days are equal
        }
      } else if (highMonth < lowMonth) {


      } else { //months are equal 03/05/2018 and 03/10/2018
        if (highDay > lowDay) {
          dayCount += Math.abs(highDay - lowDay);
        } else if (highDay < lowDay) {
          //03-16-2005 and 03-15-2005 (month same, day smaller)
          dayCount += Math.abs(lowDay - highDay);            
        } else {
          dayCount = 0;
        }
      } 
     }
     return dayCount;
    }
