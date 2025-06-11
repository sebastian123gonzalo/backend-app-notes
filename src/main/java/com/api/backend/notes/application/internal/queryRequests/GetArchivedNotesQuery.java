package com.api.backend.notes.application.internal.queryRequests;

import com.api.backend.notes.domain.model.dtos.NoteResponse;
import com.api.backend.notes.domain.repository.NoteRepository;
import com.api.backend.notes.infrastructure.persistence.jpa.mappers.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetArchivedNotesQuery {

    private final NoteRepository repository;

    public GetArchivedNotesQuery(NoteRepository repository) {
        this.repository = repository;
    }

    public List<NoteResponse> execute() {
        return repository.findAllByArchived(true).stream()
                .map(NoteMapper::toResponse)
                .toList();
    }
}
