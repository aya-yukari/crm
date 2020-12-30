package com.qf.crm.workbench.web.controller;

import com.qf.crm.settings.domain.User;
import com.qf.crm.settings.service.UserService;
import com.qf.crm.settings.service.impl.UserServiceImpl;
import com.qf.crm.utils.DateTimeUtil;
import com.qf.crm.utils.PrintJson;
import com.qf.crm.utils.ServiceFactory;
import com.qf.crm.utils.UUIDUtil;
import com.qf.crm.workbench.domain.Activity;
import com.qf.crm.workbench.service.ActivityService;
import com.qf.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName ActivityController
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/26 10:48
 * @Version 1.0
 */
public class ActivityController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入到市场活动控制器");
        
        String path = request.getServletPath(); // 拿到的是url-pattern
        
        if("/workbench/activity/getUserList.do".equals(path)){
            System.out.println(1);
            getUserList(request,response);
            
        }else if("/workbench/activity/save.do".equals(path)){

            System.out.println(1);
            save(request,response);

        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {

        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        //创建时间，当前系统时间
        String createTime = DateTimeUtil.getSysTime();
        //创建人，当前登陆用户
        String createBy = ((User)request.getSession().getAttribute("user")).getName();
        
        Activity a = new Activity();
        a.setId(id);
        a.setCost(cost);
        a.setStartDate(startDate);
        a.setOwner(owner);
        a.setName(name);
        a.setEndDate(endDate);
        a.setDescription(description);
        a.setCreateTime(createTime);
        a.setCreateBy(createBy);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        
        boolean flag = as.save(a);
        PrintJson.printJsonFlag(response,flag);

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        //虽然是由市场模块接受并处理请求，但是业务层用用户的，这是用户相关的请求
        System.out.println("取得用户信息列表");

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> uList = us.getUserList();
        PrintJson.printJsonObj(response,uList);
    }

}

