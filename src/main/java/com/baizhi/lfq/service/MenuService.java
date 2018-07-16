package com.baizhi.lfq.service;

import com.baizhi.lfq.aop.LogAnnotation;
import com.baizhi.lfq.entity.Menu;

import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
public interface MenuService {
    //查所主菜单
    public List<Menu> queryAllMenu();
}
