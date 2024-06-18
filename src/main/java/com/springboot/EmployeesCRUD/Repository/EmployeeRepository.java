package com.springboot.EmployeesCRUD.Repository;

import com.springboot.EmployeesCRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e from Employee e WHERE e.emp_city = :empCity")
    List<Employee> findByempCity(@Param("empCity") String empCity);

    @Query("SELECT e FROM Employee e WHERE e.emp_age >= :empAge")
    List<Employee> findByAge(@Param("empAge") int empAge);
}
