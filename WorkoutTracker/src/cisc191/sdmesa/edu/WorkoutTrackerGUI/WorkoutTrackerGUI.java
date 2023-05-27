package cisc191.sdmesa.edu.WorkoutTrackerGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cisc191.sdmesa.edu.User;
import cisc191.sdmesa.edu.Workout;
import cisc191.sdmesa.edu.WorkoutPlan;

public class WorkoutTrackerGUI extends JFrame
{
	private User user;
	private JTextArea userInfoArea;
	private DefaultListModel<String> planListModel;

	public WorkoutTrackerGUI(User user)
	{
		this.user = user;
		setTitle("Workout Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Create the components
		userInfoArea = new JTextArea();
		userInfoArea.setEditable(false);
		JScrollPane userInfoScrollPane = new JScrollPane(userInfoArea);

		JList<String> planList = new JList<>();
		planListModel = new DefaultListModel<>();
		planList.setModel(planListModel);
		planList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane planListScrollPane = new JScrollPane(planList);

		JButton addButton = new JButton("Add Plan");
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addWorkoutPlan();
			}
		});

		planList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (!e.getValueIsAdjusting())
				{
					String selectedPlan = planList.getSelectedValue();
					if (selectedPlan != null)
					{
						WorkoutPlan workoutPlan = findWorkoutPlan(selectedPlan);
						if (workoutPlan != null)
						{
							displayWorkouts(workoutPlan);
						}
					}
				}
			}
		});

		// Load the user's information and workout plans
		displayUserData();

		// Add the components to the frame
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(addButton, BorderLayout.NORTH);
		panel.add(planListScrollPane, BorderLayout.CENTER);

		add(userInfoScrollPane, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private void displayUserData()
	{
		// Set the user's information in the text area
		String userInfo = user.toString();
		userInfoArea.setText(userInfo);

		// Add the user's workout plans to the list
		ArrayList<WorkoutPlan> plans = user.getWorkoutPlans();
		for (WorkoutPlan plan : plans)
		{
			planListModel.addElement(plan.getName());
		}
	}

	private void addWorkoutPlan()
	{
		String name = JOptionPane.showInputDialog(this,
				"Enter the name of the new workout plan:");
		if (name != null && !name.isEmpty())
		{
			user.addWorkoutPlan(name);
			planListModel.addElement(name);
		}
	}

	private WorkoutPlan findWorkoutPlan(String planName)
	{
		ArrayList<WorkoutPlan> plans = user.getWorkoutPlans();
		for (WorkoutPlan plan : plans)
		{
			if (plan.getName().equals(planName))
			{
				return plan;
			}
		}
		return null;
	}

	private void displayWorkouts(WorkoutPlan workoutPlan)
	{
		JFrame workoutPlanFrame = new JFrame(
				workoutPlan.getName() + " Workouts");
		workoutPlanFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		workoutPlanFrame.setLayout(new BorderLayout());

		JList<String> workoutList = new JList<>();
		DefaultListModel<String> workoutListModel = new DefaultListModel<>();
		workoutList.setModel(workoutListModel);
		workoutList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane workoutScrollPane = new JScrollPane(workoutList);

		ArrayList<Workout> workouts = workoutPlan.getWorkouts();
		for (Workout workout : workouts)
		{
			workoutListModel.addElement(workout.getName());
		}

		workoutPlanFrame.add(workoutScrollPane, BorderLayout.CENTER);
		workoutPlanFrame.pack();
		workoutPlanFrame.setVisible(true);
	}

	public static void main(String[] args)
	{
		// Create a user object
		User user = new User();

		// Create and display the GUI
		WorkoutTrackerGUI gui = new WorkoutTrackerGUI(user);
	}
}