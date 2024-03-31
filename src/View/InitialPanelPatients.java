package View;

import javax.swing.*;

public class InitialPanelPatients extends JPanel {
    private CenterPanelPatients cpp;
    private AddPanelPatients APP;
    private EditPanelPatients EPP;
    private DeletePanelPatients DPP;

    public InitialPanelPatients(){
        super();
        cpp=new CenterPanelPatients();
        add(cpp);
        APP= new AddPanelPatients();
        add(APP);
        EPP=new EditPanelPatients();
        add(EPP);
        DPP=new DeletePanelPatients();
        add(DPP);
    }

    public void setAPP(AddPanelPatients APP) {
        this.APP = APP;
    }

    public AddPanelPatients getApp() {
        return APP;
    }

    public CenterPanelPatients getCpp() {
        return cpp;
    }

    public void setCpp(CenterPanelPatients cpp) {
        this.cpp = cpp;
    }

    public EditPanelPatients getEPP() {
        return EPP;
    }

    public DeletePanelPatients getDPP() {
        return DPP;
    }
}
