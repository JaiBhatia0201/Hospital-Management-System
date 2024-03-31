package View.Admit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterPanelAdmit extends JPanel {
    ArrayList <JButton> buttons=new ArrayList <>();
    public CenterPanelAdmit()
    {
        super();
    }
    public void createButtons(int count)
    {
        for (int i=1; i<=count;i++)
        {
            JButton b=new JButton();
            b.setBackground(new Color(242, 179,255));
            b.setSize(500,50);
            buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }
    public void setButtontext(int button_no, String button_txt)
    {
        buttons.get(button_no).setText(button_txt);
    }
    public ArrayList<JButton> getAllButtons()
    {
        return buttons;
    }
}
