package com.example.demo.Jl.personMapper;

import com.example.demo.Jl.personDao.userDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper {

    @Select("select count(*) from user where email = #{email}")
    int countByEmail(String email);

    @Insert("insert into user(userId,email,password,userName,status,uCode,createTime) value(#{userId},#{email},#{password},#{userName},#{status},#{uCode},#{createTime})")
    int addUser(userDao user);

    @Select("select count(*) from user where email = #{email} and password = #{password}")
    int checkUser(userDao userDao);

    @Select("select * from user where email = #{email}")
    userDao findAll(String email);
}
