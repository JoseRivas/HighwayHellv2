package panelswithtimers2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanDispChange extends JPanel // panel definition
{
    PanDisp panDisp;
    String sName;

    public PanDispChange(PanDisp _panDisp) {
        panDisp = _panDisp;
        JButton btn1 = new JButton("Start");
        JButton btn2 = new JButton("Options-COMING SOON!");
        JButton btn3 = new JButton("Highscores-COMING SOON!");
        add(btn1);
        add(btn2);
        add(btn3);
        class MenuOptionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                Object src = event.getSource();
                JButton btn1 = (JButton) event.getSource();
                if(src==btn1){
                    panDisp.isTitle=false;
                }
            }
        }
        ActionListener MenuOption = new MenuOptionListener();
        btn1.addActionListener(MenuOption);
    }
}
