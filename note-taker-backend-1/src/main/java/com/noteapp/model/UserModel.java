package com.noteapp.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {

	@Id
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "user")
	private Set<NoteModel> notes;

	// Constructors, getters, setters, toString...

	public UserModel() {
	}

	public UserModel(Long userId, String username, String email) {
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<NoteModel> getNotes() {
		return notes;
	}

	public void setNotes(Set<NoteModel> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", username=" + username + ", email=" + email + "]";
	}

}
