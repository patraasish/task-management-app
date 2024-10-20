package com.taskmanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.entities.NoteEntity;
import com.taskmanager.entities.TaskEntity;

@Service
public class NoteService {

	@Autowired
	private TaskService taskService;

	private HashMap<Integer, TaskNotesHolder> taskNoteHolders = new HashMap<>();

	class TaskNotesHolder {

		protected int noteId=1;
		protected List<NoteEntity> notes = new ArrayList<NoteEntity>();
	}

	public List<NoteEntity> getNotesForTask(int taskId) {

		TaskEntity task = taskService.getTaskById(taskId);
		if (task == null) {
			return null;
		}

		if (taskNoteHolders.get(taskId) == null) {
			taskNoteHolders.put(taskId, new TaskNotesHolder());
		}

		return taskNoteHolders.get(taskId).notes;

	}

	public NoteEntity addNoteForTask(int taskId, String title, String body) {
		TaskEntity task = taskService.getTaskById(taskId);

		if (task == null) {
			return null;
		}
		if (taskNoteHolders.get(taskId) == null) {
			taskNoteHolders.put(taskId, new TaskNotesHolder());
		}

		TaskNotesHolder taskNotesHolder = taskNoteHolders.get(taskId);
		NoteEntity note = new NoteEntity();
		
		note.setId(taskNotesHolder.noteId);
		note.setTitle(title);
		note.setBody(body);
		taskNotesHolder.notes.add(note);
		taskNotesHolder.noteId++;
		return note;

	}

}
