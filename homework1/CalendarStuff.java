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
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.1  2017-01-19  Michael Brady Writing logic for the methods
 */
public class CalendarStuff {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;

  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   */
   private static final int JANUARY    = 0;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH      = FEBRUARY  + 1;
   private static final int APRIL      = MARCH     + 1;
   private static final int MAY        = APRIL     + 1;
   private static final int JUNE       = MAY       + 1;
   private static final int JULY       = JUNE      + 1;
   private static final int AUGUST     = JULY      + 1;
   private static final int SEPTEMBER  = AUGUST    + 1;
   private static final int OCTOBER    = SEPTEMBER + 1;
   private static final int NOVEMBER   = OCTOBER   + 1;
   private static final int DECEMBER   = NOVEMBER  + 1;

  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   */
   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public CalendarStuff() {
      System.out.println( "Constructor called..." );
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
   	   long leap4 = year%4;
	   long leap100 = year%100;
	   long leap400 = year%400;
	   if (leap400 == 0) {
            return true;
        } else if (leap100 == 0) {
            return false;
        } else if (leap4 == 0) {
            return true;
        } else {
            return false;
        }
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {
        long totaldays = 0;
	   
	   if (isLeapYear(year) == false) {
		   totaldays = days[(int)month - 1];
	   }else {   
		   if (month == 2) {
		   totaldays = 29;		   
		   }else {
			   totaldays = days[(int)month - 1];			   
				}
	   }
	   return totaldays;
   }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
	   if (year1 == year2) {
		   if (month1 == month2) {
			   if (day1 == day2) {
				   return true;
			   }else {
				   return false;
			   }
		   }else {
			   return false;
		   }
	   }else {
		   return false;
	   }
   }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
     if (year1 > year2) {
		   return 1;
	   }else if (year1 < year2) {
		   return -1;
	   }else {
		   if (month1 > month2) {
			   return 1;
		   }else if (month1 < month2) {
			   return -1;
		   }else {
			   if (day1 > day2) {
				   return 1;
			   }else if (day1 < day2) {
				   return -1;
			   }else {
				   return 0;
			   }
		   }
	   }
   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( long month, long day, long year ) {
   	   if (day <= 0){
		   return false;      
		   }else if (month <= 0){
			   return false;
		   }else if (month > 12){
			   return false;
		   }else if (month == 2) {
			   if (isLeapYear(year) == true) {
				   if (day <=29){
			   return true;
			   }
			   }
		   }else if (day <= days[(int)month-1]) {
			   return true;
			   }
			   return false;
   }
   
	  
  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {
   String monthName;
	  switch( month - 1 ) {
		  case 1:  monthName = "January";
		  break;
		  case 2:  monthName = "February";
		  break;
		  case 3:  monthName = "March";
		  break;
		  case 4:  monthName = "April";
		  break;
		  case 5:  monthName = "May";
		  break;
		  case 6:  monthName = "June";
		  break;
		  case 7:  monthName = "July";
		  break;
		  case 8:  monthName = "August";
		  break;
		  case 9:  monthName = "September";
		  break;
		  case 10: monthName = "October";
		  break;
		  case 11: monthName = "November";
		  break;
		  case 12: monthName = "December";
		  break;
		  default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
      }
	  return monthName;
   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
      switch( day - 1 ) {
         default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
      }
   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       long dayCount = 0;
	   
	   if (isValidDate(month1, day1, year1) == false) {
		   System.out.println( "\n First date entered is not valid. Please enter a new date.\n" );
		   System.exit( 0 );
	   }else if (isValidDate(month2, day2, year2) == false){
		   System.out.println( "\n Second date entered is not valid. Please enter a new date.\n" );
		   System.exit( 0 );
	   }else {
		   long daysofmonth1 = daysInMonth(month1, year1);
		   long daysofmonth2 = daysInMonth(month2, year2);
		   long daysleft1 = daysofmonth1 - day1;
		   long daysleft2 = daysofmonth2 - day2;
		   int monthTimeInYear1 = 0;
		   int monthTimeInYear2 = 0;

	  
	  for(int i=0; i < month1; i++){
		 monthTimeInYear1 = monthTimeInYear1 + days[(int)i];
	  }
	  if (isLeapYear(year1) == true) {
		  if (month1 > 1){
			  monthTimeInYear1 = monthTimeInYear1 + 1;
		  }else if (month1 == 1){
			  if (day1 == 29){
				  monthTimeInYear1 = monthTimeInYear1 + 1;
			  }
		  }
	  }
	
	  for(int i=0; i < month2; i++){
		 monthTimeInYear2 = monthTimeInYear2 + days[(int)i];
	  }
	  if (isLeapYear(year2) == true) {
		  if (month2 > 1){
			  monthTimeInYear2 = monthTimeInYear2 + 1;
		  }else if (month2 == 1){
			  if (day2 == 29){
				  monthTimeInYear2 = monthTimeInYear2 + 1;
			  }
		  }
	  }
	  int daysInCurrentYear1 = monthTimeInYear1 - (int)daysleft1;
	  int daysInCurrentYear2 = monthTimeInYear2 - (int)daysleft2;
	  
	  int yearcounting = 0;
	  
	  if (compareDate(month1,day1,year1,month2,day2,year2 )==1){
		  if (year1 > year2){
			  int yeardiff = (int)year1 - (int)year2;
			   for(int i=0; i < yeardiff; i++){
				   long checkingyear = year2 + i;
				   if (isLeapYear(checkingyear)==true){
					   yearcounting = yearcounting + 366;
					   }else {
					   yearcounting = yearcounting + 365;
					   }
			   }
		  }else {
			  yearcounting = 0;
		  }
		  dayCount = yearcounting - daysInCurrentYear2 + daysInCurrentYear1;
	  }else if (compareDate(month1,day1,year1,month2,day2,year2 )==-1){
		  if (year1 < year2){
			  int yeardiff = (int)year2 - (int)year1;
			   for(int i=0; i < yeardiff; i++){
				   long checkingyear = year1 + i;
				   if (isLeapYear(checkingyear)==true){
					   yearcounting = yearcounting + 366;
					   }else {
					   yearcounting = yearcounting + 365;
					   }
			   }
		  }else {
			  yearcounting = 0;
		  }
		  dayCount = yearcounting - daysInCurrentYear1 + daysInCurrentYear2;  
	  }else {
		  dayCount = 0;
		  } 
		  System.out.println( "The number of days between the two dates is " + dayCount );
		  return dayCount;
	  }
	  return dayCount;
   }
}