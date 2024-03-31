package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CenterPanelPatients extends JPanel {
    ArrayList <JButton> buttons=new ArrayList <>();
    public CenterPanelPatients() {
        super();

    }


    public void createButtons(int count)
    {
        for (int i=0;i<count;i++)
        {
            JButton b=new JButton();
            b.setBackground(new Color(255,187,153));
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
