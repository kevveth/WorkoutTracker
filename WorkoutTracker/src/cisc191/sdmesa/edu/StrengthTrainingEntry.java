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
 *         - This class represents a data entry for a strength training workout,
 *         including the sets and repetitions.
 */

public class StrengthTrainingEntry extends WorkoutEntry
{
	// A strength training workout has sets
	private int sets;

	// A strength training workout has repetitions
	private int reps;

	/**
	 * Constructs a new StrengthTrainingData object with default values.
	 */
	public StrengthTrainingEntry()
	{
	}

	/**
	 * Constructs a new StrengthTrainingData object with the specified sets and
	 * repetitions.
	 *
	 * @param sets the number of sets in the strength training workout
	 * @param reps the number of repetitions in each set of the strength
	 *             training workout
	 */
	public StrengthTrainingEntry(int sets, int reps)
	{
		super();
		this.sets = sets;
		this.reps = reps;
	}

	// Getters

	/**
	 * Returns the number of sets in the strength training workout.
	 *
	 * @return the number of sets
	 */
	public int getSets()
	{
		return sets;
	}

	/**
	 * Returns the number of repetitions in each set of the strength training
	 * workout.
	 *
	 * @return the number of repetitions
	 */
	public int getReps()
	{
		return reps;
	}

	// Setters

	/**
	 * Sets the number of sets in the strength training workout.
	 *
	 * @param newSets the new number of sets
	 */
	public void setSets(int newSets)
	{
		this.sets = newSets;
	}

	/**
	 * Sets the number of repetitions in each set of the strength training
	 * workout.
	 *
	 * @param newReps the new number of repetitions
	 */
	public void setReps(int newReps)
	{
		this.reps = newReps;
	}

	/**
	 * Displays the strength training workout data entry.
	 */
	public void printEntry()
	{
		System.out.println(bulletPoint + " Sets: " + this.sets + " | Reps: "
				+ this.reps + " | " + this.getDate());
	}
}
