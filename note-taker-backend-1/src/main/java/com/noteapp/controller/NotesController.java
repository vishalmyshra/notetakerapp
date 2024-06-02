package com.noteapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noteapp.dao.NotesService;
import com.noteapp.dao.UserService;
import com.noteapp.model.NoteModel;
import com.noteapp.model.UserModel;

@RestController
@RequestMapping("/notesbackend")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@Autowired
	private UserService userService;

	@PostMapping("/note")
	public ResponseEntity<?> saveNote(@RequestBody NoteModel noteModel) {
		UserModel userModel = noteModel.getUser();
		System.out.println(userModel.toString());
		// UserModel userSaved = userService.saveUser(userModel);
		if (userModel.getUserId() == null) {
			Map<String, Object> responseBody = new HashMap<>();
			responseBody.put("message", "Couldn't save, Please select author.");
			return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
		}
		UserModel userFromDb = userService.findById(userModel.getUserId());
		HttpStatus status;
		if (userFromDb == null) {
			userService.saveUser(userModel);
			status = HttpStatus.CREATED;
		} else {
			status = HttpStatus.OK;
		}
		userFromDb = userService.findById(userModel.getUserId());
		NoteModel noteSaved = notesService.saveNotes(noteModel);
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("note", noteSaved);
		responseBody.put("user", userFromDb);

		return new ResponseEntity<>(responseBody, status);
	}

}
