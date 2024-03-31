package Model.Patients;
import Model.Doctors.Doctors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Displayable;
//import Model.Utils.*;

public class ManagePatients extends FileHandlingPatients implements Displayable {
    ArrayList<Patients> Patient_Arr = new ArrayList <Patients>();

    ObjectMapper objectMapper = new ObjectMapper();
    String path="src/Model/Patients/MOCK_DATA.json";

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public ManagePatients(){
        readPatientJsonFile(path);
    }
    public ArrayList<Patients> readPatientJsonFile(String file_path)
    {
        try {
            Patient_Arr.removeAll(Patient_Arr);
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int patientId = node.get("Patient_ID").asInt();
                    String Patient_Name = node.get("Patient_Name").asText();
                    String Patient_Gender = node.get("Patient_Gender").asText();
                    int Doc_ID_Assigned = node.get("Doc_ID_Assigned").asInt();
                    int Patient_Age = node.get("Patient_Age").asInt();
                    Patients pat1 = new Patients(patientId, Patient_Name, Patient_Gender, Doc_ID_Assigned, Patient_Age);
                    Patient_Arr.add(pat1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Patient_Arr;
    }
    public void writePatientsJsonFile(String file_path, ArrayList<Patients> Patient_Arr1) throws IOException {
        //objectMapper.writeValue(Paths.get("G://VESIT//Sem 2//PCC (JAVA)//EXP5//PCC_MP_Grp_3_D2B//PCC_MP_Grp_3_D2B//src/Model//Patients//MOCK_DATA.json").toFile(), this.Patient_Arr);
        ArrayList<Map<String, Object>> pat_to_be_written = new ArrayList<>();

        for (int i = 0; i < Patient_Arr1.size(); i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("Patient_ID", Patient_Arr.get(i).getPatient_ID());
            data.put("Patient_Name", Patient_Arr.get(i).getName());
            data.put("Patient_Gender", Patient_Arr.get(i).getPatient_Gender());
            data.put("Doc_ID_Assigned", Patient_Arr.get(i).getDoc_ID_Assigned());
            data.put("Patient_Age", Patient_Arr.get(i).getAge());
            pat_to_be_written.add(data);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), pat_to_be_written);
    }

    public void setPatientsTable(ArrayList<Patients> p) {
        this.Patient_Arr = p;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Patient_ID");
        headers.add("Patient_Gender");
        headers.add("Doc_ID_Assigned");
        headers.add("Patient_Age");
        headers.add("Patient_Name");
        return headers;
    }
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> pat = new ArrayList<String>();

        pat.add(String.valueOf(Patient_Arr.get(line).getPatient_ID()));
        pat.add(Patient_Arr.get(line).getPatient_Gender());
        pat.add(String.valueOf(Patient_Arr.get(line).getDoc_ID_Assigned()));
        pat.add(String.valueOf(Patient_Arr.get(line).getAge()));
        pat.add(Patient_Arr.get(line).getName());

        return pat;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Patient_Arr_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            Patient_Arr_subset.add(getLine(i));
        }
        return Patient_Arr_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Patients> getTable() {
        readPatientJsonFile(path);
        return Patient_Arr;
    }
    public void addNewPatient(int Patient_ID, String Patient_Name, String Patient_Gender, int Doc_ID_Assigned, int Patient_Age) throws IOException {
        readPatientJsonFile(path);
        Patients temp_pat=new Patients(Patient_ID,Patient_Name,Patient_Gender,Doc_ID_Assigned,Patient_Age);
        Patient_Arr.add(temp_pat);
        writePatientsJsonFile(path,Patient_Arr);
    }
    public void editPatient(int edit_patient_idx, int pat_id, String pat_name, int doc_id, String pat_gen, int pat_age) throws IOException {
        readPatientJsonFile(path);
        Patient_Arr.get(edit_patient_idx).setpatient_id(pat_id);
        Patient_Arr.get(edit_patient_idx).setName(pat_name);
        Patient_Arr.get(edit_patient_idx).setDoc_ID_Assigned(doc_id);
        Patient_Arr.get(edit_patient_idx).setPatient_Gender(pat_gen);
        Patient_Arr.get(edit_patient_idx).setAge(pat_age);
        writePatientsJsonFile(path,Patient_Arr);
    }
    public int deletePatient(int delete_patient_idx) throws IOException {
        readPatientJsonFile(path);
        int p_id = Patient_Arr.get(delete_patient_idx).getPatient_ID();
        Patient_Arr.remove(delete_patient_idx);
        writePatientsJsonFile(path,Patient_Arr);
        return p_id;
    }

}


