package com.taskmanager.dto;

import java.time.LocalDate;
import java.util.List;

import com.taskmanager.entities.NoteEntity;

public class TaskResponseDTO {
	
	private int id;
	private String title;
	private String description;
	private LocalDate deadline;
	private boolean completed;
	private List<NoteEntity> notes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate date) {
		this.deadline = date;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	public List<NoteEntity> getNotes() {
		return notes;
	}
	
	public void setNotes(List<NoteEntity> notes) {
		this.notes = notes;
	}
}
