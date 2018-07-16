package com.baizhi.lfq.service;

import com.baizhi.lfq.dao.MenuDao;
import com.baizhi.lfq.entity.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
@Service("menuService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class MenuServiceImpl implements MenuService {
    @Resource
    MenuDao menuDao;
    @Override
    public List<Menu> queryAllMenu() {
        List<Menu> menus = menuDao.selectAllMenu();
        return menus;
    }

}
