package Models;


import java.io.Serializable;
import java.util.ArrayList;


public class Diet implements Serializable {

    private int id;
    public String Description;

    public Client client;

    public IDietitian dietitian;

        private static ArrayList<Diet> instances=new ArrayList<>();

        public Diet( String description, Client client, IDietitian dietitian) throws Exception {
            int idToCheck= instances.isEmpty()?0: instances.get(instances.size()-1).id+1;
            for(Models.Diet w : instances){
                if (w.id==idToCheck)
                    throw new Exception("this client already has diet");
            }
            this.id=idToCheck;
            Description = description;
            this.client = client;
            this.dietitian = dietitian;
            client.setDiet(this);
            instances.add(this);
        }

}
