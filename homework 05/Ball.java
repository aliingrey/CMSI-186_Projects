/*

get timer to work (timeSlice)!!

*/

public class Ball {

	private double RADIUS = 4.45;
	private double WEIGHT = 1;
	private double friction = 0;
	private double ballVelocity;

	private double xPosition;
	private double yPosition;
	private double xSpeed;
	private double ySpeed;
	private String ballString;
	//at time 0, they're all put into motion at random speeds

	//constructor
	public Ball(double xPosition, double yPosition, double xSpeed, double ySpeed) {
		this.xPosition = xPosition; //m/s across
		this.yPosition = yPosition; //m/s up/down
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public double getVelocity() {
		ballVelocity = (Math.pow(xSpeed,2)) + (Math.pow(ySpeed,2));
		ballVelocity = Math.sqrt(ballVelocity);
		//System.out.println("Initial velocity: " + ballVelocity);
		return ballVelocity;
		//pthagrem theorem/totalSeconds
	}

	/*
	Friction acts to slow each ball down until it comes to rest. 
	Simulate friction that continuously decreases each ball's speed 
	@ the rate of one per cent per second until it is traveling less than one inch per second
	at which point it comes to rest.
	*/

	public double xFriction() { //what happens when velocity are neg numbers
		xSpeed -= xSpeed * 0.01;
		//System.out.println("Velocity with friction is at x is: " + xSpeed);
		return xSpeed;
	}
	public double yFriction() { //what happens when velocity are neg numbers
		ySpeed -= ySpeed * 0.01;
		//System.out.println("Velocity with friction is at y is: " + ySpeed);
		return ySpeed;
	}
	//could do a field class (Field.java)

	/*
	data about each ball will be given to your program via four consecutive args
	namely the x- and y-coordinates of the ball's starting position [measured in feet]
	followed by its speeds in the x- and y-directions [in feet per second].
	*/
	public double UpdateXPosition() {
		xPosition += xSpeed;
   		//System.out.println("new x position: " + xPosition);
   		return xPosition;

	}

	public double UpdateYPosition() {
		yPosition += ySpeed;
		//System.out.println("new y position: " + yPosition);
		return yPosition;
	}

	public String toString() {
		//current x and y position
		//current x and y velocity values
		//total movement
		if (xSpeed == 0 && ySpeed == 0) {
			ballString = "Ball (NAME?): position " + UpdateXPosition() + ", " + UpdateYPosition() + "<at rest>";
		} else {
			ballString = "Ball (NAME?): position " + UpdateXPosition() + ", " + UpdateYPosition() + " Ball b1: speed " + xFriction() + ", " + yFriction();
		}

		//velocity, if 0 - report @ rest
		System.out.println(ballString);
		return ballString;
	}
	
	public static void main( String args[] ) {
		Ball b1 = new Ball(10, 50, 2, 6);
		b1.toString();
		b1.toString();
		b1.toString();
		System.out.println("b2");
		Ball b2 = new Ball(20, 60, 3, 7);
		b2.toString();
		b2.toString();
		b2.toString();
		b2.toString();
		
		//System.out.println("Your ball starts with a velocity of: " + (int)v0  + "meters per second");
		
	}

}
