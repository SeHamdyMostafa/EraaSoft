package com.spring.boot.service;

import com.spring.boot.Dto.EmployeeDto;
import com.spring.boot.mapper.EmployeeMapper;
import com.spring.boot.model.Employee;
import com.spring.boot.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImp(EmployeeRepo employeeRepo,
                              EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        return employeeMapper.toDtoList(employeeRepo.findAll());

    }

    @Override
    public List<EmployeeDto> getEmployeesByIDs(List<Long> ids) {
        return employeeMapper.toDtoList(employeeRepo.findAllById(ids));
    }

    @Override
    public EmployeeDto getEmployeeByID(Long id) {

        return employeeMapper.toDto(employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found")));
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEntity(employeeDto);
        if (employee.getId() != null) {
            throw new RuntimeException("New Employee should not have ID");
        }

        return employeeMapper.toDto(employeeRepo.save(employee));
    }

    @Override
    public List<EmployeeDto> addEmployees(List<EmployeeDto> employeeDtos) {

        List<Employee> employees = employeeMapper.toEntityList(employeeDtos);

        if (employees.stream().anyMatch(employee -> employee.getId() != null)) {
            throw new RuntimeException("New Employee should not have ID");
        }

        return employeeMapper.toDtoList(employeeRepo.saveAll(employees));
    }

    @Override
    public EmployeeDto modifyEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEntity(employeeDto);
        if (employee.getId() == null) {
            throw new RuntimeException("Employee ID is required");
        }
        return employeeMapper.toDto(employeeRepo.save(employee));
    }

    @Override
    public List<EmployeeDto> modifyEmployees(List<EmployeeDto> employeeDtos) {

        List<Employee> employees = employeeMapper.toEntityList(employeeDtos);

        if (employees.stream().anyMatch(employee -> employee.getId() == null)) {
            throw new RuntimeException("Employee ID is required");
        }

        return employeeMapper.toDtoList(employeeRepo.saveAll(employees));
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

        return employeeMapper.toDtoList(employees);
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

        return employeeMapper.toDto(employeeRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Employee Not Found")));
    }

    @Override
    public List<EmployeeDto> searchByNameFunction(String name) {
        return employeeMapper.toDtoList(employeeRepo.findByNameStartingWith(name));
    }

    @Override
    public List<EmployeeDto> searchByNameJPQL(String name) {
        return employeeMapper.toDtoList(employeeRepo.searchByNameJPQL(name));
    }

    @Override
    public List<EmployeeDto> searchByNameNative(String name) {
        return employeeMapper.toDtoList(employeeRepo.searchByNameNative(name));
    }


}