package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;

public class Controller {
    Model model;
    View view;
    String path_admit = "src/Model/Admit/MOCK_DATA(admit).json";
    String path_doc = "src/Model/Doctors/MOCK_DATA.json";
    String path_pat = "src/Model/Patients/MOCK_DATA.json";

    public Controller(Model m, View v) {
        model = m;
        view = v;

        view.getMdf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });


        view.getFf().getManageDoctorsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Doctor Button Clicked");
                view.getFf().setVisible(false);
                view.getMdf().setVisible(true);
            }
        });


        model.getMd().setLinesBeingDisplayed(25);
        view.centerInitialSetupDoctor(model.getMd().getLinesBeingDisplayed(), model.getMd().getHeaders().size());
        model.getMd().setFirstLineToDisplay(0);
        view.centerUpdateDoctor(model.getMd().getLines(model.getMd().getFirstLineToDisplay(), model.getMd().getLastLineToDisplay()), model.getMd().getHeaders());


        view.getMdf().getIpd().getApd().getAddDoctorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_doctor_id = view.getMdf().getIpd().getApd().getTxt_Doctor_ID().getText();
                String txt_doctor_fname = view.getMdf().getIpd().getApd().getTxt_Doctor_fName().getText();
                String txt_doctor_lname = view.getMdf().getIpd().getApd().getTxt_Doctor_lname().getText();
                String txt_email = view.getMdf().getIpd().getApd().getTxt_email().getText();
                String txt_Doctor_Speciality = view.getMdf().getIpd().getApd().getTxt_Doctor_Speciality().getText();
                String txt_Doctor_Experience = view.getMdf().getIpd().getApd().getTxt_Doctor_Experience().getText();
                try {
                    model.getMd().addNewDoctor(Integer.valueOf(txt_doctor_id), txt_doctor_fname, txt_doctor_lname, txt_Doctor_Speciality, Integer.valueOf(txt_Doctor_Experience), txt_email);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMpf().getIpp().getApp().getAddPatientBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_pID = view.getMpf().getIpp().getApp().getTxt_patient_id().getText();
                String txt_p_name = view.getMpf().getIpp().getApp().getTxt_patient_name().getText();
                String txt_age = view.getMpf().getIpp().getApp().getTxt_patient_age().getText();
                String txt_gender = view.getMpf().getIpp().getApp().getTxt_patient_gender().getText();
                String txt_doc_id_assigned = view.getMpf().getIpp().getApp().getTxt_doc_id_assigned().getText();
                try {
                    model.getMp().addNewPatient(Integer.valueOf(txt_pID), txt_p_name, txt_gender, Integer.valueOf(txt_doc_id_assigned), Integer.valueOf(txt_age));
                } catch (IOException ee) {
                    throw new RuntimeException(ee);
                }
            }
        });

        view.getMdf().getIpd().getEdp().getGetDoctorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Doctor Details Clicked");
                String txt_doctor_idx = view.getMdf().getIpd().getEdp().getTxt_get_doctor_idx().getText();
                model.getMd().readDoctorJsonFile(path_doc);
                int doctor_id = model.getMd().getTable().get(Integer.valueOf(txt_doctor_idx)).getDoctor_ID();
                String doctor_fname = model.getMd().getTable().get(Integer.valueOf(txt_doctor_idx)).getDoc_name_f();
                String doctor_lname = model.getMd().getTable().get(Integer.valueOf(txt_doctor_idx)).getDoc_name_l();
                String doctor_email = model.getMd().getTable().get(Integer.valueOf(txt_doctor_idx)).getemail();
                String doctor_speciality = model.getMd().getTable().get(Integer.valueOf(txt_doctor_idx)).getSpeciality();
                int doctor_experience = model.getMd().getTable().get(Integer.valueOf(txt_doctor_idx)).getExperience();
                view.getMdf().getIpd().getEdp().getTxt_Doctor_id().setText(String.valueOf(doctor_id));
                view.getMdf().getIpd().getEdp().getTxt_Doctor_fname().setText(doctor_fname);
                view.getMdf().getIpd().getEdp().getTxt_Doctor_lname().setText(doctor_lname);
                view.getMdf().getIpd().getEdp().getTxt_Doctor_Speciality().setText(doctor_speciality);
                view.getMdf().getIpd().getEdp().getTxt_Doctor_Experience().setText(String.valueOf(doctor_experience));
                view.getMdf().getIpd().getEdp().getTxt_email().setText(doctor_email);
            }
        });

        view.getMdf().getIpd().getEdp().getEditDoctorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Doctor Button Clicked");
                String txt_doctor_idx = view.getMdf().getIpd().getEdp().getTxt_get_doctor_idx().getText();
                String txt_doctor_id = view.getMdf().getIpd().getEdp().getTxt_Doctor_id().getText();
                String txt_doctor_fname = view.getMdf().getIpd().getEdp().getTxt_Doctor_fname().getText();
                String txt_doctor_lname = view.getMdf().getIpd().getEdp().getTxt_Doctor_lname().getText();
                String txt_doctor_email = view.getMdf().getIpd().getEdp().getTxt_email().getText();
                String txt_doctor_speciality = view.getMdf().getIpd().getEdp().getTxt_Doctor_Speciality().getText();
                String txt_doctor_experience = view.getMdf().getIpd().getEdp().getTxt_Doctor_Experience().getText();
                try {
                    model.getMd().editDoctor(Integer.valueOf(txt_doctor_idx), Integer.valueOf(txt_doctor_id), txt_doctor_fname, txt_doctor_lname, txt_doctor_speciality, Integer.valueOf(txt_doctor_experience), txt_doctor_email);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMdf().getIpd().getDdp().getDeleteDoctorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Doctor Button Clicked");
                String txt_doctor_idx = view.getMdf().getIpd().getDdp().getTxt_del_doctor_id().getText();
                int d_id;
                try {
                    d_id=model.getMd().deleteDoctor(Integer.valueOf(txt_doctor_idx));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    model.getMa().deleteAdmit(d_id);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
//                try {
//                    model.getMd().deleteDoctor(Integer.valueOf(txt_doctor_idx));
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });

        view.getFf().getManageAdmitBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Admit Button Clicked");
                view.getFf().setVisible(false);
                view.getMaf().setVisible(true);
            }
        });

        view.getMaf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        view.getMpf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        model.getMa().setLinesBeingDisplayed(25);
        view.centerInitialSetupAdmit(model.getMa().getLinesBeingDisplayed(), model.getMa().getHeaders().size());
        model.getMa().setFirstLineToDisplay(0);
        view.centerUpdateAdmit(model.getMa().getLines(model.getMa().getFirstLineToDisplay(), model.getMa().getLastLineToDisplay()), model.getMa().getHeaders());


        view.getMaf().getIpa().getApa().getAddAdmitbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_doctor_id = view.getMaf().getIpa().getApa().getTxt_d_temp().getText();
                String txt_patient_id = view.getMaf().getIpa().getApa().getTxt_p_temp().getText();
                String txt_admit_date = view.getMaf().getIpa().getApa().getTxt_admit_date().getText();
                String txt_bill = view.getMaf().getIpa().getApa().getTxt_bill().getText();
                try {
                    model.getMa().addNewAdmit(Integer.valueOf(txt_patient_id),Integer.valueOf(txt_doctor_id), txt_admit_date, Integer.valueOf(txt_bill));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMaf().getIpa().getEpa().getGetAdmitBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Admit Details Clicked");
                String txt_admit_idx = view.getMaf().getIpa().getEpa().getTxt_get_admit_idx().getText();
                model.getMa().readAdmitJsonFile(path_admit);
                int d_id = model.getMa().getTable().get(Integer.valueOf(txt_admit_idx)).getD_temp().getDoctor_ID();
                int p_id = model.getMa().getTable().get(Integer.valueOf(txt_admit_idx)).getP_temp().getPatient_ID();
                String admit_date = model.getMa().getTable().get(Integer.valueOf(txt_admit_idx)).getAdmit_date();
                int bill = model.getMa().getTable().get(Integer.valueOf(txt_admit_idx)).getBill();
                view.getMaf().getIpa().getEpa().getTxt_Doctor_id().setText(String.valueOf(d_id));
                view.getMaf().getIpa().getEpa().getTxt_Patient_id().setText(String.valueOf(p_id));
                view.getMaf().getIpa().getEpa().getTxt_admit_date().setText(admit_date);
                view.getMaf().getIpa().getEpa().getTxt_Bill().setText(String.valueOf(bill));
            }
        });

        view.getMaf().getIpa().getEpa().getEditAdmitBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Admit Button Clicked");
                String txt_admit_idx = view.getMaf().getIpa().getEpa().getTxt_get_admit_idx().getText();
                String txt_doctor_idx = view.getMaf().getIpa().getEpa().getTxt_Doctor_id().getText();
                String txt_patient_idx = view.getMaf().getIpa().getEpa().getTxt_Patient_id().getText();
                String txt_admit_date = view.getMaf().getIpa().getEpa().getTxt_admit_date().getText();
                String txt_bill = view.getMaf().getIpa().getEpa().getTxt_Bill().getText();
                try {
                    model.getMa().editAdmit(Integer.valueOf(txt_admit_idx), Integer.valueOf(txt_doctor_idx), Integer.valueOf(txt_patient_idx), txt_admit_date, Integer.valueOf(txt_bill));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMaf().getIpa().getDpa().getDeleteAdmitBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Admit Button Clicked");
                String txt_doctor_idx = view.getMaf().getIpa().getDpa().getTxt_del_admit_idx().getText();
                try {
                    model.getMa().deleteAdmit(Integer.valueOf(txt_doctor_idx));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getFf().getManagePatientsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMpf().setVisible(true);
            }
        });

        model.getMp().setLinesBeingDisplayed(25);
        view.centerInitialSetupPatients(model.getMp().getLinesBeingDisplayed(), model.getMp().getHeaders().size());
        model.getMp().setFirstLineToDisplay(0);
        view.centerUpdatePatients(model.getMp().getLines(model.getMp().getFirstLineToDisplay(), model.getMp().getLastLineToDisplay()), model.getMp().getHeaders());

        view.getMpf().getIpp().getEPP().getGetPatBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Patient Details Clicked");
                String txt_get_pat_idx = view.getMpf().getIpp().getEPP().getTxt_get_patient_idx().getText();
                model.getMp().readPatientJsonFile(path_pat);
                int pat_id = model.getMp().getTable().get(Integer.valueOf(txt_get_pat_idx)).getPatient_ID();
                String name = model.getMp().getTable().get(Integer.valueOf(txt_get_pat_idx)).getName();
                int doc_id = model.getMp().getTable().get(Integer.valueOf(txt_get_pat_idx)).getDoc_ID_Assigned();
                String gender = model.getMp().getTable().get(Integer.valueOf(txt_get_pat_idx)).getPatient_Gender();
                int age = model.getMp().getTable().get(Integer.valueOf(txt_get_pat_idx)).getAge();
                view.getMpf().getIpp().getEPP().getTxt_Pat_id().setText(String.valueOf(pat_id));
                view.getMpf().getIpp().getEPP().getTxt_Pat_name().setText(name);
                view.getMpf().getIpp().getEPP().getTxt_Doc_ID_Assigned().setText(String.valueOf(doc_id));
                view.getMpf().getIpp().getEPP().getTxt_Pat_Gender().setText(gender);
                view.getMpf().getIpp().getEPP().getTxt_Pat_Age().setText(String.valueOf(age));


            }
        });

        view.getMpf().getIpp().getEPP().getEditPatBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Patient Button Clicked");
                String txt_pat_idx = view.getMpf().getIpp().getEPP().getTxt_get_patient_idx().getText();
                String txt_pat_id = view.getMpf().getIpp().getEPP().getTxt_Pat_id().getText();
                String txt_pat_name = view.getMpf().getIpp().getEPP().getTxt_Pat_name().getText();
                String txt_doc_id = view.getMpf().getIpp().getEPP().getTxt_Doc_ID_Assigned().getText();
                String txt_pat_gender = view.getMpf().getIpp().getEPP().getTxt_Pat_Gender().getText();
                String txt_pat_age = view.getMpf().getIpp().getEPP().getTxt_Pat_Age().getText();

                try {
                    model.getMp().editPatient(Integer.valueOf(txt_pat_idx), Integer.valueOf(txt_pat_id), txt_pat_name, Integer.valueOf(txt_doc_id), txt_pat_gender, Integer.valueOf(txt_pat_age));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMpf().getIpp().getDPP().getDeletePatientBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Patient Button Clicked");
                String txt_patient_idx = view.getMpf().getIpp().getDPP().getTxt_delete_pat_id().getText();

                try {
                    int p_id = model.getMp().deletePatient(Integer.valueOf(txt_patient_idx));
                    for (int i = 0; i < model.getMp().getTable().size(); i++) {
                        if (p_id == model.getMp().getTable().get(i).getPatient_ID()) {
                            model.getMp().deletePatient(i);
                            model.getMa().deleteAdmit(p_id);
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        view.getMdf().getIpd().getCpd().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMd().getFirstLineToDisplay();
                int current_last_line = model.getMd().getLastLineToDisplay();
                int no_of_courses = model.getMd().getTable().size();
                int no_of_display_lines = model.getMd().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMd().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMd().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMd().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_courses-1)
                {
                    model.getMd().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_courses-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_courses - no_of_display_lines)
                    {
                        new_first_line = no_of_courses-no_of_display_lines;
                        model.getMd().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMd().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateDoctor(model.getMd().getLines(model.getMd().getFirstLineToDisplay(), model.getMd().getLastLineToDisplay()), model.getMd().getHeaders());
            }
        });

        view.getMpf().getIpp().getCpp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMp().getFirstLineToDisplay();
                int current_last_line = model.getMp().getLastLineToDisplay();
                int no_of_courses = model.getMp().getTable().size();
                int no_of_display_lines = model.getMp().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMp().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMp().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMp().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_courses-1)
                {
                    model.getMp().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_courses-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_courses - no_of_display_lines)
                    {
                        new_first_line = no_of_courses-no_of_display_lines;
                        model.getMp().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMp().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdatePatients(model.getMp().getLines(model.getMp().getFirstLineToDisplay(), model.getMp().getLastLineToDisplay()), model.getMp().getHeaders());
            }
        });
        view.getMaf().getIpa().getCpa().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMa().getFirstLineToDisplay();
                int current_last_line = model.getMa().getLastLineToDisplay();
                int no_of_courses = model.getMa().getTable().size();
                int no_of_display_lines = model.getMa().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMa().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMa().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMa().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_courses-1)
                {
                    model.getMa().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_courses-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_courses - no_of_display_lines)
                    {
                        new_first_line = no_of_courses-no_of_display_lines;
                        model.getMa().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMa().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateAdmit(model.getMa().getLines(model.getMa().getFirstLineToDisplay(), model.getMa().getLastLineToDisplay()), model.getMa().getHeaders());
            }
        });
    }
}


//        view.getMpf().addWindowListener(new java.awt.event.WindowAdapter() {
//          @Override
//          public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//              view.getFf().setVisible(true);
//          }
//        });
//
//
//        view.getFf().getManagePatientsBtn().addActionListener(new ActionListener() {
//          @Override
//          public void actionPerformed(ActionEvent e) {
//              view.getFf().setVisible(false);
//              view.getMpf().setVisible(true);
//          }
////        });












