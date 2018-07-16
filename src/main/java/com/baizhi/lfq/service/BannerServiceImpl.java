package com.baizhi.lfq.service;

import com.baizhi.lfq.aop.LogAnnotation;
import com.baizhi.lfq.dao.BannerDao;
import com.baizhi.lfq.entity.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource
    BannerDao bannerDao;

    @Override
    @LogAnnotation(name = "查所有")
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Banner> querryAllBanner() {
        List<Banner> banners = bannerDao.selectAllBanner();
        return banners;
    }

    @Override
    public void insertOneBanner(Banner banner) {

        bannerDao.insertOneBanner(banner);
    }

    @Override
    public void deleteOneBanner(String id) {
        bannerDao.deleteOneBanner(id);
    }

    @Override
    public void updateOneBanner(Banner banner) {
        bannerDao.updateOneBanner(banner);
    }
}
