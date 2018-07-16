package com.baizhi.lfq.dao;

import com.baizhi.lfq.entity.Logging;

import java.util.List;

/**
 * Created by 14832 on 2018/7/9.
 */
public interface LoggingDao {
    //查所有日志
    public List<Logging> selectAllLogging();
    //添加
    public void insertOneLogging(Logging logging);
}
