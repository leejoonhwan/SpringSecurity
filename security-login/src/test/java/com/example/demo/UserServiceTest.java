package com.example.demo;

import com.example.demo.dto.model.User;
import com.example.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by 1002732 on 2018. 6. 25..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private User user1;

    @Before
    public void setup() {
        user1 = new User();
        user1.setUsername("1002732");
        user1.setPassword("1234");
        user1.setAccountNonExpired(true);
        user1.setAccountNonLocked(true);
        user1.setName("USER1");
        user1.setCredentialsNonExpired(true);
        user1.setEnabled(true);
        user1.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
    }

    @Test
    public void createUserTest() {
        userService.deleteUser(user1.getUsername());
        userService.createUser(user1);
        User user = userService.readUser(user1.getUsername());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String result = passwordEncoder.encode("1234");
        boolean dir = passwordEncoder.matches("1234", result);
        Collection<? extends GrantedAuthority> authorities1 = user1.getAuthorities();

        Iterator<? extends GrantedAuthority> it = authorities1.iterator();
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
        while (it.hasNext()) {
            GrantedAuthority authority = it.next();
        }
    }
}
