package com.baizhi.lfq.dao;

import com.baizhi.lfq.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
public interface MenuDao {
    //查所主菜单
    public List<Menu> selectAllMenu();
    //查所有子菜单
    public List<Menu> selectChildMenu(String id);
}
