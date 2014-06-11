package panelswithtimers2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanDisp extends JPanel // panel definition
{
    PanOut panOut;
    private JLabel lblName;
    private String sLabel;
    private int nScore;
    int Road1xPos,Road2xPos;
    Timer timer;
    Image CarImg;
    boolean isTitle = true;
    public PanDisp(PanOut _panOut) {
        panOut = _panOut;
        timer = new Timer(5, drive);
        // this Panel will contain all of the output, therefore called PanDisp for display
        // It will be in the CENTRE of PanMain
        lblName = new JLabel(" Highway to Hell");
        add(lblName); //add it to the Frame
        nScore = 0;
        timer.start();
    }

    void UpdateLabel(String _sNew) {
        sLabel = _sNew;
        lblName.setText(sLabel);
    }
    void UpdateCar(Image _CarImg) {
        //sColour = _sNew;
        //sColour = "Color."+_sNew;
        CarImg=_CarImg;
    }
    
    ActionListener drive = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
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
             panOut.UpdateLabel("Score:"+nScore);
             //System.out.println(nScore);
         }
      };
      // Allocate a Timer to run updateTask's actionPerformed() after every delay msec
      //timer = new Timer(1000, updateTask).start();
    
    
}
