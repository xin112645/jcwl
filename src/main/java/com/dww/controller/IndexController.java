package com.dww.controller;


import com.dww.controller.base.BaseController;
import com.dww.service.User.ApiSupplementService;
import com.dww.util.LogUtils;
import com.dww.util.PageData;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


@RestController
public class IndexController extends BaseController {
    @RequestMapping("AlipayreturnsTT")
    public String AlipayreturnsTT() throws Exception {
        //会调下游
        return "success";
    }
}
