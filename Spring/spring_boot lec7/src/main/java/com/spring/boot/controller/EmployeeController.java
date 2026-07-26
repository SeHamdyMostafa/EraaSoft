package com.spring.boot.controller;

import com.spring.boot.Dto.EmployeeDto;
import com.spring.boot.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // http://localhost:8080/employees
    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    // http://localhost:8080/employees/ids?ids=1,2,3
    @GetMapping("/employees/ids")
    public List<EmployeeDto> getEmployeesByIDs(@RequestParam List<Long> ids) {
        return employeeService.getEmployeesByIDs(ids);
    }

    // http://localhost:8080/employee?id=1
    @GetMapping("/employee")
    public EmployeeDto getEmployeeByID(@RequestParam Long id) {
        return employeeService.getEmployeeByID(id);
    }

    // http://localhost:8080/employee
    @PostMapping("/employee")
    public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    // http://localhost:8080/employees
    @PostMapping("/employees")
    public List<EmployeeDto> addEmployees(@RequestBody List<@Valid EmployeeDto> employeeDtos) {
        return employeeService.addEmployees(employeeDtos);
    }

    // http://localhost:8080/employee
    @PutMapping("/employee")
    public EmployeeDto modifyEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.modifyEmployee(employeeDto);
    }

    // http://localhost:8080/employees
    @PutMapping("/employees")
    public List<EmployeeDto> modifyEmployees(@RequestBody List<@Valid EmployeeDto> employeeDtos) {
        return employeeService.modifyEmployees(employeeDtos);
    }

    // http://localhost:8080/employee?employeeId=1
    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    // http://localhost:8080/employees
    @DeleteMapping("/employees")
    public void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
    }

    // http://localhost:8080/employee/ids?ids=1,2,3
    @DeleteMapping("/employee/ids")
    public List<EmployeeDto> deleteEmployeesByIDs(@RequestParam List<Long> ids) {
        return employeeService.deleteEmployeesByIDs(ids);
    }

    // http://localhost:8080/employee/Ahmed
    @GetMapping("/employee/{name}")
    public EmployeeDto getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    // http://localhost:8080/employees/search/function?name=Ahmed
    @GetMapping("/employees/search/function")
    public List<EmployeeDto> searchByFunction(@RequestParam String name) {
        return employeeService.searchByNameFunction(name);
    }

    // http://localhost:8080/employees/search/jpql?name=Ahmed
    @GetMapping("/employees/search/jpql")
    public List<EmployeeDto> searchByJPQL(@RequestParam String name) {
        return employeeService.searchByNameJPQL(name);
    }

    // http://localhost:8080/employees/search/native?name=Ahmed
    @GetMapping("/employees/search/native")
    public List<EmployeeDto> searchByNative(@RequestParam String name) {
        return employeeService.searchByNameNative(name);
    }
}