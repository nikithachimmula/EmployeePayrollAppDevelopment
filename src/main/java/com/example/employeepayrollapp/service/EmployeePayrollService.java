package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeePayrollDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.EmployeePayrollData;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeeRollService {
    private EmployeePayrollRepository employeeRepository;

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();


    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }


    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(employeePayrollData -> employeePayrollData.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found In the List"));
    }


    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData= null;
        empData = new EmployeePayrollData(employeePayrollDTO);
        log.debug("Emp Data:" +empData.toString());
        employeePayrollList.add(empData);
        return employeeRepository.save(empData);
    }


    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        empData.setGender(employeePayrollDTO.gender);
        empData.setStartDate(employeePayrollDTO.startDate);
        empData.setNote(employeePayrollDTO.note);
        empData.setProfilePic(employeePayrollDTO.profilePic);
        empData.setDepartments(employeePayrollDTO.departments);
        employeePayrollList.set(empId-1,empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
