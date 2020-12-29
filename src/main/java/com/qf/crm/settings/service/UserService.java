package com.qf.crm.settings.service;

import com.qf.crm.exception.LoginException;
import com.qf.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
