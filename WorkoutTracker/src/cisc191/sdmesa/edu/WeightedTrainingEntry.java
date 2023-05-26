package cisc191.sdmesa.edu;

/**
 * Lead Author(s):
 * 
 * @author Kenneth Rathbun : 0005493428
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-
 *         java-object-oriented-problem-solving
 *         <<Add more references here>>
 *
 *         Version: v1
 * 
 *         Responsibilites:
 *         - This class represents a data entry for a weighted strength training
 *         workout, including the weight, sets, and repetitions.
 */

// A WeightedTrainingEntry is a StrengthTrainingEntry and is Weighted
public class WeightedTrainingEntry extends StrengthTrainingEntry
		implements Weighted
{
	// A weighted training entry has a weight
	private int weight;

	/**
	 * Constructs a new WeightedTrainingData object with default values.
	 */
	public WeightedTrainingEntry()
	{
	}

	/**
	 * Constructs a new WeightedTrainingData object with the specified weight,
	 * sets, and repetitions.
	 *
	 * @param weight the weight used in the weighted strength training workout
	 * @param sets   the number of sets in the weighted strength training
	 *               workout
	 * @param reps   the number of repetitions in each set of the weighted
	 *               strength training workout
	 */
	public WeightedTrainingEntry(int weight, int sets, int reps)
	{
		super(sets, reps);
		this.weight = weight;
	}

	/**
	 * Returns the weight used in the weighted strength training workout.
	 *
	 * @return the weight
	 */
	public int getWeight()
	{
		return weight;
	}

	/**
	 * Sets the weight used in the weighted strength training workout.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	/**
	 * Displays the weighted strength training workout data entry.
	 */
	@Override
	public void printEntry()
	{
		System.out.println(bulletPoint + " Weight: " + this.weight
				+ "lbs | Sets: " + this.getSets() + " | Reps: " + this.getReps()
				+ " | " + this.getDate());

	}
}
