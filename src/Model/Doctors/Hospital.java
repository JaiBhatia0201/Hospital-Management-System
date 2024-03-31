package Model.Doctors;

public class Hospital {
    //constructor overloading since name of the constructor is same but the parameters is different
    public Hospital(){

    }
    public Hospital(String Speciality, int Experience){
        this.setSpeciality(Speciality);
        this.setExperience(Experience);
    }
    private String Speciality;
    private int Experience;
    //constructor overloading since name of the constructor is same but the parameters is different
    public void setSpeciality(String Specialitity){
        this.Speciality = Specialitity;
    }
    public void setExperience(int Experience){
        this.Experience = Experience;
    }
    public String getSpeciality(){
        return this.Speciality;
    }
    public int getExperience(){
        return this.Experience;
    }
    public void display(){
        System.out.println("Speciality: " + getSpeciality());
        System.out.println("Experience: " + getExperience());
    }
}
