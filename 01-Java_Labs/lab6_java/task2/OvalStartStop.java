import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OvalStartStop extends Applet implements Runnable {
    Thread th;
    int x, y;
    int diameter = 50;  
    int speedX = 10;
    int speedY = 10;  
    int directionX = 1, directionY = 1;  
    Button startButton, stopButton;

    public void init() {
        x = 0;  
        y = 0;  
        startButton = new Button("Start");

        stopButton = new Button("Stop");
        
        startButton.addActionListener(new ButtonHandler());
        
        stopButton.addActionListener(new ButtonHandler());
        
        add(startButton);
        add(stopButton);
        
        th = new Thread(this);
        th.start();
        th.suspend(); 
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE); 
        g.fillOval(x, y, diameter, diameter);  
    }

    public void run() {
        while (true) {
            try {
                x += speedX * directionX;
                y += speedY * directionY;

                if (x + diameter >= getWidth() || x <= 0) {
                    directionX *= -1;  
                }
                if (y + diameter >= getHeight() || y <= 0) {
                    directionY *= -1;  
                }
                repaint();  
                Thread.sleep(20);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == startButton) 
            {
                th.resume();
            }
             else if (e.getSource() == stopButton) 
             {
                th.suspend();

            }
        }
    }
}