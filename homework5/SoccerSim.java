/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Michael Brady
 *  Date written  :  2017-03-16
 *  Description   :  This class runs the simulation for the soccer balls
 *
 *  Notes         :  By making searchRange a function of timeSlice I stopped there from being lots of
 *                   repeat times for low timeSlices. However, this also meant that the larger timeSlices
 *                   are less accurate and the time found for the angle could have some margin of error.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-03-16  Michael Brady Logic for main program
 *                                            Update to handleInitialArguments
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 
       		import java.util.ArrayList;

public class SoccerSim {

   /**
    *  Constructor
    *  This just calls the superclass constructor, which is "Object"
    */
    public SoccerSim() {
		super();
    }


    public static void main( String args[] ) {
		
		SoccerSim socsim = new SoccerSim();
		
		
		int argsCount = args.length; 
		
			double xPosBalls = 0;
			double yPosBalls = 0;
			double ballSpeed = 0;
			double angle = 0;

			
		Ball[] bs = null;
		
		ArrayList<Ball> ballList = new ArrayList<Ball>();

		
		if( 2 != argsCount % 4 ) {
			System.out.println( "    Sorry you must enter at least one argument\n" +
                             "   Usage: java SoccerSim [Flag XPos] [Flag YPos] [Ball 1 XPos] [Ball 1 YPos] [Ball 1 Speed] [Ball 1 Angle] ...\n" +
							 "   [Ball n XPos] [Ball n YPos] [Ball n Speed] [Ball n Angle]" +
							 "   Angles are measured clockwise from North as 0 degrees\n" +
							 "	 All inputs must be rational numbers\n" +
                             "   Please try again..........." );
			System.exit( 1 );
		}else if (2 == argsCount%4) {

			try {
				double xPosFlag = Double.parseDouble(args[0]);
				double yPosFlag = Double.parseDouble(args[1]);
				
				flag flagLoc = new flag(xPosFlag, yPosFlag);

				int ballCount = (argsCount - 2) / 4;		
				bs = new Ball[ballCount];
				int j = 0;
					for (int i = 2; i < argsCount; i+=4) {

					xPosBalls = Double.parseDouble(args[i]);
					yPosBalls = Double.parseDouble(args[i+1]);
					ballSpeed = Double.parseDouble(args[i+2]);
					angle = Double.parseDouble(args[i+3]);
			
					bs[j] = new Ball(xPosBalls, yPosBalls, ballSpeed, angle);
					
					j++;

					}
				
				
				
			} catch(NumberFormatException nfe)
			{
			System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java SoccerSim [Flag XPos] [Flag YPos] [Ball 1 XPos] [Ball 1 YPos] [Ball 1 Speed] [Ball 1 Angle] ...\n" +
							 "   [Ball n XPos] [Ball n YPos] [Ball n Speed] [Ball n Angle]" +
							 "   Angles are measured clockwise from North as 0 degrees\n" +
							 "	 All inputs must be rational numbers\n" +
                             "   Please try again..........." );
			 System.exit(1);
			}
		
		System.out.println(bs[0].xLocation());

		
		
		field playfield = new field();
		
		
	}

			
	
}
}