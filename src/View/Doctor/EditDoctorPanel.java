package View.Doctor;

import javax.swing.*;

public class EditDoctorPanel extends JPanel {

    JTextField txt_get_doctor_idx;
    JButton getDoctorBtn;
    JTextField txt_Doctor_id;
    JTextField txt_Doctor_fname;
    JTextField txt_Doctor_lname;
    JTextField txt_email;
    JTextField txt_Doctor_Speciality;
    JTextField txt_Doctor_Experience;
    JButton editDoctorBtn;

    public EditDoctorPanel() {

        txt_Doctor_id = new JTextField();
        txt_Doctor_fname = new JTextField();
        txt_Doctor_lname = new JTextField();
        txt_Doctor_Speciality = new JTextField();
        txt_Doctor_Experience = new JTextField();
        txt_email=new JTextField();
        editDoctorBtn = new JButton("Edit Doctor");
        txt_get_doctor_idx = new JTextField();
        getDoctorBtn = new JButton("Get Doctor to Edit");

        txt_Doctor_id.setText("id");
        txt_Doctor_fname.setText("first_name");
        txt_Doctor_lname.setText("last_name");
        txt_email.setText("email");
        txt_Doctor_Speciality.setText("Speciality");
        txt_Doctor_Experience.setText("Experience");
        txt_get_doctor_idx.setText("get Doctor id");

        add(txt_get_doctor_idx);
        add(getDoctorBtn);

        add(txt_Doctor_id);
        add(txt_Doctor_fname);
        add(txt_Doctor_lname);
        add(txt_email);
        add(txt_Doctor_Speciality);
        add(txt_Doctor_Experience);
        add(editDoctorBtn);
    }

    public JTextField getTxt_Doctor_id() { return txt_Doctor_id; }

    public JTextField getTxt_Doctor_fname() {
        return txt_Doctor_fname;
    }

    public JTextField getTxt_Doctor_lname() {
        return txt_Doctor_lname;
    }

    public JTextField getTxt_email() {
        return txt_email;
    }

    public JTextField getTxt_Doctor_Speciality() {
        return txt_Doctor_Speciality;
    }

    public JTextField getTxt_Doctor_Experience() {
        return txt_Doctor_Experience;
    }

    public JButton getEditDoctorBtn() {
        return editDoctorBtn;
    }

    public JTextField getTxt_get_doctor_idx() {
        return txt_get_doctor_idx;
    }

    public JButton getGetDoctorBtn() {
        return getDoctorBtn;
    }

    public void setTxt_Doctor_id(JTextField txt_Doctor_id) {
        this.txt_Doctor_id = txt_Doctor_id;
    }

    public void setTxt_Doctor_fname(JTextField txt_Doctor_fname) {
        this.txt_Doctor_fname = txt_Doctor_fname;
    }

    public void setTxt_Doctor_lname(JTextField txt_Doctor_lname) {
        this.txt_Doctor_lname = txt_Doctor_lname;
    }

    public void setTxt_email(JTextField txt_email) {
        this.txt_email = txt_email;
    }

    public void setTxt_Doctor_Speciality(JTextField txt_Doctor_Speciality) {
        this.txt_Doctor_Speciality = txt_Doctor_Speciality;
    }

    public void setTxt_Doctor_Experience(JTextField txt_Doctor_Experience) {
        this.txt_Doctor_Experience = txt_Doctor_Experience;
    }

    public void setEditDoctorBtn(JButton editDoctorBtn) {
        this.editDoctorBtn = editDoctorBtn;
    }

    public void setTxt_get_doctor_idx(JTextField txt_get_doctor_idx) {
        this.txt_get_doctor_idx = txt_get_doctor_idx;
    }

    public void setGetDoctorBtn(JButton getDoctorBtn) {
        this.getDoctorBtn = getDoctorBtn;
    }
}
