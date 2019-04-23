package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Test
    public void contextLoads() {

    }

    @Test
    public void logTest() throws InterruptedException {
        Map<String, Object[]> paramMap = new HashMap<>();
        paramMap.put("username", new Object[]{"13520527259"});
        paramMap.put("appid", new Object[]{"1"});
        paramMap.put("password", new Object[]{"starry782779"});
        paramMap.put("next", new Object[]{"https://www.genshuixue.com/login?a=123&appid=haoke&connect_appid=flkjdsalfjaljfldjals"});
        int num = 10;
        int count = 100000;
        List<Long> times = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < count; j++) {
                logger.info("params = {}", JSON.toJSONString(paramMap));
            }
            long end = System.currentTimeMillis();
            times.add(end - start);
            Thread.sleep(500);
        }
        System.out.println(times);
        System.out.println(times.stream().reduce((a, b)-> a + b).get() / num);
    }

}
