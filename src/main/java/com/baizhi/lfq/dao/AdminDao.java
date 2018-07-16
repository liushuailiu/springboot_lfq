package com.baizhi.lfq.dao;

import com.baizhi.lfq.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 14832 on 2018/7/5.
 */
public interface AdminDao {
    //登录
    public Admin LoginAdmin(@Param("name") String name, @Param("password") String password);
}
