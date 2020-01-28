package gui5;

import java.awt.*;         // basic AWT classes
import java.awt.event.*;   // event classes
import javax.swing.*;      // Swing classes

class MyButton extends JButton {
	// we need to save some private variables
	private int nEvents = 0;
	private String id;
	
	public MyButton(String id) { 
		super(id);
		this.setActionCommand("OUCH!");
		
		this.id = id;
		
		this.addActionListener(e -> {
			this.nEvents++;
			System.out.println(id + " " + e.getActionCommand() + " " + nEvents);
		});
	}
}
public class ButtonDemoFun {
	
	public static void main(String[] args) {
    // Create new window and set it to exit from application when closed.
    JFrame frame = new JFrame("Button Demo");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    // Create a new button with label "Hit me" and string "OUCH!" to be
    // returned as part of each action event.
    MyButton button = new MyButton("Hit me");
    
    // Add button to the window and make it visible.
    frame.add(button);
    frame.pack();
    frame.setVisible(true);
	}
}
