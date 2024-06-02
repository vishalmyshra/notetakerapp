package com.noteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noteapp.model.NoteModel;

@Repository
public interface NotesRepository extends JpaRepository<NoteModel , String> {

}
