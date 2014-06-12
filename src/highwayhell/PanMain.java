package highwayhell;

import javax.swing.*;
import java.awt.*;

public class PanMain extends JPanel // panel definition
{

    PanOut panOut = new PanOut();
    PanDisp panDisp = new PanDisp(panOut);

    ;

    public PanMain() {
        setLayout(new BorderLayout());
        add(panDisp, BorderLayout.CENTER);
        add(panOut, BorderLayout.EAST);
    }
}
