package com.nada.ems.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// when we use EmployeeDto class to transfer the data between client and server
//when we build rest services we'll use this employee as response
//une class de mappeur d'employé pour mapper l'entitie d'emploiyé a l'emplyeeDto et emplyeeDto a l'entitie d'emploiyé
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
@Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
