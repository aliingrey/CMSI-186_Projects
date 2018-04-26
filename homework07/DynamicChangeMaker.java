/**
 *  File name     :  DynamicChangeMaker.java
 *  Purpose       :  
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
            printUsage();
            return;
        }
        try {
            String[] coinsStrings = args[0].split(",");
            int[] coins = new int[coinsStrings.length];

            for (int i = 0; i < coins.length; i++) {
                coins[i] = Integer.parseInt(coinsStrings[i]);
                if (coins[i] <= 0) {
                    System.out.println("coins must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (coins[j] == coins[i]) {
                        System.out.println("Duplicate coins are not allowed.\n");
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
            Tuple change = makeOptimalAmount(coins, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those coins.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < coins.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + coins[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("coins and amount must all be integers.\n");
            printUsage();
        }
    }
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {

    }
}