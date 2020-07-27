package com.example.demo.Jl.personMapper;

import com.example.demo.Jl.personDao.collectionDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface collectMapper {

    @Insert("insert into collection(userId,scenicSpots,store,createTime) values(#{userId},#{scenicSpots},#{store},#{createTime})")
    int addCollection(collectionDao dao);
}
