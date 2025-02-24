package crm08.service;

import java.util.List;
import crm08.repository.TaskRepository;
import entity.TaskEntity;

public class TaskServices {
	private TaskRepository taskRepository = new TaskRepository();
	
	public List<TaskEntity> getTask(){
		List<TaskEntity> tasks = taskRepository.findAll();
		
		return tasks;
	}
}
