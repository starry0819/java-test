package com.zhanghuanfa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("info msg");
        logger.error("error msg");
        System.out.println("Hello World!");
        byte[] a = "".getBytes();
        System.out.println(a.length);
        logger.info("\"mobile\" : \"{}\"", "12345678901");
        logger.info("mobile = {}", "12345678901");
        logger.info("password = {}", "12345678901");
        String mobile = "13520527259";
        System.out.println(mobile.substring(0, 3));
        Map<String, String[]> map = new HashMap<>(4);
        map.put("mobile", new String[]{"13520527259"});
        map.put("password", new String[]{"starry782779"});
        System.out.println(JSON.toJSONString(map));
        Object[] array = {"123", "ad"};
        logger.info("array = {}", array);
        logger.info("params = {}", map);
        logger.info("params = {}", JSON.toJSONString(map));
    }
}

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Bean {
    private String name;

    private Integer id;

    private List<String> address;

    private List<Student> students;

    private Student student;
}

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
class Student{
    private String name;
    private Integer id;
}

