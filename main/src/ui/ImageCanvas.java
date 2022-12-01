package ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class ImageCanvas extends Canvas
{
    private static final String PATH_TO_WEAPONS = "main\\images\\weapons\\";
    private static final String IMAGE_TYPE = ".png";

    private String current_weapon = "dagger";

    public void paint(Graphics g)
    {
        super.paint(g);

        Image weaponsImage = null;
        try
        {
            weaponsImage = ImageIO.read(new File(PATH_TO_WEAPONS + current_weapon + IMAGE_TYPE));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        g.drawImage(weaponsImage, 100, 100, null);
    }

    public void setCurrentWeapon(String w)
    {
        current_weapon = w;
        this.paint(this.getGraphics());
    }


}
