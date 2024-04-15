package com.byport.scheduler.DAO;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.byport.scheduler.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
    @Query("SELECT t FROM Task t WHERE t.employee.id = :employeeId")
    List<Task> findAllByEmployee(Integer employeeId);

    @Query("SELECT t FROM Task t WHERE t.employee.id = :employeeId AND (t.start >= :start AND t.start <= :end OR t.end >= :start AND t.end <= :end)")
    List<Task> findTasksByDateRange(Integer employeeId, Date start, Date end);

    @Query("SELECT t FROM Task t WHERE (t.start >= :start AND t.start <= :end OR t.end >= :start AND t.end <= :end)")
    List<Task> findAllTasksByDateRange(Date start, Date end);
}
