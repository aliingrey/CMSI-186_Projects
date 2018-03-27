public class SoccerSim {
  private final double RADIUS = 4.45;
  private final double WEIGHT = 1;
  
  private static final double DEFAULT_TIME_SLICE = 30;

  private static final double FIELD_WIDTH = 1000.0;
  private static final double FIELD_HEIGHT = 1000.0;

  private static final double X_POLE = 10;
  private static final double Y_POLE = 10;

  private double timeSlice = 1.0;
  private int ballCount = 0;
  
  private Ball[] ballArray = null;
  private Clock soccerClock = null;

  public SoccerSim() {
    soccerClock = new Clock(90, 60);
  }
  
  public boolean findCollision() {
    for (int i = 0; i < ballArray.length - 1; i++) {
      if ( ( Math.abs(ballArray[i].UpdateXPosition()) - X_POLE <= RADIUS ) && ( Math.abs(ballArray[i].UpdateYPosition()) - Y_POLE <= RADIUS ) ) {
        System.out.println("the ball hit the pole!");
        return true;
      }
      for (int j = i + 1; j < ballArray.length; j++) {
        if ( (Math.abs(ballArray[i].UpdateXPosition() - ballArray[j].UpdateXPosition()) <= RADIUS) && (Math.abs(ballArray[i].UpdateYPosition() - ballArray[j].UpdateYPosition() <= RADIUS))) {
          System.out.println("the ball hit another ball!");
          return true;
        }
       }
     }
   }
   public boolean outOfBounds() {
    for (int i = 0; i < ballArray.length - 1; i++) {
      if ( ballArray[i].UpdateXPosition() > FIELD_HEIGHT) || (ballArray[i].UpdateXPosition()< -FIELD_HEIGHT) ) {
        System.out.println("ob from the y direction");
        return true;
      } else if ( (ballArray[i].UpdateYPosition() > FIELD_WIDTH) || (ballArray[i].UpdateYPosition() < -FIELD_WIDTH) ) {
        System.out.println("ob from the x direction");
        return true;
      } else {
        return false;
      }
    }
   }
  public static void main(String[] args[]) {
    System.out.println("\n  Hello, world, from the SoccerSim program!");
    SoccerSim localSoccerSim = new SoccerSim();

    if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Please try again..........." );
         System.exit( 1 );
    } 
    if ((args.length % 4) == 1) {
      double timeSlice = Double.parseDouble(args[4]);
      if ( (args.length - 1) % 4 == 0) {
        ballCount = args.length/4;
        System.out.println("you've created " + ballCount + " balls");
      }
    }
    
    if ((args.length % 4) == 0) {
      ballCount = args.length/4;
      timer = new Timer( DEFAULT_TIMESLICE );
      System.out.println("you've created " + args.length/4 + " balls");
    }

   

    ballArray = new Ball[ballCount];

    int j = 0;
    
    for (int i = 0; i < ballArray.length; i++)  {
        ballArray[i] = new Ball(Double.parseDouble(args[(j + 0)]), Double.parseDouble(args[(j + 1)]), Double.parseDouble(args[(j + 2)]), Double.parseDouble(args[(j + 3)]));
        j += 4;
    }

    for (int i = 0; i < ballArray.length; i++) {
      ballArray[i].moveBall(timeSlice);
    }


   
     }
  }
