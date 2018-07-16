package com.baizhi.lfq.service;

import com.baizhi.lfq.entity.Admin;

/**
 * Created by 14832 on 2018/7/5.
 */
public interface AdminService {
    //登录
    public Admin LoginAdmin(String name, String password);
}
