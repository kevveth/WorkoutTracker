package cisc191.sdmesa.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import cisc191.sdmesa.edu.Exceptions.InvalidInputException;
import cisc191.sdmesa.edu.Exceptions.NoAvailableSpaceException;

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
 *         Switch Operated Text Menu
 *         https://www.javaforstudents.co.uk/Code_snippets/Switch-operated_text_menu/
 *
 *         Version: v1
 * 
 *         Responsibilites:
 *         - Presenting menus and handling user interactions within the workout
 *         tracker application.
 */

public class Menu
{
	/**
	 * Displays the main menu.
	 *
	 * @param user the User object representing the current user
	 */
	public static void displayMainMenu(User user)
	{
		Scanner keyboard = new Scanner(System.in);
		int mainSelection = -1;

		while (mainSelection != 4)
		{
			System.out.println("Hello, " + user.getUsername() + "!");
			System.out.println("\n" + "Main Menu");
			System.out.println("--------------------");
			System.out.println("1. View workout plans");
			System.out.println("2. View user info");
			System.out.println("3. Save data");
			System.out.println("4. Exit");
			System.out.println();
			System.out.print("Enter your choice: ");

			try
			{

				// Get user's choice
				mainSelection = keyboard.nextInt();

				switch (mainSelection)
				{
					case 1:
						displayWorkoutPlansMenu(user, keyboard);
						break;
					case 2:
						displayUserInfo(user, keyboard);
						break;
					case 3:
						save(user);
						break;
					case 4:
						System.out.println("Exiting Workout Tracker...");
						break;
					default:
						throw new InvalidInputException();
				}
			}
			catch (InvalidInputException e)
			{
				System.err.println(e.getMessage());
			}
			catch (InputMismatchException e)
			{
				System.err.println(
						"Invalid input. Select one of the given options.");
			}
			finally
			{
				keyboard.nextLine();
			}

		}
	}

	/**
	 * Displays the user information.
	 * 
	 * @param user the User object containing the user information
	 */
	public static void displayUserInfo(User user, Scanner keyboard)
	{
		String userInfo = user.toString();
		System.out.println(userInfo);

		int selection = -1;

		while (selection != 1)
		{
			System.out.println("1. Return to the main menu");
			System.out.println();
			System.out.print("Enter your choice: ");

			try
			{
				selection = keyboard.nextInt();

				switch (selection)
				{
					case 1:
						System.out.println("Returning...");
						break;
					default:
						throw new InvalidInputException();
				}
			}
			catch (InvalidInputException e)
			{
				System.err.println(e.getMessage());
			}
			catch (InputMismatchException e)
			{
				System.err.println(
						"Invalid input. Select one of the given options.");
				keyboard.nextLine();
			}
		}
	}

	/**
	 * Saves the user's information and workout data to a file.
	 * 
	 * @param user the User object representing the user whose data needs to be
	 *             saved
	 * @throws IOException if an error occurs while saving the data to the file
	 */
	public static void save(User user)
	{
		WorkoutTrackerIO.saveUserInfo(user);
		WorkoutTrackerIO.saveWorkoutData(user);
		System.out.println("File saved Succesfully!");
	}

	/**
	 * Displays the workout plans menu.
	 *
	 * @param user     the User object representing the current user
	 * @param keyboard the Scanner object used for user input
	 */
	public static void displayWorkoutPlansMenu(User user, Scanner keyboard)
	{
		// Menu selector
		int selection = -1;

		while (selection != 4)
		{

			try
			{
				System.out.println("\n" + "Workout Plans");
				System.out.println("--------------------");
				user.displayWorkoutPlanList();
				System.out.println();
				System.out.println("1. Create a plan");
				System.out.println("2. View a plan");
				System.out.println("3. Delete a plan");
				System.out.println("4. Return to previous menu");
				System.out.println();
				System.out.print("Enter your choice: ");

				// Get user's choice
				selection = keyboard.nextInt();

				switch (selection)
				{
					case 1:
						createWorkoutPlan(user, keyboard);
						break;
					case 2:
						viewWorkoutPlan(user, keyboard);

						break;
					case 3:
						deleteWorkoutPlan(user, keyboard);
						break;
					case 4:
						System.out.println("Returning...");
						break;
					default:
						throw new InvalidInputException();
				}
			}
			catch (InvalidInputException e)
			{
				System.err.println(e.getMessage());
				keyboard.nextLine();
			}
			catch (NoAvailableSpaceException e)
			{
				e.printStackTrace();
				keyboard.nextLine();
			}
		}
	}

