package com.qf.crm.workbench.service;

import com.qf.crm.vo.PaginationVO;
import com.qf.crm.workbench.domain.Activity;

import java.util.Map;

public interface ActivityService {

    boolean save(Activity a);

    PaginationVO<Activity> pageList(Map<String, Object> map);
}
