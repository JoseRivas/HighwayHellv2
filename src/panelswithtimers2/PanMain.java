package panelswithtimers2;
// this is for Riley D.
// I am going to put a timer in PanDisp, and update a Label in PanOut.

import javax.swing.*;
import java.awt.*;

public class PanMain extends JPanel // panel definition
{

    PanOut panOut = new PanOut();
    PanDisp panDisp = new PanDisp(panOut);
    PanDispChange panLabelChange = new PanDispChange(panDisp);
    PanColour panColour = new PanColour(panDisp);
    private PanOut PanOut;

    public PanMain() {
        // this next line tells PanMain that it has a border layout.
        setLayout(new BorderLayout());
        add(panLabelChange, BorderLayout.SOUTH);
        add(panDisp, BorderLayout.CENTER);
        add(panOut, BorderLayout.EAST);
        add(panColour, BorderLayout.WEST);

    }
}