package com.example.eschool.mappers;

import com.example.eschool.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE username=#{username} AND password=#{password}")
    User findByNameAndPassword(String username, String password);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(int id);

}
