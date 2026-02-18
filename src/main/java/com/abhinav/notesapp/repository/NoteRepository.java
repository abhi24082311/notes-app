package com.abhinav.notesapp.repository;

import com.abhinav.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {}