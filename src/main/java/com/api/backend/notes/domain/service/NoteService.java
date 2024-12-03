package com.api.backend.notes.domain.service;

import com.api.backend.notes.domain.model.Note;
import com.api.backend.notes.domain.repository.NoteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> getActiveNotes() {
        return noteRepository.findAllByArchived(false);
    }

    public List<Note> getArchivedNotes() {
        return noteRepository.findAllByArchived(true);
    }
}
