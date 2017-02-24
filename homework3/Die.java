/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Michael Brady
 *  Date          :  2017-02-23
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getSides()                      // get the number of sides on this die     
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson  Initial writing and release
 *
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.1.0  2017-02-23  Michael Brady Writing logic and completing current version
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param sides int value containing THIS card's rank
   * @throws      IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
	   if (nSides < MINIMUM_SIDES){
		   throw new IllegalArgumentException();
	   }
	   this.sides = nSides;
	   
	   this.pips = 1;
	   pips = this.roll();
   }

  /**
   * Roll the die and return the result
   * @return  integer value of the result of the roll, whatever would be on top, randomly selected
   * @throws  IllegalArgumentException
   */
   public int roll() {
	  double rollResult = Math.ceil(Math.random()*sides);
	  int rolledNum = (int)rollResult;
	  this.pips = rolledNum;
	   return rolledNum;
   }


  /**
   * @return the pip count of THIS die instance; whatever is on top when the die stops rolling
   */
   public int getValue() {
	  
	  return this.pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public void setSides( int sides ) {
	  sides = this.sides;
   }

  /**
   * @return Public Instance method that returns a String representation of THIS die instance
   * @throws UnsupportedOperationException
   */
   public String toString() {
	   int rollResult = this.getValue();
	   String stringResult = String.valueOf(rollResult);
      return stringResult;
   }

  /**
   * @return Class-wide method that returns a String representation of THIS die instance
   */
   public static String toString( Die d ) {
	   	   int rollResult = d.getValue();
		   String stringResult = String.valueOf(rollResult);
		   return stringResult;
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      Die d = new Die( 4 );
	  System.out.println("Die roll: " + d);
	  System.out.println("Die Instance String: " + d.toString());
	  System.out.println("Die Static String: " + toString(d));
      System.out.println( "Hello from the Die class main method!" );
   }

}