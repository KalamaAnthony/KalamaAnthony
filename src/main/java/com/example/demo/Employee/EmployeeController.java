package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getMapping(){
       return employeeService.getEmployee();
    }


    @PostMapping
    public void registerNewEmployee(@RequestBody Employee  employee){
        employeeService.addNewEmployee(employee);
    }


    @DeleteMapping(path ="{employeeId}" )
    public void deleteEmployee(
            @PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
    @PutMapping(path = {"employeeId"})
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        employeeService.updateEmployee(employeeId, name, email);
    }

}