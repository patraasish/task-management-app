package com.taskmanager.dto;

import com.taskmanager.entities.NoteEntity;

public class CreateNoteResponseDTO {

	private int taskId;
	private NoteEntity note;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public NoteEntity getNote() {
		return note;
	}
	public void setNote(NoteEntity note) {
		this.note = note;
	}
	public CreateNoteResponseDTO(int taskId, NoteEntity note) {
		super();
		this.taskId = taskId;
		this.note = note;
	}
	
	
}
