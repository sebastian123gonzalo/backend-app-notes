package com.api.backend.notes.domain.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {
    private String title;
    private String content;
    private boolean archived;
}
