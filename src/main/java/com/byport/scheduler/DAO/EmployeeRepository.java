package com.byport.scheduler.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.byport.scheduler.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
    @Override
    List<Employee> findAll();
}


