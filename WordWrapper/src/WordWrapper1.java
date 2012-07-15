public class WordWrapper1 {

	// http://thecleancoder.blogspot.co.uk/2010/10/craftsman-62-dark-path.html

	//@formatter:off
	// You write a class called Wrapper, that has a single static function named wrap that takes 
	// two arguments, a string, and a column number. The function returns the string, but with line 
	// breaks inserted at just the right places to make sure that no line is longer than the column number. 
	// You try to break lines at word boundaries if possible!"
	//@formatter:on

	public static String wrap(final String s, final int col) {
		if (s.length() <= col) {
			return s;
		}
		return s.replaceAll(" ", "\n");
	}

	//@formatter:off
	// Stage 1:
	// 
	// Solve the task aim to solve the following criteria,
	// if you don't agree with the test data pick your worn, 
	// you have 10mins.
	
	// Data:
	// ---------------------------------------------------
	// Input 			-	Col		- Ouput
	// ---------------------------------------------------
	// word				-	10		- word
	// word word 		- 	6		- word\nword
	// word word word 	- 	6		- word\nword\nword
	// word word word 	- 	11		- word word\nword
	//
	// Stage 2:
	//
	// Create a new test suit and archive your existing Wrapper implementation
	// 
	// Solve the task by picking the part of the problem thats doesn't deal with spaces.
	//
	// Data:
	// ---------------------------------------------------
	// Input 			-	Col		- Ouput
	// ---------------------------------------------------
	// ""				-	1		- ""
	// word				- 	10		- word
	// word			 	- 	2		- wo\nrd
	// abcdefghij	 	- 	3		- abc\ndef\nghi\nj
	//
	//
	// Stage 3:
	// 
	// Add back in tests with spaces
	//
	// Data:
	// ---------------------------------------------------
	// Input 			-	Col		- Ouput
	// ---------------------------------------------------
	// ""				-	1		- ""
	// word word		- 	5		- word\nword
	// word word		- 	6		- word\nword
	// word word		- 	3		- wor\nd\nwor\nd
	// word word		- 	4		- word\nword
	// 
	// 
	// Next time you get stuck and start guessing and 'winging it', 
	// I'm going to re-evaluate the tests
	// Is there always a simpler test that'll get me unstuck?
	//
	//@formatter:on

}
