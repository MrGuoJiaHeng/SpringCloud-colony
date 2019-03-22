package com.gd.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RedisDemo {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/setValue")
    public void setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @RequestMapping("/getValue")
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/luagetValue")
    public String luagetValue() {
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<String>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luaDemo.lua")));
        redisScript.setResultType(String.class);

        List<String> keyList = new ArrayList<>();
        keyList.add("k1");
        String result = stringRedisTemplate.execute(redisScript, keyList, "测试");
        System.out.println(result);
        return result;
    }
}
