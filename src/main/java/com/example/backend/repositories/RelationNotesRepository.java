package com.example.backend.repositories;

import com.example.backend.model.Relation;
import com.example.backend.model.RelationNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RelationNotesRepository extends MongoRepository<RelationNote, String> {

    @Query("{ 'relationId' : ?0 }")
    List<RelationNote> getAllByRelationId(String userId);
}
