package com.example.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "StartDate Should Not be Empty")
    @PastOrPresent(message = "startDate should be past or todays date")
    public LocalDate startDate;
    @NotBlank(message = "Note cannot be Empty")
    public String note;
    @NotBlank(message = "profilepic cannot be Empty")
    public String profilepic;
    @NotBlank(message = "Department should not be Empty")
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
