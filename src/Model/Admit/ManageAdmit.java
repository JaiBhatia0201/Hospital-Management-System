package Model.Admit;

import Model.Doctors.*;
import Model.Doctors.ManageDoctors;
import Model.Displayable;
import Model.Patients.*;
import Model.Patients.ManagePatients;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManageAdmit extends FileHandlingAdmit implements Displayable {

    ArrayList<Patients> patients = new ArrayList<Patients>();

    ArrayList<Doctors> doctors = new ArrayList<Doctors>();

    ArrayList<Admit> admit_data = new ArrayList<Admit>();

    ObjectMapper objectMapper = new ObjectMapper();
    String path="src/Model/Admit/MOCK_DATA(admit).json";

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    ManagePatients mp1 = new ManagePatients();
    ManageDoctors md1 = new ManageDoctors();
    public ManageAdmit() {
        patients=mp1.readPatientJsonFile("src/Model/Patients/MOCK_DATA.json");
        //patients = mp1.getTable();
        doctors=md1.readDoctorJsonFile("src/Model/Doctors/MOCK_DATA.json");
        //doctors = md1.getTable();
        readAdmitJsonFile(path);
    }

    @Override
    public ArrayList<Admit> readAdmitJsonFile(String file_path) {
        try {

            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            admit_data.clear();
            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int p_temp = node.get("p_temp").asInt();
                    int d_temp = node.get("d_temp").asInt();
                    String admit_date = node.get("admit_date").asText();
                    int bill = node.get("bill").asInt();

                    Patients p_temp_obj=new Patients();
                    Doctors d_temp_obj=new Doctors();

                    for (int i = 0; i < patients.size(); i++) {
                        if (p_temp == patients.get(i).getPatient_ID()) {
                            p_temp_obj = patients.get(i);
                        }
                    }

                    for (int i = 0; i < doctors.size(); i++) {
                        if (d_temp == doctors.get(i).getDoctor_ID()) {
                            d_temp_obj = doctors.get(i);
                        }
                    }

                    Admit a_temp = new Admit(p_temp_obj, d_temp_obj, admit_date, bill);
                    admit_data.add(a_temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return admit_data;
    }

    @Override
    public void writeAdmitJsonFile(String file_path, ArrayList<Admit> admit_al) throws IOException {

        //ArrayList<ArrayList<String>> admit_to_be_written = new ArrayList<ArrayList<String>>();
        ArrayList<Map<String, Object>> admit_to_be_written = new ArrayList<>();

        ArrayList<String> row = new ArrayList<String>();

        for (int i = 0; i < admit_al.size(); i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("d_temp", admit_data.get(i).getD_temp().getDoctor_ID());
            data.put("p_temp", admit_data.get(i).getP_temp().getPatient_ID());
            data.put("admit_date", admit_data.get(i).getAdmit_date());
            data.put("bill", admit_data.get(i).getBill());
            admit_to_be_written.add(data);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), admit_to_be_written);
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("d_temp");
        headers.add("p_temp");
        headers.add("admit_date");
        headers.add("bill");
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> admit = new ArrayList<String>();

        admit.add(String.valueOf(admit_data.get(line).getD_temp().getDoctor_ID()));
        admit.add(String.valueOf(admit_data.get(line).getP_temp().getPatient_ID()));
        admit.add(admit_data.get(line).getAdmit_date());
        admit.add(String.valueOf(admit_data.get(line).getBill()));
        return admit;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> doctor_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            doctor_subset.add(getLine(i));
        }
        return doctor_subset;
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

    public ArrayList<Admit> getTable() {
        readAdmitJsonFile(path);
        return admit_data;
    }

    public void addNewAdmit(int doctor_id, int patient_id, String admit_date, int bill) throws IOException {
        readAdmitJsonFile(path);
        patients=mp1.readPatientJsonFile("src/Model/Patients/MOCK_DATA.json");
        doctors=md1.readDoctorJsonFile("src/Model/Doctors/MOCK_DATA.json");
//        for (int i=0; i<patients.size();i++) {
//            if (patient_id==patients.get(i).getPatient_ID()) {
//
//            }
//        }
        Admit temp_admit = new Admit(patients.get(patient_id-1), doctors.get(doctor_id-1), admit_date, bill);
        admit_data.add(temp_admit);
        writeAdmitJsonFile(path, admit_data);


//         readEnrollsJsonFile(filePath);
//
//            for(int i=0;i<customers.size();i++){
//                if(c_temp==customers.get(i).getId()){
//                    c_temp_obj=customers.get(i);
//                }
//            }
//            for(int i=0; i<scheme_types.size();i++){
//                if(s_temp==scheme_types.get(i).getScheme_id()){
//                    s_temp_obj=scheme_types.get(i);
//                }
//            }
//            enrolls.add(new Enrolls(c_temp_obj,s_temp_obj,date,amt));
//            try{
//                writeEnrollsJsonFile(filePath,enrolls);
//            }
//            catch(IOException e){
//                throw new RuntimeException(e);}
        }


    public void editAdmit(int edit_admit_idx, int doctor_id, int patient_id, String admit_date, int bill) throws IOException {
        readAdmitJsonFile(path);
        Patients p_o = null;
        Doctors d_0 = null;
        for (int i = 0; i < patients.size(); i++) {

            if (patient_id == patients.get(i).getPatient_ID()) {
                p_o = patients.get(i);
            }
        }

        for (int i = 0; i < doctors.size(); i++) {

            if (doctor_id == doctors.get(i).getDoctor_ID()) {
                d_0 = doctors.get(i);
            }
        }
        admit_data.get(edit_admit_idx).setd_temp(d_0);
        admit_data.get(edit_admit_idx).setp_temp(p_o);
        admit_data.get(edit_admit_idx).setBill(bill);
        admit_data.get(edit_admit_idx).setAdmit_date(admit_date);
        try {
            writeAdmitJsonFile(path, admit_data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAdmit(int delete_admit_idx) throws IOException {
        readAdmitJsonFile(path);
        for(int i=0;i<admit_data.size();i++)
        {
            if (delete_admit_idx== admit_data.get(i).getD_temp().getDoctor_ID() || delete_admit_idx==admit_data.get(i).getP_temp().getPatient_ID())
            {
                admit_data.remove(i);
            }
        }
        admit_data.remove(delete_admit_idx);
        writeAdmitJsonFile(path,admit_data);
    }
}
