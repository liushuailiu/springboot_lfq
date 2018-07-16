package com.baizhi.lfq.service;

import com.baizhi.lfq.entity.User;
import com.baizhi.lfq.entity.UserDTO;

import java.util.List;

/**
 * Created by 14832 on 2018/7/8.
 */
public interface UserService {
    //查所有用户
    public List<User> queryAllUser();
    //根据性别查省和人数
    public List<UserDTO> selectAllUserBySex(String sex);
}
