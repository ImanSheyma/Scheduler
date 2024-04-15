package com.byport.scheduler.service;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.byport.scheduler.DAO.TaskRepository;
import com.byport.scheduler.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAllByEmployee(Integer employeeId) {
        return taskRepository.findAllByEmployee(employeeId);
    }

    @Override
    public List<Task> findTasksByDateRange(Integer employeeId, Date start, Date end) {
        if(employeeId == -1)
            return taskRepository.findAllTasksByDateRange(start, end);
        return taskRepository.findTasksByDateRange(employeeId, start, end);
    }

}
