package Model.Patients;

import Model.Doctors.Doctors;
import Model.Patients.Patients;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingPatients {
    protected abstract ArrayList<Patients> readPatientJsonFile(String file_path);
    protected abstract void writePatientsJsonFile(String file_path, ArrayList<Patients> students) throws IOException;
}
