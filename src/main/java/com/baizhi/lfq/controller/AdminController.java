package com.baizhi.lfq.controller;

import com.baizhi.lfq.entity.Admin;
import com.baizhi.lfq.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 14832 on 2018/7/5.
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Resource()
    AdminService adminService;

    @RequestMapping("Login")
    //登录
    public String Login(String enCode,String name,String password,HttpServletRequest httpServletRequest){
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        if(!enCode.equals(captchaId)){
            System.out.println("验证码不相等！");
            return "redirect:/login.jsp";
        }
        Admin admin = adminService.LoginAdmin(name, password);
        if (admin==null){
            System.out.println("密码错误！");
            return "redirect:/login.jsp";
        }else {
            httpServletRequest.getSession().setAttribute("user",admin);
            return "redirect:/main/main.jsp";
        }
    }
    //安全退出
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("name");
        return "redirect:/login.jsp";
    }
}
