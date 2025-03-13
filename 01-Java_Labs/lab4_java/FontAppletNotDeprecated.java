import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class FontAppletNotDeprecated extends Applet {
    private String[] fonts;
    
    public void init()
            {
        GraphicsEnvironment E = GraphicsEnvironment.getLocalGraphicsEnvironment();

        fonts = E.getAvailableFontFamilyNames();
    }
    
    public void paint(Graphics g) 
            {
        int y = 40; 
        for (int i = 0; i < fonts.length; i++) 
	     {
            g.setFont(new Font(fonts[i], Font.BOLD, 30)); 
            g.drawString(fonts[i], 10, y);
            y += 30; 
        }
    }
}

