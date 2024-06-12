package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class CoachDietition extends Coach implements IDietition{

    public ArrayList<Diploma> educationDiplomas=new ArrayList<>();
    public ArrayList<Diet> diets=new ArrayList<>();

    public CoachDietition(String position, double salary, ArrayList<Contract> contracts, Person person, Certificate certificate, Diploma educationDiplomas) {
        super(position, salary, contracts, person, certificate);
        this.educationDiplomas.add(educationDiplomas);
    }

    public CoachDietition(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts, Certificate certificate, Diploma educationDiplomas) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary, contracts, certificate);
        this.educationDiplomas.add(educationDiplomas);
    }

    public CoachDietition(String position, double salary, ArrayList<Contract> contracts, Person person, ArrayList<Certificate> certificates, ArrayList<Diploma> educationDiplomas) {
        super(position, salary, contracts, person, certificates);
        this.educationDiplomas = educationDiplomas;
    }

    public CoachDietition(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts, ArrayList<Certificate> certificates, ArrayList<Diploma> educationDiplomas) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary, contracts, certificates);
        this.educationDiplomas = educationDiplomas;
    }

    @Override
    public void createDiet(Client client, String description) throws Exception {
        Diet diet=new Diet(description,client,this);
        this.diets.add(diet);
    }

    @Override
    public void addDiploma(Diploma diploma) {
        this.educationDiplomas.add(diploma);
    }
}
