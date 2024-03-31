package View;

import javax.swing.*;

public class EditPanelPatients extends JPanel {
    JTextField txt_get_patient_idx;
    JTextField txt_Pat_id;
    JTextField txt_Pat_name;
    JTextField txt_Pat_Age;
    JTextField txt_Doc_ID_Assigned;
    JTextField txt_Pat_Gender;
    JButton editPatBtn;
    JButton getPatBtn;
    public EditPanelPatients()
    {
        txt_get_patient_idx=new JTextField();
        txt_Pat_id=new JTextField();
        txt_Pat_name=new JTextField();
        txt_Pat_Age=new JTextField();
        txt_Doc_ID_Assigned=new JTextField();
        txt_Pat_Gender=new JTextField();
        editPatBtn=new JButton("Edit Patient");
        getPatBtn=new JButton("Get Patient to edit");

        txt_get_patient_idx.setText("pat id to get");
        txt_Pat_id.setText("txt_pat_id");
        txt_Pat_name.setText("txt_pat_name");
        txt_Pat_Age.setText("txt_pat_age");
        txt_Doc_ID_Assigned.setText("txt_doc_id");
        txt_Pat_Gender.setText("txt_pat_gender");

        add(txt_get_patient_idx);
        add(getPatBtn);
        add(txt_Pat_id);
        add(txt_Pat_name);
        add(txt_Pat_Age);
        add(txt_Doc_ID_Assigned);
        add(txt_Pat_Gender);
        add(editPatBtn);
    }

    public JButton getEditPatBtn() {
        return editPatBtn;
    }

    public JButton getGetPatBtn() {
        return getPatBtn;
    }

    public JTextField getTxt_Doc_ID_Assigned() {
        return txt_Doc_ID_Assigned;
    }

    public JTextField getTxt_Pat_Age() {
        return txt_Pat_Age;
    }

    public JTextField getTxt_Pat_id() {
        return txt_Pat_id;
    }

    public JTextField getTxt_Pat_Gender() {
        return txt_Pat_Gender;
    }

    public JTextField getTxt_Pat_name() {
        return txt_Pat_name;
    }

    public JTextField getTxt_get_patient_idx() {
        return txt_get_patient_idx;
    }
}
