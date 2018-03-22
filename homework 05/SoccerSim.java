//do any of the balls bump into each other and or hit the pole
//simulated time of the first collision --> output collision
public class SoccerSim{
	private Ball ball = null;
	private Ball[] balls = null;
	private static double ballCount;
	private Timer stopWatch = null;
	private double j = 0;

	private static final double POLE = 15;
	//field
	private static final double CENTERFIELD_X = 0;
	private static final double CENTERFIELD_Y = 0;
	private static final double OUTOFBOUNDS_X = 45;
	private static final double OUTOFBOUNDS_Y = 60;
	


	public SoccerSim(){

	}

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
	  System.out.println( "\n   Starting the SoccerSim game!\n\n" );
	  Timer a = new Timer(60);

	  if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      } 
      
	  if ((args.length % 4) == 0) {
	  	ballCount = args.length/4;
	  }
	  if ((args.length % 4) == 1) {
	  	double timeSlice = Double.parseDouble(args[4]);
	  	if ( (args.length - 1) % 4 == 0) {
			ballCount = args.length/4;
	  	}
	  }
	
	  for (int i = 0; i < args.length; i+=4) { //loop througha ll the arguments
		/*
		j++;
		Ball = new Ball();
		*/
		double xPosition = Double.parseDouble(args[i + 0]);
	  	double yPosition = Double.parseDouble(args[i + 1]);
	  	double xSpeed = Double.parseDouble(args[i + 2]);
	  	double ySpeed = Double.parseDouble(args[i + 3]);
	  }
	  
	}
}
