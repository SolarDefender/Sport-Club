package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Coach extends Employee {
    public ArrayList<Certificate> certificates=new ArrayList<>();
    public ArrayList<Workout> clientsWorkout=new ArrayList<>();
    public Coach(String position, double salary, ArrayList<Contract> contracts, Person person,Certificate certificate) {
        super(person,position, salary, contracts);
        this.certificates.add(certificate);
    }

    public Coach(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts,Certificate certificate) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary, contracts);
        this.certificates.add(certificate);
    }
    public Coach(String position, double salary, ArrayList<Contract> contracts, Person person,ArrayList<Certificate> certificates) {
        super(person,position, salary, contracts);
        this.certificates=certificates;
    }

    public Coach(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts,ArrayList<Certificate> certificates) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary, contracts);
        this.certificates=certificates;
    }
    public void addCertificate(Certificate c) throws Exception {
        if (!certificates.contains(c))
            this.certificates.add(c);
        else
            throw new Exception("This certificate is already added");
    }
    public void addClient(Client c, String workoutDescr) throws Exception {
        Workout w=new Workout(workoutDescr,c,this);
        this.clientsWorkout.add(w);
    }
}
