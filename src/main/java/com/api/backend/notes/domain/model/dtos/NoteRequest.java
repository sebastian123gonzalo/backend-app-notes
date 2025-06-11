package com.api.backend.notes.domain.model.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Struct;

public class NoteRequest {
    private String title;
    private String content;
    private boolean archived;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isArchived() {
        return archived;
    }
    public void setArchived(boolean archived) {
        this.archived = archived;
    }

}