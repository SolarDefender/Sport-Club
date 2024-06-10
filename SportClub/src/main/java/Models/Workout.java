package Models;

import java.util.ArrayList;

public class Workout {
    private int id;
    public String Description;
    private Client client;
    private Coach coach;
    private static ArrayList<Workout> instances=new ArrayList<>();

    public Workout( String description, Client client, Coach coach) throws Exception {
        int idToCheck= instances.isEmpty()?0: instances.get(instances.size()-1).id+1;
        for(Workout w : instances){
            if (w.id==idToCheck)
                throw new Exception("this client already has training plan");
        }
        this.id=idToCheck;
        Description = description;
        this.client = client;
        this.coach = coach;
        client.setTrainingPlan(this);
        instances.add(this);
    }
}
