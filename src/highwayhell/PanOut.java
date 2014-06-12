package highwayhell;

import java.awt.Color;
import javax.swing.*;

public class PanOut extends JPanel // panel definition
{

    String sScore, sHscore,sSpeed;
    private final JLabel lblScore;

    public PanOut() {
        lblScore = new JLabel();
        add(lblScore);
    }

    void UpdateLabel(String _sScore, String _sHscore,String _sSpeed) {
        sScore = _sScore;
        sHscore = _sHscore;
        sSpeed = _sSpeed;
        lblScore.setText("<html>" + sScore + "<br />" + sHscore + "<br />"+sSpeed+"</html>");
    }
}
