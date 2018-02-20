/*

Finally, make public class file HighRoll.java which uses your dice set to play the game. You will need to have a main that constructs the dice set, has rolls, and displays scores from each roll. The rules are as follows:

Implement a Textual User Interface (TUI) on the command line. This will display a list of options to the user, and will prompt for input. Based on that input your program will do what the user selected, then will display the results, a blank line or two, and then re-display the options.

Option 1 in the list must be: ROLL ALL THE DICE



Option 2 in the list must be: ROLL A SINGLE DIE
Option 3 in the list must be: CALCULATE THE SCORE FOR THIS SET
Option 4 in the list must be: SAVE THIS SCORE AS HIGH SCORE
Option 5 in the list must be: DISPLAY THE HIGH SCORE
Option 6 in the list must be: ENTER 'Q' TO QUIT THE PROGRAM
For option 2, you may present a second prompt to get the number of the die to roll, or you may handle it as two numbers on the entry. An example of the first method would be to enter a '2' at the prompt, then display a new prompt such as "which die?" and read the user input. An example of the second method would be to read "2 5" to re-roll only die number 5; this method means you must parse the input to get the die index.
To run the program, you can do one of two things: EITHER start the program using...
java HighRoll <number of dice> <number of sides> …OR
java HighRoll and prompt the user for the parameters.
See the notes below.

*/

public class HighRoll {
	DiceSet dSet = new DiceSet(6, 7); //without arguments (if args.length = 0) --> ask user
	//Option 1 in the list must be: ROLL ALL THE DICE call ds.roll();

} 


