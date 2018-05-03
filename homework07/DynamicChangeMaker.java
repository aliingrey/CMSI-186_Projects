/**
 *  File name     :  DynamicChangeMaker.java
 *  Purpose       :  given coins with values, this code will use them to make the optimal amount of cents asked for by the code.
 *  Author        :  Ali Ingrey
 *  Date          :  2018-05-03
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-05-03  Ali Ingrey    Submitted for Homework 07 in Spring 2018
 */

public class DynamicChangeMaker {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Enter args for how many <coins you would like to optimize> and <total cents>. Make sure the coin values are sparated by commas.");
            System.exit( 0 );
        }
        try {
            String[] coinString = args[0].split(",");
            int[] denoms = new int[coinString.length];

            for (int i = 0; i < denoms.length; i++) {
                denoms[i] = Integer.parseInt(coinString[i]);
                if (denoms[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    System.exit( 0 );
                }
                for (int j = 0; j < i; j++) {
                    if (denoms[j] == denoms[i]) {
                        System.out.println("You entered " + denoms[i] + "multiple times. Duplicate denominations are not allowed.\n");
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);

            if (amount < 0) {
                System.out.println("No negative numbers - Change cannot be made for negative amounts.\n");
                return;
            }

            Tuple change = makeChangeWithDynamicProgramming(denoms, amount);

            if (change.isImpossible()) {
                System.out.println("IMPOSSIBLE: " + amount + " can't be made with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin(s)"  +
            	" as follows:");

                for (int i = 0; i < denoms.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("  "  + coinCount + " X " + denoms[i] + " cent coin");
                }
                System.out.println(" TOTAL: " + coinTotal + " coins");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("denominations and amount must all be integers.\n");
        }
    }
   
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
    	int numDenoms = denominations.length;
		Tuple[][] tuples = new Tuple[numDenoms][amount + 1];  

        for (int row = 0; row < numDenoms; row++) {        
            for (int column = 0; column < amount + 1; column++) {    
                if (column == 0) {
                    tuples[row][column] =  new Tuple(numDenoms);                
                } else {    
                    if (column >= denominations[row]){
                        tuples[row][column] = new Tuple(numDenoms);
                        tuples[row][column].setElement(row, 1);  
                        if (tuples[row][column - denominations[row]].equals(Tuple.IMPOSSIBLE)) {
                            tuples[row][column] = Tuple.IMPOSSIBLE;
                        } else if (!tuples[row][column - denominations[row]].equals(Tuple.IMPOSSIBLE)) {
                            tuples[row][column] = tuples[row][column].add(tuples[row][column-denominations[row]]);
                        }
                    } else {
                        tuples[row][column] = Tuple.IMPOSSIBLE;
                    }                  
                }

                if (row != 0) {
                    if (!tuples[row][column].equals(Tuple.IMPOSSIBLE)) {
                        if (tuples[row - 1][column].equals(Tuple.IMPOSSIBLE)) {
                        } else if (!tuples[row - 1][column].equals(Tuple.IMPOSSIBLE)) {
                            if (tuples[row - 1][column].total() < tuples[row][column].total()) {
                                 tuples[row][column] = tuples[row - 1][column];
                            } else {
                            } 
                        }
                    } else {                        
                        if (!(tuples[row - 1][column].equals(Tuple.IMPOSSIBLE))) {
                            tuples[row][column] = tuples[row - 1][column];
                        }
                    } 
                } 
            }
        }
        return tuples[numDenoms - 1][amount];
    }
    
}
