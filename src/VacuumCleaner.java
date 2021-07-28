/*
 * Stuart Wyse
 * wysesh
 * n
 * CSE 486 - HW1
 */

public class VacuumCleaner {
	
	// an integer 'score' to keep track of the vacuum's performance
	public static int score = 0;

	public static void main(String[] args) {
		boolean[] isDirty = new boolean[4];		

		// set original squares to dirty or clean
		setState(isDirty);
		
		// run the vacuum with the appropriate P and S values
		System.out.println("Performance for S = 0% & P = 10%: " + runVacuum(0, .1, isDirty));
		System.out.println("Performance for S = 25% & P = 10%: " + runVacuum(.25, .1, isDirty));
		System.out.println("Performance for S = 100% & P = 10%: " + runVacuum(1, .1, isDirty));
		System.out.println("Performance for S = 0% & P = 90%: " + runVacuum(0, .9, isDirty));
		System.out.println("Performance for S = 25% & P = 90%: " + runVacuum(.25, .9, isDirty));
		System.out.println("Performance for S = 100% & P = 90%: " + runVacuum(1, .9, isDirty));

	}
	
	
	// method that runs the vacuum around the squares for 2000 time intervals
	// returns the vacuum's score aka performance measure
	public static int runVacuum(double s, double p, boolean[] isDirty) {
		boolean isForward = true; // keeps track of vacuum's moving direction
		int square = 0;
		score = 0; // reset the score before each run
		
		// vacuum runs for 2000 time steps
		for(int i = 0; i < 2000; i++) {
			
			// set square states (dirty or clean) at beginning of each time step
			setState(isDirty);
			
			// check if square is dirty or clean - will have p% chance of correctly determining
			// use Math.random() - if it is < p, correct judgment
			double chanceCorrect = Math.random();
			
			// vacuum correctly got square's status
			if(chanceCorrect <= p) {
				if(isDirty[square]) {
					// suck - will actually clean s% of time
					double didClean = Math.random();
					if(didClean <= s) {
						isDirty[square] = false;
					}
				}
				
				// if square isn't dirty, move the vacuum
				else {
					if(isForward == true && square < 3) square++;
					else if(isForward == false && square > 0) square--;
					else if(isForward == true && square == 3) {
						isForward = false;
						square --;
					} else if(isForward == false && square == 0) {
						isForward = true;
						square++;
					} else System.err.println("This isn't right.");
				}
			}
			
			// vacuum incorrectly gets square's state and does wrong action
			else {
				// if square is dirty, move vacuum
				if(isDirty[square]) {
					if(isForward == true && square < 3) square++;
					else if(isForward == false && square > 0) square--;
					else if(isForward == true && square == 3) {
						isForward = false;
						square --;
					} else if(isForward == false && square == 0) {
						isForward = true;
						square++;
					} else System.err.println("This isn't right.");
				}
				// if square is clean, suck 
				// nothing to actually clean, so just go to next time step
				else continue;
			}
			score += getScore(isDirty);
		}
		
		return score;
	}	
	
	// method to set each square to either dirty (true) or clean (false)
	// for each square, there is a 20% chance that it will be dirty
	public static void setState(boolean[] isDirty) {
		for(int i = 0; i < isDirty.length; i++) {
			double chance = Math.random();
			if(chance <= .2) isDirty[i] = true;
			else isDirty[i] = false;
		}
	}
	
	// method that returns the # of clean squares
	public static int getScore(boolean[] isDirty) {
		int cleanSquares = 0;
		for(int i = 0; i < isDirty.length; i++) {
			if(isDirty[i] == false) cleanSquares++;
		}
		return cleanSquares;
	}
}
