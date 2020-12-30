package com.qf.crm.workbench.service.impl;

import com.qf.crm.utils.SqlSessionUtil;
import com.qf.crm.workbench.dao.ActivityDao;
import com.qf.crm.workbench.domain.Activity;
import com.qf.crm.workbench.service.ActivityService;

/**
 * @ClassName ActivityServiceImpl
 * @Description: TODO
 * @Author chenyu
 * @Date 2020/12/29 10:24
 * @Version 1.0
 */
public class ActivityServiceImpl implements ActivityService {

    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    public boolean save(Activity a) {

        boolean flag = true;

        int count = activityDao.save(a);
        if(count!=1){

            flag = false;

        }

        return flag;
    }
}
