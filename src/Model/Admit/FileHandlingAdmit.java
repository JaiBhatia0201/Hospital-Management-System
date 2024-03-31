package Model.Admit;

import Model.Doctors.Doctors;
import Model.Patients.Patients;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingAdmit {
    protected abstract ArrayList<Admit> readAdmitJsonFile(String file_path);
    protected abstract void writeAdmitJsonFile(String file_path, ArrayList<Admit> enrolls) throws IOException;
    //protected abstract ArrayList<Doctors> readAdmitJsonFile(String file_path);
    //protected abstract void writeAdmitJsonFile(String file_path, ArrayList<Admit> enrolls) throws IOException;
}
