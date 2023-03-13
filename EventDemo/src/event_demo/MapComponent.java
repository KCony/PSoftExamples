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
           
           @Override
           public void mouseWheelMoved(MouseWheelEvent e) {
               int notches = e.getWheelRotation();
//               if (notches != 0) {
//            	   customScale = true;
//               }
               
               if (notches < 0) {
                   widthScale *= Math.pow(SCALE_FACTOR, -notches);
                   heightScale *= Math.pow(SCALE_FACTOR, -notches);
               } else {
                   widthScale /= Math.pow(SCALE_FACTOR, notches);
                   heightScale /= Math.pow(SCALE_FACTOR, notches);
               }
               
               repaint();
               Container parentComponent = getParent();
               if (parentComponent.getClass() == JViewport.class) {
                   JViewport mapParent = (JViewport)getParent();
                   mapParent.revalidate();
                   mapParent.repaint();
               }
            }
           
            /*@Override public void mouseDragged(MouseEvent e) {
                Container eventComponent = (Container)e.getSource();
                Container parentComponent = eventComponent.getParent();
                if (parentComponent.getClass() == JViewport.class) {
					JViewport vport = (JViewport)parentComponent;
					JComponent label = (JComponent)vport.getView();
					Point cp = e.getPoint();
					Point vp = vport.getViewPosition();
					vp.translate(pp.x - cp.x, pp.y - cp.y);
					label.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
					//vport.setViewPosition(vp);
					pp.setLocation(cp);
                }
            }*/

            //private final Point pp = new Point();
        };
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.addMouseWheelListener(mouseListener);
        this.addPropertyChangeListener(distanceListener);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
//            	System.out.println(customScale);
//            	System.out.println(e.getComponent().getSize());
            	//if (!customScale) {
            	if (widthScale == 0.0 && heightScale == 0.0) {
                    widthScale = (double)e.getComponent().getSize().width / image.getWidth();
                    heightScale = (double)e.getComponent().getSize().height / image.getHeight();
                    widthScale = widthScale < heightScale ? widthScale : heightScale;
                    heightScale = heightScale < widthScale ? heightScale : widthScale;
            	}
            }
          });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)Math.round(widthScale * image.getWidth()),
        		(int)Math.round(widthScale * image.getWidth()));
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
    private double widthScale = 0.0;
    private double heightScale = 0.0;
    private boolean customScale = false; 
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
    private static final int POINTER_DELAY = 10000;
    private static final double SCALE_FACTOR = 1.25d;
}
