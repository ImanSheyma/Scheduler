package com.byport.scheduler.controller;

import lombok.RequiredArgsConstructor;
import java.sql.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.byport.scheduler.service.EmployeeServiceImpl;
import com.byport.scheduler.service.TaskService;
import com.byport.scheduler.entity.Employee;
import com.byport.scheduler.entity.Task;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final EmployeeServiceImpl employeeService;
    private final TaskService taskService;

    @CrossOrigin
    @GetMapping ("/api/employee")
    public ResponseEntity<List<Employee>> getAllEmployeeNames(){
        List<Employee> emps = employeeService.findAll();
        return new ResponseEntity<>(emps, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping ("/api/task")
    public ResponseEntity<List<Task>> getTasksByDateRange(
        @RequestParam(name="employeeId", required = false, defaultValue = "-1") Integer employeeId,
        @RequestParam(name="start", required = false, defaultValue = "1753-01-01") Date start,
        @RequestParam(name="end", required = false, defaultValue = "9999-12-31") Date end){
        List<Task> tasks = taskService.findTasksByDateRange(employeeId, start, end);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
