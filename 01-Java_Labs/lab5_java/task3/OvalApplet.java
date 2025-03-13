import java.applet.Applet;
import java.awt.*;

public class OvalApplet extends Applet implements Runnable {
    Thread th;
    int x, y;
    int diameter = 50;  
    int directionX= 1, directionY = 1;  

    public void init()
     {
        x = 0;  
        y = 0;  
         th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) 
    {
        g.setColor(Color.BLUE); 
        g.fillOval(x, y, diameter, diameter);  
    }

    public void run()
     {
        while (true) 
        {
            try {
               
                x+=directionX*10;
                y+=directionY*10;

                
                if (x + diameter >= getWidth() || x <= 0)
	       	{
                    directionX *= -1;  
                }

                if (y + diameter >= getHeight() || y <= 0)
	       	{
                    directionY *= -1;  
                }

                repaint();  

                Thread.sleep(10); 
            } 
            catch (InterruptedException ie)
             {
                ie.printStackTrace();
            }
        }
    }
}
