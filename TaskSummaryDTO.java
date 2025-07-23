
package com.example.taskmanager.dto;

import java.time.LocalDate;

public interface TaskSummaryDTO {
    String getTitle();
    String getStatus();
    LocalDate getDueDate();
    int getPriority();
    String getEmployeeName();
}
