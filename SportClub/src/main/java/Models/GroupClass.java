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
    private Coach coach;
    private Map<Integer,Client> clientQualif=new TreeMap<>();
    private ArrayList<ClassSession> sessions = new ArrayList<>();
    private static ArrayList<GroupClass> instances=new ArrayList<>();
    public GroupClass(String name,Coach coach,ArrayList<ClassSession> sessions) throws Exception {
        for(GroupClass groupClass : instances){
            if (groupClass.name==name)
                throw new Exception("Person of this ID already exists");
        }
        this.name = name;
        this.sessions=sessions;
        for(ClassSession session : sessions)
            session.setGroupClass(this);
        instances.add(this);
        this.coach=coach;
        this.coach.addGroupClass(this);
    }

    public String getName() {
        return name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void addClientQualif(Client client){
        if(!this.clientQualif.containsValue(client))
            this.clientQualif.put(client.getPersonLink().getId(),client);
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
            for(ClassSession cs : sessions){
                cs.removeClient(client);
            }
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
