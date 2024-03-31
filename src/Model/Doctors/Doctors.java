package Model.Doctors;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Identification comments:
 *   Name: Dhruv Ashok Lohana
 *   Experiment No: 08
 *   Experiment Title: Implement Exception Handling with User Defined Exception
 *   Experiment Date: 05-03-2024
 *   @version 1.0
 *
 * Beginning comments:
 * Filename: Doctors.java
 * @author :  Dhruv Ashok Lohana
 * Overview: This is the Doctor class. In this file we have achieved the following
 * - Created Attributes
 * --- static int d_count
 * --- int Doctor_ID
 * --- String Doctor_Name_f
 * --- String Doctor_Name_l
 * --- String email
 * --- String Speciality (in Hospital.java)
 * --- int Experience (in Hospital.java)
 * --- int Patient_Age
 *
 * - Created Review interface and then implemented it in the Doctors.java file
 * - New funtion created based on the functions present in the interface
 */
public class Doctors extends Hospital{ //Hospital class inherited by Doctors
    private static int d_count = 0;
    private int Doctor_ID;
    private String Doctor_Name_f;
    private String Doctor_Name_l;
    private String email;

    public Doctors() {
    }

    public Doctors(String Doctor_fName, String Doctor_lName, String Speciality, int Experience, String email) {
        super(Speciality, Experience);//call the constructor of Hospital
        setd_count(getd_count());
        this.setDoctor_ID(d_count);
        this.setDoctor_Name_f(Doctor_fName);
        this.setDoctor_Name_l(Doctor_lName);
        this.setemail(email);
    }

    public Doctors(int id, String Doctor_fName, String Doctor_lName, String Speciality, int Experience, String email) {
        super(Speciality, Experience); //call the constructor of Hospital
        setd_count(getd_count());
        this.setDoctor_ID(id);
        this.setDoctor_Name_f(Doctor_fName);
        this.setDoctor_Name_l(Doctor_lName);
        this.setemail(email);
    }

    public static void setd_count(int d1_count) {
        Doctors.d_count = d1_count;
    }

    public static int getd_count() {
        return d_count;
    }

    public void setDoctor_ID(int ID) {
        this.Doctor_ID = ID;
    }

    public void setDoctor_Name_f(String f_Name) {
        this.Doctor_Name_f = f_Name;
    }

    public void setDoctor_Name_l(String l_Name) {
        this.Doctor_Name_l = l_Name;
    }

    public void setemail(String email) {
        this.email = email;
    }



    // Creating Getters

    public int getDoctor_ID() {
        return this.Doctor_ID;
    }

    public String getDoc_name_f() {
        return this.Doctor_Name_f;
    }

    public String getDoc_name_l() {
        return this.Doctor_Name_l;
    }

    public String getemail() {
        return this.email;
    }

    public void display() {
        System.out.println("Doctor ID: " + getDoctor_ID());
        System.out.println("Doctor First Name: " + getDoc_name_f());
        System.out.println("Doctor Last Name: " + getDoc_name_l());
        super.display();
        System.out.println("Doctor Email ID: " + getemail());
    }
}