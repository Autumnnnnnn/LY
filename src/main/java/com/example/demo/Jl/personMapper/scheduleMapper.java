package com.example.demo.Jl.personMapper;

import com.example.demo.Jl.personDao.scheduleDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface scheduleMapper {

    @Select("select * from schedule where time=#{time} and userId=#{userId}")
    List<scheduleDao> findByTimeUserId(scheduleDao dao);
}
