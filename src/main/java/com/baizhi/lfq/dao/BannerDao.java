package com.baizhi.lfq.dao;


import com.baizhi.lfq.entity.Banner;

import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
public interface BannerDao {
    //查所有
    public List<Banner> selectAllBanner();
    //添加
    public void insertOneBanner(Banner banner);
    //删除
    public void deleteOneBanner(String id);
    //修改
    public void updateOneBanner(Banner banner);
}
