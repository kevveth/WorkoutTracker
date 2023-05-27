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
 *         Responsibilities:
 *         - This class represents a user which contains a username and bio, and
 *         a list of workout plans.
 */

public class User
{
	// The user has a name
	private String username;

	// The user has a bio
	private String bio;

	// The user has a list of workout plans
	private ArrayList<WorkoutPlan> plans = new ArrayList<>();

	/**
	 * Default constructor for the User class.
	 * Loads the user's information and workout data.
	 */
	public User()
	{
		load(this);
	}

	/**
	 * Constructor for the User class.
	 *
	 * @param username The username of the user.
	 * @param bio      The bio of the user.
	 */
	public User(String username, String bio)
	{
		this.username = username;
		this.bio = bio;
	}

	/**
	 * Retrieves the username of the user.
	 *
	 * @return The username of the user.
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * Retrieves the bio of the user.
	 *
	 * @return The bio of the user.
	 */
	public String getBio()
	{
		return bio;
	}

	/**
	 * Retrieves the workout plans of the user.
	 *
	 * @return An array of workout plans belonging to the user.
	 */
	public ArrayList<WorkoutPlan> getWorkoutPlans()
	{
		return plans;
	}

	/**
	 * Sets the username of the user.
	 *
	 * @param username The new username for the user.
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * Sets the bio of the user.
	 *
	 * @param bio The new bio for the user.
	 */
	public void setBio(String bio)
	{
		this.bio = bio;
	}

	/**
	 * Sets the workout plans for the user.
	 *
	 * @param workoutPlans An array of workout plans to be assigned to the user.
	 */
	public void setWorkoutPlans(ArrayList<WorkoutPlan> workoutPlans)
	{
		this.plans = workoutPlans;
	}

	/**
	 * Adds a new workout plan to the user's collection of workout plans.
	 *
	 * @param name The name of the new workout plan.
	 */
	public void addWorkoutPlan(String name)
	{
		plans.add(new WorkoutPlan(name));

	}

	/**
	 * Adds a workout plan to the user's collection of workout plans.
	 *
	 * @param plan The workout plan to be added.
	 */
	public void addWorkoutPlan(WorkoutPlan plan)
	{
		plans.add(plan);
	}

	/**
	 * Deletes a workout plan at the specified index.
	 *
	 * @param indexToDelete The index of the workout plan to be deleted.
	 */
	public void deleteWorkoutPlan(int index)
	{
		plans.remove(index - 1);
	}

	/**
	 * Displays the list of workout plans belonging to the user.
	 */
	public void displayWorkoutPlanList()
	{

		for (int i = 0; i < plans.size(); i++)
		{
			WorkoutPlan plan = plans.get(i);

			System.out.println((i + 1) + ". " + plan.getName());

		}
		System.out.println();
	}

	/**
	 * Retrieves a string representation of the user object.
	 *
	 * @return A string containing the user's name and bio.
	 */
	@Override
	public String toString()
	{
		return "\n" + "Name: " + getUsername() + "\n" + "Bio: " + getBio()
				+ "\n";
	}

	/**
	 * Loads the user's information and workout data.
	 *
	 * @param user The User object to load the data into.
	 */
	public static void load(User user)
	{
		WorkoutTrackerIO.loadUserInfo(user);
		WorkoutTrackerIO.loadWorkoutData(user);
	}
}
