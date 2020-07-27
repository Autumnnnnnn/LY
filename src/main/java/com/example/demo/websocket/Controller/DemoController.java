package com.example.demo.websocket.Controller;


import com.example.demo.websocket.Service.WebSocketServer;
import com.example.demo.websocket.Service.WzqContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


/**
 * WebSocketController
 * @author zhengkai.blog.csdn.net
 */
@Controller
public class DemoController {

    @Autowired
    WzqContent wzqContent;
    @GetMapping("/websocket")
    public String index(){
        return "webSocket/websocket";
    }
    @GetMapping("/wzq")
    public String wzq(){
        return "webSocket/wzq";
    }
    @GetMapping("/index2")
    public String index1(){
        return "webSocket/index";
    }
    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        System.out.println("pushToWeb");
        WebSocketServer.sendInfo(message,toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
    @GetMapping("/wzqqp")
    @ResponseBody
    public int[] wzqqp(){
//        int[] list = new int[225];
//        for (int i=0;i<=224;i++)
//            list[i]= -1;
        int[] list= wzqContent.getContent();
        return list;
    }
    @PostMapping("/wzqqp/set")
    @ResponseBody
    public int[] xiaQi(@RequestParam(name = "index") int index,
                       @RequestParam(name = "content") int content){
        System.out.println("index:"+index+"content:"+content);
        wzqContent.setContent(index,content);
        int[] list = wzqContent.getContent();
        return list;
    }
}

