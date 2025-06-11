package com.api.backend.notes;

import com.api.backend.notes.application.internal.commandRequests.CreateNoteCommand;
import com.api.backend.notes.application.internal.commandRequests.DeleteNoteCommand;
import com.api.backend.notes.application.internal.commandRequests.UpdateNoteCommand;
import com.api.backend.notes.application.internal.queryRequests.GetActiveNotesQuery;
import com.api.backend.notes.application.internal.queryRequests.GetArchivedNotesQuery;
import com.api.backend.notes.application.internal.queryRequests.GetNoteByIdQuery;
import com.api.backend.notes.domain.model.dtos.NoteRequest;
import com.api.backend.notes.domain.model.dtos.NoteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    private final CreateNoteCommand create;
    private final UpdateNoteCommand update;
    private final DeleteNoteCommand delete;
    private final GetNoteByIdQuery getById;
    private final GetActiveNotesQuery getActive;
    private final GetArchivedNotesQuery getArchived;

    public NotesController(
            CreateNoteCommand create,
            UpdateNoteCommand update,
            DeleteNoteCommand delete,
            GetNoteByIdQuery getById,
            GetActiveNotesQuery getActive,
            GetArchivedNotesQuery getArchived
    ) {
        this.create = create;
        this.update = update;
        this.delete = delete;
        this.getById = getById;
        this.getActive = getActive;
        this.getArchived = getArchived;
    }

    @PostMapping
    public ResponseEntity<NoteResponse> create(@RequestBody NoteRequest request) {
        return ResponseEntity.ok(create.execute(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> update(@PathVariable Long id, @RequestBody NoteRequest request) {
        return ResponseEntity.ok(update.execute(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getById.execute(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        delete.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<NoteResponse>> getActive() {
        return ResponseEntity.ok(getActive.execute());
    }

    @GetMapping("/archived")
    public ResponseEntity<List<NoteResponse>> getArchived() {
        return ResponseEntity.ok(getArchived.execute());
    }
}