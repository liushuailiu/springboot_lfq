package com.baizhi.lfq.service;


import com.baizhi.lfq.aop.LogAnnotation;
import com.baizhi.lfq.entity.Banner;

import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
public interface BannerService {
    //查所有
    public List<Banner> querryAllBanner();
    //添加
    public void insertOneBanner(Banner banner);
    //删除
    public void deleteOneBanner(String id);
    //修改
    public void updateOneBanner(Banner banner);
}
