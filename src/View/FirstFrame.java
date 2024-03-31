package View;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class FirstFrame extends JFrame {
    JButton manageDoctorsBtn;
    JButton managePatientsBtn;
    JButton manageAdmitBtn;
    JPanel firstPanel;
    BufferedImage bgImage;
    JLabel Heading;
    FirstFrame(){
        super("Main DashBoard");
        Heading=new JLabel("Hospital Management System",SwingConstants.CENTER);
        Heading.setSize(20,20);
        Heading.setForeground(new Color(255, 255, 255));
        Heading.setFont(new Font("algerian",Font.BOLD,100));
        Heading.setOpaque(false);
        Heading.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        manageDoctorsBtn=new JButton("Manage Doctors");
        managePatientsBtn=new JButton("Manage Patients");
        manageAdmitBtn=new JButton("Manage Admits");
        manageAdmitBtn.setBackground(Color.white);
        manageAdmitBtn.setFont(new Font("arial",Font.BOLD,32));
        manageDoctorsBtn.setBackground(Color.white);
        manageDoctorsBtn.setFont(new Font("arial",Font.BOLD,32));
        managePatientsBtn.setBackground(Color.white);
        managePatientsBtn.setFont(new Font("arial",Font.BOLD,32));
        managePatientsBtn.setForeground(new Color(255, 0, 38));
        manageDoctorsBtn.setForeground(new Color(255, 0, 38));
        manageAdmitBtn.setForeground(new Color(255, 0, 38));
        setLayout(new BorderLayout());

        try {
            bgImage = ImageIO.read(new File("src/View/hospital.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bgImage != null) {
                    g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        //backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(Heading);
        add(backgroundPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(3,1,50,50));
        Dimension buttonSize = new Dimension(400, 100);
//        manageAdmitBtn.setOpaque(false);
//        manageDoctorsBtn.setOpaque(false);
//        managePatientsBtn.setOpaque(false);
        manageDoctorsBtn.setPreferredSize(buttonSize);
        managePatientsBtn.setPreferredSize(buttonSize);
        manageAdmitBtn.setPreferredSize(buttonSize);
        buttonPanel.add(manageDoctorsBtn);
        buttonPanel.add(managePatientsBtn);
        buttonPanel.add(manageAdmitBtn);
        buttonPanel.setBounds(0, 0, 300, 200);
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        setSize(600,300);
        setVisible(true);
    }

    public void setFirstPanel(JPanel firstPanel) {
        this.firstPanel = firstPanel;
    }

    public void setManageDoctorsBtn(JButton manageDoctorsBtn) {
        this.manageDoctorsBtn = manageDoctorsBtn;
    }

    public void setManagePatientsBtn(JButton managePatientsBtn) {
        this.managePatientsBtn = managePatientsBtn;
    }

    public void setManageAdmitBtn(JButton manageAdmitBtn) {
        this.manageAdmitBtn = manageAdmitBtn;
    }

    public JPanel getFirstPanel() {
        return firstPanel;
    }

    public JButton getManageDoctorsBtn() {
        return manageDoctorsBtn;
    }

    public JButton getManagePatientsBtn() {
        return managePatientsBtn;
    }

    public JButton getManageAdmitBtn() {
        return manageAdmitBtn;
    }
}
