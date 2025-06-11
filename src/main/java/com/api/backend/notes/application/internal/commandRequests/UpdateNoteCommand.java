package com.api.backend.notes.application.internal.commandRequests;



import com.api.backend.notes.domain.model.aggregates.Note;
import com.api.backend.notes.domain.model.dtos.NoteRequest;
import com.api.backend.notes.domain.model.dtos.NoteResponse;
import com.api.backend.notes.domain.repository.NoteRepository;
import com.api.backend.notes.infrastructure.persistence.jpa.mappers.NoteMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateNoteCommand {

    private final NoteRepository repository;

    public UpdateNoteCommand(NoteRepository repository) {
        this.repository = repository;
    }

    public NoteResponse execute(Long id, NoteRequest request) {
        Note existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        existing.setTitle(request.getTitle());
        existing.setContent(request.getContent());
        existing.setArchived(request.isArchived());
        return NoteMapper.toResponse(repository.save(existing));
    }
}
