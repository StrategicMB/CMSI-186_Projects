/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Strings.java
 *  Purpose       :  Provides a class defining methods for the SoccerSim class
 *  @author       :  Michael Brady
 *  Date written  :  2017-04-04
 *  Description   :  This class generates the ball objects and contains methods associated
 *					 with that object.
 *  Notes         :  The angle uses north as the 0 degrees goin clockwise from there.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-04-04  Michael Brady Writing logic for methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 import java.text.DecimalFormat;

 
public class BigInt {
		
	String bigIntStr;
	
    public BigInt(String initialString) {

		bigIntStr = initialString;

	}
  
  
  
  
	public String add(String strInt){

		int remainderAdd = 0;
		int sumDigits = 0;
		int number1 = 0;
		int number2 = 0;
		int sign1 = 0;
		int sign2 = 0;
		int isSigned = 0;
		String sumStrings = "";
		String digitsString = "";
		String forNegatives = "";
		
		if (checkSign(strInt) > 0){
			sign1 = 1;
		}else if (checkSign(strInt) < 0){
			sign1 = -1;
		}
		if (checkSign(bigIntStr) > 0){
			sign2 = 1;
		}else if (checkSign(bigIntStr) < 0){
			sign2 = -1;
		}
		
				
		if (sign1 * -1 == sign2) {
			subtract(strInt);
			System.exit(1);
		}else if (sign1 == sign2){
			int stringLength = 0;
			int lengthDiff = 0;
			
			if (strInt.length() > bigIntStr.length()) {
				stringLength = strInt.length();
				lengthDiff = stringLength - bigIntStr.length();
				String zeroString = createZerosString(lengthDiff);
				bigIntStr = zeroString + bigIntStr;			
				if (checkSign(strInt) == 1){
					isSigned = 1;
				}else if (checkSign(strInt) == -1){
					isSigned = 1;
					forNegatives = "-";
				}
			}else {
				stringLength = bigIntStr.length();
				lengthDiff = stringLength - strInt.length();
				String zeroString = createZerosString(lengthDiff);
				strInt = zeroString + strInt;		
				if (checkSign(bigIntStr) == 1){
					isSigned = 1;
				}else if (checkSign(bigIntStr) == -1){
					isSigned = 1;
					forNegatives = "-";
				}
				
			}
	
			System.out.println("str1: " + strInt);
			System.out.println("str2: " + bigIntStr);

	
			for (int i = stringLength - isSigned - 1; i >= 0; i--){
				
				char character1 = strInt.charAt(i);
				char character2 = bigIntStr.charAt(i);
				

				System.out.println("char1: " + character1);
				System.out.println("char2: " + character2);

				
				
				if (character1 == '+') {
					character1 = '0';
				}else if (character1 == '-') {
					character1 = '0';
				}
				if (character2 == '+') {
					character2 = '0';
				}else if (character2 == '-') {
					character2 = '0';
				}
				number1 = Character.getNumericValue(character1);
				number2 = Character.getNumericValue(character2);
			
				sumDigits = number1 + number2 + remainderAdd;
				if (sumDigits > 9) {
					remainderAdd = 1;
					sumDigits = sumDigits - 10;
				}else {
					remainderAdd = 0;
				}
				
				digitsString = Integer.toString(sumDigits);
				
				sumStrings = digitsString + sumStrings;
			}
			
			
		}
		
		bigIntStr = forNegatives + sumStrings;
		System.out.println("test: " + bigIntStr);

		
		return bigIntStr;
	}

	
	public String subtract(String strInt) {
		
		int remainderSUB = 0;
		int minusDigits = 0;
		int number1 = 0;
		int number2 = 0;
		int sign1 = 0;
		int sign2 = 0;
		int isSigned = 0;
		String newSign = "";
		String minusStrings = "";
		String digitsString = "";
		String forNegatives = "";
		char character1;
		char character2;
		
		if (checkSign(strInt) > 0){
			sign1 = 1;
		}else if (checkSign(strInt) < 0){
			sign1 = -1;
		}
		if (checkSign(bigIntStr) > 0){
			sign2 = 1;
		}else if (checkSign(bigIntStr) < 0){
			sign2 = -1;
		}
		
				
		if (sign1 * -1 == sign2) {
			if (checkSign(strInt) == 1 ||checkSign(strInt) == -1 ){
			strInt = strInt.substring(1); 
			}
			if (sign1 == 1) {
				newSign = "-";
			}else if (sign1 == -1) {
				newSign = "+";
			}
			strInt = newSign + strInt;
			add(strInt);
			System.exit(1);
		}else if (sign1 == sign2){
			int stringLength = 0;
			int lengthDiff = 0;
			
			if (strInt.length() > bigIntStr.length()) {
				stringLength = strInt.length();
				lengthDiff = stringLength - bigIntStr.length();
				String zeroString = createZerosString(lengthDiff);
								System.out.println("zero1: " + zeroString);

				bigIntStr = zeroString + bigIntStr;			
				if (checkSign(strInt) == 1){
					isSigned = 1;
				}else if (checkSign(strInt) == -1){
					isSigned = 1;
				}
			}else {
				stringLength = bigIntStr.length();
				lengthDiff = stringLength - strInt.length();
				
				String zeroString = createZerosString(lengthDiff);
				strInt = zeroString + strInt;		

				if (checkSign(bigIntStr) == 1){
					isSigned = 1;
				}else if (checkSign(bigIntStr) == -1){
					isSigned = 1;
				}
				
			}

			System.out.println("str1: " + strInt);
			System.out.println("str2: " + bigIntStr);
			
			if (compareTo(strInt) == 1) {
				forNegatives = "-";
			}
	
			for (int i = stringLength - isSigned - 1; i >= 0; i--){
				
				
				if (compareTo(strInt) == 1) {
					character1 = bigIntStr.charAt(i);
					character2 = strInt.charAt(i);
				}else {
					character1 = strInt.charAt(i);
					character2 = bigIntStr.charAt(i);
				}
				System.out.println("char: " + character2);

				
				if (character1 == '+') {
					character1 = '0';
				}else if (character1 == '-') {
					character1 = '0';
				}
				if (character2 == '+') {
					character2 = '0';
				}else if (character2 == '-') {
					character2 = '0';
				}
				number1 = Character.getNumericValue(character1);
				number2 = Character.getNumericValue(character2);
			
				System.out.println("number1: " + number1);
				System.out.println("number2: " + number2);

			
			
				number2 = number2 + remainderSUB;
				System.out.println("number2 + remsub: " + number2);
				System.out.println("remainderSUB: " + remainderSUB);

				
				if (number2 < number1) {					
					number2 = number2 + 10;
					remainderSUB = -1;
				}else {
					remainderSUB = 0;
				}
			
				minusDigits = number2 - number1;
				System.out.println("minusDigits: " + minusDigits);

				
				digitsString = Integer.toString(minusDigits);
				
				minusStrings = digitsString + minusStrings;
				System.out.println("minusStrings: " + minusStrings);

			}
			
			
		}

		bigIntStr = forNegatives + minusStrings;
		
		System.out.println("test: " + bigIntStr);

		
		return bigIntStr;
		
	}
	
	
	public String multiply(String s1, String s2) {
		
		
		
		return "";
	}
	
