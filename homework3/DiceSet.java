/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Michael Brady
 *  Date          :  2017-02-23
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.1.0  2017-02-23  Michael Brady Writing logic and completing current version
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private static int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
	   this.sides = sides;
	   this.count = count;
	   ds = new Die[ count ];	  
	   for (int i = 0; i < count; i++) {
		   ds[i] = new Die(sides);
	   } 
   }

  /**
   * @return the sum of all the dice values in the set
   */
	public int sum() {
		int result = 0;
		for (int i = 0; i < count; i++) {
			int value = this.getIndividual(i);
			result = result + value;
		}

      return result;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
	   for (int i = 0; i < count; i++) {
		   Die d = new Die(sides);
		   ds[i] = d;
	   }

   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
      return this.ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      return this.ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
	  for (int i = 0; i < count; i++) {
		  int value = this.getIndividual(i);
		  String value_i = Integer.toString(value);
		  result = result + value_i + " ";
	   }
	  
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      String result = "";

	  for (int i = 0; i < count; i++) {
		  int value = ds.getIndividual(i);
		  String value_i = String.valueOf(value);
		  result = result + value_i + " ";
	   }
	  	  
	  return result;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {

   int oldCount = count;
   int[] dsArray; 
   dsArray = new int[count];

      int[] dsArrayOld; 
   dsArrayOld = new int[count];
   
   		   int[] orderedArrayOld;
		   orderedArrayOld = new int[count];
   
   for (int p = 0; p < count; p++) {
	   dsArrayOld[p] = ds.getIndividual(p);
   }

   DiceSet checkingSet = new DiceSet(count,sides);

	int newCount = count;
	int[] dsArrayNew; 
   dsArrayNew = new int[count];
   
   
   int[] orderedArrayNew;
		   orderedArrayNew = new int[count];
   
	   for (int pp = 0; pp < count; pp++) {
	   dsArrayNew[pp] = checkingSet.getIndividual(pp);
   }
   
   for (int i = 0; i <= 1; i++) {
	   if (i == 0) {
		   dsArray = dsArrayOld;
	   }else {
		   dsArray = dsArrayNew;
	   }
   
      for (int s = 0; s < count; s++) {
		  for (int n = 0; n < count - 1; n++) {

			  if (dsArray[n] > dsArray[n+1]) {
				int nVar = dsArray[n];
				int nPlusVar = dsArray[n+1];
			  
				  dsArray[n] = nPlusVar;
				  dsArray[n+1] = nVar;
				  
				  }
				  }
				  }
		if (i == 0) {
		   orderedArrayOld = dsArray;
	   }else {
		   orderedArrayNew = dsArray;
	   }		
				
				  
   }
   int counter = 0;
	if (oldCount == newCount) {
	   for (int h = 0; h < count; h++) {
			if (orderedArrayOld[h] == orderedArrayNew[h]){
				counter++;
			}
	    }
		if (newCount == counter){
			return true;
		}
	}

	return false;
	   	   
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
			DiceSet set = new DiceSet(2,4);
			set.roll();

			set.isIdentical(set);
	
   }

}