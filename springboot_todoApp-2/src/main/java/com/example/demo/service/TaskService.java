package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.TaskMapper;

import lombok.RequiredArgsConstructor;
import sample.common.dao.entity.Task;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	private final TaskMapper taskMapper;

	public List<Task> find() {
		return taskMapper.findAll();
	}

}
