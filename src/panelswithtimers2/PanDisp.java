package panelswithtimers2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanDisp extends JPanel // panel definition
{

    PanOut panOut;
    private JLabel lblName;
    private String sLabel;
    private int nScore;
    int Road1xPos, Road2xPos;
    Timer timer;
    Image CarImg,TitlePage,road;
    boolean isTitle = true;

    public PanDisp(PanOut _panOut) {
        panOut = _panOut;
        timer = new Timer(5, drive);
        CarImg=this.getImage("yellowcar.png");
        TitlePage=this.getImage("titlepage.png");
        // this Panel will contain all of the output, therefore called PanDisp for display
        // It will be in the CENTRE of PanMain
        lblName = new JLabel("Highway to Hell");
        add(lblName); //add it to the Frame
        nScore = 0;
        timer.start();
    }
    ActionListener drive = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if(!isTitle){
            if (Road1xPos < (-802)) {
                Road1xPos = 800;
            }
            if (Road2xPos < (-802)) {
                Road2xPos = 800;
            }
            Road1xPos--;
            Road2xPos--;
            repaint();
            nScore++;
            panOut.UpdateLabel("Score:" + nScore);
            }
            //System.out.println(nScore);
        }
    };
    // Allocate a Timer to run updateTask's actionPerformed() after every delay msec
    //timer = new Timer(1000, updateTask).start();

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        // g2.drawImage(road, Road1xPos, 0,810,700, null);
        if(isTitle){
            g2.drawImage(TitlePage,0,0,getWidth(),getHeight(),null);
        }else{
        g2.drawImage(CarImg, 0, 350, 120, 60, this);
        }
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
