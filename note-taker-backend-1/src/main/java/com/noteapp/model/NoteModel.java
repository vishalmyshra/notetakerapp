package com.noteapp.model;

import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes")
public class NoteModel {
	@Id
	@Column(name = "note-id", nullable = false, updatable = false)
	private String noteId;

	@Column(name = "note-content")
	private String noteContent;

	@Column(name = "note-author-id")
	private String noteAuthorId;

	@CreationTimestamp
	@Column(name = "note-creation-time", nullable = false, updatable = false)
	private Timestamp noteCreationTime;

	@ManyToOne
	@JoinColumn(name = "user_id") 
	private UserModel user;

	@PrePersist
	public void prePersist() {
		if (this.noteId == null) {
			this.noteId = UUID.randomUUID().toString();
		}
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Timestamp getNoteCreationTime() {
		return noteCreationTime;
	}

	public void setNoteCreationTime(Timestamp noteCreationTime) {
		this.noteCreationTime = noteCreationTime;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public NoteModel(String noteId, String noteContent, String noteAuthorId, Timestamp noteCreationTime,
			UserModel user) {
		super();
		this.noteId = noteId;
		this.noteContent = noteContent;
		this.noteAuthorId = noteAuthorId;
		this.noteCreationTime = noteCreationTime;
		this.user = user;
	}
	
	

	@Override
	public String toString() {
		return "NoteModel [noteId=" + noteId + ", noteContent=" + noteContent + ", noteAuthorId=" + noteAuthorId
				+ ", noteCreationTime=" + noteCreationTime + ", user=" + user + "]";
	}

	public NoteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
