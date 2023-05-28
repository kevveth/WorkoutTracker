package cisc191.sdmesa.edu.WorkoutTrackerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 *
 *         Version: v1
 * 
 *         Responsibilites:
 *         - Handles the logic for adding a new workout plan to the user and the
 *         GUI.
 */
class AddPlanButtonListener implements ActionListener
{
	private User user;
	private WorkoutTrackerGUI gui;

	/**
	 * Constructs an AddPlanButtonListener object.
	 *
	 * @param user the User object representing the user
	 * @param gui  the WorkoutTrackerGUI object representing the GUI
	 */
	public AddPlanButtonListener(User user, WorkoutTrackerGUI gui)
	{
		this.user = user;
		this.gui = gui;
	}

	/**
	 * Invoked when the "Add Plan" button is clicked.
	 *
	 * @param e the ActionEvent representing the button click event
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String planName = "New Plan"; 
		WorkoutPlan newPlan = new WorkoutPlan(planName);
		user.addWorkoutPlan(newPlan);
		gui.displayUserData();
	}
}