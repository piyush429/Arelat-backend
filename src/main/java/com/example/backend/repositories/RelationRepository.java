package com.example.backend.repositories;

import com.example.backend.model.Relation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RelationRepository extends MongoRepository<Relation, String> {
    void deleteRelationById(String id);

    @Query("{ 'userId' : ?0 }")
    List<Relation> getAllByUserId(String userId);

}
