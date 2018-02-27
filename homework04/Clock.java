/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Ali Ingrey
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

   private double degrees;
   private double timeSlice; //in seconds
   private double totalSeconds = 0; //total seconds that have elapsed since you've added a timeSlice
   private double totalMinutes = 0;
   private double totalHours = 0;
   private String timePrint; 

   double hourAngle;
   double minuteAngle;
   double angleBetween;

   /*
   hourAngle = getHourHandAngle();
   minuteAngle = getMinuteHandAngle();
   */
   

  /**
   *  Constructor goes here
   */
   public Clock(double nDegrees, double timeSlice) {
    if ( (degrees > MAXIMUM_DEGREE_VALUE) || (degrees < 0.0) ) {
      System.exit((int)INVALID_ARGUMENT_VALUE);
    }

    if (timeSlice <= 0 || timeSlice > 1800.0) {
      timeSlice = 60.0;
    }


    degrees = nDegrees;
    this.timeSlice = timeSlice; //timeSlice = args[0];
    this.totalSeconds = totalSeconds;
    this.totalMinutes = totalMinutes;
    this.totalHours = totalHours;  
   }
  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
    totalSeconds += timeSlice;
    return totalSeconds;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
    totalHours = totalSeconds/3600; //1 hour = seconds/3600
    degrees = totalHours * 30; //30 degrees per hour, 
    return degrees;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
    totalMinutes = totalSeconds % 3600;
    degrees = totalMinutes * .5; //.5 degrees per minute
    return degrees;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
    angleBetween = getHourHandAngle() - getMinuteHandAngle();
    return angleBetween;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
    //convert to hours, minutes, and seconds
    //seconds/3600 = hours
    //mod of seconds/3600 = minutes

      timePrint = totalHours + ":" + totalMinutes + ":" + totalSeconds;
      return "toString"; //hh:mm:ss.sss
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  I deleted the validateAngleArg method because I check for the angle in the clock constructor" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock(10, 50);
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println("totalSeconds: " + tick() );
      System.out.println("hour hand angle: " + getHourHandAngle() );
      System.out.println("minute hand angle: " + getMinuteHandAngle() ) ;
      System.out.println("hand angle: " + getHandAngle() );
      //System.out.print( "      sending X degrees, expecting double value: Y " );
   }
}