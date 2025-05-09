package com.example.backend.controllers;

import com.example.backend.configurations.JwtUtil;
import com.example.backend.dto.*;
import com.example.backend.model.Relation;
import com.example.backend.repositories.RelationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.backend.configurations.JwtUtil.extractUserId;

@RestController
@RequestMapping("/api/relation")
public class RelationController {

    private final RelationRepository relationRepository;
    private final JwtUtil jwtUtil;

    public RelationController(RelationRepository relationRepository, JwtUtil jwtUtil) {
        this.relationRepository = relationRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateRelationResponse> Create(@RequestBody CreateRelation request, @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7);

        String userId = extractUserId(token);


        var relation = Relation.DtoToEntity(request);
        relation.setUserId(userId);
        relationRepository.save(relation);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new CreateRelationResponse("Relation Created"));
    }

    @PostMapping("/delete")
    public ResponseEntity<DeleteRelationResponse> login(@RequestBody DeleteRelation request) {

        relationRepository.deleteRelationById(request.getRelationId());

        return ResponseEntity.status(HttpStatus.OK).body(new DeleteRelationResponse());
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UpdateRelationResponse> login(@RequestBody CreateRelation request, @PathVariable String id, @RequestHeader("Authorization") String authHeader) {

        if (!relationRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String token = authHeader.substring(7);

        String userId = extractUserId(token);


        var relation = Relation.DtoToEntity(request);
        relation.setUserId(userId);
        relation.setId(id);
        relationRepository.save(relation);

        return ResponseEntity.status(HttpStatus.OK).body(new UpdateRelationResponse());
    }

    @GetMapping("/get")
    public ResponseEntity<GetRelationsResponse> Get(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);

        String userId = extractUserId(token);
        var relations = relationRepository.getAllByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(new GetRelationsResponse(relations));
    }


}