	public String divide(String s1, String s2) {
		
		
		
		return "";
	}
	
	public String remainder(String s1, String s2) {
		
		/**
		divide, then multiply then subtract
		*/
		
		return "";
	}
  	
	public int compareTo(String strInt){
				
		int sign1 = 0;
		int sign2 = 0;
		String currStrInt = strInt;
		String currBigIntStr = bigIntStr;
		
		if (checkSign(currStrInt) > 0){
			sign1 = 1;
		}else if (checkSign(currStrInt) < 0){
			sign1 = -1;
		}
		if (checkSign(currBigIntStr) > 0){
			sign2 = 1;
		}else if (checkSign(currBigIntStr) < 0){
			sign2 = -1;
		}
		if (sign1 > sign2) {
			return 1;
		}else if (sign1 < sign2) {
			return -1;
		}else {
			if (checkLength(currStrInt) > checkLength(currBigIntStr)){
				if (sign1 > 0){
					return 1;
				}else if (sign1 < 0) {
					return -1;
				}	
			}else if (checkLength(currStrInt) < checkLength(currBigIntStr)){
				if (sign1 > 0){
					return -1;
				}else if (sign1 < 0) {
					return 1;
				}	
			}else {
				if(checkSign(currStrInt) == 1 || checkSign(currStrInt) == -1) {
					currStrInt = currStrInt.substring(1);
				}
				if(checkSign(currBigIntStr) == 1 || checkSign(currBigIntStr) == -1) {
					currBigIntStr = currBigIntStr.substring(1);
				}
				for (int i = 0; i < currStrInt.length(); i++) {
					
					char character1 = currStrInt.charAt(i);
					char character2 = currBigIntStr.charAt(i);

					int numStrInt = Character.getNumericValue(character1);
					int numBigInt = Character.getNumericValue(character2);
					
					if(numStrInt > numBigInt){
						return 1;
					}else if (numStrInt < numBigInt){
						return -1;
					}
				}
			}	
		}

		
		return 0;
	}
	
