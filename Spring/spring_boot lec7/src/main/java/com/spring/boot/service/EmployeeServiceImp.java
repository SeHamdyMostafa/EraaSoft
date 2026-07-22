package com.spring.boot.service;

import com.spring.boot.model.Employee;
import com.spring.boot.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeesByIDs(List<Long> ids) {
        return employeeRepo.findAllById(ids);
    }

    @Override
    public Employee getEmployeeByID(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getId() != null) {
            throw new RuntimeException("New Employee should not have ID");
        }
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> addEmployees(List<Employee> employees) {
        if (employees.stream().anyMatch(employee -> employee.getId() != null)) {
            throw new RuntimeException("New Employee should not have ID");
        }
        return employeeRepo.saveAll(employees);
    }


    @Override
    public Employee modifyEmployee(Employee employee) {

        if (employee.getId() == null) {
            throw new RuntimeException("Employee ID is required");
        }

        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> modifyEmployees(List<Employee> employees) {
        if (employees.stream().anyMatch(employee -> employee.getId() == null)){
            throw new RuntimeException("Employee ID is required");
        }

        return employeeRepo.saveAll(employees);
    }

    @Override
    public void deleteAllEmployees() {
         employeeRepo.deleteAll();
    }

    @Override
    public List<Employee> deleteEmployeesByIDs(List<Long> ids) {
        List<Employee> employees = employeeRepo.findAllById(ids);
        if (employees.size() != ids.size()) {
            throw new RuntimeException("One or more Employees Not Found");
        }

        employeeRepo.deleteAllById(ids);

        return employees;
    }

    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepo.existsById(id)) {
            throw new RuntimeException("Employee Not Found");
        }

        employeeRepo.deleteById(id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }

    @Override
    public List<Employee> searchByNameFunction(String name) {
        return employeeRepo.findByNameStartingWith(name);
    }

    @Override
    public List<Employee> searchByNameJPQL(String name) {
        return employeeRepo.searchByNameJPQL(name);
    }

    @Override
    public List<Employee> searchByNameNative(String name) {
        return employeeRepo.searchByNameNative(name);
    }
}