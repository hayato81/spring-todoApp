package com.example.demo.thymeleaf.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TaskService;
import com.example.demo.thymeleaf.web.tasks.TaskListDTO;

import lombok.RequiredArgsConstructor;
import sample.common.dao.entity.Task;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;

	@GetMapping
	public String list(Model model) {
		List<Task> taskEntity = taskService.find();
		var taskList = taskEntity
					   .stream()
					   .map((entity) -> TaskListDTO.from(entity))
					   .toList();
		model.addAttribute("taskList",taskList);
		return "tasks/list";
	}
	
	

}
