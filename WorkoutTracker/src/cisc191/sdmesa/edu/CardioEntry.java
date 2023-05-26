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
 *         - This class represents a data entry for a cardio workout, including
 *         the duration and distance.
 */

public class CardioEntry extends WorkoutEntry
{
	// A cardio workout has a duration, in minutes
	private int duration;

	// A cardio workout has a distance, in miles
	private int distance;

	/**
	 * Constructs a new CardioData object with default values.
	 */
	public CardioEntry()
	{
	}

	/**
	 * Constructs a new CardioData object with the specified duration and
	 * distance.
	 *
	 * @param duration the duration of the cardio workout in minutes
	 * @param distance the distance of the cardio workout in miles
	 */
	public CardioEntry(int distance, int duration)
	{
		super();
		this.distance = distance;
		this.duration = duration;
	}

	// Getters

	/**
	 * Returns the duration of the cardio workout.
	 *
	 * @return the duration of the cardio workout in minutes
	 */
	public int getDuration()
	{
		return duration;
	}

	/**
	 * Returns the distance of the cardio workout.
	 *
	 * @return the distance of the cardio workout in miles
	 */
	public int getDistance()
	{
		return distance;
	}

	// Setters

	/**
	 * Sets the duration of the cardio workout.
	 *
	 * @param newDuration the new duration of the cardio workout in minutes
	 */
	public void setDuration(int newDuration)
	{
		this.distance = newDuration;
	}

	/**
	 * Sets the distance of the cardio workout.
	 *
	 * @param newDistance the new distance of the cardio workout in miles
	 */
	public void setDistance(int newDistance)
	{
		this.distance = newDistance;
	}

	// Methods

	/**
	 * Displays the cardio workout data entry.
	 */
	public void printEntry()
	{
		System.out.println(
				bulletPoint + " Distance: " + this.distance + "mi | Duration: "
						+ this.duration + "min | " + this.getDate());
	}
}
