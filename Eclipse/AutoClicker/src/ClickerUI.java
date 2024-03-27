import holder.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClickerUI implements ActionListener, KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key code " + e.getKeyCode() + " was typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key code " + e.getKeyCode() + " was pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() ==   KeyEvent.VK_ENTER) {
            if(this.running) {
                this.timer.stop();
                this.running = !this.running;
            } else {
                this.timer.start();
                this.running = !this.running;
            }
        }
        System.out.println("Key code " + e.getKeyCode() + " was released");
    }

    private JPanel panel;
    private JFrame frame;
    private ArrayList<JButton> buttons;
    private JLabel label;
    private int count = 0;
    private Robot robot;
    private Timer timer;
    private boolean running;


    public ClickerUI() throws AWTException {
        this.running = false;
        timer = new Timer(10, this);
        robot = new Robot();
        buttons = new ArrayList<JButton>();
        frame = new JFrame();
        panel = new JPanel();
        frame.addKeyListener(this);
        frame.setFocusable(true);

        label = new JLabel();
        for(int i = 0; i < 9; i++) {
            JButton but = new JButton("Click Me");
            but.addActionListener(this);
            but.setFocusable(false);
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

    public static void main(String[] args) throws AWTException {
        ClickerUI goop = new ClickerUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of Clicks: " + count);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

    }

}
