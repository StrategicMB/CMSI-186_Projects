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

 import java.text.DecimalFormat;

 
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
              
		Ball ballTest = new Ball(1,1,10,30,1);
		
		DecimalFormat df = new DecimalFormat("0.00");
			
			
		System.out.println( "    Testing xLocation()....");
		System.out.print( "      sending 1, expecting double value 1.0" );
		try { System.out.println( (1.0 == ballTest.xLocation()) ? " - got   1.0" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		
		System.out.println( "    Testing yLocation()....");
		System.out.print( "      sending 1, expecting double value 1.0" );
		try { System.out.println( (1.0 == ballTest.yLocation()) ? " - got   1.0" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		
		System.out.println( "    Testing currentSpeed()....");
		System.out.print( "      sending 10, expecting double value 10.0" );
		try { System.out.println( (10.0 == ballTest.currentSpeed()) ? " - got   10.0" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   
		ballTest.friction();
		
		System.out.println( "    Testing currentSpeed()....");
		System.out.print( "      sending 10 with friction, expecting double value 9.9" );
		try { System.out.println( (9.90 == ballTest.currentSpeed()) ? " - got   9.9" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   
		ballTest.ballMoves();
		
		System.out.println( "    Testing xLocation()....");
		System.out.print( "      ball moved, expecting string 5.95" );
		try { System.out.println( ("5.95".equals(df.format(ballTest.xLocation()))) ? " - got   5.95" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		
		System.out.println( "    Testing yLocation()....");
		System.out.print( "      ball moved, expecting string 9.57" );
		try { System.out.println( ("9.57".equals(df.format(ballTest.yLocation()))) ? " - got   9.57" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   
   }
   
}