// @author Ric Lee Smith
// Professor Bill Jing
// Java II
// March 22, 2018

/* Assignment #3: Programming Challenges Description of this Assignment: Stopwatch Applet:
Write an applet that simulates a stopwatch. It should have a Start button and a Stop button. When the Start button is clicked the applet should count the seconds that pass. When the Stop button is clicked, the applet should stop counting seconds. */


// import packages for project

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;  
import java.awt.Graphics;  



// Create StopWatch class from JApplet
public class StopWatch extends JApplet
{
	// Variable to hold 1 second delay time
	private final int TIME_DELAY = 1000;
	// Variable to initialize seconds at 0
	private int numSeconds = 0;
	// Variable to set seconds as TextField
	private JTextField seconds;
	// Variables to hold start and stop buttons
	private JButton startButton;
	private JButton stopButton;
	// Variables to hold panels for seconds and buttons
	private JPanel secondsPanel;
	private JPanel buttonPanel;
	// Variable for times
	private Timer timer;
	
	// init function to initialize applet
	public void init()
	{
		// Call the buildButtonPanel method
		buildButtonPanel();
		// Call the buildSecondsPanel
		buildSecondsPanel();

		// Add buttonPanel to SOUTH region in BorderLayout
		add(buttonPanel, BorderLayout.SOUTH);
		// Add secondsPanel to CENTER region in BorderLayout
		add(secondsPanel, BorderLayout.CENTER);
		// Create new timer, passing the 1 second delay and TimerListener as parameters
		timer = new Timer(TIME_DELAY, new TimerListener());
	}

	// Method to build the Button Panel
	private void buildButtonPanel()
	{	
		// Create panel to hold the buttons 
		buttonPanel = new JPanel();
		
		// Create and label start and stop buttons
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");

		// Create ActionListener for when buttons are clicked
		startButton.addActionListener(new StartButtonListener());
		stopButton.addActionListener(new StopButtonListener());
		
		// Add start and stop buttons to buttonPanel
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
	}

	// Method to build the seconds panel
	private void buildSecondsPanel()
	{
		// Create panel to hold secondsPanel
		secondsPanel = new JPanel();
		
		// Create new JTextField for seconds, with length of 10 characters
		seconds = new JTextField(10);
		// Set seconds field to be not editable
		seconds.setEditable(false);
		// Set font and weight for seconds when displayed
		seconds.setFont(new Font("SansSerif", Font.BOLD, 18));
		// Set default value for seconds to be 0
		seconds.setText("0");
		// Add seconds to seconds panel
		secondsPanel.add(seconds);

	}
	// Method to create listener for startButton to start
	private class StartButtonListener implements ActionListener
	{
		// actionPerformed method to start timer
		public void actionPerformed(ActionEvent e)
		{
			timer.start();
		}
	}
	// Method to create listener for stopButton to stop
	private class StopButtonListener implements ActionListener
	{
		// actionPerformed method to stop timer
		public void actionPerformed(ActionEvent e)
		{
			timer.stop();
		}
	}
	// Method to create TimerListener implementing ActionListener
	private class TimerListener implements ActionListener
	{
		// actionPerformed to add seconds to count and set new value to be displayed
		public void actionPerformed(ActionEvent e)
		{
			numSeconds++;
			seconds.setText(String.valueOf(numSeconds));
		}
	}


}
