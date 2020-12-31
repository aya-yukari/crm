package com.qf.crm.workbench.web.controller;

import com.qf.crm.settings.domain.User;
import com.qf.crm.settings.service.UserService;
import com.qf.crm.settings.service.impl.UserServiceImpl;
import com.qf.crm.utils.DateTimeUtil;
import com.qf.crm.utils.PrintJson;
import com.qf.crm.utils.ServiceFactory;
import com.qf.crm.utils.UUIDUtil;
import com.qf.crm.vo.PaginationVO;
import com.qf.crm.workbench.domain.Activity;
import com.qf.crm.workbench.service.ActivityService;
import com.qf.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            
            save(request,response);

        }else if("/workbench/activity/pageList.do".equals(path)){

            pageList(request,response);

        }
    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到查询市场活动信息列表的操作（结合条件查询+分页查询）");
        
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String pageNoStr = request.getParameter("pageNo");
        int pageNo = Integer.valueOf(pageNoStr);
        //每页展现的记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.valueOf(pageSizeStr);
        //计算出略过的记录数
        int skipCount = (pageNo-1)*pageSize;
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",name);
        map.put("owner",owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);
        
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        /* 
            前端要什么就让业务层给控制器反什么
            前端要: 市场活动信息列表
                   查询的总条数
                   
                   业务层拿到了以上两项信息之后，如果做返回
                   map
                   map.put("dataList":dataList)
                   map.put("total":total)
                   PrintJSON map --> json
                   {"total":100，"dataList":[{市场活动1}，{2},{3}]}
                   
                   vo 使用它高概率，低概率，高概率
                   PaginationVO<T>
                        private int total;
                        private List<T> dataList;
                        
                  PaginationVo<Activity> vo = new PaginationVO<>();
                  vo.setTotal(total);
                  vo.setDataList(dataList);      
                  PrintJSON vo --> json
                  {"total":100，"dataList":[{市场活动1}，{2},{3}]}
                  
                  将来分页查询，每个模块都有，所以我们选择使用一个通用vo，操作起来比较方便
                  
         */       


        PaginationVO<Activity> vo = as.pageList(map);
        
        //vo--> {"total":100,"dataList":[{市场活动1}，{2},{3}]}
        PrintJson.printJsonObj(response,vo);
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

