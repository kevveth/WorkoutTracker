package cisc191.sdmesa.edu.Exceptions;

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
		InvalidInputException.message = "You entered: " + input
				+ ". Please enter a number greater than 0.";
	}

	@Override
	public String getMessage()
	{
		return InvalidInputException.message;
	}

}
