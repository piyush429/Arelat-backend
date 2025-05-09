package com.example.backend.dto;

import com.example.backend.model.RelationNote;

import java.util.List;

public class GetRelationNotesResponse {
    private List<RelationNote> relations;

    public GetRelationNotesResponse(List<RelationNote> relations) {
        this.relations = relations;
    }

    public List<RelationNote> getRelations() {
        return relations;
    }
}
