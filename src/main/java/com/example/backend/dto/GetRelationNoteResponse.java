package com.example.backend.dto;

import com.example.backend.model.RelationNote;

import java.util.Optional;

public class GetRelationNoteResponse {
    private RelationNote relationNote;

    public GetRelationNoteResponse(RelationNote relationNote) {
        this.relationNote = relationNote;
    }

    public RelationNote getRelationNote() {
        return relationNote;
    }
}
