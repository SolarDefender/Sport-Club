package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Subscription implements Serializable {
    public SubscriptionType type;
    public LocalDate expireDate;
    private Client client;
    private static ArrayList<Subscription> instanses=new ArrayList<>();

    private Subscription(SubscriptionType type, LocalDate expireDate)  {
        this.type = type;
        this.expireDate = expireDate;
        this.type.addSubscription(this);
    }

    public void addSubscriptionToType() {
        this.type.addSubscription(this);
    }

    public static void createSubscribtion(SubscriptionType type, LocalDate expireDate,Client client){
        Subscription s=new Subscription(type,expireDate);
        s.client=client;
        s.client.setSubscription(s);
    }
    public void removeSubscription(){
        instanses.remove(this);
    }
    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client){
        this.client=client;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "type=" + type.name() +
                ", expireDate=" + expireDate +
                ", client=" + client.getPersonLink().firstName+" " +client.getPersonLink().lastName+
                '}';
    }
}
