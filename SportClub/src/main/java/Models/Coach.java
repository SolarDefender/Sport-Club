package Models;


import java.time.LocalDate;
import java.util.ArrayList;


public class Coach extends Employee {

    public ArrayList<Certificate> certificates = new ArrayList<>();

    public ArrayList<Workout> trainingPlans = new ArrayList<>();
    public ArrayList<GroupClass> groupClasses=new ArrayList<>();
    public Coach(String position, double salary, Person person,Certificate certificate) {
        super(person,position, salary);
        this.certificates.add(certificate);
    }

    public Coach(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary,Certificate certificate) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary);
        this.certificates.add(certificate);
    }
    public Coach(String position, double salary, ArrayList<Certificate> certificates, Person person) {
        super(person,position, salary);
        this.certificates=certificates;
    }

    public Coach(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary,ArrayList<Certificate> certificates) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary);
        this.certificates=certificates;
    }
    public void addCertificate(Certificate c) throws Exception {
        if (!certificates.contains(c))
            this.certificates.add(c);
        else
            throw new Exception("This certificate is already added");
    }
    public void addGroupClass(GroupClass groupClass){ this.groupClasses.add(groupClass);}
    public void createTrainPlan(Workout workout) throws Exception {
        this.trainingPlans.add(workout);
    }
}
