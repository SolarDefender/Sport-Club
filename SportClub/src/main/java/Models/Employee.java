package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Employee implements Serializable {

    private String position;
    private double salary;


    private Person personLink;
    private Employee supervisor;
    private ArrayList<Employee> subordinates = new ArrayList<>();
    private static ArrayList<Employee> instances =new ArrayList<>();

    public Employee( Person person, String position, double salary) {
        this.position = position;
        this.salary = salary;
        this.personLink = person;
        this.personLink.setEmployee(this);

        instances.add(this);
    }
    public Employee(String firstName, String lastName, LocalDate  date_of_Birth, String phoneNumber, String email, String password, String position, double salary) throws Exception {
        this.position = position;
        this.salary = salary;

        Person.createEmployee(this, firstName,  lastName,   date_of_Birth,  phoneNumber,  email, password);
        instances.add(this);
    }

    public static ArrayList<Employee> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Employee> instances) {
        Employee.instances = instances;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public void setPersonLink(Person person) {
        this.personLink = person;
        this.personLink.setEmployee(this);
    }

    public Person getPersonLink() {
        return personLink;
    }
    public void addSubbordinate(Employee emp){
        if (!subordinates.contains(emp))
           this.subordinates.add(emp);
    }
    public void addSubbordinates(ArrayList<Employee> emps){
        for (Employee emp:emps)
            if (!subordinates.contains(emp))
                this.subordinates.add(emp);

    }


    @Override
    public String toString() {
        return "Employee{\n" +this.getClass().getSimpleName()+"\n"+
                " id=" + personLink.getId() + "\n" +
                " FirstName='" + personLink.firstName + "'\n" +
                " LastName='" + personLink.lastName + "'\n" +
                " Date_of_Birth=" + personLink.Date_of_Birth + "\n" +
                " position='" + position + "'\n" +
                " salary=" + salary + "\n" +
                '}';
    }


    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
