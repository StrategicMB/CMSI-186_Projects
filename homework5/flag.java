/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Michael Brady
 *  Date written  :  2017-04-04
 *  Description   :  This method creates the flag object and contains methods 
 *					 associated with the flag.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-04-04  Michael Brady Logic for main program
 *                                            Update to handleInitialArguments
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class flag{
	
	private double xPos;
	private double yPos;
	
	public flag(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public double xLocation(){
		return this.xPos;
	}
	
	public double yLocation(){
		return this.yPos;
	}
}