package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1002732 on 2018. 6. 22..
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.readUser(username);
        user.setAuthorities(getAuthorities(username));
        return user;
    }

    public Collection<GrantedAuthority> getAuthorities(String username) {
        Collection<GrantedAuthority> authorities = userMapper.readAuthority(username);
        return authorities;
    }

    @Override
    public User readUser(String username) {
        User user = userMapper.readUser(username);
        user.setAuthorities(userMapper.readAuthority(username));
        return user;
    }

    @Override
    public void createUser(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        userMapper.createUser(user);
        userMapper.createAuthority(user);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
        userMapper.deleteAuthority(username);
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }

}
