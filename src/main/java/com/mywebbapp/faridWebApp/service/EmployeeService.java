package com.mywebbapp.faridWebApp.service;


import com.mywebbapp.faridWebApp.model.Employee;
import com.mywebbapp.faridWebApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return  employeeRepository.findById(id).orElse(null);

    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id ){
        employeeRepository.deleteById(id);
    }
}
