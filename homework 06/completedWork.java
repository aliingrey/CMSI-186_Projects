/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  Ali Ingrey
 * Date       :  Spring 2018
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
//https://silentmatt.com/blog/2011/10/how-bigintegers-work/
//string builder:    https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html

public class BrobInt {

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( new Integer( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( new Integer( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( new Long( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( new Long( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   private String internalValue = "";        // internal String representation of this BrobInt
   private String reversed;        // the backwards version of the internal String representation
   private byte[] byteVersion   = null;      // byte array for storing the string values; uses the reversed string


  // private static final int CHARS_THAT_FIT = 8;
   private int[] values = null;
   private int[] sectionArray = null;
   private int[] sum = null;
   private int[] difference = null;
   private int[] smaller = null;
   private int[] bigger = null;

   private boolean isNegative;

   //private int sum = 0;
   private int carry;
   private String newBrobIntString;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
    if (validateDigits(value) == true) {
      if (value.charAt(0) == '+') {
        value = value.substring(1);
        isNegative = false;

      } 
      if  (value.charAt(0) == '-') {
        value = value.substring(1);
        isNegative = true;
      }

      internalValue = value;
      int size = value.length();
      sectionArray = new int[size];
        
      int j = 0; //creates array and puts values in reverse order
      for (int i = size - 1; i >= 0; i--) {
        sectionArray[i] = value.charAt(j) - 48;
        j++;
      }
      //toArray( sectionArray );
    } else {
      System.out.println("Numbers can't be converted");
      System.exit(1);
    }
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits(String value) {
    if (value.charAt(0) == '+' || value.charAt(0) == '-') {
        try {
          double d = Double.parseDouble( value.substring(1) );
        } catch (NumberFormatException nfe) {
          return false;
        }
        internalValue = value.substring(1);
    } else {
      try {
        double d = Double.parseDouble( value );
      } catch (NumberFormatException nfe) {
        return false;
      }
      //internalValue = value.substring(0);
     return true;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt reverser(String value) { 
    StringBuffer sb;
    if (value.charAt(0) == '+' || value.charAt(0) == '-') {
      sb = new StringBuffer( value.substring(1) ).reverse();
    } else {
      sb = new StringBuffer( value ).reverse();
    }
    return new BrobInt (sb.toString());
   }

   public BrobInt reverser() {
     return new BrobInt(new StringBuffer( internalValue ).reverse().toString());
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  gint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  gint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  public int getLength() {
    return sectionArray.length;
  }

  public int[] getArray() {
    return sectionArray;
  }

  public boolean isNegative() {
    return isNegative;
  }

  public void addSetUp ( BrobInt b1 ) { //sets up which int is longer, sets their places, and sets sum length
    int length1 = b1.getLength();
    int argLength = this.getLength();
    int sum[];
    int smaller[];
    int carry = 0;
    if (length1 > argLength) {
      sum = new int[length1 + 1];
      smaller = new int[argLength];
    } else {
      sum = new int[argLength + 1];
      smaller = new int[length1];
    }
  }

  public BrobInt add( BrobInt b1 ) { //performs addition
    int array1[] = b1.getArray();
    String value = "";

    if (!b1.isNegative() && !this.isNegative) { //both positive
      for (int i = 0; i < smaller.length; i++) {
        sum[i] = array1[i] + sectionArray[i] + carry;
        carry = sum[i] / 10;
        sum[i] = sum[i] % 10;
      }
      for (int i = 0; i <= sum.length - 1; i ++) {
        value += sum[i];
      }
      return new BrobInt(value);
    }

    if (b1.isNegative() && this.isNegative) {//both negative
      for (int i = 0; i < smaller.length; i++) {
        sum[i] = array1[i] + sectionArray[i] + carry;
        carry = sum[i] / 10;
        sum[i] = sum[i] % 10;
      }
      value = "-";
      for (int i = 0; i <= sum.length - 1; i ++) {
        value += sum[i];
      }
      return new BrobInt(value);
    }
    if (b1.isNegative() && !this.isNegative) { //subtract this
      return b1.subtract(this);
    }
    if (!b1.isNegative() && this.isNegative) {//subtract b1
      return this.subtract(b1);
    }

    return new BrobInt(value);
  }
   

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using bytes
   *  @param  gint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  
   public BrobInt subtract( BrobInt b1 ) {
    int length1 = b1.getLength();
    int argLength = this.getLength();
    int array1[] = b1.getArray();

    int difference[];
    int carry;

    if (b1.isNegative() && !this.isNegative()) {
      BrobInt tempThis = new BrobInt(this.toString());
      BrobInt tempb1 = new BrobInt(b1.toString());
      tempb1.makePositive();
      return tempThis.add(tempb1);
    }

    if (!b1.isNegative() && this.isNegative()) {
      BrobInt tempThis = new BrobInt(this.toString());
      BrobInt tempb1 = new BrobInt(b1.toString());
      tempThis.makeNegative();
      return tempThis.add(tempb1);

    }

    if (b1.isNegative() && this.isNegative()) { //both negative
      BrobInt tempThis = new BrobInt(this.toString());
      BrobInt tempb1 = new BrobInt(b1.toString());
      tempb1.makePositive();
      tempThis.makePositive();
      return tempb1.subtract(tempThis);
    }
  
    if (argLength > length1) {
      difference = new int[argLength];
      for (int i = 0; i < length1; i++) {
        difference[i] = array1[i] - sectionArray[i];
        if (difference[i] < 0) {
          array1[i + 1] = array1[i + 1] - 1;
          difference[i] = (array1[i] + 10) - sectionArray[i];
        }
      }
      for (int i = length1; i < argLength; i++) {
        diff[i] = array1[i];
        String value = "-";
        for (int i = difference.length - 1; i >= 0; i--) {
          value += difference[i];
          return new BrobInt(value);
        }
      }
    } else if (argLength < length1) {
      difference = new int[length1];
      for (int i = 0; i < argLength; i++) {
        difference[i] = sectionArray[i] - array1[i];
        if (difference[i] < 0) {
          sectionArray[i + 1] = sectionArray[i + 1] - 1;
          difference[i] = (sectionArray[i] + 10) - array[i];
        }
      }
      for (int i = length1; i < argLength; i++) {
        diff[i] = array1[i];
        String value = "-";
        for (int i = difference.length - 1; i >= 0; i--) {
          value += difference[i];
          return new BrobInt(value);
        }
      }
    } else {
      diff = new int[length1];
      if (b1.compareTo(this) > 0) {
        difference[i] = array1[i] - sectionArray[i];
        if (difference[i] < 0) {
          array1[i + 1] = array1[i + 1] - 1;
          difference[i] = (array1[i] + 10) - sectionArray[i];
        }
      }
    }

    if (!b1.isNegative() && !this.isNegative) { //neither has a sign
      if (argLength > length1) { //this is longer, therefore is greater -- simple subrtraction
        difference = new int[argLength];
        for (int i = 0; i < difference.length; i++) {
          difference[i] = array1[i] - sectionArray[i];
          if (difference[i] < 0) {
            carry = difference[i];
            difference[i] = difference[i] % 10;
          }
        }
      } 
      if (argLength < length1) { //b1 is longer, therefore is greater -- simple subrtraction
        difference = new int[length1];
        for (int i = 0; i < difference.length; i++) {
          difference[i] = sectionArray[i] - array1[i];
          if (difference[i] < 0) {
            carry = difference[i];
            difference[i] = difference[i] % 10;
          }
        }
      }
      if (argLength = length1) {
        int compareVal = b1.compareTo(this);
        if (compareVal > 0) { //this is greater
          //difference = new int[argLength];
          for (int i = 0; i < length1; i++) {
            difference[i] = array1[i] - sectionArray[i];
            if (difference[i] < 0) {
              array1[i + 1] = array1[i + 1] - 1;
              difference[i] = (array1[i] + 10) - sectionArray[i];
            }
          }
          String value = "-";
          for (int i = 0; i < difference.length; i--) {
            value += difference[i];
            return new BrobInt(value);
          }


        }
        else {
          return new BrobInt("0");
        }
        if (compareVal < 0) { //b1 is greater

        }
        if (compareVal = 0) { //same
          difference = 0;
        }
    }

    String value = "";
    for (int i = 0; i <= difference.length; i ++) {
      value += difference[i];
    }

    return new BrobInt(value);
    
  }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   * DONE, freebie
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt gint ) {
      return (internalValue.compareTo( gint.toString() ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  DONE, freebie
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt gint ) {
      return (internalValue.equals( gint.toString() ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  DONE, freebie
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt gi = null;
      try {
         gi = new BrobInt( new Long( value ).toString() );
      }
      catch( NumberFormatException nfe ) {
         System.out.println( "\n  Sorry, the value must be numeric of type long." );
      }
      return gi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  might need tweaking, this one focuses on it as a series of bites
   *  could do another one with an argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
    if (internalValue.charAt(0) == '0' && internalValue.length() > 1) {
      internalValue = internalValue.substring(1);
    }
    if (isNegative == true) {
      internalValue = "-" + internalValue;
    }
    return internalValue;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( int[] d ) {

    System.out.println( Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  note:  we don't really care about these
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      BrobInt g1 = new BrobInt( "456789" );
      BrobInt g2 = new BrobInt( "1234" );
      System.out.println("toString " + g1.toString());
      g1.addSetUp(g2);
      System.exit( 0 );
   }
}
