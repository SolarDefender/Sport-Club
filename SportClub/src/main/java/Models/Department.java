package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
    private List<Contract> employees=new ArrayList<>();
    private static ArrayList<Department> instances =new ArrayList<>();
    public String name;

    public Department(String name) {
        this.name = name;
        instances.add(this);
    }

    public static void removeDepartment(Department dept) {
        instances.remove(dept);
    }
    public void removeEmployee(Contract empContract){
        this.employees.remove(empContract);
    }
    public void addEmployee(Contract empContract){
        this.employees.add(empContract);
    }

    public static ArrayList<Department> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Department> instances) {
        Department.instances = instances;
    }

    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                '}';
    }
}
