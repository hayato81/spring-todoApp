package sample.common.dao.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TaskForm {
		
	 	private String title;            
	    private String content;           
	    private String name;              
	    private LocalDate startDate;
	    private LocalDate endDate;
	    
	    public Task toEntity(String username) {
	        Task task = new Task();
	        task.setUsername(username);
	        task.setTitle(this.title);
	        task.setContent(this.content);
	        task.setName(this.name);
	        task.setStartDate(this.startDate);
	        task.setEndDate(this.endDate);
	        return task;
	    }
	    
}
