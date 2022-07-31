package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
    @Query(value = "select * from employee_payroll, employee_departments where employee_id = id and departments = :departments", nativeQuery = true)
    List<EmployeePayrollData> findEmployeeByDepartments(String departments);
}
