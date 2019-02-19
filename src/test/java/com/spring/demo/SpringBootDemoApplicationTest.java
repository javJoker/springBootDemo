package com.spring.demo;

import com.spring.demo.main.SpringBootDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringBootDemoApplication.class}) // 指定启动类
public class SpringBootDemoApplicationTest {

    @Test
    public void test() {
        System.out.println("=======================");

        System.out.println(1111111);

        System.out.println("=======================");

    }

}

