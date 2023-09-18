import java.util.Random;

/**
 * Runs simulations of the Monty Hall problem.
 * 
 * @author Ian Mays
 */
public class MontyHallSimulator {
	/**
	 * Estimates the probability of winning the game, with or without a door switch,
	 * by random sampling.
	 * @param trials The number of trials to run
	 * @param switchDoor After the host initially reveals one door, whether to switch
	 * to the other unopened door
	 * @return The proportion of simulations in which the contestant ended up picking
	 * the correct door
	 */
	public double test(int trials, boolean switchDoor) {
		Random random = new Random();
		int successes = 0;
		
		for (int i = 0; i < trials; i++) {
			int correctDoor = random.nextInt(3);
			int chosenDoor = random.nextInt(3);
			
			if (!switchDoor && correctDoor == chosenDoor) {
				successes++;
			} else if (switchDoor) {
				int doorOpenedByHost = correctDoor;
				
				//Make sure the host doesn't accidentally open the wrong door
				while (doorOpenedByHost == correctDoor || doorOpenedByHost == chosenDoor) {
					doorOpenedByHost = random.nextInt(3);
				}
				
				int j = 0;
				
				//Find the remaining unopened door (yes, this is not very efficient)
				while (j < 3 && (j == chosenDoor || j == doorOpenedByHost)) {
					j++;
				}
				
				chosenDoor = j;
				
				if (correctDoor == chosenDoor) {
					successes++;
				}
			}
		}
		
		return (double) successes/trials;
	}
}