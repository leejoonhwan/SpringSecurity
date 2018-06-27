package com.example.demo.mapper;

import com.example.demo.dto.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by 1002732 on 2018. 6. 22..
 */

@Mapper
public interface UserMapper {
    public User readUser(String username);

    public List<GrantedAuthority> readAuthority(String username);

    public void createUser(User user);

    public void createAuthority(User user);

    public void deleteUser(String username);

    public void deleteAuthority(String username);
}
