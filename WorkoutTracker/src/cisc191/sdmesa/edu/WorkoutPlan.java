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
 *         - This class represents a workout plan which contains a name and a
 *         list of workouts.
 */

public class WorkoutPlan
{

	// A workout plan has a name
	private String name;

	// A workout plan has a list of workouts
	// Should pull data in from a text file
	private Workout[] workouts = new Workout[20];

	// Constructors

	/**
	 * Constructs a new empty workout plan.
	 */
	public WorkoutPlan()
	{
	}

	/**
	 * Constructs a new workout plan with the specified name.
	 *
	 * @param name the name of the workout plan
	 */
	public WorkoutPlan(String name)
	{
		this.name = name;

	}

	// Getters

	/**
	 * Returns the name of the workout plan.
	 *
	 * @return the name of the workout plan
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the list of workouts in the workout plan.
	 *
	 * @return the list of workouts
	 */
	public Workout[] getWorkouts()
	{
		return workouts;
	}

	// Setters

	/**
	 * Sets the name of the workout plan.
	 *
	 * @param name the name of the workout plan
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Sets the list of workouts in the workout plan.
	 *
	 * @param workouts the list of workouts
	 */
	public void setWorkouts(Workout[] workouts)
	{
		this.workouts = workouts;
	}

	/**
	 * Adds a new workout to the workout plan with the specified name.
	 *
	 * @param name the name of the workout
	 */
	public void addWorkout(String name)
	{
		for (int i = 0; i < workouts.length; i++)
		{
			if (workouts[i] == null)
			{
				workouts[i] = new Workout(name);
				return;
			}
		}

		System.out.println("Cannot add more workouts to this plan.");
	}

	/**
	 * Adds a new workout to the workout plan.
	 *
	 * @param currentWorkout the workout to add
	 */
	public void addWorkout(Workout currentWorkout)
	{
		for (int i = 0; i < workouts.length; i++)
		{
			if (workouts[i] == null)
			{
				workouts[i] = currentWorkout;
				return;
			}
		}

		System.out.println("Cannot add more workouts to this plan.");
	}

	/**
	 * Deletes the workout with the specified name from the workout plan.
	 *
	 * @param name the name of the workout to delete
	 */
	public void deleteWorkout(String name)
	{
		for (int i = 0; i < workouts.length; i++)
		{
			if (workouts[i] != null && workouts[i].getName().equals(name))
			{
				workouts[i] = null;
				System.out.println("Workout deleted.");
				return;
			}
		}

		System.err.println("Workout '" + name + "' not found.");
	}

	/**
	 * Displays the list of workouts in the workout plan.
	 */
	public void displayWorkoutList()
	{
		for (int i = 0; i < workouts.length; i++)
		{
			if (workouts[i] != null)
			{
				System.out.println((i + 1) + ". " + workouts[i].getName());
			}
		}
		System.out.println();
	}

}
