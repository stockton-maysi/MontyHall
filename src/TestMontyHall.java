/**
 * Runs the Monty Hall simulation 10,000 times each for switching and not switching
 * doors, and prints the approximate success rate in each scenario.
 * 
 * Answers to 2.20:
 * A. Events G, D1, and D2 each have a probability of 1/3, and so the contestant has
 * a 1/3 chance of picking the door/curtain/whatever with the car.
 * B-i. 1/3
 * B-ii. Dud
 * B-iii. Good prize
 * B-iv. 2/3
 * B-v. Switch to the other curtain
 * 
 * @author Ian Mays
 */
public class TestMontyHall {
	public static void main(String[] args) {
		MontyHallSimulator simulator = new MontyHallSimulator();
		double withoutSwitch = simulator.test(10000, false);
		double withSwitch = simulator.test(10000, true);
		System.out.printf("Without switch: %.2f%%\nWith switch: %.2f%%", withoutSwitch*100, withSwitch*100);
	}
}