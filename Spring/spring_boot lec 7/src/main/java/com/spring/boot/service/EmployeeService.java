package com.spring.boot.service;

import com.spring.boot.Dto.EmployeeDto;
import com.spring.boot.model.Employee;

import java.util.List;

public interface EmployeeService {

     List<EmployeeDto> getEmployees();

     List<EmployeeDto> getEmployeesByIDs(List<Long> ids);

     EmployeeDto getEmployeeByID(Long id);

     EmployeeDto addEmployee(EmployeeDto employeeDto);

     List<EmployeeDto>  addEmployees(List<EmployeeDto> employeeDtos);

     EmployeeDto modifyEmployee(EmployeeDto employeeDto);

     List<EmployeeDto> modifyEmployees(List<EmployeeDto> employeeDtos);

     void deleteAllEmployees();

     List<EmployeeDto> deleteEmployeesByIDs(List<Long> ids);

     void deleteEmployee(Long id);

     EmployeeDto getEmployeeByName(String name);

     List<EmployeeDto> searchByNameFunction(String name);

     List<EmployeeDto> searchByNameJPQL(String name);

     List<EmployeeDto> searchByNameNative(String name);


}