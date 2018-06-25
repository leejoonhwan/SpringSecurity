package com.example.demo.controller;

import com.example.demo.mapper.HomeMapper;
import com.example.demo.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 1002732 on 2018. 6. 22..
 */
@RestController
@EnableAutoConfiguration
public class HomeController {
    @Autowired
    HomeMapper homeMapper;

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/{name}")
    public Home home(@PathVariable String name) {
        Home home = homeMapper.readHome(name);
        return home;
    }
}
