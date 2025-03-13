import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ThreeLinesApplet extends Applet {
    private Line[] lines = new Line[3]; 
    private int lineCount = 0;
    
    private int startX, startY;
    private boolean drawing = false;

    public void init() {
        MyMouseListener M = new MyMouseListener();
        addMouseListener(M);
        addMouseMotionListener(M);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < lineCount; i++) 
        {
            lines[i].draw(g);  
        }
    }

    private class MyMouseListener extends MouseAdapter implements MouseMotionListener {
        public void mousePressed(MouseEvent e) {
            if (lineCount < 3) 
            {
                startX = e.getX();
                startY = e.getY();
                drawing = true;
            }
        }

        public void mouseReleased(MouseEvent e) {
            if (drawing && lineCount < 3) {
                lines[lineCount] = new Line(startX, startY, e.getX(), e.getY());
                lineCount++;
                drawing = false;
                repaint();
            }
        }

        public void mouseDragged(MouseEvent e) {}

        public void mouseMoved(MouseEvent e) {}
    }

    private class Line {
        private int x1, y1, x2, y2;

        public Line(int x1, int y1, int x2, int y2)
         {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public void draw(Graphics g) 
        {
            g.drawLine(x1, y1, x2, y2);
        }
    }
}
