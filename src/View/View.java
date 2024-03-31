/**
* Identification comments:
*   Name: Dhruv Ashok Lohana
*   Experiment No: 10
*   Experiment Title: Implementing View Class in Java using Swing and AWT for your chosen case study using MVC Architecture
*   Create UI for Display, Insert, Update, Delete
*   Experiment Date: 19/03/2024
*   @version 1.0
*
*  Beginning comments:
*  Filename: View.java
*  @author:  Dhruv Ashok Lohana
*  Overview: This is the View class
*  The View class acts as a mediator between the application's backend and its graphical user interface
*  instantiation of all frames being used here in the constructor
*/


package View;

import View.Doctor.ManageDoctorsFrame;
import View.ManagePatientsFrame;
import View.Admit.ManageAdmitFrame;

import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    ManagePatientsFrame mpf;
    ManageDoctorsFrame mdf;
    ManageAdmitFrame maf;


    public View()
    {
        ff = new FirstFrame();
        mpf = new ManagePatientsFrame();
        mdf = new ManageDoctorsFrame();
        maf = new ManageAdmitFrame();
    }

    public void centerInitialSetupPatients(int linesBeingDisplayed, int size) {
        mpf.getIpp().getCpp().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mpf.getIpp().getCpp().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerUpdatePatients(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            mpf.getIpp().getCpp().getAllButtons().get(i).setText(headers.get(i));
        }
        for (int pat_row_no = 0; pat_row_no < lines.size(); pat_row_no++) {
            for (int pat_col_no = 0; pat_col_no <headers.size(); pat_col_no++) {
                int button_no = pat_row_no * headers.size() + headers.size() + pat_col_no;
                String button_txt = lines.get(pat_row_no).get(pat_col_no);
                mpf.getIpp().getCpp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerInitialSetupDoctor(int linesBeingDisplayed, int size) {
        mdf.getIpd().getCpd().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        mdf.getIpd().getCpd().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerUpdateDoctor(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            mdf.getIpd().getCpd().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int doctor_row_no = 0; doctor_row_no < lines.size(); doctor_row_no++)
        {
            for (int doctor_col_no = 0; doctor_col_no < headers.size(); doctor_col_no++)
            {
                int button_no = doctor_row_no * headers.size() + headers.size() + doctor_col_no;
                String button_txt = lines.get(doctor_row_no).get(doctor_col_no);

                mdf.getIpd().getCpd().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void centerInitialSetupAdmit(int linesBeingDisplayed, int size) {
        maf.getIpa().getCpa().setLayout(new GridLayout(linesBeingDisplayed+1,size));
        maf.getIpa().getCpa().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerUpdateAdmit(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++)
        {
            maf.getIpa().getCpa().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int doctor_row_no = 0; doctor_row_no < lines.size(); doctor_row_no++)
        {
            for (int course_col_no = 0; course_col_no < headers.size(); course_col_no++)
            {
                int button_no = doctor_row_no * headers.size() + headers.size() + course_col_no;
                String button_txt = lines.get(doctor_row_no).get(course_col_no);

                maf.getIpa().getCpa().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public FirstFrame getFf() {
        return ff;
    }

    public void setMpf(ManagePatientsFrame mpf) {
        this.mpf = mpf;
    }

    public ManagePatientsFrame getMpf() {
        return mpf;
    }

    public void setMdf(ManageDoctorsFrame mdf) {
        this.mdf = mdf;
    }

    public ManageDoctorsFrame getMdf() {
        return mdf;
    }

    public ManageAdmitFrame getMaf() {
        return maf;
    }

    public void setMaf(ManageAdmitFrame maf) {
        this.maf = maf;
    }
}

