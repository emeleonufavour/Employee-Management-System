package net.favour.ems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.favour.ems.dto.EmployeeDto;
import net.favour.ems.entity.Employee;
import net.favour.ems.exception.ResourceNotFoundException;
import net.favour.ems.mapper.EmployeeMapper;
import net.favour.ems.repository.EmployeeRepository;
import net.favour.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id doesnt exist:" + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((Employee employee) -> EmployeeMapper.mapToEmployeeDto(employee)).toList();

    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find Employee with id:" + id));
        employee.setFirstName(employeeDto.getFirstname());
        employee.setLastName(employeeDto.getLastname());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
