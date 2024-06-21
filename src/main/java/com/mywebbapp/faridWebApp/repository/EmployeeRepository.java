package com.mywebbapp.faridWebApp.repository;

import com.mywebbapp.faridWebApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
