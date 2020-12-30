package com.qf.crm.settings.service.impl;

import com.qf.crm.exception.LoginException;
import com.qf.crm.settings.dao.UserDao;
import com.qf.crm.settings.domain.User;
import com.qf.crm.settings.service.UserService;
import com.qf.crm.utils.DateTimeUtil;
import com.qf.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/26 10:44
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        
        User user = userDao.login(map);
        if(user==null){
            throw new LoginException("账号密码错误");
        }
        // 如果程序能够成功的执行到改行，说明账号密码正确
        // 需要继续向下验证其他三项信息
        
        // 验证失效时间
        String expireTime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if(expireTime.compareTo(currentTime)<0){
            throw new LoginException("账号已失效");
        }
        
        //判断锁定状态
        String lockState = user.getLockState();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定");
        }
        
        // 判断ip地址
        String allowIps = user.getAllowIps();
        if(!allowIps.contains(ip)){
            throw new LoginException("ip地址受限");
        }
        
        return user;
    }

    public List<User> getUserList() {
        
        List<User> uList = userDao.getUserList();
        return uList;
    }
}























