	/**
	 * Creates a new workout plan for the user.
	 *
	 * @param user     the User object representing the current user
	 * @param keyboard the Scanner object used for user input
	 * @throws NoAvailableSpaceException if there is no available space to add
	 *                                   the workout plan
	 */
	public static void createWorkoutPlan(User user, Scanner keyboard)
			throws NoAvailableSpaceException
	{
		System.out.println("What would you like to name your new plan?");
		keyboard.nextLine(); // consume the newline character
		String name = keyboard.nextLine();
		user.addWorkoutPlan(name);
	}

	/**
	 * Displays the specified workout plan for the user.
	 *
	 * @param user     the User object representing the current user
	 * @param keyboard the Scanner object used for user input
	 */
	public static void viewWorkoutPlan(User user, Scanner keyboard)
	{
		System.out.println("Which plan would you like to view?");
		ArrayList<WorkoutPlan> plans = user.getWorkoutPlans();
		int planSelection = keyboard.nextInt();

		if (planSelection < 1 || planSelection > plans.size())
		{
			System.err
					.println("Invalid input. Select one of the given options.");
			return;
		}

		displayWorkoutPlanMenu(plans.get(planSelection - 1), keyboard);
	}

	/**
	 * Deletes the specified workout plan from the user.
	 *
	 * @param user     the User object representing the current user
	 * @param keyboard the Scanner object used for user input
	 */
	public static void deleteWorkoutPlan(User user, Scanner keyboard)
	{
		System.out.println("Which plan would you like to delete?");
		int planToDelete = keyboard.nextInt();
		user.deleteWorkoutPlan(planToDelete);
	}

	/**
	 * Displays the menu for a specific workout plan.
	 *
	 * @param plan     the WorkoutPlan object representing the workout plan to
	 *                 display
	 * @param keyboard the Scanner object used for user input
	 */
	public static void displayWorkoutPlanMenu(WorkoutPlan plan,
			Scanner keyboard)
	{
		// Menu selector
		int menuSelection = -1;

		while (menuSelection != 3)
		{
			System.out.println("\n" + plan.getName());
			System.out.println("--------------------");
			plan.displayWorkoutList();
			System.out.println();
			System.out.println("1. Add a workout");
			System.out.println("2. View a workout");
			System.out.println("3. Return to previous menu");
			System.out.println();
			System.out.print("Enter your choice: ");

			try
			{
				// Get user's choice
				menuSelection = keyboard.nextInt();

				switch (menuSelection)
				{
					case 1:
						createWorkout(plan, keyboard);
						break;
					case 2:
						viewWorkout(plan, keyboard);
						break;
					case 3:
						System.out.println("Returning...");
						break;
					default:
						throw new InvalidInputException();
				}
			}
			catch (InputMismatchException e)
			{
				System.err.println(e.getMessage());
				keyboard.nextLine();
			}
		}
	}

	/**
	 * Creates a new workout in the specified workout plan.
	 *
	 * @param plan     the WorkoutPlan object in which to create the workout
	 * @param keyboard the Scanner object used for user input
	 */
	public static void createWorkout(WorkoutPlan plan, Scanner keyboard)
	{
		keyboard.nextLine();
		System.out.println("What is the name of the workout?");
		String name = keyboard.nextLine();
		plan.addWorkout(name);
	}

