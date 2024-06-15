package Models;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

public class ClassSession implements Serializable {
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
    private GroupClass groupClass;
    public int totalMembers =0;
    private boolean completed=false;
//    private Duration duration = Duration.between(startTime, endTime);
//    private long durationHours = duration.toHours();
//    private long durationMinutes = duration.toMinutes() % 60;
    private final static int minMembers =1;
    private final static int maxMembers=3;
    private Map<Integer,Client> clientQualif=new TreeMap<>();
    public ClassSession(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime =startTime;
        this.endTime = endTime;
    }
    public ClassSession(int day, LocalTime startTime, LocalTime endTime) {
        this.day = DayOfWeek.of(day);
        this.startTime =startTime;
        this.endTime = endTime;
    }
    public void start(){
        if(!completed && totalMembers >= minMembers){
            completed=true;
            System.out.println(this.groupClass.name+" Success");
        }
        else{
            System.out.println("Failed: " + (completed?" This class is completed":" not enough players"));
        }
    }

    public boolean addClientQualif(Client client){
        if(!this.clientQualif.containsValue(client)&& totalMembers<maxMembers){
            this.clientQualif.put(client.getPersonLink().getId(),client);
            totalMembers++;
            return true;
        }
        else {
            System.out.println("Client: " + client.getPersonLink().firstName + " is already in group: " + this.groupClass.name + "in " + getDayOfWeek());
            return false;
        }
    }


    public Map<Integer, Client> getMembers() {
        return clientQualif;
    }

    public String  getName() {
        return this.groupClass.name;
    }
    public int getMaxMembers() {
        return maxMembers;
    }

    public Client findClient(int id){
        return this.clientQualif.get(id);
    }
    public void removeClient(Client client){
        if (clientQualif.containsValue(client)) {
            clientQualif.remove(client.getPersonLink().getId());
            System.out.println("Client succesfully removed from class");
            totalMembers--;
        }
        else
            System.out.println("Provided client is not registered for this class");
    }
    // Геттеры и сеттеры

    public void setGroupClass(GroupClass groupClass) {
        this.groupClass = groupClass;
    }

    public GroupClass getGroupClass() {
        return groupClass;
    }

    public DayOfWeek getDayOfWeek() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    public boolean overlapsWith(ClassSession session) {
        return startTime.isBefore(session.endTime) && endTime.isAfter(session.startTime);
    }

    @Override
    public String toString() {
        return "ClassSession{" +
                "day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
