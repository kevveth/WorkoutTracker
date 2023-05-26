package cisc191.sdmesa.edu;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
 *         - This class provides methods for saving and loading user information
 *         and workout data from text files.
 */

public class WorkoutTrackerIO
{
	private static String USER_INFO = "user_info.txt";
	private static String WORKOUT_DATA = "workout_data.txt";

	/**
	 * Save a user's information into a text file
	 */
	public static void saveUserInfo(User user)
	{
		BufferedWriter writer = null;

		try
		{
			writer = new BufferedWriter(new FileWriter(USER_INFO));

			writer.write("USER : " + user.getUsername() + "\n");
			writer.write("BIO : " + user.getBio() + "\n");

		}
		catch (IOException e)
		{
			System.out.println();
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (IOException e)
			{
				System.err.println("Trouble closing writer.");
			}
		}
	}

	/**
	 * Save a user's workout data into a text file.
	 *
	 * @param user the user object containing the workout data to save
	 */
	public static void saveWorkoutData(User user)
	{
		BufferedWriter writer = null;
		WorkoutPlan[] workoutPlans = user.getWorkoutPlans();

		try
		{
			writer = new BufferedWriter(new FileWriter(WORKOUT_DATA));

			// Write user's workout plans
			for (WorkoutPlan plan : workoutPlans)
			{
				if (plan != null)
				{
					writer.write("PLAN : " + plan.getName() + "\n");

					// Write plan's workouts
					Workout[] workouts = plan.getWorkouts();

					for (Workout workout : workouts)
					{
						if (workout != null)
						{
							writer.write(
									"WORKOUT : " + workout.getName() + "\n");
						}
					}

					writer.write("END_PLAN\n");
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (IOException e)
			{
				System.err.println("Trouble closing writer.");
			}
		}
	}

	/**
	 * Read in a user's information from a text file
	 * 
	 * @param user
	 */
	public static void loadUserInfo(User user)
	{
		BufferedReader reader = null;

		try
		{
			reader = new BufferedReader(new FileReader(USER_INFO));
			String line;

			while ((line = reader.readLine()) != null)
			{
				if (line.substring(0, 4).equals("USER"))
				{
					user.setUsername(line.substring(7));
				}
				if (line.substring(0, 3).equals("BIO"))
				{
					user.setBio(line.substring(6));
				}
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{
				System.err.println("Trouble closing the reader.");
			}
		}
	}

	/**
	 * Read in a user's workout data from a text file
	 * 
	 * @param user
	 */
	public static void loadWorkoutData(User user)
	{
		BufferedReader reader = null;
		WorkoutPlan currentPlan = null;
		String line;

		try
		{
			reader = new BufferedReader(new FileReader(WORKOUT_DATA));

			while ((line = reader.readLine()) != null)
			{
				if (line.startsWith("PLAN"))
				{
					// Get the name of the plan from the line
					String name = line.substring(7);
					// Create a new WorkoutPlan
					currentPlan = new WorkoutPlan(name);
				}
				else if (line.startsWith("WORKOUT"))
				{
					if (currentPlan != null)
					{
						// Get the name of the workout from the line
						String name = line.substring(10);
						// Create a new Workout
						Workout workout = new Workout(name);
						// Add the workout to the current plan
						currentPlan.addWorkout(workout);
					}
				}
				else if (line.equals("END_PLAN"))
				{
					if (currentPlan != null)
					{
						// Add the current plan to the user's list of plans
						user.addWorkoutPlan(currentPlan);
						// Reset the currentPlan
						currentPlan = null;
					}
				}
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Trouble closing the reader.");
			}
		}
	}

}
