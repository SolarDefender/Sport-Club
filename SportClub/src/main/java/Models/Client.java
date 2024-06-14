package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Client implements Serializable {

    private Person personLink; // Поменял модификатор доступа на private
    private Subscription subscription;
    private Workout trainingPlan;
    private Diet diet;
    private static ArrayList<Client> instances = new ArrayList<>();

    public Client(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, Subscription subscription) throws Exception {
        this.subscription = subscription;
        this.subscription.setClient(this);
        Person.createClient(this, firstName, lastName, date_of_Birth, phoneNumber, email, password);
        instances.add(this);
    }

    public Client(Person person, Subscription subscription) throws Exception {
        this.subscription = subscription;
        this.subscription.setClient(this);
        this.personLink = person;
        this.personLink.setClient(this);
        instances.add(this);
    }

    public static ArrayList<Client> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Client> instances) {
        Client.instances = instances;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Person getPersonLink() {
        return personLink;
    }

    public void setPersonLink(Person personLink) {
        this.personLink = personLink;
    }

    public void setTrainingPlan(Workout trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public String toString() {
        return "Client{\n" +
                " id=" + personLink.getId() + "\n " +
                " FirstName='" + personLink.firstName + "\n " +
                " LastName='" + personLink.lastName + "\n " +
                " Date_of_Birth=" + personLink.Date_of_Birth + "\n " +
                subscription + "\n " +
                '}';
    }
}
