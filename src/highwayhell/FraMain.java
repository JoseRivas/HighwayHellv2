package highwayhell;

import javax.swing.JFrame;

public class FraMain extends JFrame {

    FraMain() {
        PanMain panMain = new PanMain();
        setSize(900, 600);
        setLocationByPlatform(true);
        setTitle("Highway To Hell");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panMain);
        setVisible(true);

    }
}
