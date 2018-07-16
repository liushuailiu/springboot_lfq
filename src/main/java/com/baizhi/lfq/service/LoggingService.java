package com.baizhi.lfq.service;

import com.baizhi.lfq.dao.LoggingDao;
import com.baizhi.lfq.entity.Logging;

import java.util.List;

/**
 * Created by 14832 on 2018/7/9.
 */

public interface LoggingService {
    //查所有日志
    public List<Logging> queryAllLogging();
    //添加
    public void insertOneLogging(Logging logging);
}
