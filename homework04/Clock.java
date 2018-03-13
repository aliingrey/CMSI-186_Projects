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
import java.text.DecimalFormat;

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
   private double totalSeconds; //total seconds that have elapsed since you've added a timeSlice
   private double totalMinutes = 0;
   private double totalHours = 0;
   private String timePrint; 

   double hourAngle = 0;
   double minuteAngle = 0;
   double angleBetween = 0;

   double hours;
   double minutes;
   double seconds;

  /**
   *  Constructor goes here
   */
   public Clock(double nDegrees, double timeSlice) {
    degrees = nDegrees; //target angle
    this.timeSlice = timeSlice; //timeSlice = args[0];
    hours = 00;
    minutes = 00;
    seconds = 00;
    totalSeconds = 0;  
    //
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
    hourAngle = (totalSeconds * HOUR_HAND_DEGREES_PER_SECOND) % 360;
    /*
    if (hourAngle >= 180) {
      hourAngle = hourAngle - 360; 
    }
    */
    return hourAngle;

   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
    minuteAngle = (totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND) % 360;
    /*
    while (minuteAngle >= 360) {
      minuteAngle = minuteAngle - 360;
    }
    */
    return minuteAngle;
    

   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
    angleBetween = Math.abs( getHourHandAngle() - getMinuteHandAngle() );
    if (minuteAngle - hourAngle > 180) {
      angleBetween = 360 - angleBetween;
    }
    return angleBetween;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() { //tells you how far along you are in your simulation
    return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */

   public double getDegree() {
    return degrees;
   }

   public String toString() { //convert to hours, minutes, and seconds
    String hmString = "00";
    String secondString = "00.0";
    DecimalFormat hmStringFormat = new DecimalFormat(hmString);
    DecimalFormat secondStringFormat = new DecimalFormat(secondString);

    hours = Math.floor((int)totalSeconds/3600);

    minutes = Math.floor( ( totalSeconds - (hours * 3600) ) / 60 );
 
    seconds = (totalSeconds - (hours * 3600) - (minutes * 60)) % 60 ;
    String timeString = hmStringFormat.format(hours) + ":" + hmStringFormat.format(minutes) + ":" + secondStringFormat.format(seconds);
    return timeString; 

   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {
      Clock clock = new Clock(90, 30);
      /*
      for (int i = 0; i < 5; i++ ) {
          clock.tick();
      }
    */
      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
    // System.out.println( "  I deleted the validateAngleArg method because I check for the angle in the clock constructor" );
      System.out.println( "\n  Creating a new clock: " );
      clock.tick();
      System.out.println("Hour hand angle: " + clock.getHourHandAngle() );
      System.out.println("Minute hand angle: " + clock.getMinuteHandAngle() );
      System.out.println("angle between: " + clock.getHandAngle() );
      System.out.println("total seconds elapsed: " + clock.getTotalSeconds() );
      System.out.println( clock.toString() );
   }
}
