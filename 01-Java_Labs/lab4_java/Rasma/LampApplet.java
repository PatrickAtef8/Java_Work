import java.applet.Applet;
import java.awt.*;

public class LampApplet extends Applet {
    public void paint(Graphics g) {
        Color lampColor = new Color(0, 0, 0);
        g.setColor(Color.BLACK);

         
        int scale = 2;

        
        g.drawRect(150 * scale, 300 * scale, 100 * scale, 20 * scale);

     
        g.drawLine(180 * scale, 300 * scale, 180 * scale, 240 * scale);
        g.drawLine(220 * scale, 300 * scale, 220 * scale, 240 * scale);

        
        g.drawArc(120 * scale, 80 * scale, 160 * scale, 40 * scale, 0, 180);
        g.drawLine(120 * scale, 100 * scale, 90 * scale, 220 * scale);
        g.drawLine(280 * scale, 100 * scale, 310 * scale, 220 * scale);
        g.drawArc(90 * scale, 200 * scale, 220 * scale, 40 * scale, 0, -180);

       
        g.setColor(lampColor);
        g.fillArc(120 * scale, 80 * scale, 160 * scale, 40 * scale, 0, 180);

       
        g.fillOval(170 * scale, 140 * scale, 60 * scale, 90 * scale);
        g.fillOval(100 * scale, 160 * scale, 40 * scale, 60 * scale);
        g.fillOval(260 * scale, 160 * scale, 40 * scale, 60 * scale);

        
        g.setColor(Color.BLACK);
        g.drawOval(170 * scale, 140 * scale, 60 * scale, 90 * scale);
        g.drawOval(100 * scale, 160 * scale, 40 * scale, 60 * scale);
        g.drawOval(260 * scale, 160 * scale, 40 * scale, 60 * scale);
    }
}

