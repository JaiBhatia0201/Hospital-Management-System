package View.Doctor;

import javax.swing.*;

public class ManageDoctorsFrame extends JFrame {
    InitialPanelDoctors ipd;
    public ManageDoctorsFrame(){
        super("Manage Doctor Dashboard");
        ipd=new InitialPanelDoctors();
        add(ipd);
        pack();
        setSize(500,600);
    }

    public void setIpd(InitialPanelDoctors ipd) {
        this.ipd = ipd;
    }

    public InitialPanelDoctors getIpd() {
        return ipd;
    }
}
