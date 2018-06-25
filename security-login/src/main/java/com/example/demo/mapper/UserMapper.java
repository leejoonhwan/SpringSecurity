package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 1002732 on 2018. 6. 22..
 */

@Mapper
public interface UserMapper {
    public User readUser(String username);

    public List<String> readAuthority(String username);
}
