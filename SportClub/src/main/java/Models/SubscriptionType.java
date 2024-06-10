package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum SubscriptionType {
    BASIC(FacilityAccess.GYM),
    STANDARD(FacilityAccess.GYM, FacilityAccess.SWIMMING_POOL,FacilityAccess.GROUP_CLASSES),
    PREMIUM(FacilityAccess.GYM, FacilityAccess.SWIMMING_POOL, FacilityAccess.GROUP_CLASSES,FacilityAccess.SPA);

    private ArrayList<Subscription> subscriptions=new ArrayList<>();

    private final Set<FacilityAccess> facilities;
    SubscriptionType(FacilityAccess... facilities) {
        this.facilities = new HashSet<>(Arrays.asList(facilities));
    }
    public Set<FacilityAccess> getFacilities() {
        return new HashSet<>(facilities);
    }

    public void addSubscription(Subscription subscription){ this.subscriptions.add(subscription);}

    public ArrayList<Subscription> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public String toString() {
        return "Subscription Access{" +
                "facilities=" + facilities +
                '}';
    }

    public enum FacilityAccess  {
        GYM,
        SWIMMING_POOL,
        GROUP_CLASSES,
        SPA;
    }
}
