/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangemakerTestHarness.java
 * Purpose    :  Test harness for verification of the ChangeMaker class
 * @author    :  Professor Don Murphy
 * @author    :  B.J. Johnson totally ripped off from the original
 * @author	  :  Michael Brady  
 * Date       :  2017-05-04
 * Description:  This program creates the optimal change for 
 *               unknown coin values and an unknown total
 * Notes      :  I removed
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial release; stolen blatently from Professor Don Murphy with his
 *                                    express permission and blessing; just added this comment block
 *  1.1.0  2017-05-04  Michael Brady Wrote makeChangeWithDynamicProgramming method logic and made additions
 *                                    to main program and added JavaDocs
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 
public class ChangeMaker {

	/**
	* the main method which accepts command line inputs and calls 
	* the makeChangeWithDynamicProgramming method
	* @param args String[] array containing command line parameters
	* @return void
	*/
	public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }
				

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }

	/**
	*  method to create a tuple of the nominal change combination
	*  @param Tuple Inputs (int [] denominations, int amount) 
	*/
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
		
		if (denominations.length < 1) {
            printUsage();
            return null;
        }

		for (int i = 0; i < denominations.length; i++) {
			if (denominations[i] <= 0) {
                System.out.println("Denominations must all be greater than zero.\n");
                return null;
            }
				

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
						return null;
                }
            }
        }

        if (amount < 0) {
            System.out.println("Change cannot be made for negative amounts.\n");
            return null;
        }
		
		int rows = denominations.length;
		int cols = amount + 1;
		int currentDenom = 0;
		int currentTotal = 0;
		int previousTotal = 0;
		
		Tuple[][] changeTable = new Tuple[rows][cols];
		
		for (int i = 0; i < rows; i++){
			currentDenom = denominations[i];
			for (int j = 0; j < cols; j++){
				changeTable[i][j] = new Tuple(rows);
				if (j == 0 ){
					
				}else if ((j - currentDenom) < 0){
					changeTable[i][j] = Tuple.IMPOSSIBLE;
				}
				if ((j - currentDenom) >= 0){
					changeTable[i][j].setElement(i,1);
					if(changeTable[i][j-currentDenom].isImpossible()){					
						changeTable[i][j] = Tuple.IMPOSSIBLE;
	
					}else {					
						
						changeTable[i][j] = changeTable[i][j].add(changeTable[i][j-currentDenom]);
					}
					
				}
				if (i > 0){

					if (! changeTable[i-1][j].isImpossible()){
						if (changeTable[i][j].isImpossible()){
							changeTable[i][j] = changeTable[i-1][j];

						}else if (! changeTable[i][j].isImpossible()){
							currentTotal = changeTable[i][j].total();
							previousTotal = changeTable[i-1][j].total();

							if (currentTotal > previousTotal){
								changeTable[i][j] = changeTable[i-1][j];
							}
						}
					}
				}							
			}			
		}		
		return changeTable[rows-1][cols-1];
    }

	/**
	* A method to output the scrit usage when inputs are invalid
	* @return void
	*/
	
    private static void printUsage() {
        System.out.println("Usage: java Changemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

	/**
	* Method adds an "s" when coin count is greater than 1
	* @param int count
	* @return void
	*/
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}