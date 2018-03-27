/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Ali Ingrey
 *  Date written  :  3018-03-27
 *  Description   :  clock made for hw 04, corrected and updated for hw 05
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
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834; 
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

   private static double degrees = 0;
   private static double timeSlice = 0; 
   private double totalSeconds; 
   private double totalMinutes = 0;
   private double totalHours = 0;

   double hourAngle = 0;
   double minuteAngle = 0;
   double angleBetween = 0;

   double hours;
   double minutes;
   double seconds;

  public Clock (double nDegrees) {
    timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
    totalSeconds = 0;
   }

   public Clock(double nDegrees, double timeSlice) {

      totalSeconds = 0;
      degrees = nDegrees;
      this.timeSlice = timeSlice;
      seconds = 0;
      minutes = 0;
      hours = 0;
      minuteAngle = 0;
      hourAngle = 0;
   }

   public double tick() {
    totalSeconds += timeSlice;

    hours = Math.floor((int)totalSeconds/3600);
    minutes = Math.floor( ( totalSeconds - ( 3600 * hours ) ) / 60 ); 
    seconds = (totalSeconds - (hours * 3600) - (minutes * 60)) % 60;

    return totalSeconds;

   }
   public double validateAngleArg( String argValue ) throws NumberFormatException {
      double returnAngle = 0.0;

      try { 
        returnAngle = Double.parseDouble( argValue ); 
      }
      catch (NumberFormatException  nfe ) { 
        throw new NumberFormatException(" could not convert"); 
      }

      if ( returnAngle < 0 || returnAngle > 360 ) {
        throw new NumberFormatException();
      }
      return returnAngle;
   }

   public double validateTimeSliceArg( String argValue ) {
      double returnTime = 0.0;
      try { 
        returnTime = Double.parseDouble( argValue ); 
      }
      catch (NumberFormatException  nfe ) { 
        throw new NumberFormatException(" could not convert"); 
      }

      if ( returnTime <= 0 || returnTime > 1800.0 ) {
        throw new IllegalArgumentException( "time args out of range" );
      }

      return timeSlice;
   }

   public double getHourHandAngle() {
    hourAngle = totalSeconds * HOUR_HAND_DEGREES_PER_SECOND;
    return hourAngle;

   }

   public double getMinuteHandAngle() {
    minuteAngle = Math.floor( totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND ) % 360.0; //5
    return minuteAngle;

   }


   public double getHandAngle() {

    double angleBetween = Math.abs( getHourHandAngle() - getMinuteHandAngle() );
    
    if (angleBetween > 180) {
      angleBetween = MAXIMUM_DEGREE_VALUE - angleBetween;
    }  
    return angleBetween;
   }

   public double getTotalSeconds() { //tells you how far along you are in your simulation
    return totalSeconds;
   }
  
   public double getDegree() {
    return degrees;
   }

   public String toString() { 
    String hmString = "00";
    String secondString = "00.0";
    DecimalFormat hmStringFormat = new DecimalFormat(hmString);
    DecimalFormat secondStringFormat = new DecimalFormat(secondString);

    String timeString = hmStringFormat.format(hours) + ":" + hmStringFormat.format(minutes) + ":" + secondStringFormat.format(seconds);
    return timeString;
   }

   public static void main( String args[] ) {
      if (args.length == 0) {
        timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
      } else {
        double degrees = Double.parseDouble(args[0]);
      }

      if (args.length == 2) {
        double timeSlice = Double.parseDouble(args[1]);
      }

      Clock clock = new Clock(degrees, timeSlice);

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  I deleted the validateAngleArg method because I check for the angle in the clock constructor" );
      System.out.println( "\n  Creating a new clock: " );
      clock.tick();
      System.out.println("angle between: " + clock.getHandAngle() );
      System.out.println("total seconds elapsed: " + clock.getTotalSeconds() );
      System.out.println( clock.toString() );
    }
} 
