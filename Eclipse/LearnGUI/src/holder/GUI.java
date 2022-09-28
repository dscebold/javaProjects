package holder;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	
	
	private JPanel panel;
	private JFrame frame;
	private ArrayList<JButton> buttons; 
	private JLabel label; 
	private int count = 0; 
	
	
	public GUI() {
		buttons = new ArrayList<JButton>();
		frame = new JFrame();
		panel = new JPanel(); 
		
		label = new JLabel(); 
		for(int i = 0; i < 9; i++) {
			JButton but = new JButton("Click Me");
			but.addActionListener(this);
			panel.add(but);
			buttons.add(but); 
		}
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(6, 6, 6,6));
		frame.add(panel, BorderLayout.CENTER);
		
		panel.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		GUI goop = new GUI(); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of Clicks: " + count);
		
	}

}
