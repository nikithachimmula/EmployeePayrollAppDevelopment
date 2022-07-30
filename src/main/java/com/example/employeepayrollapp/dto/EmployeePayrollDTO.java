package com.example.employeepayrollapp.dto;

import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilepic;
    public List<String> department;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
