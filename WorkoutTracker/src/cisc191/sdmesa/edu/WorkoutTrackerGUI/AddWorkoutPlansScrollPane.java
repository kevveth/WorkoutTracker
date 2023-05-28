package cisc191.sdmesa.edu.WorkoutTrackerGUI;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

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
 *         - ScrollPane class for adding a scroll pane to the WorkoutTrackerGUI.
 */
@SuppressWarnings("serial")
public class AddWorkoutPlansScrollPane extends JScrollPane
{
	private JList<String> planList;

	/**
	 * Constructs an AddWorkoutPlansScrollPane object.
	 *
	 * @param planList the JList representing the list of workout plans
	 */
	public AddWorkoutPlansScrollPane(JList<String> planList)
	{
		this.planList = planList;
		planList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setViewportView(planList);
	}

	/**
	 * Sets the model for the list of workout plans.
	 *
	 * @param model the DefaultListModel representing the model for the list
	 */
	public void setModel(DefaultListModel<String> model)
	{
		planList.setModel(model);
	}

	/**
	 * Adds a ListSelectionListener to the list of workout plans.
	 *
	 * @param listener the ListSelectionListener to be added
	 */
	public void addListSelectionListener(ListSelectionListener listener)
	{
		planList.addListSelectionListener(listener);
	}

	/**
	 * Retrieves the selected workout plan.
	 *
	 * @return the selected workout plan as a String, or null if no plan is
	 *         selected
	 */
	public String getSelectedPlan()
	{
		return planList.getSelectedValue();
	}
}
