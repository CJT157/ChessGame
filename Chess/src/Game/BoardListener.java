package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BoardListener implements ActionListener {
    private static boolean active = true;

    public static void setActive(boolean active) {
        BoardListener.active = active;
    }

    protected abstract void doPerformAction(ActionEvent e);

    @Override
    public final void actionPerformed(ActionEvent e) {
        if (active) {
            doPerformAction(e);
        }
    }
}
