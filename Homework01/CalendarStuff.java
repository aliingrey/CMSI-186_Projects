/**
 *  File name     :  CalendarStuff.java
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
 */
public class CalendarStuff extends CalendarStuffTester {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   * these are constants
   */
  private static final int SUNDAY    = 0;
  private static final int MONDAY    = SUNDAY    + 1;
  private static final int TUESDAY   = MONDAY    + 1;
  private static final int WEDNESDAY = TUESDAY    + 1;
  private static final int THURSDAY  = WEDNESDAY    + 1;
  private static final int FRIDAY    = THURSDAY    + 1;
  private static final int SATURDAY  = FRIDAY    + 1;
  
  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   */
  private static final int JANUARY    = 0;
  private static final int FEBRUARY   = JANUARY + 1;
  private static final int MARCH      = FEBRUARY + 1;
  private static final int APRIL      = MARCH + 1;
  private static final int MAY        = APRIL + 1;
  private static final int JUNE       = MAY + 1;
  private static final int JULY       = JUNE + 1;
  private static final int AUGUST     = JULY + 1;
  private static final int SEPTEMBER  = AUGUST + 1;
  private static final int OCTOBER    = SEPTEMBER + 1;
  private static final int NOVEMBER   = OCTOBER + 1;
  private static final int DECEMBER   = NOVEMBER + 1;
  
  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   */
  //days (in month(s)). has all the numbers of days in the month
  //not final because the 28 becomes 29 on leap year; we change the feb value 
  private static int[]   days    = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private static int[]   leapdays    = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

   //i can't say days[month] if month is a long, i have to say days[(int)month]
    //saying month is long, but treat it as a integer and use it in the array
  /**
   * The constructor for the class
   */
  public CalendarStuff() {
    System.out.println( "Calculting leap year" );
  }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return   boolean which is true if the parameter is a leap year
   */
  public static boolean isLeapYear( long year ) {
    if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0) || (year % 4 == 0) && (year % 400 != 0)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
  public static long daysInMonth( long month, long year ) {
    if (isLeapYear(year)) {
      return leapdays[(int)month - 1];
    } else {
      return days[(int)month - 1];
    }
  }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
  public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
    return (year1 == year2 && month1 == month2 && day1 == day2);
  }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return   !!!!! int    -1/0/+1 if first date is less than/equal to/greater than second
   */
  public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
    if (CalendarStuff.dateEquals(month1, day1, year1, month2, day2, year2) == true) {
      return 0;
    } else {

      if (year1 > year2) {
        return 1;
      } else if (year1 < year2) {
        return -1;//year2 is later 

      }  else {
        if (month1 > month2) {
          return 1; //month1 is later
        } else if (month1 < month2) {
          return -1; //month2 is later
        } else if (day1 > day2) {
          return 1; //day 1 is later
        } else if (day1 < day2) {
          return -1; //day2 is later
        }
      } 
    }
   return 2; //means method failed
 }
  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( long month, long day, long year ) { //checks for 33rd day of sept
    if ((month > 0) && (month <= 12)) {
      if ((day > 0) && (day <= daysInMonth((month), year))) {
                    //keep going
                    //check if it's a leap year
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

  

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( long month ) { //if I pass in a 1, give me the string "January"

   switch((int)month - 1 ) {
    case JANUARY: return "January";
    case FEBRUARY:  return "February";
    case MARCH:  return  "March";
    case APRIL:  return  "April";
    case MAY:  return  "May";
    case JUNE:  return  "June";
    case JULY:  return  "July";
    case AUGUST:  return  "August";
    case SEPTEMBER:  return  "September";
    case OCTOBER: return  "October";
    case NOVEMBER: return  "November";
    case DECEMBER: return  "December";

    default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
  }

}

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
  public static String toDayOfWeekString( int day ) {
    switch( day - 1 ) {
      case MONDAY: return "Monday";
      case TUESDAY: return "Tuesday";
      case WEDNESDAY: return "Wednesday";
      case THURSDAY: return "Thursday";
      case FRIDAY: return "Friday";
      case SATURDAY: return "Saturday";
      case SUNDAY: return "Sunday";
      default : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
    }
  }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
  public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2) {
      long dayCount = 0; //used in CountTheDays program
      int numLeaps = 0; //calculate number of leap years
      int highYear = 0;
      int highMonth = 0;
      int highDay = 0;
      int lowYear = 0;
      int lowMonth = 0;
      int lowDay = 0;

      if (compareDate(year1, month1, day1, year2, month2, day2) == -1) { //year 1 is later
        highYear = (int)year1;
        highMonth = (int)month1;
        highDay = (int)day1;
        lowYear = (int)year2;
        lowMonth = (int)month2;
        lowDay = (int)day2;

      } else if (compareDate(year1, month1, day1, year2, month2, day2) == 1) { //year 2 is later
        highYear = (int)year2;
        highMonth = (int)month2;
        highDay = (int)day2;
        lowYear = (int)year1;
        lowMonth = (int)month1;
        lowDay = (int)day1;
       
      } else {
        dayCount = 0;
      }

      long differenceyear = (highYear - lowYear);
  
      for (int i = 0; i < highMonth-1; i++) {
        if (isLeapYear(highYear)) {
          dayCount += leapdays[i];
        } else {
          dayCount += days[i];
        }
      }
      for (int i = 0; i < lowMonth-1; i++) {
        if (isLeapYear(lowYear)) {
          dayCount -= leapdays[i];
        } else {
          dayCount -= days[i];
        }
      }
      
      
      for (int i = lowYear; i < highYear; i++) {
        if (isLeapYear(i)) {
          numLeaps++;
        }
      }
      
      dayCount += (differenceyear*365) + numLeaps;
      
      //if idate is after feb 28, (high year), then you do add one more
      dayCount = dayCount + highDay - lowDay;
      dayCount = Math.abs(dayCount); 
    return dayCount;
  }
}
