package com.example.demo.websocket.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 开启WebSocket支持
 * @author zhengkai.blog.csdn.net
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("获取的IP----》"+ip);
        return new ServerEndpointExporter();
    }

}