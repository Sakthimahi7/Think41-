
package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskSummaryDTO;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/next")
    public List<TaskSummaryDTO> getNextProcessTasks() {
        return taskService.getNextProcessTasks();
    }

    @GetMapping("/pending")
    public List<TaskSummaryDTO> getPendingTasks() {
        return taskService.getPendingTasks();
    }

    @GetMapping("/pending/top")
    public List<TaskSummaryDTO> getTopPendingTasks(@RequestParam(defaultValue = "5") int limit) {
        return taskService.getTopPendingTasks(limit);
    }
}
