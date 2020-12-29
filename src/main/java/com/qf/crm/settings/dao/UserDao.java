package com.qf.crm.settings.dao;

import com.qf.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {
    
    User login(Map<String, String> map);
}
