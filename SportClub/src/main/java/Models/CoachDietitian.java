package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class CoachDietitian extends Coach implements IDietitian {

    public ArrayList<Diploma> educationDiplomas=new ArrayList<>();
    public ArrayList<Diet> diets=new ArrayList<>();

    public CoachDietitian(String position, double salary,  Person person, Certificate certificate, Diploma educationDiplomas) {
        super(position, salary,   person, certificate);
        this.educationDiplomas.add(educationDiplomas);
    }

    public CoachDietitian(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary,  Certificate certificate, Diploma educationDiplomas) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary,   certificate);
        this.educationDiplomas.add(educationDiplomas);
    }

    public CoachDietitian(String position, double salary,  Person person, ArrayList<Certificate> certificates, ArrayList<Diploma> educationDiplomas) {
        super(position, salary, certificates, person);
        this.educationDiplomas = educationDiplomas;
    }

    public CoachDietitian(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary,  ArrayList<Certificate> certificates, ArrayList<Diploma> educationDiplomas) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary,   certificates);
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
