package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Employee {
    public String position;
    public double salary;
    private ArrayList<Contract> contracts=new ArrayList<>();
    private Employee supervisor;
    private ArrayList<Employee> subordinates=new ArrayList<>();
    private Person personLink;

    public Employee( Person person, String position, double salary, ArrayList<Contract> contracts) {
        this.position = position;
        this.salary = salary;
        this.contracts = contracts;
        this.personLink = person;
        this.personLink.setEmployee(this);
    }
    public Employee(String firstName, String lastName, LocalDate  date_of_Birth, String phoneNumber, String email, String password, String position, double salary, ArrayList<Contract> contracts) throws Exception {
        this.position = position;
        this.salary = salary;
        this.contracts = contracts;
        Person.createEmployee(this, firstName,  lastName,   date_of_Birth,  phoneNumber,  email, password);
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
    public void addContract(Contract c){
        if (!contracts.contains(c)) {
            contracts.add(c);
            contracts.sort(Comparator.comparing(contract -> contract.startDate));
        }
    }

    @Override
    public String toString() {
        return "Models.Employee{" +
                "position='" + position + '\'' +
                ", salary=" + salary +
                ", FirstName='" + personLink.firstName + '\'' +
                ", LastName='" + personLink.lastName + '\'' +
                ", id=" + this.personLink.getId() +
                '}';
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
