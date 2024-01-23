package com.example.demo.Employee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@AllArgsConstructor
public class Employee {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName="student_sequence",
            allocationSize = 10
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public Employee() {
    }

     public  Employee(Long id,
                    String name,
                    String email,
                    LocalDate dob)
                     {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Employee(String name,
                    String email,
                    LocalDate dob)
                    {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {

        return Period.between(this.dob , LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
