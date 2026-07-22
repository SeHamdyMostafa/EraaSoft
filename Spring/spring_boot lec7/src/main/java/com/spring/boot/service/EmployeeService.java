package com.spring.boot.service;

import com.spring.boot.model.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> getEmployees();

     List<Employee> getEmployeesByIDs(List<Long> ids);

     Employee getEmployeeByID(Long id);

     Employee addEmployee(Employee employee);

     List<Employee>  addEmployees(List<Employee> employees);

     Employee modifyEmployee(Employee employee);

     List<Employee> modifyEmployees(List<Employee> employees);

     void deleteAllEmployees();

     List<Employee> deleteEmployeesByIDs(List<Long> ids);

     void deleteEmployee(Long id);

     Employee getEmployeeByName(String name);

     List<Employee> searchByNameFunction(String name);

     List<Employee> searchByNameJPQL(String name);

     List<Employee> searchByNameNative(String name);


}