package cisc191.sdmesa.edu.WorkoutTrackerGUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cisc191.sdmesa.edu.User;
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
 *
 *         Version: v1
 * 
 *         Responsibilites:
 *         - Handles the logic for adding a workout plan scroll pane to the
 *         GUI.
 */
public class AddWorkoutPlansScrollPaneListener implements ListSelectionListener
{
	private User user;
	private WorkoutTrackerGUI gui;
	private AddWorkoutPlansScrollPane scrollPane;

	public AddWorkoutPlansScrollPaneListener(User user, WorkoutTrackerGUI gui,
			AddWorkoutPlansScrollPane scrollPane)
	{
		this.user = user;
		this.gui = gui;
		this.scrollPane = scrollPane;
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (!e.getValueIsAdjusting())
		{
			String selectedPlan = scrollPane.getSelectedPlan();
			if (selectedPlan != null)
			{
				WorkoutPlan workoutPlan = findWorkoutPlan(selectedPlan);
				if (workoutPlan != null)
				{
					gui.displayWorkouts(workoutPlan);
				}
			}
		}
	}

	private WorkoutPlan findWorkoutPlan(String planName)
	{
		for (WorkoutPlan plan : user.getWorkoutPlans())
		{
			if (plan.getName().equals(planName))
			{
				return plan;
			}
		}
		return null;
	}
}