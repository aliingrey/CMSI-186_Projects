/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Ali Ingrey
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
    @version 1.0.1  2018-02-22  Ali Ingrey    Submitted for Homework 03
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

//can do ds[x].roll();

public class DiceSet {
  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null; //creates an array of dice objects
   
   private int diceSum = 0;


  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int c, int s ) { // Constructor for a set of k dice each with n-sides (k ≥ 1 and n ≥ four)
    ds = new Die[ c ];
    count = c;
    sides = s;
    if (count < 1) {
        throw new IllegalArgumentException("You don't have enough die");
    }

    for (int i = 0; i < c; i ++) {
        ds[i] = new Die(s);
      }
   }

 
  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
    diceSum = 0; 
    for (int i = 0; i < count; i++) {
        diceSum += ds[i].getValue();
     }
    return diceSum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() { 
    for (int i = 0; i < count; i ++) {
        ds[i].roll();
    }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
    return ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
       String result = "{" ;
       for (int i = 0; i < count; i++) {
           result += ds[i].toString();
        }
       result += "}";
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds1 ) {
    return ds1.toString();
   }


  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds2) {
    if (this.sides == ds2.sides) {
        if (this.count == ds2.sides) {
            if (this.sum() == ds2.sum() ) {
                return true;
            }
        }
    }
      return false;
    } 
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      System.out.println("\nWelcome to DiceSet.java!");
      
      DiceSet ds = new DiceSet(4, 6);
      ds.roll();
      
      String result = new String();
      System.out.println("\nHere is your dice set:  " + ds.toString());
      
      DiceSet ds2 = new DiceSet(4, 6);
      ds2.roll();
      
      System.out.println("\nindividual dice at position 1: " + ds.getIndividual(0)); 
      System.out.println("Roll individual dice at position 1: " + ds.rollIndividual(0));
      System.out.println("Here is your new dice set with the dice at position 1 rolled again:  " + ds.toString());
      
      System.out.println("\nindividual dice at position 2: " + ds.getIndividual(1)); 
      System.out.println("Roll individual dice at position 2: " + ds.rollIndividual(1));
      System.out.println("Here is your new dice set with the dice at position 2 rolled again:  " + ds.toString());
      
      System.out.println("\nindividual dice at position 3: " + ds.getIndividual(2)); 
      System.out.println("Roll individual dice at position 3: " + ds.rollIndividual(2));
      System.out.println("Here is your new dice set with the dice at position 3 rolled again:  " + ds.toString());
      
      System.out.println("\nindividual dice at position 4: " + ds.getIndividual(3)); 
      System.out.println("Roll individual dice at position 4: " + ds.rollIndividual(3));
      System.out.println("Here is your new dice set with the dice at position 4 rolled again:  " + ds.toString());
      
      System.out.println("\nthe sum of your dice set:  " + ds.sum() );
      
      System.out.println("\nHere is your second dice set:  " + ds2.toString());
      System.out.println("the sum of your second dice set:  " + ds2.sum() );
      System.out.println("the first dice set is identical to the second dice set: " + ds.isIdentical(ds2) );
   }

}