	public int checkLength(String str1){
		int isSigned = 0;
		int totalLength = str1.length();
		if (checkSign(str1) == 1 || checkSign(str1) == -1) {
			isSigned = 1;
		}
		totalLength = totalLength - isSigned;
		return totalLength;
	}
	
	public boolean equals(String str1) {
		if (compareTo(str1) == 0){
			return true;
		}
		return false;
	}
	

	
	public int checkSign(String str1) {
		char firstChar = str1.charAt(0);
		if (firstChar == '-') {
			return -1;
		}else if (str1.length() == 1 && firstChar == '0') {
			return 0;	
		}else if ( firstChar == '+'){
			return 1;
		}else {
			return 2;
		}
	}
	
	
	
	public String reverse( String strInt ) {
	   
     	if (checkValidString(strInt) == false) {
		    return "No Integer input" ;
	    }
	   
	    int totallength = strInt.length();
	    String stringold = strInt;
	    String stringnew = "";
	    for(int i = 0; i < totallength; i++){
		    stringnew = stringnew + stringold.charAt(stringold.length()-1);
		    stringold = strInt.substring(0,stringold.length()-1) ;
	    }			   		
        return stringnew;
    }
	
	
	
	public boolean checkIsInteger(String strInt){
		
		
		
		
		return true;
	}
	
	public boolean checkValidString(String strInt) {
   	    if (strInt == null || strInt.isEmpty()|| strInt.matches(".")) {
	        return false;
	    } else {
		    return true;
	    }
    }  
	
	public String createZerosString(int stringLength){
		String output = "";
		
		for (int i = 0; i < stringLength; i++) {
			output = output + "0";
		}
		return output;
	}
	
	
	public String toString(){
		
		return bigIntStr;
	}
  
  
  
  

  public static void main( String args[] ) {
				
		System.out.println( "\nBIGINT CLASS TESTER PROGRAM\n");
              
		BigInt IntTest = new BigInt("100");
		

		
		System.out.println( "    Testing toString(String s1)....");
		System.out.print( "      string argument, expecting string '1015345439'" );
		try { System.out.println( (IntTest.toString().equals("1015345439")) ? " - got   1015345439" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	
		

		System.out.println("test: " + IntTest.subtract("114"));

		/**
		-0 and +0 break the compareTo() function
		*/

		
		/**
              1015345439
		System.out.println( "    Testing yLocation()....");
		System.out.print( "      ball moved, expecting string 9.57" );
		try { System.out.println( ("9.57".equals(df.format(ballTest.yLocation()))) ? " - got   9.57" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		*/
   }
   
}