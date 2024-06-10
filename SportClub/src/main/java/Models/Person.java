package Models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Person {
    public String firstName;
    public String lastName;
    public LocalDate Date_of_Birth; //pochodny
    public int age;
    private String phoneNumber;
    public String email;
    private int id;
    private String password;
    private Client clientLink;
    private Employee employeeLink;
    private static ArrayList<Person> instances =new ArrayList<>(); // powt

    private Person(String firstName, String lastName, LocalDate  date_of_Birth, String phoneNumber, String email, String password) throws Exception {

        int idToCheck= instances.isEmpty()?0: instances.get(instances.size()-1).id+1;
        for(Person m : instances){
            if (m.id==idToCheck)
                throw new Exception("Person of this ID already exists");
        }
        this.id=idToCheck;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Date_of_Birth = date_of_Birth;
        this.age= LocalDate.now().getYear()-date_of_Birth.getYear();
        this.setPhoneNumber(phoneNumber);
        this.email = email;
        this.password=password;
        instances.add(this);
    }

    public static void createClient(Client client, String firstName, String lastName, LocalDate  date_of_Birth, String phoneNumber, String email, String password) throws Exception {
        Person p=new Person(firstName, lastName, date_of_Birth, phoneNumber, email, password);
        p.clientLink=client;
        p.clientLink.setPersonLink(p);
    }
    public static void createEmployee(Employee emp, String firstName, String lastName, LocalDate  date_of_Birth, String phoneNumber, String email, String password) throws Exception {
        Person p=new Person(firstName, lastName, date_of_Birth, phoneNumber, email, password);
        p.employeeLink=emp;
        p.employeeLink.setPersonLink(p);
    }
    public void setClient(Client c){
        this.clientLink=c;
    }
    public void setEmployee(Employee e){
        this.employeeLink=e;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static ArrayList<Person> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Person> personIntanses) {
        Person.instances = instances;
    }

    public static void removeInstance(Person person){
        instances.remove(person);
    }
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Date_of_Birth=" + Date_of_Birth +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
    public static void saveChanges()  {
        try (
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Persons.ser"))) {
            out.writeObject(instances);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readinstances()  {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Persons.ser"))) {
            setInstances((ArrayList<Person>) in.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
