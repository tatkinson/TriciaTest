package atkinsonCalculator;

public class Calculator
{
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		controller.Display();
	}
}
