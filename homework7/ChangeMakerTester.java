/**
 *  File name     :  ChangeMakerTester.java
 *  Purpose       :  Provides a tester class to test ChangeMaker
 *  Author        :  Michael Brady
 *  Date          :  2017-05-04 
 *  Description   :  This file provides a test harness to test various denominations and amounts for the
 *                   ChangeMaker and to also test bad inputs to ensure th program handles these gracefully.
 *  Notes         :  There are currently ____ tests in this file for 
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-05-04  Michael Brady  Initial writing and release
 */
public class ChangeMakerTester {

	/**
	* the main method which calls all of the test methods in the class
	* @param args String[] array containing command line parameters
	* @return void
	*/
	public static void main ( String [] args ) {
		usDenominations();     // 4 tests
		oddDenominationsOne(); // 4 tests
		oddDenominationsTwo(); // 5 tests
		negativeDenominations();
		zeroDenominations();
		noDenomintaions();
		repeatDenominations();
	}

	/**
	* method to test the United States denominations for ChangeMaker
	* @return void
	*/
	static void usDenominations() {
		int[] usDenominations  = new int[] { 1, 5, 10, 25 };

		System.out.println( "\nFOUR TESTS FOR usDenominations:" );

		
		int [] arrayAnswer1 = {0, 0, 0, 4};
		Tuple answerTuple1 = new Tuple(arrayAnswer1);
		System.out.print( " Making change for 100 cents using united states coins-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(usDenominations,100).equals(answerTuple1) ? "Success: <0,0,0,4>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }


		int [] arrayAnswer2 = {4, 0, 2, 3};
		Tuple answerTuple2 = new Tuple(arrayAnswer2);
		System.out.print( " Making change for 99 cents using united states coins-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(usDenominations,99).equals(answerTuple2) ? "Success: <4,0,2,3>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
		
		
		int [] arrayAnswer3 = {1, 1, 1, 33};
		Tuple answerTuple3 = new Tuple(arrayAnswer3);
		System.out.print( " Making change for 841 cents using united states coins-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(usDenominations,841).equals(answerTuple3) ? "Success: <1,1,1,33>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
		
		
		int [] arrayAnswer4 = {2, 1, 1, 2};
		Tuple answerTuple4 = new Tuple(arrayAnswer4);
		System.out.print( " Making change for 67 cents using united states coins-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(usDenominations,67).equals(answerTuple4) ? "Success: <2,1,1,2>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
				
	}


	static void oddDenominationsOne() {
		int[] oddDenominations  = new int[] { 7, 22, 11, 24 };

		System.out.println( "\nFOUR TESTS FOR oddDenominations:" );

		
		int [] arrayAnswer1 = {1, 2, 0, 2};
		Tuple answerTuple1 = new Tuple(arrayAnswer1);
		System.out.print( " Making change for 99 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,99).equals(answerTuple1) ? "Success: <1,2,0,2>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }


		int [] arrayAnswer2 = {0, 1, 1, 3};
		Tuple answerTuple2 = new Tuple(arrayAnswer2);
		System.out.print( " Making change for 105 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,105).equals(answerTuple2) ? "Success: <0,1,1,3>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
		
		
		System.out.print( " Making change for 27 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,27).isImpossible() ? "Success: IMPOSSIBLE" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
		
		
		int [] arrayAnswer4 = {1, 2, 0, 8};
		Tuple answerTuple4 = new Tuple(arrayAnswer4);
		System.out.print( " Making change for 243 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,243).equals(answerTuple4) ? "Success: <1,2,0,8>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
				
	}
	
	
	static void oddDenominationsTwo() {
		int[] oddDenominations  = new int[] { 24, 61, 49, 101, 93 };

		System.out.println( "\nFIVE TESTS FOR oddDenominations:" );

		
		int [] arrayAnswer1 = {0, 0, 0, 1, 0};
		Tuple answerTuple1 = new Tuple(arrayAnswer1);
		System.out.print( " Making change for 101 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,101).equals(answerTuple1) ? "Success: <0,0,0,1,0>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }


		int [] arrayAnswer2 = {0, 0, 1, 1, 4};
		Tuple answerTuple2 = new Tuple(arrayAnswer2);
		System.out.print( " Making change for 522 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,522).equals(answerTuple2) ? "Success: <0,0,1,1,4>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
		
		
		System.out.print( " Making change for 43 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,43).isImpossible() ? "Success: IMPOSSIBLE" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
		
		
		int [] arrayAnswer4 = {0, 1, 3, 2, 4};
		Tuple answerTuple4 = new Tuple(arrayAnswer4);
		System.out.print( " Making change for 782 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,782).equals(answerTuple4) ? "Success: <0,1,3,2,4>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
			
		int [] arrayAnswer5 = {2, 0, 1, 0, 0};
		Tuple answerTuple5 = new Tuple(arrayAnswer5);
		System.out.print( " Making change for 97 cents using odd coinage-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(oddDenominations,97).equals(answerTuple5) ? "Success: <2,0,1,0,0>" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
			
	}
	
	
	static void negativeDenominations() {
		int[] negativeDenominations  = new int[] { 3, -5, 7};

		System.out.println( "\nONE TEST FOR negativeDenominations:" );

		System.out.print( " Making change for 101 cents using a negative coin-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(negativeDenominations,101) == null ? "Success: null" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }

	}
	
	static void zeroDenominations() {
		int[] zeroDenominations  = new int[] { 3, 5, 0, 8 };

		System.out.println( "\nOne TESTS FOR zeroDenominations:" );

		System.out.print( " Making change for 30 cents using a zero coin-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(zeroDenominations,30) == null ? "Success: null" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
			
	}
	
	static void noDenomintaions() {
		int[] noDenomintaions  = new int[] {};

		System.out.println( "\nONE TEST FOR noDenomintaions:" );

		System.out.print( " Making change for 101 cents using no coin denominations-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(noDenomintaions,101) == null ? "Success: null" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }
			
	}
	
	static void repeatDenominations() {
		int[] repeatDenominations  = new int[] { 3, 7, 10, 7};

		System.out.println( "\nONE TEST FOR repeatDenominations:" );

		System.out.print( " Making change for 50 cents using a repeat coin-  " );
		try { System.out.println( ChangeMaker.makeChangeWithDynamicProgramming(repeatDenominations,50) == null ? "Success: null" : "Failure" ); }
		catch( Exception e ) { System.out.println( false ); }

			
	}
	
}