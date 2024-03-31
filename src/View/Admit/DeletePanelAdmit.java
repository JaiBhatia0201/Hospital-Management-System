package View.Admit;

import javax.swing.*;

public class DeletePanelAdmit extends JPanel {

    JTextField txt_del_admit_idx;
    JButton deleteAdmitBtn;

    public DeletePanelAdmit()
    {

        txt_del_admit_idx = new JTextField();
        deleteAdmitBtn = new JButton("Delete Admit");

        txt_del_admit_idx.setText("txt_admit_idx");

        add(txt_del_admit_idx);
        add(deleteAdmitBtn);
    }

    public JButton getDeleteAdmitBtn() {
        return deleteAdmitBtn;
    }

    public JTextField getTxt_del_admit_idx() {
        return txt_del_admit_idx;
    }

    public void setDeleteAdmitBtn(JButton deleteAdmitBtn) {
        this.deleteAdmitBtn = deleteAdmitBtn;
    }

    public void setTxt_del_admit_idx(JTextField txt_del_admit_idx) {
        this.txt_del_admit_idx = txt_del_admit_idx;
    }
}
