package com.example.demo.websocket.Service;

import org.springframework.stereotype.Service;

@Service
public class WzqContent {
    private int[] content = new int[225];
    WzqContent(){
        for (int i=0;i<=224;i++)
            content[i]= -1;
    }
    public int[] getContent() {
        return content;
    }

    public void setContent(int index,int content) {
        this.content[index] = content;
    }
}
