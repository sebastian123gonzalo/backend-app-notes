package com.api.backend.notes.application.internal.queryRequests;

import com.api.backend.notes.domain.model.aggregates.Note;
import com.api.backend.notes.domain.model.dtos.NoteResponse;
import com.api.backend.notes.domain.repository.NoteRepository;
import com.api.backend.notes.infrastructure.persistence.jpa.mappers.NoteMapper;
import org.springframework.stereotype.Service;

@Service
public class GetNoteByIdQuery {

    private final NoteRepository repository;

    public GetNoteByIdQuery(NoteRepository repository) {
        this.repository = repository;
    }

    public NoteResponse execute(Long id) {
        Note note = repository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        return NoteMapper.toResponse(note);
    }
}
