package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	@Insert("""
		    INSERT INTO tasks (
		      username, title, content, name, start_date, end_date
		    ) VALUES (
		      #{username}, #{title}, #{content}, #{name}, #{startDate}, #{endDate}
		    )
		    """)
//		  @Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Task task);

	@Delete("""
			DELETE
			FROM tasks
			WHERE id = #{id} AND username = #{username}
			""")
	int delete(@Param("id") long id,@Param("username") String username);

	@Update("""
			  UPDATE tasks SET
			    title = #{task.title},
			    content = #{task.content},
			    name = #{task.name},
			    start_date = #{task.startDate},
			    end_date = #{task.endDate},
			    updated_at = CURRENT_TIMESTAMP
			  WHERE id = #{task.id} 
			  """)
	//usernameをwhere句に追加予定
	int update(@Param("task") Task entity);  
}
