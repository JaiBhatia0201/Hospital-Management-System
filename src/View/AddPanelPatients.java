package View;

import javax.swing.*;

public class AddPanelPatients extends JPanel {
    JTextField txt_patient_id;
    JTextField txt_patient_gender;
    JTextField txt_patient_age;
    JTextField txt_patient_name;
    JTextField txt_doc_id_assigned;
    JButton addPatientBtn;
    public AddPanelPatients()
    {
        txt_patient_age=new JTextField();
        txt_patient_id=new JTextField();
        txt_patient_gender=new JTextField();
        txt_patient_name=new JTextField();
        txt_doc_id_assigned=new JTextField();
        addPatientBtn=new JButton("Add Patient");

        txt_patient_id.setText("Patient_ID");
        txt_patient_name.setText("Patient_Name");
        txt_patient_gender.setText("Patient_Gender");
        txt_doc_id_assigned.setText("Doc_ID_Assigned");
        txt_patient_age.setText("Patient_Age");

        add(txt_patient_name);
        add(txt_patient_id);
        add(txt_patient_age);
        add(txt_patient_gender);
        add(txt_doc_id_assigned);
        add(addPatientBtn);

    }

    public JButton getAddPatientBtn() {
        return addPatientBtn;
    }

    public JTextField getTxt_doc_id_assigned() {
        return txt_doc_id_assigned;
    }

    public JTextField getTxt_patient_id() {
        return txt_patient_id;
    }

    public JTextField getTxt_patient_age() {
        return txt_patient_age;
    }

    public JTextField getTxt_patient_gender() {
        return txt_patient_gender;
    }

    public JTextField getTxt_patient_name() {
        return txt_patient_name;
    }

}
