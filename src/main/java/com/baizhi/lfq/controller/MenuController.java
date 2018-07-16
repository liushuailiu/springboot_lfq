package com.baizhi.lfq.controller;

import com.baizhi.lfq.entity.Menu;
import com.baizhi.lfq.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
@Controller
@RequestMapping("menu")
public class MenuController {
    @Resource
    MenuService menuService;

    @ResponseBody
    @RequestMapping("queryAllMenu")
    public List<Menu> queryAllMenu(){
        List<Menu> menus = menuService.queryAllMenu();
        return menus;
    }
}
