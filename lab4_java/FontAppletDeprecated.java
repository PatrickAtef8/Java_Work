import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Toolkit;

public class FontAppletDeprecated extends Applet
{
     
	String[] fonts;
    
    public void init()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

       fonts = toolkit.getFontList();
    }
    
    public void paint(Graphics g)
    {
        int y = 40;
        for (int i = 0; i < fonts.length; i++)
       	      {
            g.setFont(new Font(fonts[i], Font.BOLD, 20));
            g.drawString(fonts[i], 10, y); 
            y += 40;
        }
    }
}

