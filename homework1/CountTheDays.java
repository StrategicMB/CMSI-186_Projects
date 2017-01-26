/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Michael Brady
 *  Date          :  2017-01-19
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.1  2017-01-19  Michael Brady Writing logic for the program
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.2  2017-01-25  Michael Brady Finished writing logic for the program
 */
public class CountTheDays {
	public static void main(String args[]){
		    if( args.length != 6) {
	   System.out.println( "\n Run again, with six inputs for month1 day1 year1 month2 day2 year2\n" );
	   System.exit( 0 );
	 }
		try {
			int month1test = Integer.parseInt( args[0]);			 
			int day1test = Integer.parseInt( args[1]);
			int year1test = Integer.parseInt( args[2]);
			int month2test = Integer.parseInt( args[3]);
			int day2test = Integer.parseInt( args[4]);
			int year2test = Integer.parseInt( args[5]);
			}  
				catch(NumberFormatException nfe) {
					System.out.println( "\n Only use numerical characters for the date, no letters or special characters\n" );
					System.exit( 0 );
				}					
		
		long month1 = Long.parseLong( args[0]);
		long day1 = Long.parseLong( args[1]);
		long year1 = Long.parseLong( args[2]);
		long month2 = Long.parseLong( args[3]);
		long day2 = Long.parseLong( args[4]);
		long year2 = Long.parseLong( args[5]);
		
		CalendarStuff.daysBetween( month1, day1, year1, month2, day2, year2 );
	}
}
