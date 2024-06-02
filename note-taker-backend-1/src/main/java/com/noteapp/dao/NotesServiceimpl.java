package com.noteapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noteapp.model.NoteModel;
import com.noteapp.repository.NotesRepository;

@Service
public class NotesServiceimpl implements NotesService {

	@Autowired
	private NotesRepository notesRepository;

	@Override
	public NoteModel saveNotes(NoteModel noteModel) {
		NoteModel noteSavedModel = notesRepository.save(noteModel);
		return noteSavedModel;
	}

}
