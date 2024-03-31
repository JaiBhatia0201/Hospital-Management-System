package Model.Doctors;

import Model.Doctors.Doctors;
import Model.Patients.Patients;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingDoctors {
    protected abstract ArrayList<Doctors> readDoctorJsonFile(String file_path);
    protected abstract void writeDoctorJsonFile(String file_path, ArrayList<Doctors> Doctor_Arr) throws IOException;
}
