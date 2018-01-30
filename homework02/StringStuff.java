import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {


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


   public static boolean isPalindrome( String s ) {
      String reverse = new String (""); //empty string to add to 
      for (int i = s.length() - 1; i > -1; i--) {
          reverse = reverse + s.charAt(i);
          //System.out.println(reverse);
      }
      if (s.equals(reverse)) {
          return true;
        } else {
          return false;
        }
   }
