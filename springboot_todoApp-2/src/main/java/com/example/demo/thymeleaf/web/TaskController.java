package com.example.demo.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;

	@GetMapping
	public String list(Model model) {
		var taskList =  taskService.find();
		model.addAttribute("taskList",taskList);
		return "tasks/list";
	}

}
