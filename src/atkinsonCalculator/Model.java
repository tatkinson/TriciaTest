package atkinsonCalculator;


public class Model 
{
	private Double _total = 0.0;
	private String _operation = "";
	
	public String getTotal()
	{
		return String.valueOf(_total);
	}
		
	public void setOperation(String operation, String userInput) throws InputException
	{
		if (!_operation.isEmpty())
		{
			doOperation(userInput);
		}
		_total = Double.parseDouble(userInput);
				
		_operation = operation;
	}
	public void clear()
	{
		_total = 0.0;
		_operation = "";
	}

	public void doOperation(String userInput) throws InputException
	{
		Double input; 
		try 
		{
			input = Double.parseDouble(userInput);
		} 
		catch (NumberFormatException e)
		{
			return;
		}
		
		switch (_operation)
		{
		case "+":
			add(input);
			break;
		case "-":
			subtract(input);
			break;
		case "*":
			multiply(input);
			break;
		case "/":
			divide(input);
			break;
		default:
			break;
		}
		
	}
	private void multiply(Double input)
	{
		_total =  _total * input ;
	}
	public void divide(Double input) throws InputException
	{
		if (input == 0)
		{
			throw new InputException("Cannot divide by 0");
		}
		_total =  _total / input ;
	}
	public void add(Double input)
	{
		_total += input;
	}
	public void subtract(Double input)
	{
		_total -= input;
	}
	
}
