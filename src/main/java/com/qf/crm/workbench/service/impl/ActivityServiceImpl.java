package com.qf.crm.workbench.service.impl;

import com.qf.crm.utils.SqlSessionUtil;
import com.qf.crm.vo.PaginationVO;
import com.qf.crm.workbench.dao.ActivityDao;
import com.qf.crm.workbench.domain.Activity;
import com.qf.crm.workbench.service.ActivityService;

import java.util.List;
import java.util.Map;

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

    public PaginationVO<Activity> pageList(Map<String, Object> map) {
        
        //取得total
        int total = activityDao.getTotalByCondition(map);
        
        //取得dataList
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
        
        //创建一个vo对象，将total和datalist封装到vo中
        PaginationVO<Activity> vo = new PaginationVO<Activity>();
        vo.setTotal(total);
        vo.setDataList(dataList);
        
        //将vo返回
        return vo;
    }
}
