package com.springboot.EmployeesCRUD.Controller;

import com.springboot.EmployeesCRUD.Repository.EmployeeRepository;
import com.springboot.EmployeesCRUD.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    //API to create new employee
    @PostMapping("/employees")
    public String createNewEmployee(@RequestBody Employee employee){

        employeeRepository.save(employee);
        return "Employee Entry Created in DataBase";

    }

    //API to Fetch All employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        List <Employee> empList= new ArrayList<>();
        empList.addAll(employeeRepository.findAll());

        return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

    }

    //API to fetch employee Record
    @GetMapping("/employees/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid){

        //optional prevents NULL pointer in case no data is retrieved from DB
        Optional<Employee> emp = employeeRepository.findById(empid);

        if(emp.isPresent()){
            return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/employees/{empid}")
    public String updateEmployeebyId(@PathVariable long empid, @RequestBody Employee employee){

        Optional<Employee> emp = employeeRepository.findById(empid);

        if(emp.isPresent())
        {
            Employee curemp= emp.get();  //fetching the employee by ID

            //Setting values from employee object passed in request
            curemp.setEmp_age(employee.getEmp_age());
            curemp.setEmp_city(employee.getEmp_city());
            curemp.setEmp_name(employee.getEmp_name());
            curemp.setEmp_salary(employee.getEmp_salary());

            employeeRepository.save(curemp);

            return "Employee Details are updated against Employee ID: " + empid;
        }

        else{
            return "Employee Details does not exist for Employee ID: " + empid;
        }

    }

    @DeleteMapping("/employees/{empid}")
    public String deleteEmployeeById(@PathVariable long empid){

        employeeRepository.deleteById(empid);
        return "Employee Deleted Successfully";
    }

    @DeleteMapping("/employees")
    public String deleteAllEmployees(){

        employeeRepository.deleteAll();
        return "All Employees Deleted Successfully....";
    }
}
