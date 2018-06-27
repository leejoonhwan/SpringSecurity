package com.example.demo.controller;

import com.example.demo.mapper.HomeMapper;
import com.example.demo.dto.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 1002732 on 2018. 6. 22..
 */
@RestController
public class HomeController {
    @Autowired
    HomeMapper homeMapper;

    @Autowired
    AuthenticationManager authenticationManager;


    @RequestMapping("/login")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/{name}")
    public Home home(@PathVariable String name) {
        Home home = homeMapper.readHome(name);
        return home;
    }

    @RequestMapping("/admin")
    public String admin() {
        return "This is admin page";
    }

    @RequestMapping("/user")
    public String user() {
        return "this is user page";
    }

    @RequestMapping("/all")
    public String all() {
        return "Allow access page";
    }
    @RequestMapping("/picaso")
    public String picaso() {
        return "picaso all allow";
    }
}
