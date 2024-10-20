package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.dto.CreateNoteDTO;
import com.taskmanager.dto.CreateNoteResponseDTO;
import com.taskmanager.entities.NoteEntity;
import com.taskmanager.service.NoteService;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {

	@Autowired
	private NoteService noteService;
	
	
	
	@GetMapping
	public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") int taskId) {
		
		var notes=noteService.getNotesForTask(taskId);
		return ResponseEntity.ok(notes);
	}
	
	@PostMapping
	public ResponseEntity<CreateNoteResponseDTO> addNote
	(@PathVariable("taskId") int taskId,@RequestBody CreateNoteDTO createNoteDTO)
	{
		var note=noteService.addNoteForTask(taskId, createNoteDTO.getTitle(),createNoteDTO.getBody());
		return ResponseEntity.ok(new CreateNoteResponseDTO(taskId,note));
	}
}
