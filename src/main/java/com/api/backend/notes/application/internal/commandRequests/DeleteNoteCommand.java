package com.api.backend.notes.application.internal.commandRequests;


import com.api.backend.notes.domain.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteNoteCommand {

    private final NoteRepository repository;

    public DeleteNoteCommand(NoteRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
