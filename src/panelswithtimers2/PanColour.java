package panelswithtimers2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanColour extends JPanel // panel definition
{   
    PanDisp panDisp;

    public PanColour(PanDisp _panDisp) {
        panDisp = _panDisp;      
        setLayout(new GridLayout(3, 1));
        // notice now that I created a new CarColour class that takes the name and 
        // the Image variable. Look at the CarColour class which extends JButton
        CarColour btnRed = new CarColour("Red Car");
        CarColour btnBlue = new CarColour("Blue Car");
        CarColour btnYellow = new CarColour("Yellow Car");
        add(btnRed);
        add(btnBlue);
        add(btnYellow);
        class ColourChangeListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                // I get the source of the click, and then I can find out what Image has been assigned 
                //to that button.
                CarColour btn = (CarColour)event.getSource();
                Image carImg = btn.getImage("");
                panDisp.UpdateCar(carImg);
            }
        }
        ActionListener colourChangeListener = new ColourChangeListener();
        // all 3 buttons call the same listener
        btnRed.addActionListener(colourChangeListener);
        btnBlue.addActionListener(colourChangeListener);
        btnYellow.addActionListener(colourChangeListener);
        
        
    }/*
     public void paintComponent(Graphics g) {

     g.drawString("Colour", 50, 50);
        
     }*/

}