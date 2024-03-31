package View.Admit;

import javax.swing.*;

public class AddPanelAdmit extends JPanel{
    JTextField txt_p_temp;
    JTextField txt_d_temp;
    JTextField txt_bill;
    JTextField txt_admit_date;
    JButton addAdmitbtn;
    public AddPanelAdmit()
    {
        txt_p_temp=new JTextField();
        txt_d_temp=new JTextField();
        txt_admit_date=new JTextField();
        txt_bill=new JTextField();
        addAdmitbtn=new JButton("Add Admit");

        txt_p_temp.setText("Patient_ID");
        txt_d_temp.setText("Doctor_ID");
        txt_bill.setText("Bill");
        txt_admit_date.setText("Admit_Date");

        add(txt_p_temp);
        add(txt_d_temp);
        add(txt_bill);
        add(txt_admit_date);
        add(addAdmitbtn);
    }

    public JButton getAddAdmitbtn() {
        return addAdmitbtn;
    }

    public JTextField getTxt_bill() {
        return txt_bill;
    }

    public JTextField getTxt_admit_date() {
        return txt_admit_date;
    }

    public JTextField getTxt_d_temp() {
        return txt_d_temp;
    }

    public JTextField getTxt_p_temp() {
        return txt_p_temp;
    }

    public void setTxt_admit_date(JTextField txt_admit_date) {
        this.txt_admit_date = txt_admit_date;
    }

    public void setTxt_bill(JTextField txt_bill) {
        this.txt_bill = txt_bill;
    }

    public void setTxt_d_temp(JTextField txt_d_temp) {
        this.txt_d_temp = txt_d_temp;
    }

    public void setTxt_p_temp(JTextField txt_p_temp) {
        this.txt_p_temp = txt_p_temp;
    }

    public void setAddAdmitbtn(JButton addAdmitbtn) {
        this.addAdmitbtn = addAdmitbtn;
    }
}
