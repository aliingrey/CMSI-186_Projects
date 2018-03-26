//do any of the balls bump into each other and or hit the pole
//simulated time of the first collision --> output collision
public class SoccerSim{
	//private Ball ball = null;
	private static Ball[] ballArray = null;
	private static int ballCount = 0;
	private Timer stopWatch = null;
	private static int j = 0;

	private static final double POLE = 15;
	//field
	private static final double CENTERFIELD_X = 0;
	private static final double CENTERFIELD_Y = 0;
	private static final double OUTOFBOUNDS_X = 45;
	private static final double OUTOFBOUNDS_Y = 60;
	
	double DEFAULT_TIMESLICE = 1;

	public SoccerSim(){

		//
		/*
 		for (int i = 0; i < c; i ++) {
        	ds[i] = new Die(s);
      	
      	in main:
      	DiceSet ds = new DiceSet(4, 6);
      	
      }
	*/
	}
	public boolean checkCollision(double x2, double y2){
    if ((Math.abs(x-x2) <= RADIUS) && (Math.abs(y-y2) <= RADIUS)) {
      return true;
    } else {
      return false; 
    }
    /*
    public void positonBall(double timeSlice){
    	x = x + speedX*timeSlice;
    	y = y + speedY*timeSlice;
   }
*/
	/*
	if (Ball.length > 1) {

	}

   public boolean checkCollision(double x2, double y2){
    if ((Math.abs(x-x2) <= RADIUS) && (Math.abs(y-y2) <= RADIUS)) {
      return true;
    } else {
      return false; 
    }
   }
   */
	//args: x1, y1, xv1, x2, y2, xv2 (new ball) x1, y1 ...
	
	//creating multiple balls
	//collision cheeck
	public static void main( String args[] ) {
	  //SoccerSim ballArray = new SoccerSim();
	  System.out.println( "\n   Starting the SoccerSim game!\n\n" );
	  
	  Timer a = new Timer(60);
	  Ball b1 = new Ball(0, 0, 0, 0);
	  Ball pole = new Ball(0, 0, 0, 0);
	  

	  if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      } 
      
	  if ((args.length % 4) == 0) {
	  	ballCount = args.length/4;
	  	timer = new Timer( DEFAULT_TIMESLICE );
	  	System.out.println("you've created " + args.length/4 + " balls");
	  }

	  if ((args.length % 4) == 1) {
	  	double timeSlice = Double.parseDouble(args[4]);
	  	if ( (args.length - 1) % 4 == 0) {
			ballCount = args.length/4;
	  	}
	  }

	  pole = new Ball( (double)Math.floor( 10 , 10 , 0 , 0);

	  //ballArray = new Ball[ballCount];
	  


	/*
	  for (int j = 0; j < args.length; j+=4) {
	  	balls[j] = new Ball(xPosition, yPosition, xSpeed, ySpeed);
	  }
	  */

	  for (int i = 0; i < args.length; i+=4) { //loop through all the arguments
		double xPosition = Double.parseDouble(args[i + 0]);
		System.out.println("x posiiton: " + xPosition);
	  	double yPosition = Double.parseDouble(args[i + 1]);
	  	double xSpeed = Double.parseDouble(args[i + 2]);
	  	double ySpeed = Double.parseDouble(args[i + 3]);
		//Ball ball = new Ball(xPosition, yPosition, xSpeed, ySpeed);

		j++; 
		ballArray[j] = new Ball(xPosition, yPosition, xSpeed, ySpeed);
		//balls[j] = new Ball(Double.parseDouble(args[i + 0]), Double.parseDouble(args[i + 1]), Double.parseDouble(args[i + 2]), Double.parseDouble(args[i + 3]));//j keeps count of how many balls there are
		//Ball ball = new Ball [j];
		//System.out.println(j);
	  }
	  System.out.println("balll array: " + ballArray);
	  
	}
}
