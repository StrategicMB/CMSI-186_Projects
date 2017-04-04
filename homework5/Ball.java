/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class defining methods for the SoccerSim class
 *  @author       :  Michael Brady
 *  Date written  :  2017-04-04
 *  Description   :  This class generates the ball objects and contains methods associated
 *					 with that object.
 *  Notes         :  The angle uses north as the 0 degrees goin clockwise from there.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-04-04  Michael Brady Writing logic for methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Ball {
		
    private double angle;
	private double timeElapsed;
	private double timeSlice;
	private double xPos;
	private double yPos;
	private double ballSpeed;
	
	
	
    public Ball(double xStartPos, double yStartPos, double speed, double angle, double timeSlice) {

		this.xPos = xStartPos;
		this.yPos = yStartPos;
		this.ballSpeed = speed;
		this.angle = angle;
		this.timeElapsed = 0;
		this.timeSlice = timeSlice;
	}

	public void ballMoves() {
		double velocityVecsX = this.ballSpeed * Math.cos(angleToRad(this.angle));
		double velocityVecsY = this.ballSpeed * Math.sin(angleToRad(this.angle));
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
	
	public double currentSpeed(){
		return this.ballSpeed;
	}
	  
  
	public double angleToRad(double angle) {
		double adjustAngle = 90 - angle;
		double Radians = adjustAngle * Math.PI / 180;
		return Radians;
	}
  
  

  public static void main( String args[] ) {
		System.out.println( "\nBALL CLASS TESTER PROGRAM\n");
              
		Ball ballTest = new Ball(1,1,10,10,1);
		

			
		
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