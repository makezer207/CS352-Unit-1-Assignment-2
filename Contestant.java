/* Contestant.java:  
 * This class extends Person while adding attributes and methods
 * related to recording performance in the specified contest. 
 *     
 * Author: Mitchell Kezer Student ID: 1486912
 * Last updated: 
 */
public class Contestant extends Person {
	// A Contestant IS-A Person
	// that also needs needs to keep track of data related to the game
	// Start simple to get your program running, then add attributes and methods as you need them
	
	// Step 1 Add at least one constructor so the driver will compile and run

	// The code below calls the constructor of the superclass (Person) to initialize name and age
	public Contestant(String name, int age) { 
		super(name, age);
	}
	
	// Step 5 Add attributes and methods to assist with recording game statistics

	/*
	The code below adds attributes and methods to record the position of the Contestant in the game. The 
	recordPosition method is used to update the total position and number of positions recorded, while the 
	getAveragePosition method calculates and returns the average position of the Contestant.
	*/
	
	private long contestantPosition;
	private int numberOfPosition;

	public void recordPosition(int position) {
		contestantPosition += position;
		numberOfPosition++;
	}

	public double getAveragePosition() {
		if (numberOfPosition == 0) {
			return 0.0;
		}
		return (double) contestantPosition / numberOfPosition;
	}
}