package View.Doctor;

import javax.swing.*;

public class AddPanelDoctors extends JPanel {
    JTextField txt_Doctor_ID;
    JTextField txt_Doctor_fName;
    JTextField txt_Doctor_lname;
    JTextField txt_email;
    JTextField txt_Doctor_Speciality;
    JTextField txt_Doctor_Experience;
    JButton addDoctorBtn;
    public AddPanelDoctors(){
        txt_Doctor_ID = new JTextField();
        txt_Doctor_fName = new JTextField();
        txt_Doctor_lname = new JTextField();
        txt_email = new JTextField();
        txt_Doctor_Speciality=new JTextField();
        txt_Doctor_Experience=new JTextField();

        addDoctorBtn = new JButton("Add Doctor");

        txt_Doctor_ID.setText("Doctor_ID");
        txt_Doctor_fName.setText("Doctor_First_Name");
        txt_Doctor_lname.setText("Doctor_Last_Name");
        txt_email.setText("Doctor_Email");
        txt_Doctor_Speciality.setText("Doctor_Speciality");
        txt_Doctor_Experience.setText("Doctor_Experience");


        add(txt_Doctor_ID);
        add(txt_Doctor_fName);
        add(txt_Doctor_lname);
        add(txt_email);
        add(txt_Doctor_Speciality);
        add(txt_Doctor_Experience);
        add(addDoctorBtn);
    }

    public JButton getAddDoctorBtn() {
        return addDoctorBtn;
    }

    public JTextField getTxt_Doctor_fName() {
        return txt_Doctor_fName;
    }

    public JTextField getTxt_Doctor_lname() {
        return txt_Doctor_lname;
    }

    public JTextField getTxt_email() {
        return txt_email;
    }

    public JTextField getTxt_Doctor_ID() { return txt_Doctor_ID; }

    public JTextField getTxt_Doctor_Speciality() { return txt_Doctor_Speciality; }

    public JTextField getTxt_Doctor_Experience() { return txt_Doctor_Experience; }

    public void setTxt_Doctor_Experience(JTextField txt_Doctor_Experience) {
        this.txt_Doctor_Experience = txt_Doctor_Experience;
    }

    public void setTxt_Doctor_Speciality(JTextField txt_Doctor_Speciality) {
        this.txt_Doctor_Speciality = txt_Doctor_Speciality;
    }

    public void setTxt_email(JTextField txt_email) {
        this.txt_email = txt_email;
    }

    public void setTxt_Doctor_lname(JTextField txt_Doctor_lname) {
        this.txt_Doctor_lname = txt_Doctor_lname;
    }

    public void setAddDoctorBtn(JButton addDoctorBtn) {
        this.addDoctorBtn = addDoctorBtn;
    }

    public void setTxt_Doctor_fName(JTextField txt_Doctor_fName) {
        this.txt_Doctor_fName = txt_Doctor_fName;
    }

    public void setTxt_Doctor_ID(JTextField txt_Doctor_ID) {
        this.txt_Doctor_ID = txt_Doctor_ID;
    }
}

