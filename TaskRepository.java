
package com.example.taskmanager.repository;

import com.example.taskmanager.dto.TaskSummaryDTO;
import com.example.taskmanager.model.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t.title AS title, t.status AS status, t.dueDate AS dueDate, t.priority AS priority, e.name AS employeeName " +
           "FROM Task t JOIN t.employee e WHERE t.status = 'NEXT'")
    List<TaskSummaryDTO> findNextProcessTasks();

    @Query("SELECT t.title AS title, t.status AS status, t.dueDate AS dueDate, t.priority AS priority, e.name AS employeeName " +
           "FROM Task t JOIN t.employee e WHERE t.status IN :statuses")
    List<TaskSummaryDTO> findPendingTasks(@Param("statuses") List<String> statuses);

    @Query("SELECT t.title AS title, t.status AS status, t.dueDate AS dueDate, t.priority AS priority, e.name AS employeeName " +
           "FROM Task t JOIN t.employee e WHERE t.status = :status ORDER BY t.priority DESC, t.dueDate ASC")
    List<TaskSummaryDTO> findTopPendingTasks(@Param("status") String status, Pageable pageable);
}
