package com.qf.crm.settings.service;

import com.qf.crm.exception.LoginException;
import com.qf.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
