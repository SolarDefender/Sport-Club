package Services;


import Models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class Serializator {

    /*private final static ArrayList<Class<?>> classes = new ArrayList<>() {
        {
            add(Administrator.class);
            add(Certificate.class);
            add(ClassSession.class);
            add(Client.class);
            add(Coach.class);
            add(CoachDietitian.class);
            add(Contract.class);
            add(Department.class);
            add(Diet.class);
            add(Dietitian.class);
            add(Diploma.class);
            add(Employee.class);
            add(GroupClass.class);
            add(Person.class);
            add(Schedule.class);
            add(Subscription.class);
            add(Workout.class);
        }
    };*/


    public static void save() {
        saveData(Client.getInstances(),"Client");
        saveData(Employee.getInstances(),"Employee");
        saveData(GroupClass.getInstances(),"GroupClass");
        saveData(Person.getInstances(),"Person");
        saveData(Schedule.getInstances(),"Schedule");
    }

    public static  void saveGroups() {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/GroupClass.ser"))) {
            out.writeObject(GroupClass.getInstances());
            System.out.println("Serialized data is saved in " +"src/main/resources/"+ GroupClass.getInstances().getClass().getSimpleName() + ".ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static <T extends Serializable> void saveData(ArrayList<T> instanceToSave,String name) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/"+name + ".ser"))) {
            out.writeObject(instanceToSave);
            System.out.println("Serialized data is saved in " +"src/main/resources/"+ name + ".ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData() {
        readData(Client.class);
        readData(Employee.class);
        readData(GroupClass.class);
        readData(Person.class);
        readData(Schedule.class);
    }

    private static <T extends Serializable> void readData(Class<T> clazz) {
        String filePath = "src/main/resources/"+clazz.getSimpleName() + ".ser";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            ArrayList<T> deserializedList = (ArrayList<T>) in.readObject();
            invokeSetInstancesMethod(clazz, deserializedList);
            System.out.println("Deserialized data from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static <T extends Serializable> void invokeSetInstancesMethod(Class<T> clazz, ArrayList<T> instances) {
        try {
            // Используем рефлексию для вызова статического метода setInstances(ArrayList<T> instances)
            clazz.getMethod("setInstances", ArrayList.class).invoke(null, instances);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    public static void save(){

        saveData(Client.getInstances());
        saveData(Department.getInstances());
        saveData(Employee.getInstances());
        saveData(GroupClass.getInstances());
        saveData(Person.getInstances());
        saveData(Schedule.getInstances());

    }
    private static <T> void saveData(ArrayList<T> instanceToSave) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Сериализация объекта в файл
            mapper.writeValue(new File(instanceToSave.get(0).getClass().getSimpleName() + ".json"), instanceToSave);
            System.out.println("Serialized data is saved in schedule.json");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readData()  {


        //readFile("src/main/resources/"+Administrator.class.getSimpleName()+".json",Administrator.class,new TypeReference<ArrayList<Administrator>>() {});
        //readFile("src/main/resources/"+Certificate.class.getSimpleName()+".json",Certificate.class,new TypeReference<ArrayList<Certificate>>() {});
        //readFile("src/main/resources/"+ClassSession.class.getSimpleName()+".json",ClassSession.class,new TypeReference<ArrayList<ClassSession>>() {});
        readFile("src/main/resources/"+Client.class.getSimpleName()+".json",Client.class,new TypeReference<ArrayList<Client>>() {});
        //readFile("src/main/resources/"+Coach.class.getSimpleName()+".json",Coach.class,new TypeReference<ArrayList<Coach>>() {});
        //readFile("src/main/resources/"+CoachDietitian.class.getSimpleName()+".json",CoachDietitian.class,new TypeReference<ArrayList<CoachDietitian>>() {});
        //readFile("src/main/resources/"+Contract.class.getSimpleName()+".json",Contract.class,new TypeReference<ArrayList<Contract>>() {});
        readFile("src/main/resources/"+Department.class.getSimpleName()+".json",Department.class,new TypeReference<ArrayList<Department>>() {});
        //readFile("src/main/resources/"+Diet.class.getSimpleName()+".json",Diet.class,new TypeReference<ArrayList<Diet>>() {});
        //readFile("src/main/resources/"+Dietitian.class.getSimpleName()+".json",Dietitian.class,new TypeReference<ArrayList<Dietitian>>() {});
        //readFile("src/main/resources/"+Diploma.class.getSimpleName()+".json",Diploma.class,new TypeReference<ArrayList<Diploma>>() {});
        readFile("src/main/resources/"+Employee.class.getSimpleName()+".json",Employee.class,new TypeReference<ArrayList<Employee>>() {});
        readFile("src/main/resources/"+GroupClass.class.getSimpleName()+".json",GroupClass.class,new TypeReference<ArrayList<GroupClass>>() {});
        readFile("src/main/resources/"+Person.class.getSimpleName()+".json",Person.class,new TypeReference<ArrayList<Person>>() {});
        readFile("src/main/resources/"+Schedule.class.getSimpleName()+".json",Schedule.class,new TypeReference<ArrayList<Schedule>>() {});
        //readFile("src/main/resources/"+Subscription.class.getSimpleName()+".json",Subscription.class,new TypeReference<ArrayList<Subscription>>() {});
        //readFile("src/main/resources/"+Workout.class.getSimpleName()+".json",Workout.class,new TypeReference<ArrayList<Workout>>() {});


    }

    private static <T> void readFile(String filePath, Class<?> clazz, TypeReference<ArrayList<T>> typeReference) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<T> deserializedList = mapper.readValue(new File(filePath), typeReference);
            Method setInstancesMethod = clazz.getDeclaredMethod("setInstances", ArrayList.class);
            setInstancesMethod.invoke(null, deserializedList); // Передаем null, потому что метод статический
            System.out.println("Serialized data is saved in "+filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
