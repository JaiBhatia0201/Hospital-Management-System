/**
 * Identification comments:
 *   Name: Dhruv Ashok Lohana
 *   Experiment No: 10
 *   Experiment Title: Implementing View Class in Java using Swing and AWT for your chosen case study using MVC Architecture
 *   Create UI for Display, Insert, Update, Delete
 *   Experiment Date: 19/03/2024
 *
 *   @version 1.0
 *   Beginning comments:
 *   Filename: Model.java
 *   @author:  Dhruv Ashok Lohana
 *   Overview: The Model class orchestrates the handling of essential entities within the application, encapsulating
 *   functionalities related to managing employees (manageEmployee), projects (manageProject), and handles (manageHandles).
 */
package Model;
import Model.Admit.ManageAdmit;
import Model.Doctors.ManageDoctors;
import Model.Patients.ManagePatients;
public class Model {
    ManageDoctors md;
    ManagePatients mp;
    ManageAdmit ma;
    public Model()
    {
        md =new ManageDoctors();
        mp =new ManagePatients();
        ma =new ManageAdmit();
    }

    public void setMa(ManageAdmit ma) {
        this.ma = ma;
    }

    public void setMd(ManageDoctors md) {
        this.md = md;
    }

    public void setMp(ManagePatients mp) {
        this.mp = mp;
    }

    public ManageAdmit getMa() {
        return ma;
    }

    public ManageDoctors getMd() {
        return md;
    }

    public ManagePatients getMp() {
        return mp;
    }
}
