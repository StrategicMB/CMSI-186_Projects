/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousInt.java
 *  Purpose       :  Provides a class of methods for using big integers
 *  @author       :  Michael Brady
 *  Date written  :  2017-04-19
 *  Description   :  This class has operations for large integers
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-04-19  Michael Brady Writing methods and logic
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 import java.text.DecimalFormat;

 
public class GinormousInt {
		
	String bigIntStr;
	
    public GinormousInt(String initialString) {

		bigIntStr = initialString;

	}
  
	public String add(String strIntInput){
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
		String newSign = "";
		
		if (checkSign(strIntInput) > 0){
			sign1 = 1;
		}else if (checkSign(strIntInput) < 0){
			sign1 = -1;
		}else if (checkSign(strIntInput) == 0){
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
			sumStrings = strIntInput;
		}else if (sign1 * -1 == sign2) {
			if (checkSign(strIntInput) == 1 ||checkSign(strIntInput) == -1 ){
			strIntInput = strIntInput.substring(1); 
			}
			if (sign1 == 1) {
				newSign = "-";
			}else if (sign1 == -1) {
				newSign = "+";
			}
			strIntInput = newSign + strIntInput;

			subtract(strIntInput);
		}else if (sign1 == sign2){

			int stringLength = 0;
			int lengthDiff = 0;
			
			if (strIntInput.length() > bigIntStr.length()) {
				stringLength = strIntInput.length();
				lengthDiff = stringLength - bigIntStr.length();
				String zeroString = createZerosString(lengthDiff);
				bigIntStr = zeroString + bigIntStr;			
				if (checkSign(strIntInput) == 1){
					isSigned = 1;
				}else if (checkSign(strIntInput) == -1){
					isSigned = 1;
					forNegatives = "-";
				}

			}else {
				stringLength = bigIntStr.length();
				lengthDiff = stringLength - strIntInput.length();
				String zeroString = createZerosString(lengthDiff);
				strIntInput = zeroString + strIntInput;		
				if (checkSign(bigIntStr) == 1){
					isSigned = 1;
				}else if (checkSign(bigIntStr) == -1){
					isSigned = 1;
					forNegatives = "-";
				}

			}

			for (int i = stringLength - isSigned - 1; i >= 0; i--){

				char character1 = strIntInput.charAt(i);
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

	
	public String subtract(String strIntInput) {
		
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

		if (checkSign(strIntInput) > 0){
			sign1 = 1;
		}else if (checkSign(strIntInput) < 0){
			sign1 = -1;
		}
		if (checkSign(bigIntStr) > 0){
			sign2 = 1;
		}else if (checkSign(bigIntStr) < 0){
			sign2 = -1;
		}
				
		if (sign1 * -1 == sign2) {
			if (checkSign(strIntInput) == 1 ||checkSign(strIntInput) == -1 ){
			strIntInput = strIntInput.substring(1); 
			}
			if (sign1 == 1) {
				newSign = "-";
			}else if (sign1 == -1) {
				newSign = "+";
			}
			strIntInput = newSign + strIntInput;

			add(strIntInput);
		}else if (sign1 == sign2){
			int stringLength = 0;
			int lengthDiff = 0;

			if (strIntInput.length() > bigIntStr.length()) {
				stringLength = strIntInput.length();
				lengthDiff = stringLength - bigIntStr.length();
				String zeroString = createZerosString(lengthDiff);

				bigIntStr = zeroString + bigIntStr;			
				if (checkSign(strIntInput) == 1){
					isSigned = 1;
				}else if (checkSign(strIntInput) == -1){
					isSigned = 1;
				}
			}else {
				stringLength = bigIntStr.length();
				lengthDiff = stringLength - strIntInput.length();
				
				String zeroString = createZerosString(lengthDiff);
				strIntInput = zeroString + strIntInput;		

				if (checkSign(bigIntStr) == 1){
					isSigned = 1;
				}else if (checkSign(bigIntStr) == -1){
					isSigned = 1;
				}
				
			}
			
			if (compareTo(strIntInput) == 1) {
				forNegatives = "-";
			}
	
			for (int i = stringLength - isSigned - 1; i >= 0; i--){
				
				
				if (compareTo(strIntInput) == 1) {
					character1 = bigIntStr.charAt(i);
					character2 = strIntInput.charAt(i);
				}else {
					character1 = strIntInput.charAt(i);
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
			
			bigIntStr = forNegatives + minusStrings;

		}

		

		
		return bigIntStr;
		
	}
	
	
	public String multiply(String strIntInput) {
	
			
		
		int number1 = 0;
		int halfNumber = 0;
		int carryOver = 0;
		int checkLastDigit;
		char character1;
		int sign1 = 0;
		int sign2 = 0;
		String newSign = "";
		
		if (checkSign(strIntInput) > 0){
			sign1 = 1;
		}else if (checkSign(strIntInput) < 0){
			sign1 = -1;
		}
		if (checkSign(bigIntStr) > 0){
			sign2 = 1;
		}else if (checkSign(bigIntStr) < 0){
			sign2 = -1;
		}
		
		
		if (checkSign(strIntInput) == 1 ||checkSign(strIntInput) == -1 ){
			strIntInput = strIntInput.substring(1); 
		}
		if (checkSign(bigIntStr) == 1 ||checkSign(bigIntStr) == -1 ){
			bigIntStr = bigIntStr.substring(1); 
		}
		if (sign1 * -1 == sign2){
			newSign = "-";
		}
		
		
		
		String strNum1 = strIntInput;
		GinormousInt strNum2 = new GinormousInt(bigIntStr);
		GinormousInt trackTotal = new GinormousInt("0");
		
			
			
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

		
		
		return bigIntStr = newSign + trackTotal.toString();
	}
	
	public String divide(String strIntInput) {

		
		
		
		
		int sign1 = 0;
		int sign2 = 0;
		int count = -1;
		int startNumber = 0;
		int endNumber = 1;
		int loopRuns = 0;
		int bigLoopRuns = 0;
		char character1;
		char character2;
		String remainder = "";
		String countString = "";
		String TrackTotal = "0";
		String previousNum = "";
		String currentValue = "";
		

		
		String newSign = "";
		
		if (checkSign(strIntInput) > 0){
			sign1 = 1;
		}else if (checkSign(strIntInput) < 0){
			sign1 = -1;
		}
		if (checkSign(bigIntStr) > 0){
			sign2 = 1;
		}else if (checkSign(bigIntStr) < 0){
			sign2 = -1;
		}
		
		
		if (checkSign(strIntInput) == 1 ||checkSign(strIntInput) == -1 ){
			strIntInput = strIntInput.substring(1); 
		}
		if (checkSign(bigIntStr) == 1 ||checkSign(bigIntStr) == -1 ){
			bigIntStr = bigIntStr.substring(1); 
		}
		if (sign1 * -1 == sign2){
			newSign = "-";
		}
		

		
		strIntInput = strIntInput.substring(0,strIntInput.length());
		bigIntStr = bigIntStr.substring(0,bigIntStr.length());
		
		GinormousInt bigNum1 = new GinormousInt(strIntInput);
		GinormousInt bigNum2 = new GinormousInt(bigIntStr);

		
			while(bigNum1.compareTo(bigIntStr.substring(startNumber,endNumber)) == -1){				
				endNumber++;
			}		
				
			GinormousInt partialInt = new GinormousInt(bigIntStr.substring(startNumber,endNumber));

			startNumber = endNumber;
			endNumber = endNumber + 1;
						
			while(partialInt.compareTo("0") == -1){
				previousNum = partialInt.toString();
				partialInt.subtract(strIntInput);		
				count++;

			}


			
			
		
			remainder = previousNum;



			countString = "" + count;

			TrackTotal = TrackTotal + countString;
			
			while(endNumber <= bigIntStr.length()) {
				currentValue = remainder + bigIntStr.substring(startNumber,endNumber);
				partialInt.setNumber(currentValue);
				
				count = 0;
				while(partialInt.compareTo("0") == -1){
					previousNum = partialInt.toString();
					partialInt.subtract(strIntInput);		
					count++;

				}
				
				count = count - 1;
				countString = "" + count;

				TrackTotal = TrackTotal + countString;
				
				startNumber = endNumber;
				endNumber = endNumber + 1;
				remainder = previousNum;
				


				
			}
			
		
		
		return bigIntStr = newSign + TrackTotal;
	}
	
	public String remainder(String strIntInput) {
		GinormousInt currentBigInt = new GinormousInt(bigIntStr);
		currentBigInt.divide(strIntInput);
		
		currentBigInt.multiply(strIntInput);

		currentBigInt.subtract(strIntInput);
		
		return bigIntStr = currentBigInt.toString();
	}
	
	public String setNumber(String inputStr){
		
		return bigIntStr = inputStr;
		
	}
	
  	
	public int compareTo(String strIntInput){
				
		int sign1 = 0;
		int sign2 = 0;
		String currStrInt = strIntInput;
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
		if (str1.length() == 1 && firstChar == '0') {
			return 0;
		} else if (firstChar == '-') {
			return -1;
		}else if ( firstChar == '+'){
			return 1;
		}else {
			return 2;
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
  

  

  public static void main( String args[] ) {
				
		System.out.println( "\nGINORMOUSINT CLASS TESTER PROGRAM\n");
              
		GinormousInt IntTest = new GinormousInt("900");		
		IntTest.remainder("31");
		
		System.out.println(IntTest.toString());
		
		System.out.println( "    Testing remainder(String 30)....");
		System.out.print( "      string argument, expecting string '1'" );
		try { System.out.println( (IntTest.remainder("31").toString().equals("1")) ? " - got   001" : " - no joy" ); }
		catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
	



   }
   
}