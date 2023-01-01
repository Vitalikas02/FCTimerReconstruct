import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        new JsonManager().jsonTimeout();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        new JsonManager().jsonTimeout();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}