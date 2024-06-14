package Models;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Contract implements Serializable {
    private int id;
    public LocalDate startDate;
    public LocalDate expireDate;
    public double salary;
    public String position;
    private static final ArrayList<Contract> instances=new ArrayList<>();

    private Employee emp;

    private Department dept;


    public Contract(int id, LocalDate expireDate,String position, double salary,Department dept) throws Exception {
        for(Contract c : instances){
            if (c.id==id)
                throw new Exception("Certificate of this ID already exists");
        }
        this.id = id;
        this.position=position;
        this.expireDate = expireDate;
        this.salary = salary;
        this.startDate=LocalDate.now();
        this.setDept(dept);
        this.dept.addEmployee(this);
        instances.add(this);
    }

    public Contract() {

    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Contract{\n" +
                "id=" + id + "\n" +
                "startDate=" + startDate + "\n" +
                "expireDate=" + expireDate + "\n" +
                "salary=" + salary + "\n" +
                "position='" + position + '\'' + "\n" +
                "emp=" + emp.getPersonLink().firstName + "\n" +
                "dept=" + dept.name + "\n" +
                '}';
    }


}
