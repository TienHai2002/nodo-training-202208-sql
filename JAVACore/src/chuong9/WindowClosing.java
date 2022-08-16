package chuong9;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public interface WindowClosing extends WindowListener {
    public default void windowOpened(WindowEvent e) {}
    public default void windowIconified(WindowEvent e) {}
    public default void windowDeiconified(WindowEvent e) {}
    public default void windowActivated(WindowEvent e) {}
    public default void windowDeactivated(WindowEvent e) {}
    public default void windowClosed(WindowEvent e) {}
}
