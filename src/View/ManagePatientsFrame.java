package View;

import javax.swing.*;

public class ManagePatientsFrame extends JFrame {
    InitialPanelPatients ipp;
    public ManagePatientsFrame(){
        super("Manage Patients Dashboard");
        ipp=new InitialPanelPatients();
        add(ipp);
        pack();
        setSize(500,600);
    }

    public void setIpp(InitialPanelPatients ipp) {
        this.ipp = ipp;
    }

    public InitialPanelPatients getIpp() {
        return ipp;
    }
}
