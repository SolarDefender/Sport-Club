package Models;

import java.time.LocalDate;

public class Contract {
    public LocalDate startDate;
    public LocalDate expireDate;
    public double salary;
    public String position;
    private Employee emp;
    private Department dept;


    public Contract( LocalDate expireDate,String position, double salary,Department dept) {
        this.position=position;
        this.expireDate = expireDate;
        this.salary = salary;
        this.startDate=LocalDate.now();
        this.setDept(dept);
        this.setEmp(emp);
        this.dept.addEmployee(this);
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
}
