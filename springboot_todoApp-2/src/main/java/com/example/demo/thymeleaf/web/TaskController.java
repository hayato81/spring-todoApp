package com.example.demo.thymeleaf.web;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@DeleteMapping("/delete/{id}")//後でPostMappinngに変更
	public String delete(@PathVariable("id") long id,Principal principal) {
	    String username = (principal != null) ? principal.getName() : "guest";
		taskService.delete(id,username);
		return "redirect:tasks/list";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") long id, 
						Principal principal,
						@Validated TaskForm form) {
		 String username = (principal != null) ? principal.getName() : "guest";
		var entity = form.toEntity(id,username);
		 taskService.update(entity);
		return "redirect:tasks/list";
	}

}
