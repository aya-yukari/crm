package com.qf.crm.settings.web.controller;

import com.qf.crm.settings.domain.User;
import com.qf.crm.settings.service.UserService;
import com.qf.crm.settings.service.impl.UserServiceImpl;
import com.qf.crm.utils.MD5Util;
import com.qf.crm.utils.PrintJson;
import com.qf.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/26 10:48
 * @Version 1.0
 */
public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到用户控制器");
        
        String path = request.getServletPath(); // 拿到的是url-pattern
        
        if("/setting/user/login.do".equals(path)){
            System.out.println(1);
            login(request,response);
            
        }else if("/setting/user/xx.do".equals("path")){

            // xxx(request,response)

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到验证登录的操作");
        
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //将密码的明文形式转换为MD5的密文形式
        loginPwd = MD5Util.getMD5(loginPwd);
        //接受浏览器端的ip地址
        String ip = request.getRemoteAddr();
        System.out.println("----------ip: "+ip);

        //未来业务层开发，统一使用代理类形态的接口对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user = us.login(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            
            // 如果程序执行到此处，说明业务层没有为controller抛出任何异常
            // 表示登陆成功
            /*  
                {"success":true}
             */
            PrintJson.printJsonFlag(response,true);
        } catch (Exception e) {
            e.printStackTrace();
            // 一旦程序执行到catch块的信息，说明业务层为我们验证登陆失败，为controller抛出了异常
            // 表示登陆失败
            /* 
                {"success":true,"msg":?}
             */
            String msg = e.getMessage();
            /* 
                我们现在作为controller，需要为ajax请求提供多项信息
                
                可以有两种手段来处理:
                    1）将多项信息打称为map，将map解析为json串
                    2）创建一个Vo
                        private Boolean success;
                        private String msg;
                        
                如果对于展现的信息将来还会大量的使用，我们创建一个Vo类方便使用
                如果对于展现的信息只有在这个需求中能够使用，我们使用map就够了        
             */
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(response,map);
        }


    }
}
