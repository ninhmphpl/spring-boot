package com.example.boot.model;

import lombok.Getter;
import lombok.Setter;

import java.security.Principal;

@Getter
@Setter
public class User implements Principal {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
