import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutoClicker {

    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        ClickerUI frame =  new ClickerUI();
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            }
        };
        javax.swing.Timer time = new Timer(1000, actionListener);
    }

}
