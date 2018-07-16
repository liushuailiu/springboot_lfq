package com.baizhi.lfq.service;

import com.baizhi.lfq.dao.LoggingDao;
import com.baizhi.lfq.entity.Logging;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 14832 on 2018/7/9.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class LoggongServiceImpl implements LoggingService {
    @Resource
    LoggingDao loggingDao;
    @Override
    public List<Logging> queryAllLogging() {
        List<Logging> loggings = loggingDao.selectAllLogging();
        return loggings;
    }

    @Override
    @Transactional
    public void insertOneLogging(Logging logging) {
        System.out.println(logging);
        loggingDao.insertOneLogging(logging);
    }
}
