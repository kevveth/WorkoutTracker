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
 *         <<Add more references here>>
 *
 *         Version: v1
 * 
 *         Responsibilites:
 *         - This class represents an exception that is thrown when there is no
 *         available space to add data.
 */

@SuppressWarnings("serial")
public class NoAvailableSpaceException extends ArrayIndexOutOfBoundsException
{

	/**
	 * Constructs a NoAvailableSpaceException with a default error message.
	 */
	public NoAvailableSpaceException()
	{
		super("No more avialable space.");
	}
}
