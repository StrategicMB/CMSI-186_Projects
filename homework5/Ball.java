/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class defining methods for the SoccerSim class
 *  @author       :  Michael Brady
 *  Date written  :  2017-03-16
 *  Description   :  This class provides a bunch of methods which are used for ClockSolver
 *
 *  Notes         :  Validation of both the timeSlice argument and Angle argument are handled 
 *					 in the ClockSolver program. 0 degrees is east.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-16  Michael Brady Writing logic for methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Ball {
	
	private final double ballRadius = 4.45;
	private final double maxSpeed = 192; // ft/sec
	
   /**
    *  Class field definintions go here
    */
    private double angle;
	private double timeElapsed = 0;
	private double timeSlice = 1;
	private double xPos;
	private double yPos;
	private double ballSpeed;
	
	
	
   /**
    *  Constructor goes here
    */
    public Ball(double xStartPos, double yStartPos, double speed, double angle) {

	
	this.xPos = xStartPos;
	this.yPos = yStartPos;
	this.ballSpeed = speed;

	}

	public void ballMoves(double ballSpeed, double angle) {
		double velocityVecsX = this.ballSpeed * Math.cos(angleToRad(angle));
		double velocityVecsY = this.ballSpeed * Math.sin(angleToRad(angle));
		xPos = this.xPos + velocityVecsX * timeSlice;
		yPos = this.yPos + velocityVecsY * timeSlice;
	}
  
  
	public void friction(){
		ballSpeed = this.ballSpeed * 0.99;
		
		if (ballSpeed < 0.1) {
			ballSpeed = 0;
		}
	}
	
	public double xLocation(){
		return this.xPos;
	}
	
	public double yLocation(){
		return this.yPos;
	}
	
	public void tick(){
		timeElapsed = this.timeElapsed + timeSlice;
	}
  
  
	public double angleToRad(double angle) {
		double Radians = angle * Math.PI / 180;
		return Radians;
	}
  
   public String toString() {
	   double currentSpeed = this.ballSpeed;
	   String stringResult = String.valueOf(currentSpeed);
      return stringResult;
   }

  

  public static void main( String args[] ) {
		System.out.println( "\nBALL CLASS TESTER PROGRAM\n");
              
		Ball ballTest = new Ball(1,1,10,10);
		
		System.out.println("speed: " + ballTest.toString());
		ballTest.friction();
		System.out.println("speed: " + ballTest.toString());
		ballTest.friction();
		System.out.println("speed: " + ballTest.toString());

			
		
/**
			  "--------------------------\n" );
		System.out.println( "  Creating a new clock: " );
		Clock clockTest = new Clock(240,60);  
				
					
		System.out.println( "    Testing tick()....");
		System.out.print( "      sending '  240 seconds', expecting double value   300.0" );
		try { System.out.println( (300.0 == clockTest.tick()) ? " - got   300.0" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		*/
   }
   
}