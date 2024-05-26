package com.nada.ems.service.impl;

import com.nada.ems.dto.EmployeeDto;
import com.nada.ems.entity.Employee;
import com.nada.ems.exception.ResourceNotFoundException;
import com.nada.ems.mapper.EmployeeMapper;
import com.nada.ems.repository.EmployeeRepository;
import com.nada.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
// cette annotation pour indique au conteneur Spring de cree le spring bean
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // pour mapper le employeeDto en entité
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
        //nous avons d'implimenté la methode de creation d'employé
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with given id:" + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
        //nous avons d'implimente la methode  get employee by id

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {

       Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                () ->   new ResourceNotFoundException("Employee is not existe with given id:" + employeeId)

        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Employee updateEmployeeObj= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                () ->   new ResourceNotFoundException("Employee is not existe with given id:" + employeeId)

        );
        employeeRepository.deleteById(employeeId);
    }


}
