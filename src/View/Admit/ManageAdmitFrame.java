package View.Admit;

import javax.swing.*;

public class ManageAdmitFrame extends JFrame {
    InitialPanelAdmit ipa;
    public ManageAdmitFrame()
    {
        super("Manage Admit Dashboard");
        ipa=new InitialPanelAdmit();
        add(ipa);
        pack();
        setSize(500,600);
    }

    public void setIpa(InitialPanelAdmit ipa) {
        this.ipa = ipa;
    }

    public InitialPanelAdmit getIpa() {
        return ipa;
    }
}
