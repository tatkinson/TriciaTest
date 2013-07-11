package atkinsonCalculator; 

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame 
{

	private JButton numberKeys[];
	private JButton multiplyKey = new JButton("*");
	private JButton divideKey= new JButton("/");
	private JButton addKey = new JButton("+");
	private JButton subtractKey= new JButton("-");
	private JButton equalKey= new JButton("=");
	private JButton clearKey = new JButton("C");
	private JButton periodKey = new JButton(".");

	private JPanel keyPad;
	private JTextField userInput;
	
	public View()
	{
		super( "Calculator" );

		userInput = createTextField();

		numberKeys = new JButton[ 10 ];
		for ( int i = 0; i <= 9; i++ )
		{
			numberKeys[ i ] = createButton(String.valueOf(i));
		}

		keyPad = new JPanel();
		keyPad.setLayout( new GridLayout( 5, 4 ) );
		keyPad.add(clearKey);
		keyPad.add(new JButton(""));
		keyPad.add(new JButton(""));
		keyPad.add(divideKey);
		
		for ( int i = 7; i <= 9; i++ )
		{
			keyPad.add( numberKeys[ i ] );
		}
		keyPad.add( multiplyKey );

		for ( int i = 4; i <= 6; i++ )
		{
			keyPad.add( numberKeys[ i ] );
		}
		keyPad.add( subtractKey );

		for ( int i = 1; i <= 3; i++ )
		{
			keyPad.add( numberKeys[ i ] );
		}
		keyPad.add(addKey);

		keyPad.add( numberKeys[ 0 ] );
		keyPad.add(new JButton(""));
		keyPad.add(periodKey);
		keyPad.add(equalKey);
		


		//add components to (default) border layout
		Container container = getContentPane();
		container.add(userInput, BorderLayout.NORTH);
		container.add( keyPad, BorderLayout.CENTER );
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(440,385);
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setLocation(x, y);

		//setSize( 200, 200 );
		setVisible( true );

	}

	private JTextField createTextField() {
		JTextField x = new JTextField( 20 );
		x.setEditable( false );
		
		return x;
	}

	private JButton createButton( String buttonLabel)
	{
		JButton button = new JButton(buttonLabel);
		return button;
	} 

	//execute application
	public static void main( String args[] )
	{
		View application = new View();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public String getUserInput()
	{
		return userInput.getText();
	}
	public void setUserInput(String input)
	{
		userInput.setText(input);
	}
	public void addNumberListener(ActionListener numberListener)
	{
		for (int i = 0; i < numberKeys.length; i++)
		{
			numberKeys[i].addActionListener(numberListener);
		}
	}
	public void addEqualListener(ActionListener equalListener)
	{
		equalKey.addActionListener(equalListener);
	}
	public void addOperationListener(ActionListener operationListener)
	{
		multiplyKey.addActionListener(operationListener);
		divideKey.addActionListener(operationListener);
		addKey.addActionListener(operationListener);
		subtractKey.addActionListener(operationListener);
	}

	public void addClearListner(ActionListener clearListener)
	{
		clearKey.addActionListener(clearListener);
	}
	
	public void addPeriodListener(ActionListener periodListener)
	{
		periodKey.addActionListener(periodListener);
	}
	public void displayError(String message)
	{
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE) ;
	}
}


