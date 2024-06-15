package Services;
import Models.*;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Set;

public class DataCreator {
    public static void main(String[] args) {
        createData();
        Serializator.readData();
        System.out.println(Client.getInstances()+"\n"+Employee.getInstances()+"\n"+GroupClass.getInstances()+"\n"+Person.getInstances()+"\n"+Schedule.getInstances());

    }
//    public static void createData(){
//        try {
//            // Создание объектов Department
//            Department dept1 = new Department("Fitness");
//            Department dept2 = new Department("Swimming");
//            Department dept3 = new Department("Yoga");
//            Department dept4 = new Department("Cardio");
//            Department dept5 = new Department("Strength Training");
//
//            // Создание объектов Certificate
//            Certificate cert1 = new Certificate(1, LocalDate.of(2021, 1, 1), LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1));
//            Certificate cert2 = new Certificate(2, LocalDate.of(2021, 2, 1), LocalDate.of(2022, 2, 1), LocalDate.of(2023, 2, 1));
//            Certificate cert3 = new Certificate(3, LocalDate.of(2021, 3, 1), LocalDate.of(2022, 3, 1), LocalDate.of(2023, 3, 1));
//            Certificate cert4 = new Certificate(4, LocalDate.of(2021, 4, 1), LocalDate.of(2022, 4, 1), LocalDate.of(2023, 4, 1));
//            Certificate cert5 = new Certificate(5, LocalDate.of(2021, 5, 1), LocalDate.of(2022, 5, 1), LocalDate.of(2023, 5, 1));
//
//            // Создание объектов Contract
//            Contract contract1 = new Contract(1, LocalDate.of(2022, 12, 31), "Personal Trainer", 50000, dept1);
//            Contract contract2 = new Contract(2, LocalDate.of(2022, 11, 30), "Swimming Coach", 45000, dept2);
//            Contract contract3 = new Contract(3, LocalDate.of(2023, 1, 31), "Yoga Instructor", 40000, dept3);
//            Contract contract4 = new Contract(4, LocalDate.of(2023, 2, 28), "Cardio Specialist", 47000, dept4);
//            Contract contract5 = new Contract(5, LocalDate.of(2023, 3, 31), "Strength Coach", 49000, dept5);
//
//            ArrayList<Contract> contracts1 = new ArrayList<>();
//            contracts1.add(contract1);
//            ArrayList<Contract> contracts2 = new ArrayList<>();
//            contracts2.add(contract2);
//            ArrayList<Contract> contracts3 = new ArrayList<>();
//            contracts3.add(contract3);
//            ArrayList<Contract> contracts4 = new ArrayList<>();
//            contracts4.add(contract4);
//            ArrayList<Contract> contracts5 = new ArrayList<>();
//            contracts5.add(contract5);
//
//            // Создание объектов Coach
//            Coach coach1 = new Coach("John", "Doe", LocalDate.of(1980, 5, 15), "+1 123-456-7890", "john.doe@example.com", "password123", "Head Coach", 60000, contracts1, cert1);
//            Coach coach2 = new Coach("Jane", "Smith", LocalDate.of(1985, 7, 20), "+44 20 7946 0958", "jane.smith@example.com", "password456", "Assistant Coach", 55000, contracts2, cert2);
//            Coach coach3 = new Coach("Robert", "Johnson", LocalDate.of(1990, 8, 25), "+91 9876543210", "robert.johnson@example.com", "password789", "Senior Coach", 53000, contracts3, cert3);
//            Coach coach4 = new Coach("Emily", "Davis", LocalDate.of(1992, 9, 30), "+81 3-1234-5678", "emily.davis@example.com", "password101", "Junior Coach", 50000, contracts4, cert4);
//            Coach coach5 = new Coach("Michael", "Wilson", LocalDate.of(1988, 6, 10), "+49 30 123456", "michael.wilson@example.com", "password102", "Strength Coach", 52000, contracts5, cert5);
//
//            // Создание объектов Subscription
//
//
//            // Создание объектов ClassSession
//            ClassSession session1 = new ClassSession(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0));
//            ClassSession session2 = new ClassSession(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(15, 0));
//            ClassSession session3 = new ClassSession(DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(10, 0));
//            ClassSession session4 = new ClassSession(DayOfWeek.THURSDAY, LocalTime.of(16, 0), LocalTime.of(17, 0));
//            ClassSession session5 = new ClassSession(DayOfWeek.FRIDAY, LocalTime.of(18, 0), LocalTime.of(19, 0));
//            session1.addClientQualif(client1);
//
//
//
//            ArrayList<ClassSession> sessions1 = new ArrayList<>();
//            sessions1.add(new ClassSession(DayOfWeek.WEDNESDAY, LocalTime.of(8, 0), LocalTime.of(9, 0)));
//            sessions1.add(new ClassSession(DayOfWeek.SUNDAY, LocalTime.of(14, 0), LocalTime.of(15, 0)));
//            sessions1.add(new ClassSession(DayOfWeek.THURSDAY, LocalTime.of(14, 0), LocalTime.of(15, 0)));
//            sessions1.add(session1);
//            sessions1.add(session2);
//            ArrayList<ClassSession> sessions2 = new ArrayList<>();
//            sessions2.add(new ClassSession(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(11, 0)));
//            sessions2.add(session3);
//            sessions2.add(session4);
//            ArrayList<ClassSession> sessions3 = new ArrayList<>();
//            sessions3.add(session5);
//            sessions3.add(session1);
//            ArrayList<ClassSession> sessions4 = new ArrayList<>();
//            sessions4.add(session2);
//            sessions4.add(session3);
//            ArrayList<ClassSession> sessions5 = new ArrayList<>();
//            sessions5.add(session4);
//            sessions5.add(session5);
//
//            // Создание объектов GroupClass
//            GroupClass groupClass1 = new GroupClass("Yoga", sessions1);
//            GroupClass groupClass2 = new GroupClass("Pilates", sessions2);
//            GroupClass groupClass3 = new GroupClass("CrossFit", sessions3);
//            GroupClass groupClass4 = new GroupClass("Zumba", sessions4);
//            GroupClass groupClass5 = new GroupClass("Spin Class", sessions5);
//
//            ArrayList<GroupClass> schedule1 = new ArrayList<>();
//            schedule1.add(groupClass1);
//            schedule1.add(groupClass2);
//            ArrayList<GroupClass> schedule2 = new ArrayList<>();
//            schedule2.add(groupClass3);
//            schedule2.add(groupClass4);
//            ArrayList<GroupClass> schedule3 = new ArrayList<>();
//            schedule3.add(groupClass5);
//            schedule3.add(groupClass1);
//            ArrayList<GroupClass> schedule4 = new ArrayList<>();
//            schedule4.add(groupClass2);
//            schedule4.add(groupClass3);
//            ArrayList<GroupClass> schedule5 = new ArrayList<>();
//            schedule5.add(groupClass4);
//            schedule5.add(groupClass5);
//
//            // Создание объектов Schedule
//            Schedule scheduleObj1 = new Schedule(schedule1);
//            Schedule scheduleObj2 = new Schedule(schedule2);
//            Schedule scheduleObj3 = new Schedule(schedule3);
//            Schedule scheduleObj4 = new Schedule(schedule4);
//            Schedule scheduleObj5 = new Schedule(schedule5);
//
//            // Создание объектов Workout
//            Workout workout1 = new Workout("Upper Body Strength", client1, coach1);
//            Workout workout2 = new Workout("Cardio Blast", client2, coach2);
//            Workout workout3 = new Workout("Full Body Workout", client3, coach3);
//            Workout workout4 = new Workout("Yoga Session", client4, coach4);
//            Workout workout5 = new Workout("HIIT Training", client5, coach5);
//            System.out.println(Client.getInstances()+"\n"+Department.getInstances()+"\n"+Employee.getInstances()+"\n"+GroupClass.getInstances()+"\n"+Person.getInstances()+"\n"+Schedule.getInstances());
//
//            Serializator.save();
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    public static void createData() {
        try {

            // Создание объектов Client
            Client client1 = new Client("Alice", "Brown", LocalDate.of(1995, 1, 15), "678-901-2345", "alice.brown@example.com", "password201",SubscriptionType.BASIC, LocalDate.of(2023, 12, 31) );
            Client client2 = new Client("asdsaasa", "Brown", LocalDate.of(1995, 1, 15), "678-901-2345", "alicdae.brasown@example.com", "password201", SubscriptionType.STANDARD, LocalDate.of(2023, 11, 30));
            Client client3 = new Client("Emma", "Martinez", LocalDate.of(1992, 3, 20), "890-123-4567", "emma.martinez@example.com", "password203",SubscriptionType.PREMIUM, LocalDate.of(2023, 10, 31) );
            Client client4 = new Client("Olivia", "Garcia", LocalDate.of(1990, 4, 10), "901-234-5678", "olivia.garcia@example.com", "password204",SubscriptionType.BASIC, LocalDate.of(2023, 9, 30) );
            Client client5 = new Client("Liam", "Rodriguez", LocalDate.of(1985, 5, 5), "012-345-6789", "liam.rodriguez@example.com", "password205", SubscriptionType.STANDARD, LocalDate.of(2023, 8, 31));
            Client client6 = new Client("Sophia", "Johnson", LocalDate.of(1994, 6, 12), "234-567-8901", "sophia.johnson@example.com", "password206",SubscriptionType.BASIC, LocalDate.of(2024, 1, 31) );
            Client client7 = new Client("James", "Smith", LocalDate.of(1987, 7, 25), "345-678-9012", "james.smith@example.com", "password207",SubscriptionType.STANDARD, LocalDate.of(2024, 2, 28) );
            Client client8 = new Client("Benjamin", "Lee", LocalDate.of(1991, 8, 18), "456-789-0123", "benjamin.lee@example.com", "password208",SubscriptionType.PREMIUM, LocalDate.of(2024, 3, 31) );
            Client client9 = new Client("Mia", "Davis", LocalDate.of(1989, 9, 14), "567-890-1234", "mia.davis@example.com", "password209",SubscriptionType.BASIC, LocalDate.of(2024, 4, 30) );
            Client client10 = new Client("Isabella", "Wilson", LocalDate.of(1993, 10, 30), "678-901-2345", "isabella.wilson@example.com", "password210", SubscriptionType.STANDARD, LocalDate.of(2024, 5, 31));
            System.out.println(Client.getInstances());

            ArrayList<Coach> coaches = createCoaches();
            ArrayList<Dietitian> dietitians=createDietitians();
            ArrayList<ClassSession> classSessions = createClassSessions();
            ArrayList<GroupClass> groupClasses = createGroupClasses(coaches, classSessions);
            Schedule schedule = createSchedule(groupClasses);

            Workout workout1 = new Workout("Upper Body Strength", client1, coaches.get(1));
            Workout workout2 = new Workout("Cardio Blast", client2, coaches.get(2));
            Workout workout3 = new Workout("Full Body Workout", client3, coaches.get(3));
            Workout workout4 = new Workout("Yoga Session", client4, coaches.get(4));
            Workout workout5 = new Workout("HIIT Training", client5, coaches.get(5));
            Diet diet1=new Diet("No milk",client6,dietitians.get(1));
            Diet diet2=new Diet("No milk",client7,dietitians.get(2));
            Diet diet3=new Diet("No milk",client8,dietitians.get(3));
            Diet diet4=new Diet("No milk",client9,dietitians.get(4));
            Diet diet5=new Diet("No milk",client10,dietitians.get(5));

            // Output for demonstration
            System.out.println("Created Schedule:");
            for (GroupClass groupClass : schedule.getSchedule()) {
                System.out.println("Group Class: " + groupClass.getName());
                System.out.println("Coach: " + groupClass.getCoach().getPersonLink().firstName + " " + groupClass.getCoach().getPersonLink().firstName);
                System.out.println("Sessions:");
                for (ClassSession session : groupClass.getSessions()) {
                    System.out.println("  Day: " + session.getDayOfWeek() + ", Time: " + session.getStartTime() + "-" + session.getEndTime());
                }
                System.out.println();
            }
            Serializator.save();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static ArrayList<Coach> createCoaches() throws Exception {
        ArrayList<Coach> coaches = new ArrayList<>();
        ArrayList<Certificate> certificates = createCertificates();
        for (int i = 1; i <= 10; i++) {
            Coach coach = new Coach("CoachFirstName" + i, "CoachLastName" + i, LocalDate.of(1990 + i, 1, 1),
                    "678-901-23" + i, "coach" + i + "@example.com", "password" + i,
                    "Head Coach", 50000.0 + i * 1000, certificates.get(i));
            coaches.add(coach);
        }
        return coaches;
    }
    private static ArrayList<Dietitian> createDietitians() throws Exception {
        ArrayList<Dietitian> dietitians = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Dietitian dietitian=new Dietitian("CoachFirstName" + i, "CoachLastName" + i, LocalDate.of(1990 + i, 1, 1),
                    "678-901-23" + i, "coach" + i + "@example.com", "password" + i,
                    "Head Coach", 50000.0 + i * 1000,new Diploma(i,"PJATK","Doctor",LocalDate.of(2022, 1, 1), LocalDate.of(2023, 12, 31)));
            dietitians.add(dietitian);
        }
        return dietitians;
    }

    private static ArrayList<Certificate> createCertificates() throws Exception {
        ArrayList<Certificate> certificates = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            certificates.add(new Certificate(i, LocalDate.of(2020, 1, i), LocalDate.of(2022, 1, i), LocalDate.of(2023, 12, 31)));
        }
        return certificates;
    }

    private static ArrayList<ClassSession> createClassSessions() {
        ArrayList<ClassSession> classSessions = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            classSessions.add(new ClassSession((i%7)+1, LocalTime.of(10 + i, i), LocalTime.of(11 + i, 0)));
        }
        return classSessions;
    }

    private static ArrayList<GroupClass> createGroupClasses(ArrayList<Coach> coaches, ArrayList<ClassSession> classSessions) {
        ArrayList<GroupClass> groupClasses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<ClassSession> sessions = new ArrayList<>();
            sessions.add(classSessions.get(i));
            GroupClass groupClass = null;
            try {
                groupClass = new GroupClass("GroupClass" + (i + 1), coaches.get(i), sessions);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            groupClasses.add(groupClass);
        }
        return groupClasses;
    }

    private static Schedule createSchedule(ArrayList<GroupClass> groupClasses) {
        return new Schedule(groupClasses);
    }
}

