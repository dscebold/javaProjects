import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyDetecter implements KeyListener {

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
        System.out.println("Key code " + e.getKeyCode() + " was released");
    }
}

public class AutoClicker {

    public static void main(String[] args) throws AWTException{
        Robot robot = new Robot();
        Key
        while (true) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            if()
        }

    }

}
