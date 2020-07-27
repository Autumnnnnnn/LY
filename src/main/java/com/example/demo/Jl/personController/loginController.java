package com.example.demo.Jl.personController;
import com.example.demo.Jl.personDao.diaryDao;
import com.example.demo.Jl.producer.sendEmailProducer;
import com.example.demo.Jl.util.VCodeUtil;
import com.example.demo.Jl.util.utilDao.EmailDao;
import com.example.demo.Jl.util.utilDao.pageDao;
import com.example.demo.Jl.personDao.userDao;
import com.example.demo.Jl.util.EmailUtil;
import com.example.demo.Jl.util.UUIDUtil;
import com.example.demo.Jl.util.pageUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class loginController {
    @Autowired
    private com.example.demo.Jl.personMapper.diaryMapper diaryMapper;
    @Autowired
    private com.example.demo.Jl.personMapper.userMapper userMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "person/login";
    }

    /**
     * 检查邮箱是否被注册
     * @param email
     * @return
     */
    @GetMapping("/login/check")
    @ResponseBody
    public int emailCheck(@RequestParam("email") String email){
        int i = userMapper.countByEmail(email);
        if (i==0){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 发送验证码
     * @param emailDao
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/login/sendEmail")
    @ResponseBody
    public int sendEmail(@RequestBody EmailDao emailDao,
                         HttpServletRequest httpServletRequest){
        HttpSession session= httpServletRequest.getSession();
        String code = VCodeUtil.getVCode();
        session.setAttribute("verificationCode",code);
        //验证邮箱发送验证码
        String content = "你的验证码为：<a href='#'>"+code+"</a> ，你正在进行"+emailDao.getType()+"，请在5分钟内完成操作,如不是本人操作请忽略本条邮件。";
        boolean b = EmailUtil.sendMail(emailDao.getToUser(),content,"个人记录网");
        if (b){
            System.out.println("验证码发送成功");
            return 1;
        }else {
            System.out.println("验证码发送失败");
            return 0;
        }
    }

    @Value("${name.ip}")
    private String ip;
    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/login/Register")
    @ResponseBody
    public int loginRegister(@RequestBody userDao user,
                             HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        /**
         * 提交的验证码与发送的验证码对比
         */
        if(user.getuCode().toUpperCase().equals(String.valueOf(httpSession.getAttribute("verificationCode"))))
        {
            user.setUserId("L"+String.valueOf(System.currentTimeMillis()));
            user.setStatus(1);
            user.setuCode(UUIDUtil.getUuid());
            user.setCreateTime(new Date(System.currentTimeMillis()+28800000));
            int i = userMapper.addUser(user);
            if (i==1){
                //添加成功，移除验证码
                httpSession.removeAttribute("verificationCode");
                return 200;
            }else {
                return 500;
            }
        }else {
            return 0;
        }
    }

    /**
     * 登录验证
     * @param userDao
     * @param httpServletRequest
     * @return
     */
    @PostMapping("/login/userCheck")
    @ResponseBody
    public boolean loginCheck(@RequestBody userDao userDao,
                              HttpServletRequest httpServletRequest){

        Map map=new HashMap();
        map.put("email",userDao.getEmail());
        map.put("name","黄飞鸿");
        rabbitTemplate.convertAndSend("sendEmail",map);

        int i = userMapper.checkUser(userDao);
        if(i==1){
            HttpSession session = httpServletRequest.getSession();
            userDao userDao1 = userMapper.findAll(userDao.getEmail());
            session.setAttribute("email",userDao.getEmail());
            session.setAttribute("userId",userDao1.getUserId());
            return true;
        }else {
            return false;
        }
    }
    /**-------------------------------------------------------
     * 分页查询diary：
     * @param page 当前页
     * @param model
     * @return
     */
    @GetMapping("/person/{page}")
    public String person(@PathVariable("page")int page,
                         Model model,
                         HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        pageDao pageDao=new pageDao();
        int count = diaryMapper.countDiary();
        new pageUtil(count,page,pageDao,10);
        /**
         * 根据用户id 查询对应日记
         * @param page
         * @pqram userId
         */
        List<diaryDao> list = diaryMapper.findLimit(pageDao,userId);
        model.addAttribute("lists",list);
        model.addAttribute("lastPage",pageDao.getLastPage());
        model.addAttribute("nextPage",pageDao.getNextPage());
        model.addAttribute("currentPage",pageDao.getCurrentPage());
        model.addAttribute("sumPages",pageDao.getSum());
        return "person/personIdex";
    }
}
