 /**
 *  File name     :  StringStuffTester.java
 *  Purpose       :  Provides a tester class to test the methods in the StringStuff class
 *  Author        :  Michael Brady
 *  Date          :  2017-02-09
 *  Description   :  This file provides the tester for checking the methods created in StringStuff.java 
 *  Notes         :  There are fifty-one separate tests. Successful tests output correct or true while 
 *                   unsuccessful tests output false .  If an exception is thrown, the test
 *                   will output false.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  Michael Brady Initial writing and release
 */
 public class StringStuffTester {
 public static void main( String args[] ) {
	 test_containsVowel();
	 test_isPalindrome();
	 test_evensOnly();
	 test_evensOnlyNoDupes();
	 test_oddsOnly();
	 test_oddsOnlyNoDupes();
	 test_reverse();
    }
   
    static void test_containsVowel(){

	    System.out.println( " FIFTEEN TESTS FOR containsVowel(): " );
		   
	    System.out.print( " Test for vowel in the string 'bcdf'  : " );
	    try { System.out.println( StringStuff.containsVowel( "bcdf" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string ''  : " );
	    try { System.out.println( StringStuff.containsVowel( "" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'CATS AND RATS'  : " );
	    try { System.out.println( StringStuff.containsVowel( "CATS AND RATS" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'cats and rats'  : " );
	    try { System.out.println( StringStuff.containsVowel( "cats and rats" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'I IT '  : " );
   	    try { System.out.println( StringStuff.containsVowel( "I IT" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Test for vowel in the string 'i it'  : " );
	    try { System.out.println( StringStuff.containsVowel( "i it" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Test for vowel in the string 'O OPPS'  : " );
	    try { System.out.println( StringStuff.containsVowel( "O OPPS" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Test for vowel in the string 'o opps'  : " );
	    try { System.out.println( StringStuff.containsVowel( "o opps" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'DOGS OK'  : " );
	    try { System.out.println( StringStuff.containsVowel( "DOGS OK" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'dogs ok'  : " );
	    try { System.out.println( StringStuff.containsVowel( "dogs ok" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'MY Y'  : " );
	    try { System.out.println( StringStuff.containsVowel( "MY Y" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'my y'  : " );
	    try { System.out.println( StringStuff.containsVowel( "my y" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'Testing All My Vowels Out'  : " );
	    try { System.out.println( StringStuff.containsVowel( "Testing All My Vowels Out" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'I ate 8 2 scoop ice cream cones'  : " );
	    try { System.out.println( StringStuff.containsVowel( "I ate 8 2 scoop ice cream cones" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test for vowel in the string 'They're I'm'  : " );
	    try { System.out.println( StringStuff.containsVowel( "They're I'm" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	}
   
    static void test_isPalindrome(){
		
		System.out.println( " NINE TESTS FOR isPalindrome(): " );

	    System.out.print( " Test if the string 'testset' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "testset" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Test if the string 'Racecar' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "Racecar" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Test if the string 'dog god' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "dog god" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test if the string 'cats and dogs' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "cats and dogs " ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test if the string '8008' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "8008" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test if the string 'mom ' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "mom " ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test if the string 'name no one man' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "name no one man" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test if the string ' ' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( "" ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Test if the string ' ' is a palindrome  : " );
	    try { System.out.println( StringStuff.isPalindrome( " " ) ? "true" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
    }
   
    static void test_evensOnly(){
		   
		System.out.println( " FIVE TESTS FOR evensOnly(): " );
		   
	    System.out.print( " Find the even letters in string 'AbAACCcCDdHDhHh'  : " );
	    try { System.out.println( "bDdDHhHh".equals(StringStuff.evensOnly( "AbAACCcCDdHDhHh" )) ? "Correct, BbDd" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the even letters in string 'Find the evens.'  : " );
	    try { System.out.println( "dFhnntv".equals(StringStuff.evensOnly( "Find the evens." )) ? "Correct, dFhnntv" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
        System.out.print( " Find the even letters in string 'TrIaL, tRiAl'  : " );
	    try { System.out.println( "LlrRTt".equals(StringStuff.evensOnly( "TrIaL, tRiAl" )) ? "Correct, LlrRTt" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Find the even letters in string ''  : " );
	    try { System.out.println( "No string input" == StringStuff.evensOnly( "" ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the even letters in string ' '  : " );
	    try { System.out.println( "No string input" == StringStuff.evensOnly( " " ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
    }
   
    static void test_evensOnlyNoDupes(){
			  
        System.out.println( " SIX TESTS FOR evensOnlyNoDupes(): " );

		System.out.print( " Find the even letters, no duplicates, in string 'Mississippi'  : " );
	    try { System.out.println( "p".equals(StringStuff.evensOnlyNoDupes( "Mississippi" )) ? "Correct, p" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   		
		System.out.print( " Find the even letters, no duplicates, in string 'Twinkle Twinkle Little Star'  : " );
	    try { System.out.println( "LlnrTt".equals(StringStuff.evensOnlyNoDupes( "Twinkle Twinkle Little Star" )) ? "Correct, lnTt" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   		
		System.out.print( " Find the even letters, no duplicates, in string 'testing-testing'  : " );
	    try { System.out.println( "nt".equals(StringStuff.evensOnlyNoDupes( "testing-testing" )) ? "Correct, nt" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
				   
		System.out.print( " Find the even letters, no duplicates, in string 'TrIaL, tRiAl'  : " );
	    try { System.out.println( "LlrRTt".equals(StringStuff.evensOnlyNoDupes( "TrIaL, tRiAl" )) ? "Correct, LlrRTt" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the even letters, no duplicates, in string ''  : " );
	    try { System.out.println( "No string input" == StringStuff.evensOnlyNoDupes( "" ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the even letters, no duplicates, in string ' '  : " );
	    try { System.out.println( "No string input" == StringStuff.evensOnlyNoDupes( " " ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	}
   
    static void test_oddsOnly(){

    	System.out.println( " FIVE TESTS FOR oddsOnly(): " );
			   
	    System.out.print( " Find the odd letters in string 'AbAACCcCDdHDhHh'  : " );
	    try { System.out.println( "AAACCcC".equals(StringStuff.oddsOnly( "AbAACCcCDdHDhHh" )) ? "Correct, AAACCcC" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
        System.out.print( " Find the odd letters in string 'Find the odds.'  : " );
	    try { System.out.println( "eios".equals(StringStuff.oddsOnly( "Find the odds." )) ? "Correct, inos" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the odd letters in string 'TrIaL, tRiAl'  : " );
	    try { System.out.println( "aAIi".equals(StringStuff.oddsOnly( "TrIaL, tRiAl" )) ? "Correct, IaiA" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the odd letters in string ''  : " );
	    try { System.out.println( "No string input" == StringStuff.oddsOnly( "" ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the odd letters in string ' '  : " );
	    try { System.out.println( "No string input" == StringStuff.oddsOnly( " " ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
    }
   

  
    static void test_oddsOnlyNoDupes(){
				
		System.out.println( " SIX TESTS FOR oddsOnlyNoDupes(): " );
			
	   	System.out.print( " Find the odd letters, no duplicates, in string 'Mississippi'  : " );
	    try { System.out.println( "iMs".equals(StringStuff.oddsOnlyNoDupes( "Mississippi" )) ? "Correct, Mississippi" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the odd letters, no duplicates, in string 'Twinkle Twinkle Little Star'  : " );
	    try { System.out.println( "aeikSw".equals(StringStuff.oddsOnlyNoDupes( "Twinkle Twinkle Little Star" )) ? "Correct, aeikrw" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Find the odd letters, no duplicates, in string 'testing-testing'  : " );
	    try { System.out.println( "egis".equals(StringStuff.oddsOnlyNoDupes( "testing-testing" )) ? "Correct, egis" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
			
	    System.out.print( " Find the odd letters, no duplicates, in string 'TrIaL, tRiAl'  : " );
	    try { System.out.println( "aAIi".equals(StringStuff.oddsOnlyNoDupes( "TrIaL, tRiAl" )) ? "Correct, aAIi" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Find the odd letters, no duplicates, in string ''  : " );
	    try { System.out.println( "No string input" == StringStuff.oddsOnlyNoDupes( "" ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Find the odd letters, no duplicates, in string ' '  : " );
	    try { System.out.println( "No string input" == StringStuff.oddsOnlyNoDupes( " " ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
    }
  
    static void test_reverse(){
			
	    System.out.println( " FIVE TESTS FOR reverse(): " );

	    System.out.print( " Reverse the string 'Random string 80 cats (*&^$'  : " );
	    try { System.out.println( "'$^&*( stac 08 gnirts modnaR".equals(StringStuff.reverse( "Random string 80 cats (*&^$'" )) ? "Correct, $^&*( stac 08 gnirts modnaR" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
		System.out.print( " Reverse the string 'Testing Testing  '  : " );
	    try { System.out.println( "  gnitseT gnitseT".equals(StringStuff.reverse( "Testing Testing  " )) ? "Correct,   gnitseT gnitseT" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
		System.out.print( " Reverse the string 'Because I'm Batman'  : " );
	    try { System.out.println( "namtaB m'I esuaceB".equals(StringStuff.reverse( "Because I'm Batman" )) ? "Correct, namtaB m'I esuaceB" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	   	System.out.print( " Reverse the string ''  : " );
	    try { System.out.println( "No string input" == StringStuff.reverse( "" ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
	   
	    System.out.print( " Reverse the string ' '  : " );
	    try { System.out.println( "No string input" == StringStuff.reverse( " " ) ? "Correct, No string input" : "false" ); }
	    catch( Exception e ) { System.out.println ( false ); }
   }
 }