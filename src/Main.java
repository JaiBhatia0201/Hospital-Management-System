import Controller.Controller;
import Model.Admit.Admit;
import Model.Admit.ManageAdmit;
import Model.Doctors.ManageDoctors;
import Model.Model;
import Model.Patients.ManagePatients;
import Model.Patients.Patients;
import Model.Doctors.Doctors;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.IntegerValue;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Identification comments:
 *   Name: Dhruv Ashok Lohana
 *   Experiment No: 10
 *   Experiment Title: Implement Exception Handling with User Defined Exception
 *   Experiment Date: 19-03-2024
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Main.java
 * @author:  Dhruv Ashok Lohana
 * Overview: This is the main class used to created objects for View Class, Model Class and Controller class. In this file we have achieved the following
 * - GUI interface
 * - MVC architecture
 * - CRUD operations on Doctors, Patients and Admit in GUI
 *
 */
public class Main {
    public static void main(String args[]) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }
}
