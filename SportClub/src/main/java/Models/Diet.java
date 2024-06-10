package Models;

import java.util.ArrayList;

public class Diet {

        private int id;
        public String Description;
        private Client client;
        private Dietition dietition;
        private static ArrayList<Diet> instances=new ArrayList<>();

        public Diet( String description, Client client, Dietition Dietition) throws Exception {
            int idToCheck= instances.isEmpty()?0: instances.get(instances.size()-1).id+1;
            for(Models.Diet w : instances){
                if (w.id==idToCheck)
                    throw new Exception("this client already has diet");
            }
            this.id=idToCheck;
            Description = description;
            this.client = client;
            this.dietition = Dietition;
            client.setDiet(this);
            instances.add(this);
        }

}
