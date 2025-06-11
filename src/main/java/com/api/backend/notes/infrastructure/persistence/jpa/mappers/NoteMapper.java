package com.api.backend.notes.infrastructure.persistence.jpa.mappers;

import com.api.backend.notes.domain.model.aggregates.Note;
import com.api.backend.notes.domain.model.dtos.NoteRequest;
import com.api.backend.notes.domain.model.dtos.NoteResponse;

public class NoteMapper {

    public static Note toEntity(NoteRequest dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        note.setArchived(dto.isArchived());
        return note;
    }

    public static NoteResponse toResponse(Note entity) {
        return NoteResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .archived(entity.isArchived())
                .build();
    }
}
