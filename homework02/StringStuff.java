/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-19
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {
  
  private static final String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * @param s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {
       for (int i = 0; i < s.length(); i++) {
           if ((s.charAt(i) == 'a' ) || (s.charAt(i) == 'e')  || (s.charAt(i) == 'i') || (s.charAt(i) == 'o') || (s.charAt(i) == 'u') 
               || (s.charAt(i) == 'A' ) || (s.charAt(i) == 'E')  || (s.charAt(i) == 'I') || (s.charAt(i) == 'O' ) || (s.charAt(i) == 'U')) {
               return true;
           } else {
               if ((s.charAt(i) == 'y') || (s.charAt(i) == 'Y')) {
                   return true;
               }
            }      
       }
       return false;
   }

  /**
   * WORKS!
   */
   public static boolean isPalindrome( String s ) {
      String reverse = new String (""); //empty string to add to 
      for (int i = s.length() - 1; i > -1; i--) {
          reverse = reverse + s.charAt(i);
      }
      if (s.equals(reverse)) {
          return true;
        } else {
          return false;
        }
   }


  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
     String evens = "";
      for (int i = 0; i < s.length(); i++) {
     
             if ((upperCaseAlphabet.indexOf(s.substring(i, i + 1).toUpperCase()) + 1) % 2 == 0) {
                 evens += s.charAt(i);
             }
         
    
    }
      return evens;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {
      String odds = "";
      for (int i = 0; i < s.length(); i++) {
         if ((upperCaseAlphabet.indexOf(s.substring(i, i + 1).toUpperCase()) + 1) % 2 != 0) {
                 odds += s.charAt(i);
             }
      }
      return odds;
   }
