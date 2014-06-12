package highwayhell;

import java.awt.Color;
import javax.swing.*;

public class PanOut extends JPanel // panel definition
{

    String sScore, sHscore;
    private final JLabel lblScore;

    public PanOut() {
        lblScore = new JLabel();
        add(lblScore);
    }

    void UpdateLabel(String _sScore, String _sHscore) {
        sScore = _sScore;
        sHscore = _sHscore;
        lblScore.setText("<html>" + sScore + "<br />" + sHscore + "</html>");
    }
}
