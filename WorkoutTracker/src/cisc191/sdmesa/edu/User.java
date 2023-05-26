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
	private WorkoutPlan[] workoutPlans = new WorkoutPlan[20];

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
	public WorkoutPlan[] getWorkoutPlans()
	{
		return workoutPlans;
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
	public void setWorkoutPlans(WorkoutPlan[] workoutPlans)
	{
		this.workoutPlans = workoutPlans;
	}

	/**
	 * Adds a new workout plan to the user's collection of workout plans.
	 *
	 * @param name The name of the new workout plan.
	 * @throws NoAvailableSpaceException if there is no available space to add
	 *                                   the workout plan.
	 */
	public void addWorkoutPlan(String name) throws NoAvailableSpaceException
	{
		for (int i = 0; i < workoutPlans.length; i++)
		{
			if (workoutPlans[i] == null)
			{
				workoutPlans[i] = new WorkoutPlan(name);
				// System.out.println("Created Successfully!");
				return;
			}
		}

		throw new NoAvailableSpaceException();

	}

	/**
	 * Adds a workout plan to the user's collection of workout plans.
	 *
	 * @param plan The workout plan to be added.
	 */
	public void addWorkoutPlan(WorkoutPlan plan)
	{
		try
		{
			for (int i = 0; i < workoutPlans.length; i++)
			{
				if (workoutPlans[i] == null)
				{
					workoutPlans[i] = plan;
					return;
				}
			}
			throw new NoAvailableSpaceException();
		}
		catch (NoAvailableSpaceException e)
		{
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Deletes a workout plan at the specified index.
	 *
	 * @param indexToDelete The index of the workout plan to be deleted.
	 */
	public void deleteWorkoutPlan(int indexToDelete)
	{
		if (indexToDelete < 0 || indexToDelete >= workoutPlans.length)
		{
			System.out.println("Invalid index.");
			return;
		}
		if (workoutPlans[indexToDelete - 1] != null)
		{
			workoutPlans[indexToDelete - 1] = null;
			System.out.println("Workout plan deleted.");
		}
		else
		{
			System.out.println(
					"No workout plan found at index " + indexToDelete + ".");
		}
	}

	/**
	 * Displays the list of workout plans belonging to the user.
	 */
	public void displayWorkoutPlanList()
	{
		for (int i = 0; i < workoutPlans.length; i++)
		{
			if (workoutPlans[i] != null)
			{
				System.out.println((i + 1) + ". " + workoutPlans[i].getName());
			}
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
