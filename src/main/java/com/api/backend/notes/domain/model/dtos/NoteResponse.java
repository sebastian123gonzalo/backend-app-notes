package com.api.backend.notes.domain.model.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoteResponse {
    private Long id;
    private String title;
    private String content;
    private boolean archived;
}
