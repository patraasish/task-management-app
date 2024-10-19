package com.taskmanager.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.entities.TaskEntity;

@Service
public class TaskService {

	private List<TaskEntity> tasks = new ArrayList<TaskEntity>();
	private static int taskId = 1;
	//  Eg: dateString = "2024-10-19";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = null ;
	
	public TaskEntity addTask(String title, String description, String deadline) {

		date= LocalDate.parse(deadline, formatter);
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setId(taskId);
		taskEntity.setTitle(title);
		taskEntity.setDescription(description);
		taskEntity.setDeadline(date);
		taskEntity.setCompleted(false);
		tasks.add(taskEntity);
		taskId++;
		return taskEntity;
	}

	public List<TaskEntity> getAllTasks() {
		return tasks;
	}

	public TaskEntity getTaskById(int id) {

		for (TaskEntity task : tasks) {

			if (task.getId() == id) {
				return task;
			}

		}
		return null;
	}

	public String deleteTask(int id) {
		
		for(TaskEntity task:tasks) {
			if(task.getId()==id) {
				tasks.remove(task);
				return "Task Successfully Deleted..";
			}
			
		}
		
		return "Task Not Found";
	}
	
	
}
