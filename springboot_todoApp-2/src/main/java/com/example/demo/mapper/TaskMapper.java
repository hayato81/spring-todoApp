package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import sample.common.dao.entity.Task;


@Mapper
public interface TaskMapper {

	@Select("""
			  SELECT
			    id, username, title, content, name,
			    start_date AS startDate,
			    end_date   AS endDate,
			    created_at AS createdAt,
			    updated_at AS updatedAt
			  FROM tasks
			""")
	public List<Task> findAll();

}
