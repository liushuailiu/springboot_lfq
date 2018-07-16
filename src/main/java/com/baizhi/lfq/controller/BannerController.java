package com.baizhi.lfq.controller;

import com.baizhi.lfq.entity.Banner;
import com.baizhi.lfq.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by 14832 on 2018/7/5.
 */
@Controller
@RequestMapping("banner")
public class BannerController {
    @Resource
    BannerService bannerService;

    //查所有
    @RequestMapping("queryAllBanner")
    @ResponseBody
    public List<Banner> queryAllBanner(){
        List<Banner> banners = bannerService.querryAllBanner();
        return banners;
    }
    //添加
    @RequestMapping("insertOneBanner")
    @ResponseBody
    public void insertOneBanner(MultipartFile img,Banner banner,HttpServletRequest request){
        /*
        * 1.文件传送位置
        * 2.文件覆盖
        * 3.上传
        * */
        String realPath = request.getSession().getServletContext().getRealPath("/");
        realPath=realPath+"myimage";
        File file = new File(realPath);
        if(!file.exists()) {
            file.mkdir();
        }
        //旧的照片名
        String originalFilename = img.getOriginalFilename();
        //拿到jpg 后缀名
        String extension = FilenameUtils.getExtension(originalFilename);
        UUID uuid = UUID.randomUUID();
        String s = uuid + "." + extension;
        String newName = realPath + "/" + s;
        try {
            img.transferTo(new File(newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setPicPath("/"+s);
        bannerService.insertOneBanner(banner);
    }
    //删除
    @RequestMapping("deleteOneBanner")
    @ResponseBody
    public void deleteOneBanner(String id){
         bannerService.deleteOneBanner(id);
    }
    //查一个
    @RequestMapping("updateOneBanner")
    @ResponseBody
    //修改
    public void updateOneBanner(Banner banner){
        bannerService.updateOneBanner(banner);
    }

}
