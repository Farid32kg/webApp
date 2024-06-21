package com.mywebbapp.faridWebApp.controller;

import com.mywebbapp.faridWebApp.model.Employee;
import com.mywebbapp.faridWebApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String getAllEmployee(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployee());
        return "index";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String createEmployee(@ModelAttribute ("employee") Employee employee){
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")Long id , Model model){

        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee (@PathVariable("id") Long id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }


}
