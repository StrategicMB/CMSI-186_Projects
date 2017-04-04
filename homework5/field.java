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
 
public class field {
	
		
	
	/**
	*  Constructor goes here
    */
    public field() {
		super();
    }
  
	public double checkDistance(double xPos1, double yPos1, double xPos2, double yPos2) {
		double distanceBetween = Math.sqrt(Math.pow((xPos1-xPos2),2) + Math.pow((yPos1-yPos2),2));
		return distanceBetween;
	}
  
	

  
   /**
    *  The main program starts here
    *  remember the constraints from the project description
    *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
    *  be sure to make LOTS of tests!!
    *  remember you are trying to BREAK your code, not just prove it works!
    */
    public static void main( String args[] ) {
		
		field playfield = new field();
		
		playfield.checkDistance(

   }
}