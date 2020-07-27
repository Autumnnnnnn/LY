package com.example.demo.websocket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping("/index1")
    public String indexxx(){
        return  "webSocket/index";
    }
}
