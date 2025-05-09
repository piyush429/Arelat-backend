package com.example.backend.controllers;

import com.example.backend.dto.*;
import com.example.backend.model.RelationNote;
import com.example.backend.repositories.RelationNotesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/relation/{relationId}/note")
public class RelationNotesController {

    private final RelationNotesRepository relationNotesRepository;

    public RelationNotesController(RelationNotesRepository relationNotesRepository) {
        this.relationNotesRepository = relationNotesRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateRelationResponse> Create(@RequestBody CreateRelationNote request, @PathVariable String relationId) {

        var relation = RelationNote.DtoToEntity(request);
        relation.setRelationId(relationId);
        relationNotesRepository.save(relation);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new CreateRelationResponse("Relation Created"));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<DeleteRelationResponse> login(@RequestBody DeleteRelationNote request, @PathVariable String id) {

        relationNotesRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new DeleteRelationResponse());
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UpdateRelationResponse> login(@RequestBody CreateRelationNote request, @PathVariable String id) {

        if (!relationNotesRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        var relationNote = RelationNote.DtoToEntity(request);
        relationNote.setId(id);
        relationNotesRepository.save(relationNote);

        return ResponseEntity.status(HttpStatus.OK).body(new UpdateRelationResponse());
    }

    @GetMapping("/get")
    public ResponseEntity<GetRelationNotesResponse> Get(@PathVariable String relationId) {

        var relations = relationNotesRepository.getAllByRelationId(relationId);

        return ResponseEntity.status(HttpStatus.OK).body(new GetRelationNotesResponse(relations));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GetRelationNoteResponse> Get(@PathVariable String relationId, @PathVariable String id) {
        var relationNote = relationNotesRepository.findById(id);

        if (relationNote.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(new GetRelationNoteResponse(relationNote.get()));
    }


}