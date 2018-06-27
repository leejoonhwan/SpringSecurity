package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Created by 1002732 on 2018. 6. 27..
 */

@Getter
@Setter
public class AuthToken {

    private String username;
    private Collection authorities;
    private String sessionToken;

    public AuthToken(String username, Collection collection, String token) {
        this.username = username;
        this.authorities = collection;
        this.sessionToken = token;
    }
}
