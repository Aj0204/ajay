package wiprotraining;

public class TowerOfHanoi {	 
	 // Function to print the move
	 public static void moveDisk(int n, char fromPeg, char toPeg) {
	 System.out.println("Move disk " + n + " from " + fromPeg + " to " + toPeg);
	 }
	 // Recursive function to solve Tower of Hanoi puzzle
	 public static void solveTowerOfHanoi(int n, char sourcePeg, char destinationPeg, char auxiliaryPeg) {
	 if (n == 1) {
	 // Base case: only one disk to move
	 moveDisk(n, sourcePeg, destinationPeg);
	 return;
	 }
	 // Move n-1 disks from source to auxiliary, using destination as a temporary holding area
	 solveTowerOfHanoi(n - 1, sourcePeg, auxiliaryPeg, destinationPeg);
	 // Move the nth disk from source to destination
	 moveDisk(n, sourcePeg, destinationPeg);
	 // Move the n-1 disks from auxiliary to destination, using source as a temporary holding area
	 solveTowerOfHanoi(n - 1, auxiliaryPeg, destinationPeg, sourcePeg);
	 }
	 public static void main(String[] args) {
	 int numberOfDisks = 3; // Change this value to solve for a different number of disks
	 solveTowerOfHanoi(numberOfDisks, 'A', 'C', 'B');
	 }
	}
