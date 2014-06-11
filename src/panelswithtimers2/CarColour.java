package panelswithtimers2;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CarColour extends JButton // panel definition
{
    private String sName;

    public CarColour(String _sName) {
        sName = _sName;
        this.setText(sName);
    }
    
    public Image getImage(String path) {
        Image tempImage = null;
        try {
            tempImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return tempImage;
    }

    public Image getRandImg() {
        Image img = null;
        int nRand;
        String sFilename;
        nRand = (int) (Math.random() * 5) + 1;
        if (nRand == 1) {
            sFilename = "yellowcar.png";
        } else if (nRand == 2) {
            sFilename = "greycar.png";
        } else if (nRand == 3) {
            sFilename = "police.png";
        } else if (nRand == 4) {
            sFilename = "bluecar.png";
        } else {
            sFilename = "whitecar.png";
        }
        try {
            img = ImageIO.read(new File(sFilename));
        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return img;
    }
}