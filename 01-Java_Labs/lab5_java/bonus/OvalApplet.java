import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

class MovingOval {
    int x, y, diameter = 50;
    int speedX = 5, speedY = 5;
    int directionX, directionY;
    boolean hasSpawned = false;
    
    public MovingOval(int x, int y) {
        this.x = x;
        this.y = y;
        Random rand = new Random();
        this.directionX = rand.nextBoolean() ? 1 : -1;
        this.directionY = rand.nextBoolean() ? 1 : -1;
    }

    public void move(int width, int height) {
        x += speedX * directionX;
        y += speedY * directionY;
        
        if (x + diameter >= width || x <= 0) {
            directionX *= -1;
        }
        if (y + diameter >= height || y <= 0) {
            directionY *= -1;
        }
    }

    public boolean collidesWith(MovingOval other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        int distanceSquared = dx * dx + dy * dy;
        int radiusSum = this.diameter / 2 + other.diameter / 2;
        return distanceSquared <= radiusSum * radiusSum;
    }
}

public class OvalApplet extends Applet implements Runnable {
    Thread th;
    ArrayList<MovingOval> ovals;

    public void init() {
        ovals = new ArrayList<>();
        ovals.add(new MovingOval(50, 50));
        ovals.add(new MovingOval(200, 200));
        
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        for (MovingOval oval : ovals) {
            g.fillOval(oval.x, oval.y, oval.diameter, oval.diameter);
        }
    }

    public void run() {
        while (true) {
            try {
                for (int i = 0; i < ovals.size(); i++) {
                    MovingOval oval1 = ovals.get(i);
                    oval1.move(getWidth(), getHeight());
                    
                    for (int j = i + 1; j < ovals.size(); j++) {
                        MovingOval oval2 = ovals.get(j);
                        if (oval1.collidesWith(oval2) && !oval1.hasSpawned && !oval2.hasSpawned) {
                            ovals.add(new MovingOval((oval1.x + oval2.x) / 2, (oval1.y + oval2.y) / 2));
                            oval1.hasSpawned = true;
                            oval2.hasSpawned = true;
                        }
                    }
                }
                repaint();
                Thread.sleep(20);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}