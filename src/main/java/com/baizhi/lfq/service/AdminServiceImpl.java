package com.baizhi.lfq.service;

import com.baizhi.lfq.dao.AdminDao;
import com.baizhi.lfq.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 14832 on 2018/7/5.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin LoginAdmin(String name, String password) {
        Admin admin = adminDao.LoginAdmin(name, password);
        return admin;
    }
}
