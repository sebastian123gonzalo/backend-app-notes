package com.api.backend.notes.domain.commandRequests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteRequest {
    // Getters and setters
    private String title;
    private String content;
    private boolean archived;

}