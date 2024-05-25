package com.nada.ems.service.impl;

import com.nada.ems.dto.EmployeeDto;
import com.nada.ems.entity.Employee;
import com.nada.ems.mapper.EmployeeMapper;
import com.nada.ems.repository.EmployeeRepository;
import com.nada.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    }
    //nous avons d'implimenté la methode de creation d'employé
}
