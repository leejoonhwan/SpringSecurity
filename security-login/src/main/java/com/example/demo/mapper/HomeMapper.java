package com.example.demo.mapper;

/**
 * Created by 1002732 on 2018. 6. 22..
 */

import com.example.demo.model.Home;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {
    public Home readHome(String name);
}