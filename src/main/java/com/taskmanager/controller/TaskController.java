package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.dto.CreateTaskDTO;
import com.taskmanager.dto.UpdateTaskDTO;
import com.taskmanager.entities.TaskEntity;
import com.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping
	public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO createTaskDTO){
		return new ResponseEntity<TaskEntity>(taskService.addTask
	(createTaskDTO.getTitle(), createTaskDTO.getDescription(), createTaskDTO.getDeadline()),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<TaskEntity>> getAllTasks(){
		return new ResponseEntity<List<TaskEntity>>(taskService.getAllTasks(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") int id){
		var task=taskService.getTaskById(id);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<TaskEntity>(task,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTaskById(@PathVariable("id") int id){
		return new ResponseEntity<String>(taskService.deleteTask(id),HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> updateTask(@PathVariable("id") int id, UpdateTaskDTO updateTaskDTO){
		
		String result=taskService.updateTask(id, updateTaskDTO.getTitle(), updateTaskDTO.getDescription(), updateTaskDTO.getDeadline(), false);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
