package com.dww.controller;

import com.dww.controller.base.BaseController;
import com.dww.service.User.ApiSupplementService;
import com.dww.util.NewMD5;
import com.dww.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

@RestController
public class LoginController extends BaseController {

    @Autowired
    private ApiSupplementService apiSupplementService;

    @RequestMapping("login.action")//登录
    public String LoginText() {
        /*try {
            PageData pageData = this.getPageData();
            String TextPassWord = NewMD5.hmacSign(pageData.getString("passwd")).toUpperCase().toString();
            pageData.put("tpasswd",TextPassWord);
            List<PageData> list = apiSupplementService.findUserManage(pageData);
            HttpServletRequest request = getRequest();
            HttpSession sessio = request.getSession();
            if(list.size() == 1){
                for(PageData pd : list){
                    sessio.setAttribute("mer_uuid",pd.get("mer_uuid"));
                    sessio.setAttribute("manager_uuid",pd.get("uuid"));
                    sessio.setAttribute("type_ext",pd.get("type_ext"));
                }
                return "登录成功";
            }else{
                return "登录失败";
            }
        }catch(Exception e){
            return "登录失败";
        }*/
        return "登录失败";
    }
}
