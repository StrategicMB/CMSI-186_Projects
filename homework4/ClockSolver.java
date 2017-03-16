/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Michael Brady
 *  Date written  :  2017-03-16
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
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

public class ClockSolver {
   
   /**
    *  Constructor
    *  This just calls the superclass constructor, which is "Object"
    */
    public ClockSolver() {
		super();
    }

   /**
    *  Method to handle all the input arguments from the command line
    *   this sets up the variables for the simulation
    */
    public void handleInitialArguments( String args[] ) {
		// args[0] specifies the angle for which you are looking
		//  your simulation will find all the angles in the 12-hour day at which those angles occur
		// args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
		// you may want to consider using args[2] for an "angle window"

		if( 0 == args.length ) {
			System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
			System.exit( 1 );
		}else if (3 <= args.length) {
			System.out.println("Sorry, only a maximum of 2 arguments allowed");
		  	System.exit( 1 );
		}
	}

   /**
    *  The main program starts here
    *  remember the constraints from the project description
    *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
    *  @param  args  String array of the arguments from the command line
    *                args[0] is the angle for which we are looking
    *                args[1] is the time slice; this is optional and defaults to 60 seconds
    */
    public static void main( String args[] ) {
		double timeSlice = 0;
		double searchAngle = 0;
		ClockSolver cse = new ClockSolver();
		cse.handleInitialArguments( args );
		if (1 == args.length) {
			try {
				searchAngle = Double.parseDouble(args[0]);
			} catch(NumberFormatException nfe)
			{
				System.out.println("Error: input must be a number");				   
				System.exit(1);
			} 
			timeSlice = 60;
		}else if (2 == args.length) {
			try {
				searchAngle = Double.parseDouble(args[0]);
				timeSlice = Double.parseDouble(args[1]);
			} catch(NumberFormatException nfe)
			{
				System.out.println("Error: inputs must be a number");
				System.exit(1);
			}
		}
	  
		if (timeSlice > 200) {
			System.out.println("Warning: TimeSlices above 200 are more likely to miss angles");
		}
	  
		Clock clock = new Clock(0,timeSlice);
		double searchRange = timeSlice/20;
		double currentAngle = 0;
	  
		while (clock.tick() < 43200) {
			currentAngle = clock.getHandAngle();
			if (currentAngle >= searchAngle - searchRange && currentAngle < searchAngle + searchRange){
				System.out.println(clock.toString());
			}
		}
		System.exit( 0 );
	}
}