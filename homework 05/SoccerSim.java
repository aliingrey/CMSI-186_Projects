public class SoccerSim {
  private final double RADIUS = 4.45;
  private final double WEIGHT = 1;
  
  private static final double DEFAULT_TIME_SLICE = 1;
  private static final double INCHES_PER_FOOT = 12;

  private static final double FIELD_WIDTH = 1000.0;
  private static final double FIELD_HEIGHT = 1000.0;

  private static final double X_POLE = 10;
  private static final double Y_POLE = 10;


  private double timeSlice = 1.0;
  private int ballCount = 0;
  
  private static Ball[] ballArray = null;
  private Clock soccerClock = null;

  String inputConversionError = "your input can not be converted, please try again";

  public SoccerSim() {
    soccerClock = new Clock(90, 60);
    ballArray = new Ball[ballCount];
  }

  private boolean findCollision() {
    for (int i = 0; i < ballArray.length - 1; i++) {
      if ( (ballArray[i].UpdateXPosition() - X_POLE <= RADIUS ) && ( ballArray[i].UpdateYPosition() - Y_POLE <= RADIUS ) ) {
        System.out.println("the ball hit the pole!");
        return true;
      }
      for (int j = i + 1; j < ballArray.length; j++) {
        double velocityDifferenceX = Math.abs( ballArray[i].UpdateXPosition() - ballArray[i + 1].UpdateXPosition() );
        double velocityDifferenceY = Math.abs( ballArray[i].UpdateYPosition() - ballArray[i + 1].UpdateYPosition() );
        if ( (velocityDifferenceX <= RADIUS) && (velocityDifferenceY <= RADIUS) ) {
          return true;       
       }
     }  
   }
   return false;
   }
   private boolean inBounds() {
    for (int i = 0; i < ballArray.length - 1; i++) {
      if ( ( ballArray[i].UpdateXPosition() > FIELD_HEIGHT) || (ballArray[i].UpdateXPosition() < 0) ) {
        System.out.println("ob from the y direction");
        return false;
      } if ( (ballArray[i].UpdateYPosition() > FIELD_WIDTH) || (ballArray[i].UpdateYPosition() < 0) ) {
        System.out.println("ob from the x direction");
        return false;
      } 
    }
    return true;
   }

  public void setUp(String[] args) throws NumberFormatException {
    
    if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Please try again..........." );
         System.exit( 1 );
    }

    if ((args.length % 4) == 1) {
      try {
        soccerClock.timeSlice = Double.parseDouble(args[args.length - 1]);
        if ( (args.length - 1) % 4 == 0) {
          ballCount = (int)args.length/4;
          ballArray = new Ball[ballCount];
          System.out.println("you've created " + ballCount + " balls");

          int i = 0;
          for (int j = 0; j < ballArray.length - 1; j++)  {
              ballArray[j] = new Ball( Double.parseDouble(args[(i + 0)]), Double.parseDouble(args[(i + 1)]), Double.parseDouble(args[(i + 2)]), Double.parseDouble(args[(i + 3)]) );
              i += 4;
          }
        }
      } catch (NumberFormatException cantConvert) { 
        System.out.println("make sure you put in numbers for xPosition, yPosition, xSpeed, ySpeed, and an optional timeSlice");

      }
    }

    if ((args.length % 4) == 0) {
      try {
        timeSlice = DEFAULT_TIME_SLICE;
        ballCount = (int)args.length/4;
        ballArray = new Ball[ballCount];
        soccerClock = new Clock( 90, 1 );
        int i = 0;
        for (int j = 0; j < ballArray.length; j++)  {
            ballArray[j] = new Ball( Double.parseDouble(args[(i + 0)]), Double.parseDouble(args[(i + 1)]), Double.parseDouble(args[(i + 2)]), Double.parseDouble(args[(i + 3)]) );
            i += 4;
        }

        System.out.println("you've created " + args.length/4 + " balls");
      } catch (NumberFormatException cantConvert) { 
        System.out.println("make sure you put in numbers for xPosition, yPosition, xSpeed, ySpeed, and an optional timeSlice");
      }
      
    }
    
  }


  
  public static void main(String[] args) {
    System.out.println("\n  Hello, world, from the SoccerSim program!");
    SoccerSim localSoccerSim = new SoccerSim();
   // Ball ballWithTimeSlice = new Ball(40, 20, 5, 10, 1);
   //Ball ballWithNoTimeSlice = new Ball(40, 20, 5, 10);

    

    
    for (int k = 0; k < ballArray.length; k++) {
        ballArray[k].moveWithTime();
     }
    
/*
    for (int i = 0; i < ballArray.length; i++) {
        ballArray[i].moveBall();
    }
*/   
    }
  }

