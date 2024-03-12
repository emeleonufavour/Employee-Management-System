package net.favour.ems.mapper;

import net.favour.ems.dto.EmployeeDto;
import net.favour.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getFirstname(), employeeDto.getLastname(),
                employeeDto.getEmail());
    }
}
