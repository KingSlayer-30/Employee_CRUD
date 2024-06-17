package com.springboot.EmployeesCRUD.model;

import jakarta.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {

   /* empid bigint NOT NULL AUTO_INCREMENT,
    emp_name VARCHAR(50) DEFAULT NULL,
    emp_salary float DEFAULT NULL,
    emp_age integer DEFAULT NULL,
    emp_city VARCHAR(50) DEFAULT NULL,*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empid;
    @Column(name="emp_name")
    private String emp_name;
    @Column(name="emp_salary")
    private  float emp_salary;
    @Column(name="emp_age")
    private int emp_age;
    @Column(name="emp_city")
    private String emp_city;

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public float getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(float emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public Employee(long empid, String emp_name, float emp_salary, int emp_age, String emp_city) {
        this.empid = empid;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
        this.emp_age = emp_age;
        this.emp_city = emp_city;
    }

    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", emp_name='" + emp_name + '\'' +
                ", emp_salary=" + emp_salary +
                ", emp_age=" + emp_age +
                ", emp_city='" + emp_city + '\'' +
                '}';
    }
}
