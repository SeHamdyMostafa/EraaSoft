package com.spring.boot.mapper;

import com.spring.boot.Dto.EmployeeDto;
import com.spring.boot.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);

    List<EmployeeDto> toDtoList(List<Employee> employees);

    List<Employee> toEntityList(List<EmployeeDto> employeeDtos);

}