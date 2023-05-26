package cisc191.sdmesa.edu;

import java.time.LocalDate;

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
 *         - This class represents a data entry for a workout, containing the
 *         date it was made.
 */

// A Workout has a/many WorkoutEntry
public abstract class WorkoutEntry
{
	// A data entry has a date it was made
	private LocalDate date;

	protected char bulletPoint = '\u2022';

	/**
	 * Constructs a new WorkoutData object with the current date.
	 */
	public WorkoutEntry()
	{
		this.date = LocalDate.now();
	}

	/**
	 * Returns the date of the data entry.
	 *
	 * @return the date of the data entry
	 */
	public LocalDate getDate()
	{
		return date;
	}

	/**
	 * Displays the workout's data entry.
	 */
	public abstract void printEntry();

}
