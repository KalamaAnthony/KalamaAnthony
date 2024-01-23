package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


      public List<Employee> getEmployee(){
         return employeeRepository.findAll();
     }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository
          .findEmployeeByEmail(employee.getEmail());

        if (employeeOptional.isPresent()){

            throw new IllegalStateException("Email already Registered");
        }
        employeeRepository.save(employee);
    }
}
