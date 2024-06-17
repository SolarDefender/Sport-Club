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

    public Client(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email, String password, SubscriptionType subType, LocalDate subExpireDate) throws Exception {

        for(Client c : instances)
            if (c.personLink.email.equals(email))
                throw new Exception("Person of this email already exists");
        Subscription.createSubscribtion(subType,subExpireDate,this);
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

    public static void removeExpiredClients(){
        for(Client c : instances)
            if (c.getSubscription().expireDate.isBefore(LocalDate.now().minusMonths(6)))
                c.removeClient();
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

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
    public void removeClient(){
        this.personLink.setClient(null);
        this.subscription.removeSubscription();
        instances.remove(this);
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
