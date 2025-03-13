import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class OneLineApplet extends Applet {
    private int startX;

    private int startY;

    private int endX;
    private int endY;
    private boolean drawing = false;

    public void init() {
        
        MyMouseListener M = new MyMouseListener();
        addMouseListener(M);
        addMouseMotionListener(M);
    }

    public void paint(Graphics g) 
    {
        g.setColor(Color.BLACK);
        if (drawing)
         {
            g.drawLine(startX, startY, endX, endY);
        }
    }

    private class MyMouseListener implements MouseListener, MouseMotionListener {
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
            drawing = true;
        }

        public void mouseReleased(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            repaint();
        }

        public void mouseDragged(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            repaint();
        }

        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
    }
}
