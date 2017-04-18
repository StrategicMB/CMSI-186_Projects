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
		}else if (checkSign(strInt) == 0){
			sign1 = 0;
		}
		if (checkSign(bigIntStr) > 0){
			sign2 = 1;
		}else if (checkSign(bigIntStr) < 0){
			sign2 = -1;
		}else if (checkSign(bigIntStr) == 0){
			sign2 = 0;
		}
		
		
				
		if (sign1 == 0) {
			sumStrings = bigIntStr;
		}else if (sign2 == 0) {
			sumStrings = strInt;
		}else if (sign1 * -1 == sign2) {
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

			for (int i = stringLength - isSigned - 1; i >= 0; i--){
				
				char character1 = strInt.charAt(i);
				char character2 = bigIntStr.charAt(i);				
				
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
					if (i>0){
						sumDigits = sumDigits - 10;
					}
				}else {
					remainderAdd = 0;
				}
				
				digitsString = Integer.toString(sumDigits);

				
				sumStrings = digitsString + sumStrings;
				
			}
			
			
		}

		bigIntStr = forNegatives + sumStrings;

		
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

				number2 = number2 + remainderSUB;
				
				if (number2 < number1) {					
					number2 = number2 + 10;
					remainderSUB = -1;
				}else {
					remainderSUB = 0;
				}
			
				minusDigits = number2 - number1;

				
				digitsString = Integer.toString(minusDigits);
				
				minusStrings = digitsString + minusStrings;

			}
			
			
		}

		bigIntStr = forNegatives + minusStrings;
		
		System.out.println("test: " + bigIntStr);

		
		return bigIntStr;
		
	}
	
	
	public String multiply(String strInt) {
	
			
		
		int number1 = 0;
		int halfNumber = 0;
		int carryOver = 0;
		int checkLastDigit;
		char character1;
		String strNum1 = strInt;
		BigInt strNum2 = new BigInt(bigIntStr);
		BigInt trackTotal = new BigInt("0");
		
System.out.println("multiplying");
			
			
		checkLastDigit = Character.getNumericValue(strNum1.charAt(strNum1.length()-1));
			
		if (1 == checkLastDigit % 2) {
			trackTotal.add(strNum2.toString());;
		}
				
		String digitsString = "";
		String halfStrings = "";




	
		while (strNum1.equals("1")== false) {
			strNum2.add(strNum2.toString());

			
			for (int i = 0; i < strNum1.length(); i++) {

					
				character1 = strNum1.charAt(i);

				
				if (character1 == '+') {
					character1 = '0';
				}else if (character1 == '-') {
					character1 = '0';
				}

				number1 = Character.getNumericValue(character1);

				
				
				halfNumber = number1 / 2;
				

				
				halfNumber = halfNumber + carryOver;
				carryOver = 0;
				if (1 < strNum1.length()){
					if (1 == number1 % 2){
						carryOver = 5;
					}
				}

				
				digitsString = Integer.toString(halfNumber);
				
								
				halfStrings = halfStrings + digitsString;
				
			}
			carryOver = 0;

			

			
			strNum1 = halfStrings;
			halfStrings = "";

			checkLastDigit = Character.getNumericValue(strNum1.charAt(strNum1.length()-1));
			
			if (1 == checkLastDigit % 2) {

				trackTotal.add(strNum2.toString());

			}
			
			strNum1 = strNum1.replaceFirst ("^0*", "");
			
		}
		

		
		
		
		return trackTotal.toString();
	}
	
	public String divide(String strInt) {
		
		/** Just use LONG DIVISION
		*/
		
		
		
		
		
		
		
		
		
		
		/**
		int lengthDiff = 0;
		int s = 0;
		int strIntLength = 0;
		int bigIntLength = 0;
		int firstStrIntNum = 0;
		int firstBigIntNum = 0;
		int count = 0;
		char firstStrIntChar;
		char firstBigIntChar;
		String countStr = "";
		String firstDigitStr = "";
		String difference = "";
		
		BigInt bigNum1 = new BigInt(strInt);
		BigInt bigNum2 = new BigInt(bigIntStr);
		BigInt estimation = new BigInt("0");

		String lowerBound = bigNum2.subtract(strInt).toString();
		
				System.out.println("bigNum1: " + bigNum1.toString());

		System.out.println("bigNum2: " + bigNum2.toString());
		
		bigNum2.add(strInt);
		System.out.println("bigNum2: " + bigNum2.toString());

		String zeroString = "";
		String ballparkMulti = "1";
		String estimateP0 = "";
		
		if (checkSign(bigNum1.toString()) == 1 || checkSign(bigNum1.toString()) == -1){
			
			strIntLength = bigNum1.toString().length() - 1;
		
		}else {
			strIntLength = bigNum1.toString().length();
		}
		if (checkSign(bigNum2.toString()) == 1 || checkSign(bigNum2.toString()) == -1){
			bigIntLength = bigNum2.toString().length() - 1;
		}else {
			bigIntLength = bigNum2.toString().length();
		}
		
		lengthDiff = bigIntLength - strIntLength;

		firstStrIntChar = bigNum1.toString().charAt(0);
		firstBigIntChar = bigNum2.toString().charAt(0);
		
		firstStrIntNum = Character.getNumericValue(firstStrIntChar);
		firstBigIntNum = Character.getNumericValue(firstBigIntChar);

		if (firstBigIntNum < firstStrIntNum){
			firstBigIntNum = firstBigIntNum * 10; 
			lengthDiff = lengthDiff - 1;
		}
		firstDigitStr = String.valueOf((firstBigIntNum/firstStrIntNum));
		
		if (lengthDiff > 0) {
			zeroString = createZerosString(lengthDiff-1);
			ballparkMulti = firstDigitStr + zeroString;
		}else {
			ballparkMulti = firstDigitStr;
		}
		
		System.out.println("bigNum1: " + bigNum1.toString());
		System.out.println("ballparkMulti: " + ballparkMulti);

		estimateP0 = (bigNum1.multiply(ballparkMulti)).toString();
		
		while(estimation.compareTo(bigIntStr) == 1) {
			
			count++;
			estimation.add(estimateP0);
		}
		count = count - 1;
		estimation.subtract(estimateP0);
		
		System.out.println("estimate: " + estimation.toString());
		
		difference = (bigNum2.subtract(estimation.toString())).toString();

		estimation.zeroNumber();
		estimation.add(estimateP0);
		estimation.multiply(count)

		

		
		ballparkMulti.substring(0,ballparkMulti.length()-1);
		
		*/
		
		
		return "";
	}
	
	public String remainder(String strInt) {
		
		/**
		divide, then multiply then subtract
		*/
		
		return "";
	}
	
	public String zeroNumber(){
		
		return bigIntStr = "0";
		
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
	
	
	  public String getCurrentString() {
	  
	  return bigIntStr;
   }
	
	public String toString(){
		
		return bigIntStr;
	}
  
   public static String toString( BigInt number ) {
	    String currentBigInt = number.getCurrentString();
		return currentBigInt;
   }
  

  public static void main( String args[] ) {
				
		System.out.println( "\nBIGINT CLASS TESTER PROGRAM\n");
              
		BigInt IntTest = new BigInt("10000");
		

	
		
		/**
		System.out.println( "    Testing toString(String s1)....");
		System.out.print( "      string argument, expecting string '1015345439'" );
		try { System.out.println( (IntTest.toString().equals("1015345439")) ? " - got   1015345439" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
		*/

		IntTest.divide("15");

		/**
								String strNum1 = "0001";
					int s = String.valueOf(strNum1);

					char character1 = bigIntStr.charAt(strNum1);

				   int number1 = Character.getNumericValue(character1);
					
					if (number1 = 1) {
								System.out.println("test: complete");
					}
					
						IntTest.multiply("100");


		
		System.out.println("test: " + IntTest.subtract("1"));
		System.out.println("test sdfd: " + IntTest.toString(IntTest));
		
		
		address negatives in multiplication
		-0 and +0 break the compareTo() function
		account for negatives in divide program
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