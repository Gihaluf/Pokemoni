package ui;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class UIStateManager {

    public static void setPanelContent(JPanel panel, JComponent content) {
        panel.removeAll();
        if (content != null) {
            panel.add(content);
        }
        refresh(panel);
    }

    public static void clearAndRefresh(Component component) {
        if (component instanceof JPanel) {
            JPanel panel = (JPanel) component;
            panel.removeAll();
            refresh(panel);
        }
    }

    public static void refresh(Component component) {
        component.revalidate();
        component.repaint();
    }
}
