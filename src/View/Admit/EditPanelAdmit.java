package View.Admit;

import javax.swing.*;

public class EditPanelAdmit extends JPanel {

    JTextField txt_get_admit_idx;
    JButton getAdmitBtn;
    JTextField txt_Doctor_id;
    JTextField txt_Patient_id;
    JTextField txt_admit_date;
    JTextField txt_Bill;
    JButton editAdmitBtn;

    public EditPanelAdmit()
    {

        txt_Doctor_id = new JTextField();
        txt_Patient_id = new JTextField();
        txt_admit_date = new JTextField();
        txt_Bill = new JTextField();
        editAdmitBtn = new JButton("Edit Admit");
        txt_get_admit_idx = new JTextField();
        getAdmitBtn = new JButton("Get Admit to Edit");

        txt_Doctor_id.setText("txt_doctor_id");
        txt_Patient_id.setText("txt_patient_id");
        txt_admit_date.setText("txt_admit_date");
        txt_Bill.setText("    txt_bill    ");
        txt_get_admit_idx.setText("get admit idx");

        add(txt_get_admit_idx);
        add(getAdmitBtn);

        add(txt_Doctor_id);
        add(txt_Patient_id);
        add(txt_admit_date);
        add(txt_Bill);
        add(editAdmitBtn);
    }

    public JTextField getTxt_Doctor_id() {
        return txt_Doctor_id;
    }

    public JTextField getTxt_Patient_id() {
        return txt_Patient_id;
    }

    public JTextField getTxt_admit_date() {
        return txt_admit_date;
    }

    public JTextField getTxt_Bill() {
        return txt_Bill;
    }

    public JButton getEditAdmitBtn() {
        return editAdmitBtn;
    }

    public JTextField getTxt_get_admit_idx() {
        return txt_get_admit_idx;
    }

    public JButton getGetAdmitBtn() {
        return getAdmitBtn;
    }

    public void setTxt_Doctor_id(JTextField txt_Doctor_id) {
        this.txt_Doctor_id = txt_Doctor_id;
    }

    public void setTxt_Patient_id(JTextField txt_Patient_id) {
        this.txt_Patient_id = txt_Patient_id;
    }

    public void setTxt_admit_date(JTextField txt_admit_date) {
        this.txt_admit_date = txt_admit_date;
    }

    public void setTxt_Bill(JTextField txt_Bill) {
        this.txt_Bill = txt_Bill;
    }

    public void setEditAdmitBtn(JButton editAdmitBtn) {
        this.editAdmitBtn = editAdmitBtn;
    }

    public void setTxt_get_admit_idx(JTextField txt_get_admit_idx) {
        this.txt_get_admit_idx = txt_get_admit_idx;
    }

    public void setGetAdmitBtn(JButton getAdmitBtn) {
        this.getAdmitBtn = getAdmitBtn;
    }

}
