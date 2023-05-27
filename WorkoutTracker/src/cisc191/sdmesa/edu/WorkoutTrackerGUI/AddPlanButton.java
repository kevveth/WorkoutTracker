package cisc191.sdmesa.edu.WorkoutTrackerGUI;

import javax.swing.JButton;

import cisc191.sdmesa.edu.User;

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
 *         - Button class for adding a workout plan to the WorkoutTrackerGUI.
 */
@SuppressWarnings("serial")
public class AddPlanButton extends JButton
{
	public AddPlanButton(User user, WorkoutTrackerGUI gui)
	{
		super("Add Plan");
		addActionListener(new AddPlanButtonListener(user, gui));
	}
}