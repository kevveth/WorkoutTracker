package cisc191.sdmesa.edu.WorkoutTrackerGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import cisc191.sdmesa.edu.User;
import cisc191.sdmesa.edu.Workout;
import cisc191.sdmesa.edu.WorkoutPlan;

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
 * 
 *         Java AWT | BorderLayout Class
 *         https://www.geeksforgeeks.org/java-awt-borderlayout-class/
 * 
 *         How to Use Scroll Panes
 *         https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html
 * 
 *
 *         Version: v1
 * 
 *         Responsibilites:
 *         - Display user's information and workout data through a GUI
 */
@SuppressWarnings("serial")
public class WorkoutTrackerGUI extends JFrame
{
	private User user;
	private JTextArea userInfoArea;
	private DefaultListModel<String> workoutPlansModel;
	private JList<String> planList;

	/**
	 * Constructs a WorkoutTrackerGUI object.
	 *
	 * @param user the User object containing user's information and workout
	 *             data
	 */
	public WorkoutTrackerGUI(User user)
	{
		this.user = user;
		setTitle("Workout Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// User Info Area
		userInfoArea = new JTextArea();
		userInfoArea.setEditable(false);
		userInfoArea.setPreferredSize(new Dimension(400, 200));

		// Workout Plans List
		workoutPlansModel = new DefaultListModel<>();
		planList = new JList<>(workoutPlansModel);
		planList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add Workout Plans Scroll Pane
		AddWorkoutPlansScrollPane addPlansScrollPane = new AddWorkoutPlansScrollPane(
				planList);

		// List Selection Listener for Workout Plans
		AddWorkoutPlansScrollPaneListener listSelectionListener = new AddWorkoutPlansScrollPaneListener(
				user, this, addPlansScrollPane);
		planList.addListSelectionListener(listSelectionListener);

		JScrollPane planScrollPane = new JScrollPane(addPlansScrollPane);

		// Add Plan Button
		AddPlanButton addButton = new AddPlanButton(user, this);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(addButton, BorderLayout.NORTH);
		panel.add(planScrollPane, BorderLayout.CENTER);

		add(userInfoArea, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		pack();
		setSize(600, 400);
		setVisible(true);

		displayUserData();
	}

	/**
	 * Displays the user's information and workout plans in the GUI.
	 */
	public void displayUserData()
	{
		workoutPlansModel.clear();

		String userInfo = user.toString();
		userInfoArea.setText(userInfo);

		ArrayList<WorkoutPlan> plans = user.getWorkoutPlans();
		for (WorkoutPlan plan : plans)
		{
			workoutPlansModel.addElement(plan.getName());
		}
	}

	/**
	 * Displays the workouts for a specific workout plan in a separate window.
	 *
	 * @param plan the WorkoutPlan object containing the workouts to display
	 */
	public void displayWorkouts(WorkoutPlan plan)
	{
		JTextArea workoutsArea = new JTextArea();
		workoutsArea.setEditable(false);

		StringBuilder workoutsInfo = new StringBuilder();
		workoutsInfo.append("~Workouts for ").append(plan.getName())
				.append("~\n");
		for (Workout workout : plan.getWorkouts())
		{
			workoutsInfo.append(workout.getName()).append("\n");
		}
		workoutsArea.setText(workoutsInfo.toString());

		JFrame workoutsFrame = new JFrame("Workouts");
		workoutsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		workoutsFrame.add(new JScrollPane(workoutsArea));
		workoutsFrame.pack();
		workoutsFrame.setVisible(true);
	}

	/**
	 * The entry point of the WorkoutTracker.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args)
	{
		try
		{
			User user = new User();
			new WorkoutTrackerGUI(user);
		}
		catch (Exception e)
		{
			System.err.println("There was an error. " + e.getCause());
		}
	}
}
