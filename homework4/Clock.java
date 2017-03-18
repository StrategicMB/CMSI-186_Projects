/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Michael Brady
 *  Date written  :  2017-03-16
 *  Description   :  This class provides a bunch of methods which are used for ClockSolver
 *
 *  Notes         :  Validation of both the timeSlice argument and Angle argument are handled 
 *					 in the ClockSolver program.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-03-16  Michael Brady Writing logic for methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   import java.text.DecimalFormat;

public class Clock {
   /**
    *  Class field definintions go here
    */
    private double searchAngle;
    private double totalSeconds;
    private double currentTimeSec;
    private double currentTimeMin;
    private double currentTimeHour;
    private double timeSlice;
   
   /**
    *  Constructor goes here
    */
    public Clock(double totalSeconds, double timeSlice) {

    this.totalSeconds = totalSeconds;
    this.timeSlice = timeSlice;
    this.currentTimeHour = Math.floor(totalSeconds/3600);;
    this.currentTimeMin = Math.floor(totalSeconds/60)-(currentTimeHour * 60);
    this.currentTimeSec = totalSeconds - (currentTimeMin * 60) - (currentTimeHour * 3600);
    this.searchAngle = searchAngle;
    }

   /**
    *  Methods go here
    *
    *  Method to calculate the next tick from the time increment
    *  @return double-precision value of the current clock tick
    */
    public double tick() {
	    totalSeconds = this.totalSeconds + this.timeSlice;
		this.currentTimeHour = Math.floor(totalSeconds/3600);
		this.currentTimeMin = Math.floor(totalSeconds/60)-(currentTimeHour * 60);
		this.currentTimeSec = totalSeconds - (currentTimeMin * 60) - (currentTimeHour * 3600);
		return totalSeconds;
	}

   /**
    *  Method to calculate and return the current position of the hour hand
    *  @return double-precision value of the hour hand location
    */
    public double getHourHand() {
		double seconds = this.currentTimeSec;
	    double minutes = this.currentTimeMin;
		double hour = this.currentTimeHour;
		double angleHour = (hour * 30)+(minutes / 2)+(seconds / 120);
		
		return angleHour;
	}

   /**
    *  Method to calculate and return the current position of the minute hand
    *  @return double-precision value of the minute hand location
    */
	public double getMinuteHand() {
		double seconds = this.currentTimeSec;
		double minutes = this.currentTimeMin;
		double angleMin = (minutes * 6)+(seconds / 10);
		

		return angleMin;
	}

   /**
    *  Method to calculate and return the angle between the hands
    *  @return double-precision value of the angle between the two hands
    */
    public double getHandAngle() {
		searchAngle = this.getMinuteHand() - this.getHourHand(); 
		if (searchAngle < 0) {
			searchAngle = searchAngle * -1;
		}
		
		return searchAngle;
	}


   /**
    *  Method to return a String representation of this clock
    *  @return String value of the current clock
    */
    public String toString() {
		DecimalFormat df = new DecimalFormat("0");

		String Seconds = String.valueOf(df.format(currentTimeSec));
		String Minutes = String.valueOf(df.format(currentTimeMin));
		if (currentTimeHour == 0) {
			currentTimeHour = 12;
		}
		String Hours = String.valueOf(df.format(currentTimeHour));
	    String NoteTime = Hours + ":" + Minutes + ":" + Seconds;
		return NoteTime;
	}

   /**
    *  The main program starts here
    *  remember the constraints from the project description
    *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
    *  be sure to make LOTS of tests!!
    *  remember you are trying to BREAK your code, not just prove it works!
    */
    public static void main( String args[] ) {
		System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
		System.out.println( "  Creating a new clock: " );
		Clock clockTest = new Clock(240,60);  
						
		System.out.println( "    Testing tick()....");
		System.out.print( "      sending '  240 seconds', expecting double value   300.0" );
		try { System.out.println( (300.0 == clockTest.tick()) ? " - got   300.0" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
				
		System.out.println( "    Testing getMinuteHand()....");
		System.out.print( "      sending '  30.0 degrees', expecting double value   30.0" );
		try { System.out.println( (30.0 == clockTest.getMinuteHand()) ? " - got   30.0" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		
		System.out.println( "    Testing getHourHand()....");
		System.out.print( "      sending '  2.5 degrees', expecting double value   2.5" );
		try { System.out.println( (2.5 == clockTest.getHourHand()) ? " - got   2.5" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		
		System.out.println( "    Testing getHandAngle()....");
		System.out.print( "      sending '  27.5 degrees', expecting double value   27.5" );
		try { System.out.println( (27.5 == clockTest.getHandAngle()) ? " - got   27.5" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		
		System.out.println( "    Testing toString()....");
		System.out.print( "      sending '  string 12.0:5.0:0.0' " );
		try { System.out.println( ("12.0:5.0:0.0".equals(clockTest.toString())) ? " - got correct string" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   }
}