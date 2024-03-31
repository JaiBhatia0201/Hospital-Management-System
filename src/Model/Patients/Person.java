package Model.Patients;

public class Person {
    //constructor overloading since name of the constructor is same but the parameters is different
    public Person()
    {

    }
    public Person(String p_name,int patient_Age)
    {
        this.setName(p_name);
        this.setAge(patient_Age);
    }
    private  String Patient_Name;

    private int Patient_Age;
    //creating setter and getter for the above variables
    public void setAge(int Patient_Age) {
        this.Patient_Age = Patient_Age;
    }
    public void setName(String Patient_Name)
    {
        this.Patient_Name = Patient_Name;
    }

    public String getName()
    {
        return this.Patient_Name;
    }

    public int getAge() {
        return this.Patient_Age;
    }
    public void display()
    {
        System.out.println("Name: "+getName());
        System.out.println("Age: "+getAge());
    }
}


