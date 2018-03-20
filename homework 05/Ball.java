/*

get timer to work (timeSlice)!!

*/

public class Ball {

	private double RADIUS = 4.45;
	private double WEIGHT = 1;
	private double friction = 0;
	//private double v0;
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
		System.out.println("Initial velocity: " + ballVelocity);
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
		//absolute value
		xSpeed -= xSpeed * 0.01;
		//ySpeed -= ySpeed * 0.01;
		//ballVelocity -= ballVelocity * 0.001; //import Timer.java
		System.out.println("Velocity with friction is at x is: " + xSpeed);
		//System.out.println("Velocity with friction is at y is: " + ySpeed)
		return xSpeed;
	}
	public double yFriction() { //what happens when velocity are neg numbers
		//absolute value
		//xSpeed -= xSpeed * 0.01;
		ySpeed -= ySpeed * 0.01;
		//ballVelocity -= ballVelocity * 0.001; //import Timer.java
		//System.out.println("Velocity with friction is at x is: " + xSpeed);
		System.out.println("Velocity with friction is at y is: " + ySpeed);
		return ySpeed;
	}
	//could do a field class (Field.java)

	/*
	data about each ball will be given to your program via four consecutive args
	namely the x- and y-coordinates of the ball's starting position [measured in feet]
	followed by its speeds in the x- and y-directions [in feet per second].
	*/
	public double UpdateXPosition() {
		//increase x1 by x1 every timeSlice
		xPosition += xSpeed;
   		System.out.println("new x position: " + xPosition);
   		return xPosition;

	}

	public double UpdateYPosition() {
		yPosition += ySpeed;
		System.out.println("new y position: " + yPosition);
		return yPosition;
	}

	public String toString() {
		ballString = "update this";
		//position
		//velocity, if 0 - report @ rest
		return ballString;
	}
	
	public static void main( String args[] ) {
		Ball ball = new Ball(100, 100, 3, 4);
		System.out.println("Starting ball position is: " + ball.xPosition + ", " + ball.yPosition);
		System.out.println("Starting ball speeds are: " + ball.xSpeed + ", " + ball.ySpeed);
		ball.getVelocity();
		ball.UpdateXPosition();
		ball.UpdateYPosition();
		ball.xFriction();
		ball.yFriction();
		
		ball.UpdateXPosition();
		ball.UpdateYPosition();

		//System.out.println("Your ball starts with a velocity of: " + (int)v0  + "meters per second");
		
	}

}
