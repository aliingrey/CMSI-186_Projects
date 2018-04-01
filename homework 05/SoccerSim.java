public class SoccerSim {
  private final double RADIUS = 4.45;
  private final double WEIGHT = 1;
  
  private static final double DEFAULT_TIME_SLICE = 30;
  private static final double INCHES_PER_FOOT = 12;

  private static final double FIELD_WIDTH = 1000.0;
  private static final double FIELD_HEIGHT = 1000.0;

  private static final double X_POLE = 10;
  private static final double Y_POLE = 10;

  private double timeSlice = 1.0;
  private int ballCount = 0;
  
  private Ball[] ballArray = null;
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

     for (int k = 0; k < ballArray.length; k++) {
        ballArray[k].moveWithTime();
     }
   }
   }
   private boolean outOfBounds() {
    for (int i = 0; i < ballArray.length - 1; i++) {
      if ( ( ballArray[i].UpdateXPosition() > FIELD_HEIGHT) || (ballArray[i].UpdateXPosition() < 0) ) {
        System.out.println("ob from the y direction");
        return true;
      } else if ( (ballArray[i].UpdateYPosition() > FIELD_WIDTH) || (ballArray[i].UpdateYPosition() < 0) ) {
        System.out.println("ob from the x direction");
        return true;
      } else {
        return false;
      }
    }
   }

  private int setUp(String[] args[]) throws NumberFormatException {
    if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Please try again..........." );
         System.exit( 1 );
    }

    if ((args.length % 4) == 1) {
      try {
        soccerClock.timeSlice = Double.parseDouble([args.length - 1]);
        if ( (args.length - 1) % 4 == 0) {
          ballCount = (int)args.length/4;
          System.out.println("you've created " + ballCount + " balls");
        }
      } catch (NumberFormatException cantConvert) { 
        System.out.println("make sure you put in numbers for xPosition, yPosition, xSpeed, ySpeed, and an optional timeSlice");

      }
    }

    if ((args.length % 4) == 0) {
      try {
        ballCount = (int)args.length/4;
        soccerClock = new Clock( 90, 1 );
        System.out.println("you've created " + args.length/4 + " balls");
      } catch (NumberFormatException cantConvert) { 
        System.out.println("make sure you put in numbers for xPosition, yPosition, xSpeed, ySpeed, and an optional timeSlice");
      }
      
    }
    return ballCount;
  }


  
  public static void main(String[] args[]) {
    System.out.println("\n  Hello, world, from the SoccerSim program!");
    SoccerSim localSoccerSim = new SoccerSim();

    //ballArray = new Ball[ballCount];

    int j = 0;
    
    for (int i = 0; i < ballArray.length; i++)  {
        xPosition = Double.parseDouble(args[(j + 0)]);
        yPosition = Double.parseDouble(args[(j + 1)]);
        xSpeed = Double.parseDouble(args[(j + 2)]);
        ySpeed = Double.parseDouble(args[(j + 3)]);
        ballArray[i] = new Ball(xPosition, yPosition, xSpeed, ySpeed);
        j += 4;
    }

    for (int i = 0; i < ballArray.length; i++) {
        ballArray[i].moveBall(timeSlice);
    }
   
     }
  }

