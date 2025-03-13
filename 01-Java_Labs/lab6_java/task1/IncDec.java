import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncDec extends Applet {
     private int x = 0;
    private Button incButton;
    private Button decButton;

    public void init() {
        incButton = new Button("Increment");
        decButton = new Button("Decrement");
        
        incButton.addActionListener(new MyButtonListener()); 
        decButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x--;
                repaint();
            }
        });
        
        add(incButton);
        add(decButton);
    }

    public void paint(Graphics g) {
        g.drawString("Click Count: " + x, 50, 100);
    }

    class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            x++;
            repaint();
        }
    }
}
