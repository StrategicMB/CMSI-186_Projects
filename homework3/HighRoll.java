/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Michael Brady
 *  Date          :  2017-02-23
 *  Description   :  This program runs the game HighRoll allowing the user to select from different options
 *					 to roll all the dice, one die, calculate the score, save the score as the highscore, 
 * 					 display the highscore, and to quit the game.
 *
 *  Notes         : None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-23  Michael Brady Initial Writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {
	
	
	public static void main( String args [] ) {
	
		int highScore = 0;
		int currentScore = 0;
		int inLoop = 0;
		
		System.out.print("Enter the number of dice for game: ");
		String countString = null;
		int kk = 0;
		BufferedReader inputCount = new BufferedReader( new InputStreamReader( System.in ) );
		while( kk < 1 ) {
			try {
				countString = inputCount.readLine();
				kk = 1;
			}
			catch( IOException ioe ) {
				System.out.print( "Caught IOException" );
			}
		}
	  	int count = Integer.parseInt(countString);			

	 	System.out.print("Enter the number of sides on the dice: ");

		String sidesString = null;
		int AA = 0;
		BufferedReader inputSides = new BufferedReader( new InputStreamReader( System.in ) );
		while( AA < 1 ) {
			try {
				sidesString = inputSides.readLine();
				AA = 1;		
			}
			catch( IOException ioe ) {
				System.out.println( "Caught IOException" );
			}
		}
		int sides = Integer.parseInt(sidesString);			

		DiceSet set = new DiceSet(count,sides);
	
		System.out.println("1) ROLL ALL THE DICE ");
		System.out.println("2) ROLL A SINGLE DIE ");
		System.out.println("3) CALCULATE THE SCORE FOR THIS SET ");
		System.out.println("4) SAVE THIS SCORE AS HIGH SCORE ");
		System.out.println("5) DISPLAY THE HIGH SCORE");
		System.out.println("ENTER 'Q' TO QUIT THE PROGRAM");

		while (inLoop < 1) {
			System.out.print("Enter the number of the desired option >> ");
		    String s = null;
			int p = 0;
			BufferedReader inputSelection = new BufferedReader( new InputStreamReader( System.in ) );
			while( p < 1 ) {
				try {
					s = inputSelection.readLine();
					p = 1;
				if( s.length() == 0 ) {
					break;
				}
				}
				catch( IOException ioe ) {
					System.out.println( "Caught IOException" );
				}
			}
		
			if(s.equals("1")) {
				set.roll();
				set.toString();
				System.out.println("DICESET: " + set.toString());
			}else if (s.equals("2")) {
				System.out.println("Select which die?");
				String rr = null;
				int nn = 0;
				BufferedReader input3 = new BufferedReader( new InputStreamReader( System.in ) );
				while( nn < 1 ) {
					try {
						rr = input3.readLine();
						nn = 1;
						if( rr.length() == 0 ) {
							break;
						}			
					}	
					catch( IOException ioe ) {
						System.out.println("Caught IOException");
					}
				}
				int dieIndex = Integer.parseInt(rr);
				if(dieIndex > count) {
					System.out.println("Input is greater than the number of dice");
				}

				if(dieIndex <= count) {
					set.rollIndividual(dieIndex-1);
					System.out.println("DICESET: " + set.toString());
				}
			}else if (s.equals("3")) {
				currentScore = set.sum();
				System.out.println("Score: " + currentScore);
			}else if (s.equals("4")) {
				if (highScore < currentScore) {
					highScore = currentScore;
				}else {
					System.out.println("NOT A NEW HIGH SCORE, HIGH SCORE IS " + highScore );
				}
			}else if (s.equals("5")) {
				System.out.println("High Score:" + highScore);
			}else if (s.equals("Q")) {
				inLoop = 1;
			}else {
				System.out.println("Please only enter numbers 1-5 or Q to quit");	
			}
		}
	}
}