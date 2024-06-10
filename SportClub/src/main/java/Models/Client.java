package Models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    private Subscription subscription;
    public Person personLink;
    public Workout trainingPlan;
    public Diet diet;
    public Client(String firstName, String lastName, LocalDate date_of_Birth, String phoneNumber, String email,String password, Subscription subscription) throws Exception {
        this.subscription=subscription;
        this.subscription.setClient(this);
        Person.createClient(this, firstName,  lastName,   date_of_Birth,  phoneNumber,  email, password);
    }

    public Client(Person person, Subscription subscription) throws Exception {
        this.subscription=subscription;
        this.subscription.setClient(this);
        this.personLink = person;
        this.personLink.setClient(this);
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
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
                " id=" + personLink.getId() +"\n " +
                " FirstName='" + personLink.firstName + "\n " +
                " LastName='" + personLink.lastName + "\n " +
                " Date_of_Birth=" + personLink.Date_of_Birth + "\n " +
                subscription+"\n "+
                '}';
    }
}
