package com.baizhi.lfq.service;

import com.baizhi.lfq.dao.UserDao;
import com.baizhi.lfq.entity.User;
import com.baizhi.lfq.entity.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14832 on 2018/7/8.
 */
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public List<User> queryAllUser() {
        List<User> users = userDao.selectAllUser();
        return users;
    }

    @Override
    public List<UserDTO> selectAllUserBySex(String sex) {
        List<UserDTO> users = userDao.selectAllUserBySex(sex);
        return users;
    }
}
