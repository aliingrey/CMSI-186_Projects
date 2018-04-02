public class SoccerSim {
  private final double RADIUS = 4.45;
  private final double RADIUS_IN_FEET = 4.45/12;
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

  public SoccerSim() {
    soccerClock = new Clock(90, 60);
  }

  private boolean poleCollision() {
    for (int i = 0; i < ballArray.length - 1; i++) {
      if ( (ballArray[i].UpdateXPosition() - X_POLE <= RADIUS ) && ( ballArray[i].UpdateYPosition() - Y_POLE <= RADIUS ) ) {
        System.out.println("the ball hit the pole!");
        return true;
      }
    }
    return false;
  }
  private boolean ballCollision() {
    
     for (int i = 0; i < ballArray.length - 1; i++) {
      for (int j = i + 1; j < ballArray.length; j++) {
        double distance = Math.sqrt(Math.pow(ballArray[i].UpdateXPosition() 
          - ballArray[j].UpdateXPosition(), 2) 
        + Math.pow(ballArray[i].UpdateYPosition() 
          - ballArray[j].UpdateYPosition(), 2) );  

          if (distance <= RADIUS_IN_FEET*2) {
           System.out.println("the balls collided at " + ballArray[i].UpdateXPosition() + " and " + ballArray[i].UpdateYPosition());
           return true;
          }   
       }

      }  
     
     System.out.println("the balls do not collide");
     return false;
   }


   private boolean inBounds() {
    for (int i = 0; i < ballArray.length; i++) {
      System.out.println(ballArray[i].UpdateXPosition());
      System.out.println(ballArray[i].UpdateYPosition());
      if ( ( ballArray[i].UpdateXPosition() > FIELD_WIDTH) || (ballArray[i].UpdateXPosition() < 0) ) {
        System.out.println("ball is out of bounds from the x direction");
        return false;
      } if ( (ballArray[i].UpdateYPosition() > FIELD_HEIGHT) || (ballArray[i].UpdateYPosition() < 0) ) {
        System.out.println("ball is out of bounds from the y direction");
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

    if( (args.length % 4) == 2 || (args.length % 4) == 3 ) {
         System.out.println( "   Sorry you must enter a proper number of arguments\n" +
                             "   Please try again..........." );
         System.exit( 1 );
    }



    if ((args.length % 4) == 1) {
      try {
        soccerClock.timeSlice = Double.parseDouble(args[args.length - 1]);
        if ( (args.length - 1) % 4 == 0) {
          ballCount = (int)args.length/4;
          ballArray = new Ball[ballCount];
          System.out.println("you've created " + ballCount + " balls with a timeSlice argument.");

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

        int i = 0;
        for (int j = 0; j < ballArray.length; j++)  {
            ballArray[j] = new Ball( Double.parseDouble(args[(i + 0)]), Double.parseDouble(args[(i + 1)]), Double.parseDouble(args[(i + 2)]), Double.parseDouble(args[(i + 3)]) );
            i += 4;
        }
        
        for (Ball b : ballArray) {
                System.out.println(b.toString());
        }
        

        System.out.println("you've created " + args.length/4 + " balls");
      } catch (NumberFormatException cantConvert) { 
        System.out.println("make sure you put in numbers for xPosition, yPosition, xSpeed, ySpeed, and an optional timeSlice");
      }
      
    }
    
  }


  public void UpdateBalls() {
    for (int i = 0; i < ballArray.length; i++) {
      ballArray[i].moveWithTime();
    }
    System.out.println("-- update --");
  }

  public static void main(String[] args) {
    System.out.println("\n  Hello, world, from the SoccerSim program!");
    SoccerSim newSoccerSim = new SoccerSim();

    newSoccerSim.setUp(args);
    newSoccerSim.poleCollision();
    newSoccerSim.ballCollision();
    newSoccerSim.UpdateBalls();
    System.out.println(newSoccerSim.inBounds());

    }
  }

