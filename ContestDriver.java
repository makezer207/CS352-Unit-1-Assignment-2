/*
Mitchell Kezer
Student ID: 1486912
November 1, 2026
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random; 

public class ContestDriver {

	public static void main(String[] args) {
		System.out.println("Starting Simulation...");
		System.out.println();

		// Step -1 Compile the program as is to be sure it runs

		// Step 0 - Uncomment the two lines below, then add code to the Contestant class to make this compile
		// This creates a single Contestant and prints its attributes, just to show it can be done
		
		/* Contestant ac = new Contestant("Billy",22);
		System.out.println(ac);
		System.out.println();
		*/
		
		// Step 2
		// Create multiple Contestants and add them to an ArrayList
		// Do something simple to get started, but remember, you will need
		// to generate up to 1,000,000 Contestants	
		

		/*
		The code below creates an ArrayList of Contestants and adds 'n' Contestants to it, starting from the 
		1 position with "Contestant1" and ends with "Contestant'n'". You will easily be able to change the 
		number of Contestants created by changing the value of `n`. Also will output 
		how many Contestants are in the ArrayList.
		*/

		/* 
		This is the ArrayList from Assignment 1

		int n = 45000;
		ArrayList<Contestant> contestants = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			Contestant c = new Contestant("Contestant " + (i + 1), 20 + i);
			contestants.add(c);
		}

		System.out.println("Contestants in the Array List: " + contestants.size());
		System.out.println();
		*/ 
		


		/*
		The code below creates a LinkedList of Contestants and adds 'n' Contestants to it, starting from the 1 position 
		with "Contestant1" and ends with "Contestant'n'". You will easily be able to change the number of Contestants 
		created by changing the value of `n`.
		*/

		int n = 43;
		LinkedList<Contestant> contestants = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			Contestant c = new Contestant("Contestant " + (i + 1), 20 + i);
			contestants.add(c);
		}



		// Steps 3 and 4
		// Play a round
		// For each Contestant, flip a coin, then move the Contestant to
		// one end of the ArrayList or the other.

		/*
		This is where you can test the flipCoin() method. You can change the value of `testingFlips` to test 
		how many times you want to flip the coin. The code will output how many times the coin was flipped either
		correctly or incorrectly, for the purpose of say contestants answering questions correctly or incorrectly. 
		
		int testingFlips = 10_000;
		int correctCount = 0;
		for (int i = 0; i < testingFlips; i++) {
			if (flipCoin()) {
				correctCount++;
			}
		}
		int incorrectCount = testingFlips - correctCount;
		System.out.println();
		System.out.println("Coin Flip Testing:");
		System.out.println("Correct: " + correctCount);
		System.out.println("Incorrect: " + incorrectCount);
		System.out.println();
		*/

		// Steps 3 and 4
		// Play a round
		// For each Contestant, flip a coin, then move the Contestant to
		// one end of the ArrayList or the other.

		/*
		This grabs the ArrayList method to get the initial position of the Contestants, then it loops through each
		Contestant and flips a coin to determine if they answered a question correctly or incorrectly. 
		If they answered correctly, they are moved to the front of the ArrayList, if not, they are moved to the end
		of the list. The code will output the Contestant's name and their new position in the ArrayList after each round
		or in this case just one.
		*/

		/*
		ArrayList<Contestant> initialPosition = new ArrayList<>(contestants);

		for (Contestant contestant : initialPosition) {
			boolean correct = flipCoin();

			contestants.remove(contestant);

			if (correct) {
				contestants.add(0, contestant);
				System.out.println(contestant.getName() + " answered correctly and moved to the front.");
			}
			else {
				contestants.add(contestant); 
				System.out.println(contestant.getName() + " answered incorrectly and moved to the end.");
			}
		}

		System.out.println("\nContestant position after the round:");
		System.out.println();
		for (int i = 0; i < contestants.size(); i++) {
			Contestant contestant = contestants.get(i);
			System.out.println(contestant.getName() + " is in position " + (i));
		}
		*/

		// Steps 5 - 7
		// Repeat Steps 3 and 4 many times to gather data.
		// You will need to modify the Contestant class so each Contestant
		// will keep track of its individual statistics. Be smart about how you record its
		// position at the end of each round.
		
		/*
		The code below simulates multiple rounds of the game, where each Contestant's position is recorded 
		after each round.
		This is code from Assignment 1.

		int rounds = 100000;

		long startTime = System.nanoTime();

		for (int round = 1; round <= rounds; round++) {
			ArrayList<Contestant> roundStartOrder = new ArrayList<>(contestants);

			for (Contestant contestant : roundStartOrder) {
				boolean correct = flipCoin();

				contestants.remove(contestant);

				if (correct) {
					contestants.add(0, contestant);
				}
				else {
					contestants.add(contestant); 
				}
			}
		
		for (int position = 0; position < contestants.size(); position++) {
			contestants.get(position).recordPosition(position);
		}
		}
		*/


		/*
		The code below simulates multiple rounds of the game, where each Contestant's position is recorded after each round. 
		This is code from Assignment 2, which uses a LinkedList instead of an ArrayList for better performance when 
		adding/removing elements from the list.
		*/

		int rounds = 100000;

		long startTime = System.nanoTime();

		for (int round = 1; round <= rounds; round++) {
			LinkedList<Contestant> roundStartOrder = new LinkedList<>(contestants);

			for (Contestant contestant : roundStartOrder) {
				boolean correct = flipCoin();

				contestants.remove(contestant);

				if (correct) {
					contestants.addFirst(contestant);
				}
				else {
					contestants.addLast(contestant); 
				}
			}

			int position = 0;
			for (Contestant contestant : contestants) {
				contestant.recordPosition(position);
				position++;
			}
		}


		/*
		The code below measures the time taken to simulate the specified number of rounds. It uses System.nanoTime()
		to record the start and end time of the simulation, then calculates the duration in nanoseconds, then converts 
		it to milliseconds for easier readability. 
		*/

		long endTime = System.nanoTime();
		long duration = endTime - startTime;

		System.out.printf("Time taken to simulate %d rounds: %d ns (%.2f ms)%n", rounds, duration, duration / 1_000_000.0);

		/*
		The code below prints the average position of each Contestant after the specified number of rounds. It 
		loops through the ArrayList of Contestants and calls the getAveragePosition() method for each Contestant 
		to calculate and print their average position in the game. The output is formatted to show the Contestant's 
		name and their average position rounded to two decimal places for the sake of simplicity.
		
		System.out.println("Average position of each Contestant after " + rounds + " rounds:");
		System.out.println();

		for (Contestant contestant : contestants) {
			System.out.printf("%s: %.2f%n", contestant.getName(), contestant.getAveragePosition());
		}
		*/

		System.out.println();
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