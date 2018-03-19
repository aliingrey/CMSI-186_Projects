/*

get timer to work (timeSlice)!!

*/

public class Ball {

	private double RADIUS = 4.45;
	private double WEIGHT = 1;
	private double friction = 0;
	private double v0;
	private double ballVelocity;

	private double xPosition;
	private double yPosition;
	private double xSpeed;
	private double ySpeed;
	//at time 0, they're all put into motion at random speeds

	//constructor
	public Ball(double xPosition, double yPosition, double xSpeed, double ySpeed) {
		this.xPosition = xPosition; //m/s across
		this.yPosition = yPosition; //m/s up/down
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public double getVelocity() {
		v0 = (Math.pow(xSpeed,2)) + (Math.pow(ySpeed,2));
		v0 = Math.sqrt(v0);
		return v0;
		//pthagrem theorem/totalSeconds
	}

	/*
	Friction acts to slow each ball down until it comes to rest. 
	Simulate friction that continuously decreases each ball's speed 
	@ the rate of one per cent per second until it is traveling less than one inch per second
	at which point it comes to rest.
	*/
	public double frictionFromMovement() {
		ballVelocity = v0 - ( (v0 * 0.001) * timeSlice); //import Timer.java
		return ballVelocity;
	}
	//could do a field class (Field.java)

	/*
	data about each ball will be given to your program via four consecutive args
	namely the x- and y-coordinates of the ball's starting position [measured in feet]
	followed by its speeds in the x- and y-directions [in feet per second].
	*/
	public double ballPosition() {
		//increase x1 by x1 every timeSlice
		xPosition = xPosition + xSpeed*timeSlice;
   		yPosition = yPosition + ySpeed*timeSlice;
	}

	public String toString() {
		//position
		//velocity, if 0 - report @ rest
	}
	
	public static void main( String args[] ) {
		Timer timer = new Timer();
		Ball ball = new Ball(100, 100, 5, 10);


		//System.out.println("Your ball starts with a velocity of: " + (int)v0  + "meters per second");
		
	}

}
