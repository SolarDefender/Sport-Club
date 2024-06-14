package Models;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GroupClass implements Serializable {
    public String name;
    private Map<Integer,Client> clientQualif=new TreeMap<>();
    private ArrayList<ClassSession> sessions = new ArrayList<>();
    private static ArrayList<GroupClass> instances=new ArrayList<>();
    public GroupClass(String name,ArrayList<ClassSession> sessions) {
        this.name = name;
        this.sessions=sessions;
        for(ClassSession session : sessions)
            session.setGroupClass(this);
        instances.add(this);
    }

    public void addClientQualif(Client client){
        if(!this.clientQualif.containsValue(client)){
            this.clientQualif.put(client.getPersonLink().getId(),client);
        }
        else
            System.out.println("Client: "+ client.getPersonLink().firstName+" is already in group: "+this.name);
    }

    public ArrayList<ClassSession> getSessions() {
        return sessions;
    }

    public Client findClient(int id){
        return this.clientQualif.get(id);
    }
    public void removeClient(Client client){
        if (clientQualif.containsValue(client)) {
            clientQualif.remove(client.getPersonLink().getId());
            System.out.println("Client succesfully removed from class");
        }
        else
            System.out.println("Provided client is not registered for this class");
    }

    public static ArrayList<GroupClass> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<GroupClass> instances) {
        GroupClass.instances = instances;
    }

    @Override
    public String toString() {
        return "GroupClass{" +
                "name='" + name + '\'' +
                ", clientQualif=" + clientQualif +
                '}';
    }
}
