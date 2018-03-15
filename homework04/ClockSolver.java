/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  B.J. Johnson
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


public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   static final double EPSILON_VALUE = 0.5;
   private static double nDegrees;
   private static double timeSlice;
   private Clock clock = null;

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
  
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Hello world, from the ClockSolver program!!\n" ) ;

      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      } 

      double nDegrees = Double.parseDouble(args[0]);
      
      if ( (nDegrees > MAXIMUM_DEGREE_VALUE) || (nDegrees < 0.0) ) {
        System.out.println("   Your degree value is out of bounds!\n" +
                          "   Please enter a value between 0.0 and 360 degrees.");
        System.exit((int)INVALID_ARGUMENT_VALUE);
      }

      if (args.length == 2) {
        double timeSlice = Double.parseDouble(args[1]); 

          if (timeSlice <= 0 || timeSlice > 1800.0) {
            System.out.println( "   Your timeSlice value is out of bounds!\n" +
                             "   Please try again with a timeSlice between 0 and 180" );
            System.exit( 1 );
          }   
      } else {
        timeSlice = 60.0;
      }  

   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
    ClockSolver cse = new ClockSolver();
    cse.handleInitialArguments(args);

    double[] timeValues = new double[3];
    
    double nDegrees = Double.parseDouble(args[0]);
    
    if (args.length == 2) {
      timeSlice = Double.parseDouble(args[1]);
    } else {
      timeSlice = 60.0;
    }


    Clock clock = new Clock (nDegrees, timeSlice); //(cse.angle, cse.timeSlice)
    System.out.println("searching for a " + clock.getDegree() + " angle");
    while (clock.getTotalSeconds() <= 43200) {
          
        if (Math.abs(clock.getHandAngle() - clock.getDegree()) <= EPSILON_VALUE) { //!!
          System.out.println(clock.toString());
        }
        clock.tick();
     } 
    System.exit( 0 );
   }
}
