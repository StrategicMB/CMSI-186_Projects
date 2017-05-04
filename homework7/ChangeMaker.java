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
	Code needs javadocs. Most are already written but need to be written for any new methods
	
	Javadoc *.java
	
	
	Remove all of the checking conditions from the main program and move them to a separate one that can be referenced from both main an make change with dynamic programming
	
	first TestBogusDenomination1 did not work
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

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
		
		int rows = denominations.length;
		int cols = amount + 1;
		int currentDenom = 0;
		int currentTotal = 0;
		int previousTotal = 0;

		
		/**
		 need a trackCount variable
		*/

		
		Tuple[][] changeTable = new Tuple[rows][cols];
		
		
		/**
		changeTable[1][1] = new Tuple(4);
		changeTable[1][1].setElement(0,3);		

   		System.out.println("test:" + changeTable[1][1]);
*/
	

		
		
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
					
					
					
					/**
					not adding when looking above, just checking for better solution
					*/
					
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

    private static void printUsage() {
        System.out.println("Usage: java Changemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}