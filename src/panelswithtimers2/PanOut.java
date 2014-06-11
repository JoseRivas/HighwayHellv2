package panelswithtimers2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanOut extends JPanel // panel definition
{

    String sScore;
    private JLabel lblCount;

    public PanOut() {
        lblCount = new JLabel("0");
        add(lblCount);

    }

    void UpdateLabel(String _sScore) {
        sScore =_sScore;
        lblCount.setText(sScore);
    }
}

