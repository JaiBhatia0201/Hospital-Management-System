package View;

import javax.swing.*;

public class DeletePanelPatients extends JPanel {
    JTextField txt_delete_pat_id;
    JButton deletePatientBtn;
    public DeletePanelPatients()
    {
        txt_delete_pat_id=new JTextField();
        deletePatientBtn=new JButton("Delete Patient");
        txt_delete_pat_id.setText("Pat_id");
        add(txt_delete_pat_id);
        add(deletePatientBtn);
    }

    public JButton getDeletePatientBtn() {
        return deletePatientBtn;
    }

    public JTextField getTxt_delete_pat_id() {
        return txt_delete_pat_id;
    }
}
