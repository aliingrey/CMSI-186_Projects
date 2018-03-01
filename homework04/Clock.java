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

   double hourAngle = 0;
   double minuteAngle = 0;
   double angleBetween = 0;

  /*
   private double hourAngle = getHourHandAngle();
   private double minuteAngle = getMinuteHandAngle();
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


    degrees = nDegrees; //target angle
    this.timeSlice = timeSlice; //timeSlice = args[0];
    /*
    this.totalSeconds = totalSeconds;
    this.totalMinutes = totalMinutes;
    this.totalHours = totalHours;  
    */
   }
  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
    totalSeconds += timeSlice;
    System.out.println("TICK");
    System.out.println("total seconds: " + totalSeconds);
    System.out.println("time slice: " + totalSeconds);
    return totalSeconds;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
    System.out.println("\nGET HOUR HAND ANGLE");
/*
    totalHours = Math.floor(totalSeconds/3600); //gives you total hours
    System.out.println("total hours: " + totalHours);
*/
    hourAngle = totalSeconds * HOUR_HAND_DEGREES_PER_SECOND;
    System.out.println("hour angle " + hourAngle);

    return hourAngle;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
    System.out.println("\nGET MINUTE HAND ANGLE");
    /*
    totalMinutes = Math.floor(totalSeconds/60); //not 3600
    System.out.println("total minutes: " + totalMinutes);
    */
    minuteAngle = totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND;
    System.out.println("minute angle: " + minuteAngle);

    return minuteAngle;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
    angleBetween = getHourHandAngle() - getMinuteHandAngle(); //ABSOLLUTE VALUE

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
   public String toString() {
    //convert to hours, minutes, and seconds
    
    //totalHours = totalSeconds/3600; //1 hour = seconds/3600
    //degrees = totalHours * 30; //30 degrees per hour, 
    
    //seconds/3600 = hours
    //mod of seconds/3600 = minutes
    String timeString = (int)totalHours + ":" + (int)totalMinutes + ":" + (int)totalSeconds;
    return timeString; //hh:mm:ss.sss
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {
      Clock clock = new Clock(100, 100);
      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
    // System.out.println( "  I deleted the validateAngleArg method because I check for the angle in the clock constructor" );
      System.out.println( "  Creating a new clock: " );

      clock.tick();
      clock.tick();
      clock.tick();
      clock.tick();
      //System.out.println("Hour hand angle: " + clock.getHourHandAngle() );
      clock.getHourHandAngle();
      //System.out.println("Minute hand angle: " + clock.getMinuteHandAngle() );
      clock.getMinuteHandAngle();
      System.out.println("Angle between: " + clock.getHandAngle() );
      //System.out.println("Total seconds: " + clock.getTotalSeconds() );
      //System.out.println("String format: " + clock.toString() );
      //System.out.print( "      sending X degrees, expecting double value: Y " );
   }
}
