package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;
    private String name;
    private String password;

    public static User createUser(String email, String name, String password) {
        var newUser = new User();

        newUser.email = email;
        newUser.name = name;
        newUser.password = password;

        return newUser;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    // Getters and Setters
}
