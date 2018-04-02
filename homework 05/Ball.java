import java.text.DecimalFormat;

public class Ball {
	private double ballVelocity;
	private  double xPosition;
	private  double yPosition;
	private  double xSpeed;
	private  double ySpeed;
	private String ballString;
	private double timeSlice;

	private static final double FRICTION = 0.01;
	private static final double MINIIMUM_SPEED = 0.083;

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
		this.timeSlice = timeSlice;
		xPosition += xSpeed * timeSlice;
    	yPosition += ySpeed * timeSlice;

	    xSpeed = xSpeed * (Math.pow( 1 - FRICTION, timeSlice ));
	    ySpeed = ySpeed * (Math.pow( 1 - FRICTION, timeSlice ));
	    ballVelocity = Math.sqrt( (xSpeed * xSpeed) + (ySpeed * ySpeed) );
	}
	



	public double getVelocity() {
		ballVelocity = Math.sqrt( (xSpeed * xSpeed) + (ySpeed * ySpeed) );
		//System.out.println("ballVelocity: " + ballVelocity);
		return ballVelocity;
	}

	public double UpdateXSpeed() { 
		return xSpeed;
	}

	public double UpdateYSpeed() { 
		return ySpeed;
	}

	public double UpdateXPosition() {
   		return xPosition;
	}

	public double UpdateYPosition() {
		return yPosition;
	}

	public boolean atRest() {
		if ( Math.abs( getVelocity() ) < MINIIMUM_SPEED ) {
			return true;
		} else {
     		return false;
		}
	}

	public String toString() {
		String stringFormat = "00.0000";
		DecimalFormat outputFormat = new DecimalFormat( stringFormat );

		if (atRest() == true) {
			ballString = "position " + outputFormat.format(xPosition) + ", " + outputFormat.format(yPosition) + "    <at rest>";
		} else {
			ballString = "position " + outputFormat.format(xPosition) + ", " + outputFormat.format(yPosition) + "    SPEED " + outputFormat.format(xSpeed) + ", " + outputFormat.format(ySpeed) + " m/s";
		}
		//System.out.println(ballString);
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



		b1.toString();
	}

}
