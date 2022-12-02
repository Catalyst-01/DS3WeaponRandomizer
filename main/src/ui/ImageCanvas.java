package ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class ImageCanvas extends Canvas
{
    private static final String PATH_TO_WEAPONS = "images\\weapons\\";
    private static final String IMAGE_TYPE = ".png";
    private String current_type = "0";
    private String current_weapon = "dagger";

    public void paint(Graphics g)
    {
        super.paint(g);

        Image weaponsImage = null;
        try
        {
            weaponsImage = ImageIO.read(new File(PATH_TO_WEAPONS + current_type + "\\" + current_weapon + IMAGE_TYPE));
            int imgWidth = weaponsImage.getWidth(null);
            int imgHeight = weaponsImage.getHeight(null);

            double imgAspect = (double) imgHeight / imgWidth;

            int canvasWidth = this.getWidth();
            int canvasHeight = this.getHeight();

            double canvasAspect = (double) canvasHeight / canvasWidth;

            int x1 = 0; // top left X position
            int y1 = 0; // top left Y position
            int x2 = 0; // bottom right X position
            int y2 = 0; // bottom right Y position

            if (imgWidth < canvasWidth && imgHeight < canvasHeight) {
                // the image is smaller than the canvas
                x1 = (canvasWidth - imgWidth) / 2;
                y1 = (canvasHeight - imgHeight) / 2;
                x2 = imgWidth + x1;
                y2 = imgHeight + y1;

            } else {
                if (canvasAspect > imgAspect) {
                    y1 = canvasHeight;
                    // keep image aspect ratio
                    canvasHeight = (int) (canvasWidth * imgAspect);
                    y1 = (y1 - canvasHeight) / 2;
                } else {
                    x1 = canvasWidth;
                    // keep image aspect ratio
                    canvasWidth = (int) (canvasHeight / imgAspect);
                    x1 = (x1 - canvasWidth) / 2;
                }
                x2 = canvasWidth + x1;
                y2 = canvasHeight + y1;
            }

            g.drawImage(weaponsImage, x1, y1, x2, y2, 0, 0, imgWidth, imgHeight, null);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void setCurrentWeapon(String type, String w)
    {
        current_type = type;
        current_weapon = w;
        this.paint(this.getGraphics());
    }

    public String getCurrentWeapon()
    {
        return current_weapon;
    }


}
