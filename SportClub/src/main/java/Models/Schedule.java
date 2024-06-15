package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Schedule implements Serializable {
    public ArrayList<GroupClass> schedule=new ArrayList<>();
    public Map<Integer,ArrayList<ClassSession>> weekSchedule=new HashMap<>();
    private static ArrayList<Schedule> instances=new ArrayList<>();

    public Schedule(ArrayList<GroupClass> schedule) {
        for (GroupClass groupClass : schedule)
            try {
                addGroupClass(groupClass);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        instances.add(this);
    }

    public void sortWeekSchedule() {
        for (ArrayList<ClassSession> sessions : this.weekSchedule.values()) {
            sessions.sort(Comparator.comparing(ClassSession::getStartTime));
        }
    }

    public boolean isTimeSlotAvailable(ClassSession sessionToCheck) {

        if(weekSchedule.containsKey(sessionToCheck.getDayOfWeek().getValue()))
            for (ClassSession session : weekSchedule.get(sessionToCheck.getDayOfWeek().getValue()))
                 if (session.overlapsWith(sessionToCheck))
                     return false;
        return true;
    }

    public void addGroupClass(GroupClass groupClass) throws Exception {
        for(ClassSession session : groupClass.getSessions()){
            if(!isTimeSlotAvailable(session)){
                 throw new Exception("This class overlaps another class: "+ session.getDayOfWeek() + " " + session.getStartTime());
            }
            else {
                if (!weekSchedule.containsKey(session.getDayOfWeek().getValue())) {
                    ArrayList<ClassSession> daySessions = new ArrayList<>();
                    daySessions.add(session);
                    weekSchedule.put(session.getDayOfWeek().getValue(), daySessions);
                } else {
                    weekSchedule.get(session.getDayOfWeek().getValue()).add(session);
                }
            }
        }
        this.sortWeekSchedule();
        this.schedule.add(groupClass);
    }

    public static ArrayList<Schedule> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Schedule> instances) {
        Schedule.instances = instances;
    }

    public ArrayList<GroupClass> getSchedule() {
        return schedule;
    }
    public ArrayList<GroupClass> getClassByDate(LocalDate date) {
        return schedule;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schedule=" + schedule +
                '}';
    }
}
