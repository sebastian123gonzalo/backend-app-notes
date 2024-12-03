package com.api.backend.notes;

import com.api.backend.notes.domain.commandRequests.NoteRequest;
import com.api.backend.notes.domain.model.Note;
import com.api.backend.notes.domain.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    private final NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody NoteRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        return ResponseEntity.ok(noteService.createNote(note));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody NoteRequest noteRequest) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(noteRequest.getTitle());
        note.setContent(noteRequest.getContent());
        note.setArchived(noteRequest.isArchived());
        return ResponseEntity.ok(noteService.updateNote(note));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<Note>> getActiveNotes() {
        return ResponseEntity.ok(noteService.getActiveNotes());
    }

    @GetMapping("/archived")
    public ResponseEntity<List<Note>> getArchivedNotes() {
        return ResponseEntity.ok(noteService.getArchivedNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
