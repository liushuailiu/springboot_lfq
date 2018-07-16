package com.baizhi.lfq.controller;

import com.baizhi.lfq.entity.Logging;
import com.baizhi.lfq.service.LoggingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14832 on 2018/7/9.
 */
@Controller
@RequestMapping("logging")
public class LoggingController {
    @Resource
    LoggingService loggingService;

    @RequestMapping("queryAllLogging")
    @ResponseBody
    public List<Logging> queryAllLogging(){
        List<Logging> loggings = loggingService.queryAllLogging();
        return loggings;
    }
}
