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
 *         - This class represents a workout plan which contains a name and a
 *         list of workouts.
 */

public class WorkoutPlan
{

	// A workout plan has a name
	private String name;

	// A workout plan has a list of workouts
	// Should pull data in from a text file
	private ArrayList<Workout> workouts = new ArrayList<>();
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
	public ArrayList<Workout> getWorkouts()
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
	public void setWorkouts(ArrayList<Workout> workouts)
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
		workouts.add(new Workout(name));
	}

	/**
	 * Adds a new workout to the workout plan.
	 *
	 * @param workout the workout to add
	 */
	public void addWorkout(Workout workout)
	{
		workouts.add(workout);
	}

	/**
	 * Deletes the workout at the specified index from the workout plan.
	 *
	 * @param name the name of the workout to delete
	 */
	public void deleteWorkout(int index)
	{
		this.workouts.remove(index - 1);
	}

	/**
	 * Displays the list of workouts in the workout plan.
	 */
	public void displayWorkoutList()
	{
		for (int i = 0; i < workouts.size(); i++)
		{
			Workout workout = workouts.get(i);

			System.out.println((i + 1) + ". " + workout.getName());

		}
		System.out.println();
	}

}
