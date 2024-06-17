package com.springboot.EmployeesCRUD.Repository;

import com.springboot.EmployeesCRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
