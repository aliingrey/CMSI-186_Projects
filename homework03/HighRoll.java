import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {
   private int currentScore;
   private int highScore;

    
   public static void main( String args[] ) {
   
    
    DiceSet dSet;
    
    System.out.println( "\n Welcome to Ali's Dice Rolling Game! \n" );
    System.out.println( "     Press the 'q' key to quit the program." );
    
    dSet = new DiceSet(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    if (args.length == 0) {
        //prompt for two arguments
        //create new DiceSet with arguments: dSet = new DiceSet(args[0], args[1]);
        //} else if (args.length == 2) {
        
        } else {
            System.out.println( "  Instructions: enter two numbers, so the first is <# of dice> and the second is <# of sides>" );
            //break
        }
    
    System.out.println( "type in the number of the following menu options you want to do: ");
    System.out.println( "Option 1 in the list must be: ROLL ALL THE DICE \n Option 2 in the list must be: ROLL A SINGLE DIE \n Option 3 in the list must be: CALCULATE THE SCORE FOR THIS SET \n Option 4 in the list must be: SAVE THIS SCORE AS HIGH SCORE Option 5 in the list must be: DISPLAY THE HIGH SCORE \n Option 6 in the list must be: ENTER 'Q' TO QUIT THE PROGRAM" );
        
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
        System.out.print( ">>" ); // display menu //get user input //system.exit = quit
        String inputLine = null;

        try {
             inputLine = input.readLine();
              if( 0 == inputLine.length() ) {
                   System.out.println("you didn't enter anything. enter some text!");
              }
                //System.out.println( "   You typed: " + inputLine );
              
              if('1' == inputLine.charAt(0) ) { //Option 1 in the list must be: ROLL ALL THE DICE
                  dSet.roll();
              }
              if('2' == inputLine.charAt(0) ) { //Option 2 in the list must be: ROLL A SINGLE DIE
                  
                  System.out.println( dSet );
                  System.out.println("would you like to roll an individual dice?" );
                  
                  if ( ('Y' == inputLine.charAt(0) ) || ('y' == inputLine.charAt(0) ) ) {
                      System.out.println("which dice would you like to roll?" );
                      rollIndividual( inputLine.charAt(0) );
                    } 
                  
                  //rollIndividual( int dieIndex ) 
                  
                  /*
                  * For option 2, you may present a second prompt to get the number of the die to roll, 
                  * or you may handle it as two numbers on the entry. 
                  An example of the first method would be to enter a '2' at the prompt, 
                  then display a new prompt such as "which die?" and read the user input. 
                  An example of the second method would be to read "2 5" to re-roll only die number 5; 
                  this method means you must parse the input to get the die index.
                  To run the program, you can do one of two things: EITHER start the program using...
                  java HighRoll <number of dice> <number of sides> …OR
                    java HighRoll and prompt the user for the parameters.
                    See the notes below
                  */
                 //System.out.println( dSet.rollIndividual() );
              }
              if('3' == inputLine.charAt(0) ) { //Option 3 in the list must be: CALCULATE THE SCORE FOR THIS SET
                  dSet.sum();
              }
              if('4' == inputLine.charAt(0) ) { //Option 4 in the list must be: SAVE THIS SCORE AS HIGH SCORE
                  //highScore = dSet.sum();
              }
              if('5' == inputLine.charAt(0) ) { //Option 5 in the list must be: DISPLAY THE HIGH SCORE
                  //System.out.println("highscore: " + highScore);
              }
              if(( 'q' == inputLine.charAt(0) ) || ( 'Q' == inputLine.charAt(0) ) || ('6' == inputLine.charAt(0) )) { //Option 6 in the list must be: ENTER 'Q' TO QUIT THE PROGRAM
                   break;
              }
            } catch( IOException ioe ) {
                System.out.println( "Caught IOException" );
             }
          }
	}

}

