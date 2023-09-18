/**
 * Runs the Monty Hall simulation 10,000 times each for switching and not switching
 * doors, and prints the approximate success rate in each scenario.
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