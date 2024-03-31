package View.Doctor;

import javax.swing.*;

public class DeleteDoctorPanel extends JPanel {

    JTextField txt_del_doctor_id;
    JButton deleteDoctorBtn;

    public DeleteDoctorPanel()
    {

        txt_del_doctor_id = new JTextField();
        deleteDoctorBtn = new JButton("Delete Doctor");

        txt_del_doctor_id.setText("txt_doctor_id");

        add(txt_del_doctor_id);
        add(deleteDoctorBtn);
    }

    public JButton getDeleteDoctorBtn() {
        return deleteDoctorBtn;
    }

    public JTextField getTxt_del_doctor_id() {
        return txt_del_doctor_id;
    }

    public void setDeleteDoctorBtn(JButton deleteDoctorBtn) {
        this.deleteDoctorBtn = deleteDoctorBtn;
    }

    public void setTxt_del_doctor_id(JTextField txt_del_doctor_id) {
        this.txt_del_doctor_id = txt_del_doctor_id;
    }
}
