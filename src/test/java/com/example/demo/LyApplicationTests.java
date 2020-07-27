package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LyApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test

    public void random(){
        Random s =new  Random(100);
        for (int i = 0; i < 50; i++) {
            System.out.println(s.nextInt());
        }
    }

}
