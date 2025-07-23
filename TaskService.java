
package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskSummaryDTO;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskSummaryDTO> getNextProcessTasks() {
        return taskRepository.findNextProcessTasks();
    }

    public List<TaskSummaryDTO> getPendingTasks() {
        return taskRepository.findPendingTasks(List.of("PENDING", "TO_DO"));
    }

    public List<TaskSummaryDTO> getTopPendingTasks(int limit) {
        return taskRepository.findTopPendingTasks("PENDING", PageRequest.of(0, limit));
    }
}
