import java.applet.Applet;
import java.awt.*;

public class JavaWorldApplet extends Applet implements Runnable {
    Thread th;
    String text = "Java world ";
    int x;
    int y = 100;  
    int textLength = 100;  

    public void init() 
    {
        x = getWidth();  
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) 
    {
        g.drawString(text, x, y);
    }

    public void run()
     {
        while (true) 
        {
            try
             {
                x -= 5;  
                if (x < -textLength) 
                {  
                    x = getWidth();
                }

                repaint();

                Thread.sleep(50);  
            }
             catch (InterruptedException ie) 
            {
                ie.printStackTrace();
            }
        }
    }
}
