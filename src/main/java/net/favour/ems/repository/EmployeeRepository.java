package net.favour.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.favour.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
