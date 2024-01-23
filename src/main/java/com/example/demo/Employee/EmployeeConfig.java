package com.example.demo.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            Employee Kalama=new Employee(
                    "Kalama",
                    "tonnykalama9@gmail.com",
                    LocalDate.of(1997, 6, 23),
                    26


            );

            Employee Baraka=new Employee(
                    "Baraka",
                    "barakakalama9@gmail.com",
                    LocalDate.of(2004, 6, 23),
                    19


            );

            Employee Anthony=new Employee(
                    "Anthony",
                    "chumakalama9@gmail.com",
                    LocalDate.of(2000, 6, 23),
                    23


            );
            repository.saveAll(
             List.of(Kalama, Baraka, Anthony)
             );

        };
    }




}
