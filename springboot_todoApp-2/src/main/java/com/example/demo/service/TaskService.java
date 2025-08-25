package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void create(Task task) {
		taskMapper.insert(task);
	}
	@Transactional
	public boolean delete(long id,String username) {
		return taskMapper.delete(id,username) == 1;
	}
	@Transactional
	public boolean update(Task entity) {
		return taskMapper.update(entity) == 1;
	}
	public Optional<Task> findById(long id) {
		return taskMapper.selectById(id);
	}

}
