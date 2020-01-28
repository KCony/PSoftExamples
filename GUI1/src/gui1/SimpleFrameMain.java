package gui1;

import javax.swing.*;

/**
 * Simple graphics window (based on ex. 7-1 in Core Java 8th ed.)
 */

public class SimpleFrameMain {
	/** Create a frame and display it. */
	public static void main(String[] args) {
		SimpleFrame frame = new SimpleFrame("A Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class SimpleFrame extends JFrame {

	public SimpleFrame(String title) {
		super(title);	// set the title
		pack();  // resize frame to fit components if there are any
		this.setSize(1200,800);
	}
}
