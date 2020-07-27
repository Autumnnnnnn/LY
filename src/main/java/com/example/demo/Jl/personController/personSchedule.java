package com.example.demo.Jl.personController;

import com.example.demo.Jl.personDao.scheduleDao;
import com.example.demo.Jl.personMapper.scheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class personSchedule {

    @Autowired
    private scheduleMapper scheduleMapper;

    @GetMapping("/person/personSchedule")
    public String index(){
        return "person/personSchedule";
    }


    @RequestMapping(value = "/person/personSchedule/time",method = RequestMethod.GET)
    @ResponseBody
    public List<scheduleDao> findByTime(@RequestParam("time") String time){
        scheduleDao scheduleDao = new scheduleDao();
        scheduleDao.setTime(time);
        scheduleDao.setUserId("17851033");
        List<scheduleDao> list = scheduleMapper.findByTimeUserId(scheduleDao);

        return list;
    }
}
