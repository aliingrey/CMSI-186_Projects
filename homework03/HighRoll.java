import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {
   private static int highScore;

   private static DiceSet dSet;

   public static void main( String args[] ) {
   
   System.out.println( "\nWelcome to Ali's Dice Rolling Game! \n" );
    
    if (args.length == 0) {
    	System.out.println("Usage Instructions - java HighRoll enter two numbers: <# dice> <# sides>");
    	System.exit(-1);
    }

    dSet = new DiceSet(Integer.parseInt(args[0]), Integer.parseInt(args[1]) );
      
    BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

    while( true ) {
    	System.out.println( "Type in the number of the following menu options you want to do:");
   		System.out.println( "\n Option 1 in the list must be: ROLL ALL THE DICE \n" + 
    					" Option 2 in the list must be: ROLL A SINGLE DIE \n" +
    					" Option 3 in the list must be: CALCULATE THE SCORE FOR THIS SET \n" + 
    					" Option 4 in the list must be: SAVE THIS SCORE AS HIGH SCORE   \n" +
    					" Option 5 in the list must be: DISPLAY THE HIGH SCORE \n" +
    					" Option 6 in the list must be: ENTER 'Q' TO QUIT THE PROGRAM" );
        System.out.print( ">>" ); 
        String inputLine = null;

        try {
             inputLine = input.readLine();

              if( 0 == inputLine.length() ) {
                System.out.println("You didn't enter anything. Enter a number for a menu option!");

              } else if('1' == inputLine.charAt(0) ) { //Option 1 in the list must be: ROLL ALL THE DICE
                dSet.roll();
              	System.out.println("You rolled the dice! here's your roll: " + dSet.toString() );

              } else if('2' == inputLine.charAt(0) ) { //Option 2 in the list must be: ROLL A SINGLE DIE
                  System.out.println("Your dice set is: " + dSet + "Choose which number dice you would like to roll again.");
                  BufferedReader newInput = new BufferedReader( new InputStreamReader( System.in ) );
                  String userChoice = newInput.readLine();
                     // System.out.println("your roll is: " + dSet.rollIndividual( Integer.parseInt(inputLine) - 1 ))
                  dSet.rollIndividual( Integer.parseInt(userChoice) - 1 );
                  System.out.println("Your dice set is: " + dSet);

              } else if('3' == inputLine.charAt(0) ) { //Option 3 in the list must be: CALCULATE THE SCORE FOR THIS SET
                  System.out.println("the sum of your dice is: " + dSet.sum() );

              } else if('4' == inputLine.charAt(0) ) { //Option 4 in the list must be: SAVE THIS SCORE AS HIGH SCORE
                  highScore = dSet.sum(); //highscore ref from static context
                  System.out.println("Your score " + highScore + "is saved.");

              } else if('5' == inputLine.charAt(0) ) { //Option 5 in the list must be: DISPLAY THE HIGH SCORE
                  System.out.println("highscore: " + highScore);

              } else if(( 'q' == inputLine.charAt(0) ) || ( 'Q' == inputLine.charAt(0) ) || ('6' == inputLine.charAt(0) )) { //Option 6 in the list must be: ENTER 'Q' TO QUIT THE PROGRAM
                   System.exit(0);
              }

            } catch( IOException ioe ) {
                System.out.println( "Caught IOException" );
            }

          }
	}

}

