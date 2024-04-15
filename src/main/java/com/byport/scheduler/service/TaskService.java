package com.byport.scheduler.service;

import java.sql.Date;
import java.util.List;
import com.byport.scheduler.entity.Task;

public interface TaskService {
    public List<Task> findAllByEmployee(Integer employeeId);
    public List<Task> findTasksByDateRange(Integer employeeId, Date start, Date end);
}
