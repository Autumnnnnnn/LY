package com.example.demo.Jl.personMapper;

import com.example.demo.Jl.personDao.scenicSpots;
import com.example.demo.Jl.personDao.shopDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface shopMapper {

    @Select("select * from shop where type = ${type}")
    List<shopDao> findByType(int type);

    @Select("select * from scenicspots")
    List<scenicSpots> findAllScenicSpots();

    @Select("select * from scenicspots where SpotsMP like '%${name}%'")
    List<scenicSpots> selectByName(String name);
}
