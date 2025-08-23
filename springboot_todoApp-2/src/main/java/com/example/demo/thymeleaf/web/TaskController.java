package com.example.demo.thymeleaf.web;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;
import sample.common.dao.entity.Task;
import sample.common.dao.entity.TaskForm;

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
	
	@PostMapping
	public String create(@Validated TaskForm form,Principal principal) {
		String username = (principal != null) ? principal.getName() : "guest";
	    taskService.create(form.toEntity(username));
		return "redirect:tasks/list";
	}

}
