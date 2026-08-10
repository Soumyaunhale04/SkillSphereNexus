package com.skillsphere.skillservice.repository;

import com.skillsphere.skillservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
