package Models;

import java.util.Map;
import java.util.TreeMap;

public class GroupClass {
    public String name;
    private Map<Integer,Client> clientQualif=new TreeMap<>();

    public GroupClass(String name) {
        this.name = name;
    }

    public void addClientQualif(Client client){
        if(!this.clientQualif.containsValue(client)){
            this.clientQualif.put(client.personLink.getId(),client);
        }
        else
            System.out.println("Client: "+ client.personLink.firstName+" is already in group: "+this.name);
    }

    public Client findClient(int id){
        return this.clientQualif.get(id);
    }

    @Override
    public String toString() {
        return "GroupClass{" +
                "name='" + name + '\'' +
                ", clientQualif=" + clientQualif +
                '}';
    }
}
