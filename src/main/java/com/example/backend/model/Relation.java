package com.example.backend.model;

import com.example.backend.dto.CreateRelation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("relation")
public class Relation {
    @Id
    private String id;

    private String userId;
    private String name;
    private String email;
    private String phone;
    private String relationType;
    private LocalDate birthday;
    private String imageUrl;

    static public Relation DtoToEntity(CreateRelation dto) {
        var relation = new Relation();
        relation.name = dto.getName();
        relation.email = dto.getEmail();
        relation.birthday = dto.getBirthday();
        relation.relationType = dto.getRelationType();
        relation.phone = dto.getPhone();
        relation.userId = dto.getUserId();

        return relation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRelationType() {
        return relationType;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
