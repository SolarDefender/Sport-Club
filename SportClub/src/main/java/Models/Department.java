package Models;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Contract> employees=new ArrayList<>();
    private static List<Department> allDepartments=new ArrayList<>();
    public String name;

    public Department(String name) {
        this.name = name;
        allDepartments.add(this);
    }

    public static void removeDepartment(Department dept) {
        allDepartments.remove(dept);
    }
    public void removeEmployee(Contract empContract){
        this.employees.remove(empContract);
    }
    public void addEmployee(Contract empContract){
        this.employees.add(empContract);
    }

    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                '}';
    }
}
