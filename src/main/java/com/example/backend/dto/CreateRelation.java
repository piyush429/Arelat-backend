package com.example.backend.dto;

import java.time.LocalDate;

public class CreateRelation {
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
    private String relationType;
    private String userId;

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getRelationType() {
        return relationType;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserId() {
        return userId;
    }
}