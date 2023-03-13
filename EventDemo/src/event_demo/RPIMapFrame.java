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
        
        map = new MapComponent(model, this); 
        JScrollPane scrollableMapArea = new JScrollPane(map);
  
        scrollableMapArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scrollableMapArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        add(scrollableMapArea);

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
    public MapComponent map;
    private JLabel status;
    private Model model = new Model();
    private static final long serialVersionUID = 1L;
}
