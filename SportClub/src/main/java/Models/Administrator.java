package Models;


import java.time.LocalDate;
import java.util.ArrayList;


public class Administrator extends Employee{
    public Administrator(String position, double salary, ArrayList<Contract> contracts, Person person) {
        super( person,position, salary, contracts);
    }

    public Administrator(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts) throws Exception {
        super(firstName, lastName, date_of_Birth, phoneNumber, email, password, position, salary, contracts);
    }
    public void updateEmployeePosition(Employee employee, String newPosition) {
        employee.setPosition(newPosition);
    }

    public void updateEmployeeSalary(Employee employee, double newSalary) {
        employee.setSalary(newSalary);
    }

    public void updatePersonPhoneNumber(Person person, String newPhoneNumber) {
        person.setPhoneNumber(newPhoneNumber);
    }

    public void updatePersonEmail(Person person, String newEmail) {
        person.email = newEmail;
    }

    public void updatePersonPassword(Person person, String newPassword) {
        person.setPassword(newPassword);
    }

    public void updatePersonName(Person person, String newFirstName, String newLastName) {
        person.firstName = newFirstName;
        person.lastName = newLastName;
    }
}
