package cisc191.sdmesa.edu.WorkoutTrackerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
 *         Version: v1
 * 
 *         Responsibilites:
 *         - Button class for adding a workout plan to the WorkoutTrackerGUI.
 */
@SuppressWarnings("serial")
public class AddPlanButton extends JButton implements ActionListener
{
	private User user;
	private WorkoutTrackerGUI gui;

	/**
	 * Constructs an AddPlanButton object.
	 *
	 * @param user the User object representing the user
	 * @param gui  the WorkoutTrackerGUI object representing the GUI
	 */
	public AddPlanButton(User user, WorkoutTrackerGUI gui)
	{
		super("Add Plan");
		this.user = user;
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Invoked when the "Add Plan" button is clicked.
	 *
	 * @param e the ActionEvent representing the button click event
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String planName = JOptionPane.showInputDialog(gui,
				"Enter the name of the new workout plan:");
		if (planName != null && !planName.isEmpty())
		{
			WorkoutPlan newPlan = new WorkoutPlan(planName);
			user.addWorkoutPlan(newPlan);
			gui.displayUserData();
		}
	}
}