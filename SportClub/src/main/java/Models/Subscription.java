package Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Subscription implements Serializable {
    public SubscriptionType type;
    public LocalDate expireDate;

    private Client client;
    public Subscription(SubscriptionType type, LocalDate expireDate)  {
        this.type = type;
        this.expireDate = expireDate;
        this.type.addSubscription(this);
    }

    public void addSubscriptionToType() {
        this.type.addSubscription(this);
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
