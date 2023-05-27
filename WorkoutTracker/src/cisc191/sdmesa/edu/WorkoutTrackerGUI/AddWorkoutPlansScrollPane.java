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
 *         Java AWT | BorderLayout Class
 *         https://www.geeksforgeeks.org/java-awt-borderlayout-class/
 * 
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

	public AddWorkoutPlansScrollPane(JList<String> planList)
	{
		this.planList = planList;
		planList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setViewportView(planList);
	}

	public void setModel(DefaultListModel<String> model)
	{
		planList.setModel(model);
	}

	public void addListSelectionListener(ListSelectionListener listener)
	{
		planList.addListSelectionListener(listener);
	}

	public String getSelectedPlan()
	{
		return planList.getSelectedValue();
	}
}
