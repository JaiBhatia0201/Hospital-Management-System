package Model.Admit;

import Model.Doctors.Doctors;
import Model.Patients.Patients;
import javax.print.Doc;
/**
 * Identification comments:
 *   Name: Dhruv Ashok Lohana
 *   Experiment No: 07
 *   Experiment Title: Implementing JSON File Handling in Java to store relationship objects data. Reading a json file to objects and writing objects to a json data file.
 *   Experiment Date: 20-02-2024
 *   @version 1.0
 *
 * Beginning comments:
 * Filename: Admit.java
 * @author :  Dhruv Ashok Lohana
 * Overview: This is the Admit class. In this file we have achieved the following
 * - Created Attributes
 * --- Patients p_temp
 * --- Doctors d_temp
 * --- String admit_date
 * --- int bill
 *
 */
public class Admit {
    Patients p_temp;
    Doctors d_temp;
    String admit_date;
    int bill;

    public Admit(Patients p_temp, Doctors d_temp, String admit_date, int bill)
    {
        setp_temp(p_temp);
        setd_temp(d_temp);
        setAdmit_date(admit_date);
        setBill(bill);
    }

    public void setp_temp(Patients p_temp) {
        this.p_temp = p_temp;
    }

    public void setd_temp(Doctors d_temp) {
        this.d_temp = d_temp;
    }

    public void setAdmit_date(String admit_date) {
        this.admit_date = admit_date;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public Patients getP_temp() {
        return p_temp;
    }

    public Doctors getD_temp() {
        return d_temp;
    }

    public String getAdmit_date() {
        return admit_date;
    }

    public int getBill() {
        return bill;
    }

}
