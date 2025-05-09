package com.example.backend.model;

import com.example.backend.dto.CreateRelation;
import com.example.backend.dto.CreateRelationNote;
import org.springframework.data.annotation.Id;

public class RelationNote {

    @Id
    private String id;
    private String relationId;
    private String name;
    private String note;

    static public RelationNote DtoToEntity(CreateRelationNote dto) {
        var relationNote = new RelationNote();
        relationNote.note = dto.note();
        return relationNote;
    }

    public String getId() {
        return id;
    }

    public String getRelationId() {
        return relationId;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
}
