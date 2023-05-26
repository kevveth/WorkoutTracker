package cisc191.sdmesa.edu;

import java.util.InputMismatchException;

@SuppressWarnings("serial")
public class InvalidInputException extends InputMismatchException
{
	private static String message = "Invalid input. Select one of the given options.";

	public InvalidInputException()
	{
		super(message);
	}

	public InvalidInputException(int input)
	{
		this.message = "You entered: " + input
				+ ". Please enter a number greater than 0.";
	}

	@Override
	public String getMessage()
	{
		return this.message;
	}

}
