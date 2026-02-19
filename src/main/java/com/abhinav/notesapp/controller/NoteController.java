package com.abhinav.notesapp.controller;

import com.abhinav.notesapp.model.Note;
import com.abhinav.notesapp.repository.NoteRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteData) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTitle(noteData.getTitle());
        note.setContent(noteData.getContent());
        return noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }
}