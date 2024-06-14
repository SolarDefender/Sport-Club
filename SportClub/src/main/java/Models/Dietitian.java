package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dietitian extends Employee implements IDietitian {

    public ArrayList<Diploma> educationDiplomas=new ArrayList<>();
    public ArrayList<Diet> diets=new ArrayList<>();
     public Dietitian(Person person, String position, double salary, ArrayList<Contract> contracts, Diploma diploma) {
        super(person, position, salary, contracts);
        this.educationDiplomas.add(diploma);
    }

    public Dietitian(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts, Diploma diploma) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary, contracts);
    }
    public Dietitian(Person person, String position, double salary, ArrayList<Contract> contracts, ArrayList<Diploma> diplomas) {
        super(person, position, salary, contracts);
        this.educationDiplomas=diplomas;
    }

    public Dietitian(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts, ArrayList<Diploma> diplomas) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary, contracts);
        this.educationDiplomas=diplomas;
    }
    @Override
    public void createDiet(Client client,String description) throws Exception {
        Diet diet=new Diet(description,client,this);
        this.diets.add(diet);
    }
    @Override
    public void addDiploma(Diploma diploma){
         this.educationDiplomas.add(diploma);
    }
}
