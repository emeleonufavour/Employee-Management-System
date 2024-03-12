package net.favour.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import lombok.AllArgsConstructor;
import net.favour.ems.dto.EmployeeDto;
import net.favour.ems.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // Add Employee
    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savEmployeeDto, HttpStatus.CREATED);
    }

    // Get employee by Id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    // Get all employees
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtos);
    }

    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") Long id,
            @RequestBody EmployeeDto uemployeeDto) {
        EmployeeDto employeeDto = employeeService.updateEmployee(id, uemployeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee")
    public String helloEmployee() {
        return "Hello Employee";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }
}
