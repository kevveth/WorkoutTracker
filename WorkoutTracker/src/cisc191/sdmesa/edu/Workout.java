package cisc191.sdmesa.edu;

import java.util.ArrayList;

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
 *         - This class represents a workout, which contains a name and a list
 *         of workout data (entries).
 */

public class Workout
{
	// A workout has a name
	private String name;

	// A workout has data (entries)
	private ArrayList<WorkoutEntry> entries = new ArrayList<>();

	// Constructors

	/**
	 * Constructs a new empty workout.
	 */
	public Workout()
	{
	}

	/**
	 * Constructs a new workout with the specified name.
	 *
	 * @param name the name of the workout
	 */
	public Workout(String name)
	{
		this.name = name;
	}

	// Getters

	/**
	 * Returns the name of the workout.
	 *
	 * @return the name of the workout
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the workout data entries.
	 *
	 * @return the workout data entries
	 */
	public ArrayList<WorkoutEntry> getData()
	{
		return entries;
	}

	// Setters

	/**
	 * Sets the name of the workout.
	 *
	 * @param name the name of the workout
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Sets the workout data entries.
	 *
	 * @param data the workout data entries
	 */
	public void setWorkoutEntries(ArrayList<WorkoutEntry> entries)
	{
		this.entries = entries;
	}

	/**
	 * Adds a new data entry to the workout.
	 *
	 * @param entry the WorkoutData object to add
	 * @throws NoAvailableSpaceException if there is no available space to add
	 *                                   the data entry
	 */
	public void addDataEntry(WorkoutEntry entry)
	{
		this.entries.add(entry);
	}

	/**
	 * Displays the workout data entries.
	 */
	public void displayWorkoutData()
	{
		for (WorkoutEntry entry : entries)
		{
			entry.printEntry();
		}
	}
}
