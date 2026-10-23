/*
Mitchell Kezer
Student ID: 1486912
October 26, 2026
*/

import java.util.ArrayList;
import java.util.Random; 

public class ContestDriver {

	public static void main(String[] args) {
		System.out.println("Starting Simulation...");
		System.out.println();

		// Step -1 Compile the program as is to be sure it runs

		// Step 0 - Uncomment the two lines below, then add code to the Contestant class to make this compile
		// This creates a single Contestant and prints its attributes, just to show it can be done
		Contestant ac = new Contestant("Billy",22);
		System.out.println(ac);
		System.out.println();
		
		// Step 2
		// Create multiple Contestants and add them to an ArrayList
		// Do something simple to get started, but remember, you will need
		// to generate up to 1,000,000 Contestants	
		
		/*
		The code below creates an ArrayList of Contestants and adds 10 Contestants to it, stating from the 
		1 position with "Contestant1" and ends with "Contestant10". You will easily be able to change the 
		number of Contestants created by changing the value of `n`. Each has an age of 20-29. Also will output 
		how many Contestants are in the ArrayList.
		*/
		int n = 10;
		ArrayList<Contestant> contestants = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			Contestant c = new Contestant("Contestant" + (i + 1), 20 + i);
			contestants.add(c);
		}

		System.out.println("Contestants in the Array List: " + contestants.size());
		System.out.println();

		// Steps 3 and 4
		// Play a round
		// For each Contestant, flip a coin, then move the Contestant to
		// one end of the ArrayList or the other.

		/*
		This is where you can test the flipCoin() method. You can change the value of `testingFlips` to test 
		how many times you want to flip the coin. The code will output how many times the coin was flipped either
		correctly or incorrectly, for the purpose of say contestants answering questions correctly or incorrectly. 
		*/
		int testingFlips = 10_000;
		int correctCount = 0;
		for (int i = 0; i < testingFlips; i++) {
			if (flipCoin()) {
				correctCount++;
			}
		}
		int incorrectCount = testingFlips - correctCount;
		System.out.println("Coin Flip Testing:");
		System.out.println("Correct: " + correctCount);
		System.out.println("Incorrect: " + incorrectCount);
		System.out.println();

		// Steps 5 - 7
		// Repeat Steps 3 and 4 many times to gather data.
		// You will need to modify the Contestant class so each Contestant
		// will keep track of its individual statistics. Be smart about how you record its
		// position at the end of each round.
		System.out.println("Finished!");
	}

	private static final Random random = new Random();

	/**
	 * This method below simulates a coin flip.
	@return true or false, representing the result of a coin flip, with each having close to a 
	50% chance of being returned.
	*/
	private static boolean flipCoin() {
		return random.nextBoolean();
	}

}