import java.text.DecimalFormat;

public class Ball {
	private double ballVelocity;

	public static double xPosition;
	public static double yPosition;
	public static double xSpeed;
	public static double ySpeed;
	private String ballString;
	private double timeSlice;

	private static final double FRICTION = 0.01;
	private static final double MINIIMUM_SPEED = 0.083;
/*
	public Ball(double xPosition, double yPosition, double xSpeed, double ySpeed, double userTimeSlice) {
		this.xPosition = xPosition; //m/s across
		this.yPosition = yPosition; //m/s up/down
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.timeSlice = userTimeSlice;
	}
*/
	public Ball(double xPosition, double yPosition, double xSpeed, double ySpeed) {
		this.xPosition = xPosition; //m/s across
		this.yPosition = yPosition; //m/s up/down
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public void moveBall() {
		xPosition += xSpeed; //*timeSlice
		xSpeed -= xSpeed * FRICTION;

		yPosition = yPosition;
		ySpeed -= ySpeed * FRICTION;
		ballVelocity = Math.sqrt( (xSpeed * xSpeed) + (ySpeed * ySpeed) );
	}
	

	public void moveWithTime() {
		xPosition += xSpeed * timeSlice;
    	yPosition += ySpeed * timeSlice;

	    xSpeed = xSpeed * (Math.pow( 1 - FRICTION, timeSlice ));
	    ySpeed = ySpeed * (Math.pow( 1 - FRICTION, timeSlice ));
	    ballVelocity = Math.sqrt( (xSpeed * xSpeed) + (ySpeed * ySpeed) );
	}
	
	public double getVelocity() {
		ballVelocity = Math.sqrt( (xSpeed * xSpeed) + (ySpeed * ySpeed) );
		System.out.println("ballVelocity: " + ballVelocity);
		return ballVelocity;
	}

	public double UpdateXSpeed() { //what happens when velocity are neg numbers
		/*
		xSpeed -= xSpeed * FRICTION;
		System.out.println("xSpeed: " + xSpeed);
		*/
		return xSpeed;
	}
	public double UpdateYSpeed() { //what happens when velocity are neg numbers
		/*
		ySpeed -= ySpeed * FRICTION;
		System.out.println("ySpeed: " + ySpeed);
		*/
		return ySpeed;
	}
	//could do a field class (Field.java)

	public double UpdateXPosition() {
		/*
		xPosition += xSpeed;
		System.out.println("x pos: " + xPosition);
		*/
   		return xPosition;
	}

	public double UpdateYPosition() {
		/*
		yPosition += ySpeed;
		System.out.println("y pos: " + yPosition);
		*/
		return yPosition;
	}

	public boolean atRest() {
		//if ( ( xSpeed*12 <= 1.0 ) && ( ySpeed*12 <= 1.0 ) ) {
		if ( Math.abs( ballVelocity ) < MINIIMUM_SPEED ) {
			return true;
		} else {
     		return false;
		}
	}

	public String toString() {
		String stringFormat = "00.0000";
		DecimalFormat outputFormat = new DecimalFormat( stringFormat );

		if (atRest() == true) {
			ballString = "POSITOIN " + outputFormat.format(xPosition) + ", " + outputFormat.format(yPosition) + "    <at rest>";
		} else {
			ballString = "POSITOIN " + outputFormat.format(xPosition) + ", " + outputFormat.format(yPosition) + "    SPEED " + outputFormat.format(xSpeed) + ", " + outputFormat.format(ySpeed) + " m/s";
		}
		System.out.println(ballString);
		return ballString;
	}
	
	public static void main( String args[] ) {
    System.out.println( "\nBaLL CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );

		System.out.println("\nnew ball - b1");
		Ball b1 = new Ball(10, 50, 2, 6);
		System.out.println( "The velocity of the ball is " + b1.getVelocity() + " ft/s.");
		b1.moveBall();
		b1.toString();
		b1.moveBall();
		b1.toString();
		b1.moveBall();
		b1.toString();
		b1.moveBall();
		b1.toString();
		b1.moveBall();
		b1.toString();
		System.out.println("\nnew ball - b2");
		Ball b2 = new Ball(20, 60, 3, 7);
		b2.moveBall();
		b2.toString();
		b2.getVelocity();
		b2.moveBall();
		b2.toString();
		b2.moveBall();
		b2.toString();
		b2.moveBall();
		b2.toString();
		System.out.println("\nnew ball - b3");
		Ball b3 = new Ball(30, 70, 4, 8);
		b3.moveBall();
		b3.toString();
		b3.moveBall();
		b3.toString();
		b3.moveBall();
		b3.toString();
		b3.moveBall();
		b3.toString();
		System.out.println("\nnew ball - b4");
		Ball b4 = new Ball(40, 80, 5, 9);
		b4.moveBall();
		b4.toString();
		b4.moveBall();
		b4.toString();
		b4.moveBall();
		b4.toString();
		b4.moveBall();
		b4.toString();

	}

}
