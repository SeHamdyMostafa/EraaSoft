package com.spring.boot.controller;

import com.spring.boot.model.Employee;
import com.spring.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // http://localhost:8080/employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // http://localhost:8080/employees/ids?ids=1,2,3
    @GetMapping("/employees/ids")
    public List<Employee> getEmployeesByIDs(@RequestParam List<Long> ids){
        return employeeService.getEmployeesByIDs(ids);
    }

    // http://localhost:8080/employee?id=1
    @GetMapping("/employee")
    public Employee getEmployeeByID(@RequestParam Long id) {
        return employeeService.getEmployeeByID(id);
    }

    // http://localhost:8080/employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // http://localhost:8080/employees
    @PostMapping("/employees")
    public List<Employee> addEmployees(List<Employee> employees){
        return employeeService.addEmployees(employees);
    }

    // http://localhost:8080/employee
    @PutMapping("/employee")
    public Employee modifyEmployee(@RequestBody Employee employee) {
        return employeeService.modifyEmployee(employee);
    }

    // http://localhost:8080/employees
    @PutMapping("/employees")
    public List<Employee> modifyEmployees(List<Employee> employees){
        return employeeService.modifyEmployees(employees);
    }


    // http://localhost:8080/employee?employeeId=1
    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    // http://localhost:8080/employees
    @DeleteMapping("/employees")
    public void deleteAllEmployees(){
         employeeService.deleteAllEmployees();
    }

    // http://localhost:8080/employees/ids?ids=1,2,3
    @DeleteMapping("/employee/ids")
    public  List<Employee> deleteEmployeesByIDs(List<Long> ids){
        return employeeService.deleteEmployeesByIDs(ids);
    }

    // http://localhost:8080/employee/Ahmed
    @GetMapping("/employee/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    //  http://localhost:8080/employees/search/function?name=Ahmed
    @GetMapping("/employees/search/function")
    public List<Employee> searchByFunction(@RequestParam String name) {
        return employeeService.searchByNameFunction(name);
    }

    //  http://localhost:8080/employees/search/jpql?name=Ahmed
    @GetMapping("/employees/search/jpql")
    public List<Employee> searchByJPQL(@RequestParam String name) {
        return employeeService.searchByNameJPQL(name);
    }

    //  http://localhost:8080/employees/search/native?name=Ahmed
    @GetMapping("/employees/search/native")
    public List<Employee> searchByNative(@RequestParam String name) {
        return employeeService.searchByNameNative(name);
    }
}