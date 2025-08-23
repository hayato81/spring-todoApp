package com.example.demo.thymeleaf.web.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;

import sample.common.dao.entity.Task;

public record TaskListDTO(
		Long id,
	    String title,
	    String content,
	    String name,
	    LocalDate startDate,
	    LocalDate endDate,
	    LocalDateTime createdAt,
	    LocalDateTime updatedAt)
	{
	    public static TaskListDTO from(Task t) {
	        return new TaskListDTO(
	            t.getId(), t.getTitle(), t.getContent(), t.getName(),
	            t.getStartDate(), t.getEndDate(), t.getCreatedAt(), t.getUpdatedAt()
	        );
	    }

}
