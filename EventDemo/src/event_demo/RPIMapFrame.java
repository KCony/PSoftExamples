package event_demo;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class RPIMapFrame extends JFrame implements PropertyChangeListener {
    public RPIMapFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("RPI Campus Path Finder");
        model.init();

        JPanel mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(0, 1));
        map = new MapComponent(model, this);
        mapPanel.add(map, BorderLayout.CENTER);
        add(mapPanel);

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY),
            new EmptyBorder(4, 4, 4, 4)));
        status = new JLabel();
        statusBar.add(status);
        add(statusBar, BorderLayout.SOUTH);
    }

    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == map) {
            status.setText((String)e.getNewValue());
        }
    }

    public static final int DEFAULT_WIDTH = 1024;
    public static final int DEFAULT_HEIGHT = 768;
    private MapComponent map;
    private JLabel status;
    private Model model = new Model();
}
