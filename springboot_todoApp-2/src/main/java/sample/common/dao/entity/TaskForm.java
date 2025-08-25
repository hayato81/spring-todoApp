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
	    
	    public Task toEntity(long id ,String username) {
	    	Task task = new Task();
	    	task.setId(id);
	    	task.setUsername(username);
	    	task.setTitle(this.title);
	    	task.setContent(this.content);
	    	task.setName(this.name);
	    	task.setStartDate(this.startDate);
	    	task.setEndDate(this.endDate);
	    	return task;
	    }

	    public static TaskForm fromServiceEntity(Task form) {
	        TaskForm f = new TaskForm();
	        f.setTitle(form.getTitle());
	        f.setContent(form.getContent());
	        f.setName(form.getName());
	        f.setStartDate(form.getStartDate());
	        f.setEndDate(form.getEndDate());
	        return f;
	    }
	    
	    
}
