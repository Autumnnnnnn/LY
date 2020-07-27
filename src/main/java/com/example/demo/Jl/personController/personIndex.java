package com.example.demo.Jl.personController;
import com.example.demo.Jl.personDao.diaryDao;
import com.example.demo.Jl.personDao.userDao;
import com.example.demo.Jl.personMapper.diaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class personIndex {

    @Autowired
    private diaryMapper diaryMapper;
    @Autowired
    private com.example.demo.Jl.personMapper.userMapper userMapper;

    @GetMapping("/person/personDaily")
    public String personDaily(){
        return "person/personDaily";
    }

    /**
     * 登入 入口 设定session
     * @param email
     * @param password
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/person/Daily")
    public String personDailyPost(@RequestParam("email") String email,
                                  @RequestParam("ps")String password,
                                  HttpServletRequest httpServletRequest){
        System.out.println(email);
        System.out.println(password);
        HttpSession session = httpServletRequest.getSession();
        boolean t = (boolean) session.getAttribute("isTrue");
        userDao userD = userMapper.findAll(email);

        if(t && userD.getStatus()!=0){
            session.setAttribute("email",email);
            session.setAttribute("userName",userD.getUserName());
            session.setAttribute("userId",userD.getUserId());
            session.setAttribute("uCode",userD.getuCode());
            return "redirect:/person/personDaily";
        }
            return "404";
    }

    /**
     * 根据当前用户userId 获取daily；
     * @return
     */
    @GetMapping("/person/personDaily/diary")
    @ResponseBody
    public List<diaryDao> findAll(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String id = String.valueOf(session.getAttribute("userId"));
//        System.out.println(id);
        if (id ==""|| id == null) {
            return null;
        }else{
            List<diaryDao> list = diaryMapper.findAllByUserId(id);
            return list;
        }
    }

    /**
     * 删除daily 更新数据
     * @param diaryDao
     * @return
     */
    @RequestMapping(value = "/person/personDaily/diary",method = RequestMethod.POST)
    @ResponseBody
    public List<diaryDao> delete(@RequestBody diaryDao diaryDao){

        /**
         * 判断是否为当前用户，会话是否过期；
         */

        /**
         * 删除数据
         */
        int i = diaryMapper.deleteById(diaryDao.getId());
        if(i>0){
            /**
             * 更新数据
             */
            List<diaryDao> list = diaryMapper.findAllByUserId(diaryDao.getUserId());
            return list;
        }else {
            return null;
        }
    }

    /**
     * 批量删除 更新数据
     * @param httpServlet
     * @param id
     * @return
     */
    @RequestMapping(value = "/person/personDaily/diaryDelete",method = RequestMethod.GET)
    @ResponseBody
    public List<diaryDao> deleteById(HttpServletRequest httpServlet,
                                     @RequestParam("id") String[] id){
        /**
         * 获取当前用户userId
         */
        HttpSession httpSession =httpServlet.getSession();
        String userId= (String) httpSession.getAttribute("userId");
        /**
         * 删除操作
         */
        if (userId!=null&&userId!=""){
            for(String id1 :id){
                System.out.println(id1);
                diaryMapper.deleteById(Integer.parseInt(id1));
            }
            List<diaryDao> list = diaryMapper.findAllByUserId(userId);
            return list;
        }else {
            return null;
        }
    }

    @Value("${invented.url}")
    private String inventedUrl;
    @Value("${img.trueLocation}")
    private String trueLocation;
    /**
     * 添加 dairy
     * @param map
     * @param file
     * @param httpServlet
     * @return
     */
    @RequestMapping(value ="/person/personDaily/diaryInsert",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> insertDaily(@RequestParam Map<String, String> map,
                                           @RequestParam("file") MultipartFile file,
                                           HttpServletRequest httpServlet){
        HttpSession session = httpServlet.getSession();
        String userId= String.valueOf(session.getAttribute("userId"));
        Map<String, String> map1 = new HashMap();
        if (map.size() > 0 && file != null) {
            String path; //文件路径
            String type; //文件类型
            String fileName = file.getOriginalFilename();//源文件名
            //文件大小 b
            long size = file.getSize();
            System.out.println(size);
            if (size < 1024 * 1024) {
                type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) { //判断文件类型
                        String realPath = trueLocation;
                        String trueFileName = System.currentTimeMillis() + "." + type;
//                        String realPath = request.getServletContext().getRealPath("file");
//                        System.out.println(type);
                        //设置存放图片的路径
                        path = trueLocation + trueFileName;
                        System.out.println("存放图片的路径：" + path);
                        //设置修改图片的路径命名
                        String thePath = inventedUrl + trueFileName;

                        //添加diary信息
                        diaryDao diaryDao= new diaryDao();
                        diaryDao.setUserId(userId);
                        diaryDao.setTitle(map.get("title"));
                        diaryDao.setNotes(map.get("notes"));
                        diaryDao.setContent(map.get("content"));
                        diaryDao.setImg(thePath);
                        diaryDao.setCreateTime(new Date(System.currentTimeMillis()+28800000));

                        int i=diaryMapper.insertDaily(diaryDao);
                        if(i>0){
                            map1.put("status", "200");
                            map1.put("msg", "新添成功！");
                            // 转存文件到指定的路径↓
                            try {
                                file.transferTo(new File(path));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return map1;
                        }else {
                            map1.put("status", "500");
                            map1.put("msg", "新添失败！");
                            return map1;
                        }
                    }
                } else {
                    System.out.println("文件类型为空！");
                    map1.put("status", "500");
                    map1.put("msg", "文件类型为空！");
                    return map1;
                }
            } else {
                System.out.println("图片太大！");
                map1.put("status", "500");
                map1.put("msg", "图片太大！");
                return map1;
            }
            System.out.println("文件信息或者文件不存在！");
            map1.put("status", "500");
            map1.put("msg", "文件信息或者文件不存在！");
            return map1;
        }
        map1.put("status", "500");
        map1.put("msg", "error！");
        return map1;

//        HttpSession httpSession =httpServlet.getSession();
//        String userId= (String) httpSession.getAttribute("userId");
//        userId= String.valueOf(17851033);
//
//        diaryDao.setUserId(userId);
//        diaryDao.setCreateTime(new Date(System.currentTimeMillis()));
//        int i = diaryMapper.insertDaily(diaryDao);
//        if (i>0){
//            List<diaryDao> list = diaryMapper.findAllByUserId(userId);
//            return list;
//        }else {
//            return null;
//        }
    }
}
