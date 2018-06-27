package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.dto.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 1002732 on 2018. 6. 22..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void readUserTest() {
        User user = userMapper.readUser("cusonar");
    }

    @Test
    public void readAuthorityTest() {
        List<GrantedAuthority> authorities = userMapper.readAuthority("cusonar");
        Iterator<GrantedAuthority> it = authorities.iterator();
        while (it.hasNext()) {
            GrantedAuthority authority = it.next();
        }
    }
}
