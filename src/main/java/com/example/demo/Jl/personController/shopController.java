package com.example.demo.Jl.personController;
import com.example.demo.Jl.personDao.collectionDao;
import com.example.demo.Jl.personDao.scenicSpots;
import com.example.demo.Jl.personDao.shopDao;
import com.example.demo.Jl.personMapper.collectMapper;
import com.example.demo.Jl.personMapper.shopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class shopController {

    @Autowired
    private shopMapper shopMapper;
    @Autowired
    private collectMapper collectMapper;

    @RequestMapping("/person/shop")
    public String index(){
        return "person/shop";
    }

    /**
     * 根据类型查询商店
     * @param id
     * @return
     */
    @RequestMapping(value = "/person/shop/type/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<shopDao> findByType(@PathVariable("id") int id){
        List<shopDao> list = shopMapper.findByType(id);
        return list;
    }

    /**
     * 查询所有景点
     * @return
     */
    @RequestMapping(value = "/person/shop/spots",method = RequestMethod.GET)
    @ResponseBody
    public List<scenicSpots> findAllSpots(){
        List<scenicSpots> list = shopMapper.findAllScenicSpots();
        return list;
    }

    /**
     * 添加景点收藏
     * @param id
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/person/collectionOfSc/{id}")
    @ResponseBody
    public String addCollectionOfSc(@PathVariable("id")int id,
                                    HttpServletRequest httpServletRequest){
        HttpSession session=httpServletRequest.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));

        collectionDao collectionDao =new collectionDao();

        collectionDao.setCreateTime(new Date(System.currentTimeMillis()));
        collectionDao.setStore(0);
        collectionDao.setScenicSpots(id);
        collectionDao.setUserId("17851033");

        int i = collectMapper.addCollection(collectionDao);
        if (i>0) {
            return "200";
        }else {
            return "500";
        }
    }

    /**
     * 添加 store 收藏
     * @param id
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/person/collectionOfSt/{id}")
    @ResponseBody
    public String addCollectionOfSt(@PathVariable("id")int id,
                                    HttpServletRequest httpServletRequest){
        HttpSession session=httpServletRequest.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));

        collectionDao collectionDao =new collectionDao();

        collectionDao.setCreateTime(new Date(System.currentTimeMillis()));
        collectionDao.setScenicSpots(0);
        collectionDao.setStore(id);
        collectionDao.setUserId("17851033");

        int i = collectMapper.addCollection(collectionDao);
        if (i>0) {
            return "200";
        }else {
            return "500";
        }
    }
    @RequestMapping(value = "/person/scenicspots/byName",method = RequestMethod.GET)
    @ResponseBody
    public List<scenicSpots> selectByName(HttpServletRequest httpServlet,
                                          @RequestParam("name") String name){
        List<scenicSpots> list = shopMapper.selectByName(name);
        return list;
    }
}
