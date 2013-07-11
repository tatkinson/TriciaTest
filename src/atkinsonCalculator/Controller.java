package atkinsonCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller 
{
	private Model _model;
	private View _view;
	
	public Controller(Model model, View view)
	{
		_model = model;
		_view = view;
		_view.addNumberListener(new NumberListener());
		_view.addEqualListener( new EqualListener());
		_view.addOperationListener(new OperationListener());
		_view.addClearListner(new ClearListener());
		_view.addPeriodListener(new PeriodListener());
		_model.clear();
	}
	
	public void Display()
	{
		_view.setVisible(true);
	}
	
	public void DisplayError(String message)
	{
		_view.displayError(message);
	}
	
	private void RemoveDecimalIfNecessary(String displayText)
	{
		if (displayText.contains("."))
		{
			String decimalString = displayText.substring(displayText.indexOf(".")+1);
			if (Integer.parseInt(decimalString) == 0)
			{
				displayText = displayText.substring(0, displayText.indexOf("."));
			}		
		}
		_view.setUserInput(displayText);
	}
	
	class NumberListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{			
			String input = _view.getUserInput();
			String source = ((JButton)e.getSource()).getText();
			input += source;
			_view.setUserInput(input);
		}
	}
	class EqualListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{			
			String input = _view.getUserInput();
			try 
			{
				_model.doOperation(input);
			} 
			catch (InputException exc)
			{
				_view.displayError(exc.getMessage());
			}
			finally
			{
				RemoveDecimalIfNecessary(_model.getTotal());
			}
		}
	}
	class OperationListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{			
			String input = _view.getUserInput();
			String source = ((JButton)e.getSource()).getText();
			try
			{
				_model.setOperation(source, input);
			} 
			catch (Exception exc)
			{
				_view.displayError(exc.getMessage());
			}
			finally
			{
				_view.setUserInput("");
			}
		}
	}
	
	class ClearListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{			
			if (_view.getUserInput().isEmpty())
			{
				_model.clear();
			}
			_view.setUserInput("");
		}
	}
	class PeriodListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{			
			String userInput = _view.getUserInput();
			
			if (!userInput.contains("."))
			{
				userInput += ".";
			}
			_view.setUserInput(userInput);
		}
	}
}


