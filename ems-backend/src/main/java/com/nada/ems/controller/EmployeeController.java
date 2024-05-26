package com.nada.ems.controller;


import com.nada.ems.dto.EmployeeDto;
import com.nada.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    public static final String ID = "{id}";
    @Autowired
    private EmployeeService employeeService;

    //build add employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //build Get employee rest api
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);

        return  ResponseEntity.ok(employeeDto);
    }



    // build Get all employees rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){

        List<EmployeeDto> employees =employeeService.getAllEmployees();


        return ResponseEntity.ok(employees);
    }

    // build Get update employees rest api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee( @PathVariable("id") Long employeeId,@RequestBody EmployeeDto updateEmployee ){

     EmployeeDto employeeDto= employeeService.updateEmployee(employeeId,updateEmployee);
     return ResponseEntity.ok(employeeDto);


    }


}
