package com.example.backend.dto;

import com.example.backend.model.Relation;

import java.util.List;

public class GetRelationsResponse {
    List<Relation> relations;

    public GetRelationsResponse(List<Relation> relations) {
        this.relations = relations;
    }

    public Object[] getRelations() {
        return relations.toArray();
    }
}
