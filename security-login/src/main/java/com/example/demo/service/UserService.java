package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

/**
 * Created by 1002732 on 2018. 6. 22..
 */
public interface UserService extends UserDetailsService {
    Collection<GrantedAuthority> getAuthorities(String username);

    public User readUser(String username);

    public void createUser(User user);

    public void deleteUser(String username);

    public PasswordEncoder passwordEncoder();
}
