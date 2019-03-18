package com.dww.controller;


import com.dww.controller.base.BaseController;
import com.dww.jms.Producer;
import com.dww.service.User.ApiSupplementService;
import com.dww.util.PageData;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class ApiController extends BaseController {

    @Autowired
    private StringRedisTemplate redis;
    @Autowired
    private Producer producer;
    @Autowired
    private ApiSupplementService apiSupplementService;

    @GetMapping("gettext")
    public String gettext() {
        Gson json = new Gson();

        System.out.println("get请求测试" + json.toJson(this.getPageData()));
        return "";
    }

    @PostMapping("posttext")
    public String posttext() {
        Gson json = new Gson();
        producer.sendMessage("ceshi");
        System.out.println("post请求测试" + json.toJson(this.getPageData()));
        return "";
    }

    @PostMapping("SqlInsertStar.api")
    public String SqlInsertStar(@RequestHeader("SecretKey") String SecretKey) {
        return "error";
    }
}
