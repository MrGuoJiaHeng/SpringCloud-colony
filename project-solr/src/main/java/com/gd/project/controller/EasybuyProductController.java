package com.gd.project.controller;


import com.gd.project.entity.EasybuyProduct;
import com.gd.project.service.EasybuyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 郭家恒
 * @since 2019-03-11
 */
@RestController
public class EasybuyProductController {

    @Autowired
    EasybuyProductService easybuyProductService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/QueryShopFroRedis")
    public Object QueryShopFroRedis() {
        List<EasybuyProduct> productList = easybuyProductService.list(null);
        for (EasybuyProduct p : productList) {
//            stringRedisTemplate.opsForValue().set(p.getId().toString(),p.getName());
            stringRedisTemplate.opsForHash().put("product" + p.getId(), "id", p.getId());
            stringRedisTemplate.opsForHash().put("product" + p.getId(), "name", p.getName());
        }
        return productList;
    }


    @RequestMapping("/DelShopFroRedis")
    public Object DelShopFroRedis(Integer pid) {
        stringRedisTemplate.delete("Product" + pid);

        return "SUCCESS";
    }
}

