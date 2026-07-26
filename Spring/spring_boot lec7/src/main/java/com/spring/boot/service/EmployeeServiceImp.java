package com.spring.boot.service;

import com.spring.boot.Dto.EmployeeDto;
import com.spring.boot.model.Employee;
import com.spring.boot.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        return employeeRepo.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public List<EmployeeDto> getEmployeesByIDs(List<Long> ids) {
        return employeeRepo.findAllById(ids)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public EmployeeDto getEmployeeByID(Long id) {

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
        return toDTO(employee);
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        Employee employee = toEntity(employeeDto);
        if (employee.getId() != null) {
            throw new RuntimeException("New Employee should not have ID");
        }

        return toDTO(employeeRepo.save(employee));
    }

    @Override
    public List<EmployeeDto> addEmployees(List<EmployeeDto> employeeDtos) {

        List<Employee> employees = employeeDtos.stream()
                .map(this::toEntity)
                .toList();

        if (employees.stream().anyMatch(employee -> employee.getId() != null)) {
            throw new RuntimeException("New Employee should not have ID");
        }

        return employeeRepo.saveAll(employees)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public EmployeeDto modifyEmployee(EmployeeDto employeeDto) {

        Employee employee = toEntity(employeeDto);
        if (employee.getId() == null) {
            throw new RuntimeException("Employee ID is required");
        }
        return toDTO(employeeRepo.save(employee));
    }

    @Override
    public List<EmployeeDto> modifyEmployees(List<EmployeeDto> employeeDtos) {

        List<Employee> employees = employeeDtos.stream()
                .map(this::toEntity)
                .toList();

        if (employees.stream().anyMatch(employee -> employee.getId() == null)) {
            throw new RuntimeException("Employee ID is required");
        }

        return employeeRepo.saveAll(employees)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }

    @Override
    public List<EmployeeDto> deleteEmployeesByIDs(List<Long> ids) {

        List<Employee> employees = employeeRepo.findAllById(ids);
        if (employees.size() != ids.size()) {
            throw new RuntimeException("One or more Employees Not Found");
        }

        employeeRepo.deleteAllById(ids);

        return employees.stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepo.existsById(id)) {
            throw new RuntimeException("Employee Not Found");
        }

        employeeRepo.deleteById(id);
    }

    @Override
    public EmployeeDto getEmployeeByName(String name) {

        Employee employee = employeeRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        return toDTO(employee);
    }

    @Override
    public List<EmployeeDto> searchByNameFunction(String name) {
        return employeeRepo.findByNameStartingWith(name)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public List<EmployeeDto> searchByNameJPQL(String name) {
        return employeeRepo.searchByNameJPQL(name)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public List<EmployeeDto> searchByNameNative(String name) {
        return employeeRepo.searchByNameNative(name)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private EmployeeDto toDTO(Employee employee) {

        EmployeeDto dto = new EmployeeDto();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setPhoneNumber(employee.getPhoneNumber());

        return dto;
    }

    private Employee toEntity(EmployeeDto dto) {

        Employee employee = new Employee();

        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setPhoneNumber(dto.getPhoneNumber());

        return employee;
    }
}