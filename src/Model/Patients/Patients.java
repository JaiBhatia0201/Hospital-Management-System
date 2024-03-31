package Model.Patients;
import Model.Displayable;
import java.util.ArrayList;
/**
 * Identification comments:
 *   Name: Dhruv Ashok Lohana
 *   Experiment No: 08
 *   Experiment Title: Implement Exception Handling with User Defined Exception
 *   Experiment Date: 05-03-2024
 *   @version 1.0
 *
 * Beginning comments:
 * Filename: Patients.java
 * @author :  Dhruv Ashok Lohana
 * Overview: This is the Patient class. In this file we have achieved the following
 * - Created Attributes
 * --- static int p_count
 * --- int Patient_ID
 * --- Patient_Name (in Person.java)
 * --- Patient_Gender (in Person.java)
 * --- int Patient_Age
 *
 * - Created AdditionalFacilities interface and then implemented it in the Patients.java file
 * - New funtion created based on the functions present in the interface
 */
public class Patients extends Person {
    private static int p_count = 51;
    private int Patient_ID;
    private int Doc_ID_Assigned;
    private String Patient_Gender;

    public Patients() {

    }

    public Patients(String Patient_Name, String Patient_Gender, int Doc_ID_Assigned, int Patient_Age) {
        super(Patient_Name, Patient_Age);// call the constructor of Person
        setp_count(getP_count());
        this.setpatient_id(p_count);
        this.setDoc_ID_Assigned(Doc_ID_Assigned);
        this.setPatient_Gender(Patient_Gender);
    }

    public Patients(int Patient_ID, String Patient_Name, String Patient_Gender, int Doc_ID_Assigned, int Patient_Age) {
        super(Patient_Name, Patient_Age); // call the constructor of Person
        setp_count(getP_count());
        this.setpatient_id(Patient_ID);
        this.setDoc_ID_Assigned(Doc_ID_Assigned);
        this.setPatient_Gender(Patient_Gender);
    }

    public static void setp_count(int p1_count) {
        Patients.p_count = p1_count;
    }
    public static int getP_count() {
        return p_count;
    }
    public void setPatient_Gender(String Patient_Gender)
    {
        this.Patient_Gender = Patient_Gender;
    }
    public void setpatient_id(int Patient_ID) {
        this.Patient_ID = Patient_ID;
    }
    public void setDoc_ID_Assigned(int Doc_ID_Assigned) {
        this.Doc_ID_Assigned = Doc_ID_Assigned;
    }

    public int getPatient_ID() {
        return this.Patient_ID;
    }
    public int getDoc_ID_Assigned() {
        return this.Doc_ID_Assigned;
    }
    public String getPatient_Gender()
    {
        return this.Patient_Gender;
    }

    public void display() {
        System.out.println("Patient ID: " + getPatient_ID());
        super.display();
        System.out.println("Patient Gender: "+getPatient_Gender());
        System.out.println("Doctor ID Assigned: " + getDoc_ID_Assigned());
    }
}