package com.api.backend.notes.application.internal.commandRequests;


import com.api.backend.notes.domain.model.aggregates.Note;
import com.api.backend.notes.domain.model.dtos.NoteRequest;
import com.api.backend.notes.domain.model.dtos.NoteResponse;
import com.api.backend.notes.domain.repository.NoteRepository;
import com.api.backend.notes.infrastructure.persistence.jpa.mappers.NoteMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateNoteCommand {

    private final NoteRepository repository;

    public CreateNoteCommand(NoteRepository repository) {
        this.repository = repository;
    }

    public NoteResponse execute(NoteRequest request) {
        Note note = NoteMapper.toEntity(request);
        Note saved = repository.save(note);
        return NoteMapper.toResponse(saved);
    }
}