	/**
	 * View a specific workout in the workout plan.
	 *
	 * @param workout  the Workout object representing the workout to display
	 * @param keyboard the Scanner object used for user input
	 */
	public static void viewWorkout(WorkoutPlan plan, Scanner keyboard)
	{
		System.out.println("Which workout would you like to view?");
		ArrayList<Workout> workouts = plan.getWorkouts();
		int workoutSelection = keyboard.nextInt();

		if (workoutSelection < 1 || workoutSelection > workouts.size())
		{
			System.err
					.println("Invalid input. Select one of the given options.");
			return;
		}

		displayWorkoutMenu(workouts.get(workoutSelection - 1), keyboard);
	}

	/**
	 * Displays the menu for a specific workout.
	 *
	 * @param workout  the Workout object representing the workout to display
	 * @param keyboard the Scanner object used for user input
	 */
	public static void displayWorkoutMenu(Workout workout, Scanner keyboard)
	{
		int selection = -1;

		while (selection != 3)
		{
			System.out.println("\n" + workout.getName());
			System.out.println("--------------------");
			workout.displayWorkoutData();
			System.out.println();
			System.out.println("1. Add a new entry");
			System.out.println("2. Delete an entry");
			System.out.println("3. Return to previous menu");
			System.out.println();
			System.out.print("Enter your choice: ");

			try
			{
				selection = keyboard.nextInt();
				keyboard.nextLine();

				switch (selection)
				{
					case 1:
						createNewEntry(workout, keyboard);
						break;
					case 2:
						deleteAnEntry(workout, keyboard);
						break;
					case 3:
						System.out.println("Returning...");
						break;
					default:
						throw new InvalidInputException();

				}
			}
			catch (InvalidInputException e)
			{
				System.err.println(e.getMessage());
				keyboard.nextLine();
			}
			catch (NoAvailableSpaceException e)
			{
				System.err.println(e.getMessage());
				keyboard.nextLine();
			}

		}

	}

	/**
	 * Creates a new entry for a workout.
	 *
	 * @param workout  the Workout object for which the entry is created
	 * @param keyboard the Scanner object used for user input
	 * @throws NoAvailableSpaceException if there is no available space to add
	 *                                   the entry to the workout
	 */
	public static void createNewEntry(Workout workout, Scanner keyboard)
			throws NoAvailableSpaceException
	{
		WorkoutEntry entry = null;

		try
		{
			System.out.println("Enter the type of workout:");
			System.out.println("1. Cardio");
			System.out.println("2. Strength Training");
			System.out.println("3. Weighted Training");
			System.out.print("Enter your choice: ");

			int selection = keyboard.nextInt();

			while (selection != 3)
			{
				switch (selection)
				{
					case 1:
						int distance, duration;
						System.out.println("Enter the distance (in miles): ");
						distance = keyboard.nextInt();
						System.out.println("Enter the duration (in minutes): ");
						duration = keyboard.nextInt();
						entry = new CardioEntry(distance, duration);
						break;
					case 2:
						int sets, reps;
						System.out.println("Enter the number of sets: ");
						sets = keyboard.nextInt();
						if (sets < 0)
						{
							throw new InvalidInputException(sets);
						}

						System.out.println("Enter the number of reps: ");
						reps = keyboard.nextInt();
						if (reps < 0)
						{
							throw new InvalidInputException(reps);
						}

						entry = new StrengthTrainingEntry(sets, reps);
						break;
					case 3:
						int weight;
						System.out.println("Enter the amount of weight: ");
						weight = keyboard.nextInt();
						System.out.println("Enter the number of sets: ");
						sets = keyboard.nextInt();
						System.out.println("Enter the number of reps: ");
						reps = keyboard.nextInt();
						entry = new WeightedTrainingEntry(weight, sets, reps);
						break;
					default:
						throw new InvalidInputException();
				}
			}
		}
		catch (InvalidInputException e)
		{
			System.err.println(e.getMessage());
			keyboard.nextLine();
		}
		finally
		{
			workout.addEntry(entry);
		}
	}

	public static void deleteAnEntry(Workout workout, Scanner keyboard)
	{

		System.out.println("Which entry would you like to delete?");
		int selection = keyboard.nextInt();

		try
		{
			workout.removeEntry(selection);
		}
		catch (InputMismatchException e)
		{

		}

		workout.removeEntry(selection);
	}
}
