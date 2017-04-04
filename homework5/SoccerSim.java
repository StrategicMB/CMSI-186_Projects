/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Michael Brady
 *  Date written  :  2017-03-16
 *  Description   :  This class runs the simulation for the soccer balls
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

import java.text.DecimalFormat;

public class SoccerSim {
	
	private static double ballRadius = 4.45; // inches
	private static double maxSpeed = 192; // ft/sec

	
    public SoccerSim() {
		super();
    }


    public static void main( String args[] ) {
		
		SoccerSim socsim = new SoccerSim();
		field playField = new field();
		
		int argsCount = args.length; 
		int ballCount = (argsCount - 2) / 4;		
		
		double timeElapsed = 0;
		double ballContactRange = ballRadius/6;
		double flagContactRange = ballRadius/12;
		
		
		double xPosBalls = 0;
		double yPosBalls = 0;
		double ballSpeed = 0;
		double angle = 0;

			
		Ball[] bs = null;
		flag flagPole = null;

		
		if( 3 != argsCount % 4 ) {
			System.out.println( "    Sorry you must enter at least one argument\n" +
                             "   Usage: java SoccerSim [Flag XPos] [Flag YPos] [Ball 1 XPos] [Ball 1 YPos] [Ball 1 Speed] [Ball 1 Angle] ...\n" +
							 "   [Ball n XPos] [Ball n YPos] [Ball n Speed] [Ball n Angle] [timeSlice]" +
							 "   Angles are measured clockwise from North as 0 degrees\n" +
							 "	 All inputs must be rational numbers\n" +
                             "   Please try again..........." );
			System.exit( 1 );
		}else if (3 == argsCount%4) {

			if (3 == argsCount){ 
				System.out.println("Enter ball info to run simulation");
				System.exit( 1 );
			}
			try {
				double xPosFlag = Double.parseDouble(args[0]);
				double yPosFlag = Double.parseDouble(args[1]);
				double timeSlice = Double.parseDouble(args[argsCount-1]);

				flagPole = new flag(xPosFlag, yPosFlag);

				bs = new Ball[ballCount];
				int j = 0;
				for (int i = 2; i < argsCount-1; i+=4) {

					xPosBalls = Double.parseDouble(args[i]);
					yPosBalls = Double.parseDouble(args[i+1]);
					ballSpeed = Double.parseDouble(args[i+2]);
					angle = Double.parseDouble(args[i+3]);
			
					bs[j] = new Ball(xPosBalls, yPosBalls, ballSpeed, angle, timeSlice);
					
					j++;
				}
				
				
			} catch(NumberFormatException nfe)
			{
			System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java SoccerSim [Flag XPos] [Flag YPos] [Ball 1 XPos] [Ball 1 YPos] [Ball 1 Speed] [Ball 1 Angle] ...\n" +
							 "   [Ball n XPos] [Ball n YPos] [Ball n Speed] [Ball n Angle] [timeSlice]" +
							 "   Angles are measured clockwise from North as 0 degrees\n" +
							 "	 All inputs must be rational numbers\n" +
                             "   Please try again..........." );
			 System.exit(1);
			}
	
			double timeSlice = Double.parseDouble(args[argsCount-1]);


			while(true) {
				for (int i = 0; i < ballCount-1; i++){
					for (int j = i+1; j < ballCount; j++){
						double ballDistance = playField.checkDistance(bs[i].xLocation(), bs[i].yLocation(), bs[j].xLocation(), bs[j].yLocation());
						if (ballDistance < ballContactRange) {
							System.out.println("Collision");
							System.exit(1);
						}
					}
				}
				
				
				for (int k = 0; k < ballCount; k++){
					double flagDistance = playField.checkDistance(bs[k].xLocation(), bs[k].yLocation(), flagPole.xLocation(), flagPole.yLocation());
					if (flagDistance < flagContactRange) {
						System.out.println("Collision");
						System.exit(1);
					}
				}
				
				int stoppedBalls = 0;
				for (int s = 0; s < ballCount; s++) {
					double momentSpeed = bs[s].currentSpeed();
					DecimalFormat df = new DecimalFormat("0.00");
					System.out.println("Ball " + s + " is at coordinates " + df.format(bs[s].xLocation()) + ", " + df.format(bs[s].yLocation()) + " with a speed of " + df.format(momentSpeed));
					if (0 == momentSpeed) {
						stoppedBalls = stoppedBalls + 1;		
						if (stoppedBalls == ballCount) {
							System.out.println("All balls stopped");
							System.exit(1);
						}
						
					}
				}
				
				for (int z = 0; z< ballCount; z++) {
					bs[z].ballMoves();	
					if ( Math.floor(timeElapsed) + timeSlice >= timeElapsed) {
						bs[z].friction();
					}				
				}
				timeElapsed = timeElapsed + timeSlice;
				System.out.println("Time Elapsed: " + timeElapsed + " seconds");
			}	
		}	
	}
}