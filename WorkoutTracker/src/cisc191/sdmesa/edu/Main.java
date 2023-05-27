package cisc191.sdmesa.edu;

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
 *         - Creates a User object and displays the main menu.
 */

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			User user = new User();

			Menu.displayMainMenu(user);
		}
		catch (Exception e)
		{
			System.err.println("There was an error. " + e.getCause());
		}
	}
}
