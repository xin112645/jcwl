package com.dww.util;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class StrSplit {
    public static String str(String str){
        Gson json=new Gson();
        String[] split = str.split("&");
        Map<Object,Object> map=new HashMap<>();
        for (int i=0;i<=split.length-1;i++) {
            String[] split1 = split[i].split("=");
            for (int ii=0;ii<=split1.length-1;ii++){
                try {
                    map.put(split1[0],String.valueOf(split1[1]));
                }catch (Exception e){
                    map.put(split1[0],"");
                }
            }
        }
        return json.toJson(map);
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s=str("out_trade_no=901664494109892608432598&pay_notify_urls=http://pay.bailidaa.cn/4pay-api/services/notify/zfb_tl_notify&return_url=null&productUuid=763452fd83f84a4697b2d1554932a4e5_b4f2a43c9d314eb690ae36c7bdcf6709_6d8f98b3f2cb40018c0ef7b34eba1cc3&mer_platuser_id=null&call_type=POST&random_str=e4c7fe91683043ba82af5e352c27a3d5&user_code=a15843126039@sina.com&pay_app_id=4");
        System.out.println(s);
    }

}
