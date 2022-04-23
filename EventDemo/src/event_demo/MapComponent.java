package event_demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.beans.*;

public class MapComponent extends JPanel {
	public MapComponent(Model model, PropertyChangeListener distanceListener) {
        this.model = model;
        try {                
            image = ImageIO.read(new File(FILE_NAME));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, String.format("File %s caused an IO error when trying to load", FILE_NAME), 
            "Unable to load file", JOptionPane.ERROR_MESSAGE);
        }
        image = image.getSubimage(0, 0, image.getWidth(), image.getHeight() - CROP_BOTTOM);

        pointerTimer = new Timer(POINTER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    pointer = false;
                    pointerTimer.stop();
                    repaint();
                }
            });

        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pointer = true;
                int[] MRCLoc = model.getCoords("MRC");
                pointerCoords[0] = (int)Math.round(MRCLoc[0] * widthScale);
                pointerCoords[1] = (int)Math.round(MRCLoc[1] * heightScale);
                pointerCoords[2] = e.getX();
                pointerCoords[3] = e.getY();
                repaint();
                pointerTimer.restart();
           }
           @Override
           public void mouseMoved(MouseEvent e) {
            int mouseX = (int)Math.round(e.getX() / widthScale);
            int mouseY = (int)Math.round(e.getY() / heightScale);
            int[] MRCLoc = model.getCoords("MRC");
            setDistance(String.format("Mouse position (%d, %d); scaled (%d, %d); distance %.2f from MRC (%d, %d)", e.getX(), e.getY(),
            mouseX, mouseY, model.getBuilding("MRC").getDistanceFrom(mouseX, mouseY), MRCLoc[0], MRCLoc[1]));
           }
        };
         this.addMouseListener(mouseListener);
         this.addMouseMotionListener(mouseListener);
         this.addPropertyChangeListener(distanceListener);
    }

    public void
    addPropertyChangeListener(PropertyChangeListener listener) {
        distancePcs.addPropertyChangeListener(listener);
    }

    public void
    removePropertyChangeListener(PropertyChangeListener listener) {
        distancePcs.removePropertyChangeListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
       super.paintComponent(g); // erase background
       Graphics2D g2 = (Graphics2D) g;
       widthScale = (double)this.getSize().width / image.getWidth();
       heightScale = (double)this.getSize().height / image.getHeight();
       widthScale = widthScale < heightScale ? widthScale : heightScale;
       heightScale = heightScale < widthScale ? heightScale : widthScale;
       int width = (int) (image.getWidth() * widthScale);
       int height = (int) (image.getHeight() * heightScale);
       g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       g2.drawImage(image, 0, 0, width, height, this);
       if (pointer) {
           g2.setColor(POINTER_COLOR);
           g2.setStroke(POINTER_STROKE);
           g2.drawLine(pointerCoords[0],pointerCoords[1], pointerCoords[2], pointerCoords[3]);
       }
    }

    private void setDistance(String distance) {
        String oldDistance = this.distance;
        this.distance = distance;
        distancePcs.firePropertyChange("distance", oldDistance, distance);
    }

    private BufferedImage image;
    private static final String FILE_NAME = "data/RPI_campus_map_2010_extra_nodes_edges.png";
    private double widthScale = 1.0;
    private double heightScale = 1.0;
    private Model model;
    private String distance;
    private PropertyChangeSupport distancePcs = new PropertyChangeSupport(this);
    private boolean pointer = false;
    private int[] pointerCoords = new int[4];
    private Timer pointerTimer;
	private static final long serialVersionUID = 1L;
    private static final int CROP_BOTTOM = 1405;
    private static final Color POINTER_COLOR = Color.RED;
    private static final Stroke POINTER_STROKE = new BasicStroke(2);
    private static final int POINTER_DELAY = 2000;
}
