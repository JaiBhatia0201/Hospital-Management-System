package Model.Doctors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Displayable;

import javax.print.Doc;
//import Model.Utils.*;

public class ManageDoctors extends FileHandlingDoctors implements Displayable{

    ArrayList<Doctors> Doctor_Arr = new ArrayList<Doctors>();

    ObjectMapper objectMapper = new ObjectMapper();
    String path="src/Model/Doctors/MOCK_DATA.json";

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public ManageDoctors(){
        readDoctorJsonFile(path);
    }
    public ArrayList<Doctors> readDoctorJsonFile(String file_path)
    {
        try {
            Doctor_Arr.removeAll(Doctor_Arr);
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            Doctor_Arr.clear();
            // Iterate through JSON array
            if (rootNode.isArray()){
                for(JsonNode node : rootNode){
                    int DoctorID = node.get("id").asInt();
                    String Doctor_FName = node.get("first_name").asText();
                    String Doctor_LName = node.get("last_name").asText();
                    String Doctor_email = node.get("email").asText();
                    String Doctor_Speciality = node.get("Speciality").asText();
                    int Doctor_Experience = node.get("Experience").asInt();
                    Doctors Doc1 = new Doctors(DoctorID, Doctor_FName, Doctor_LName, Doctor_Speciality, Doctor_Experience, Doctor_email);
                    Doctor_Arr.add(Doc1);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return Doctor_Arr;
    }

    public void writeDoctorJsonFile(String file_path, ArrayList<Doctors> Doctor_Arr1) throws IOException {
        ArrayList<Map<String, Object>> doc_to_be_written = new ArrayList<>();

        for (int i = 0; i < Doctor_Arr1.size(); i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", Doctor_Arr.get(i).getDoctor_ID());
            data.put("first_name", Doctor_Arr.get(i).getDoc_name_f());
            data.put("last_name", Doctor_Arr.get(i).getDoc_name_l());
            data.put("email", Doctor_Arr.get(i).getemail());
            data.put("Speciality", Doctor_Arr.get(i).getSpeciality());
            data.put("Experience", Doctor_Arr.get(i).getExperience());
            doc_to_be_written.add(data);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), doc_to_be_written);
    }

    public void setDoctorTable(ArrayList<Doctors> d) {this.Doctor_Arr = d;}

    public ArrayList<String> getHeaders(){
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("ID");
        headers.add("First Name");
        headers.add("Last Name");
        headers.add("Email");
        headers.add("Speciality");
        headers.add("Experience");

        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> doc = new ArrayList<String>();

        doc.add(String.valueOf(Doctor_Arr.get(line).getDoctor_ID()));
        doc.add(Doctor_Arr.get(line).getDoc_name_f());
        doc.add(Doctor_Arr.get(line).getDoc_name_l());
        doc.add(Doctor_Arr.get(line).getemail());
        doc.add(Doctor_Arr.get(line).getSpeciality());
        doc.add(String.valueOf(Doctor_Arr.get(line).getExperience()));

        return doc;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Doctor_Arr_Subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++){
            Doctor_Arr_Subset.add(getLine(i));
        }
        return Doctor_Arr_Subset;
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

    public ArrayList<Doctors> getTable(){
        readDoctorJsonFile(path);
        return Doctor_Arr;
    }
    public void addNewDoctor(int id, String Doctor_fName, String Doctor_lName, String Speciality, int Experience, String email) throws IOException {
        readDoctorJsonFile(path);
        Doctors temp_doc=new Doctors(id,Doctor_fName,Doctor_lName,Speciality,Experience,email);
        Doctor_Arr.add(temp_doc);
        writeDoctorJsonFile(path,Doctor_Arr);
    }
    public void editDoctor(int edit_doctor_idx, int id, String Doctor_fName,String Doctor_lName, String Speciality, int Experience, String email) throws IOException {
        readDoctorJsonFile(path);
        Doctor_Arr.get(edit_doctor_idx).setDoctor_ID(id);
        Doctor_Arr.get(edit_doctor_idx).setDoctor_Name_f(Doctor_fName);
        Doctor_Arr.get(edit_doctor_idx).setDoctor_Name_l(Doctor_lName);
        Doctor_Arr.get(edit_doctor_idx).setemail(email);
        Doctor_Arr.get(edit_doctor_idx).setSpeciality(Speciality);
        Doctor_Arr.get(edit_doctor_idx).setExperience(Experience);
        writeDoctorJsonFile(path,Doctor_Arr);
    }

    public int deleteDoctor(int delete_doctor_idx) throws IOException {
        readDoctorJsonFile(path);
        int d_id=Doctor_Arr.get(delete_doctor_idx).getDoctor_ID();
        Doctor_Arr.remove(delete_doctor_idx);
        writeDoctorJsonFile(path,Doctor_Arr);
        return d_id;
    }
}
