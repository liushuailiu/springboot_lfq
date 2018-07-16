package com.baizhi.lfq.controller;

import com.baizhi.lfq.entity.Album;
import com.baizhi.lfq.entity.Chapter;
import com.baizhi.lfq.service.AlbumService;
import com.baizhi.lfq.service.ChapterService;
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
 * Created by 14832 on 2018/7/7.
 */
@Controller
@RequestMapping("album")
public class AlbumController {
    @Resource
    AlbumService albumService;
    @Resource
    ChapterService chapterService;

    @RequestMapping("queryAllAlbum")
    @ResponseBody
    public List<Album> queryAllAlbum(){
        List<Album> albums = albumService.queryAllAlbum();
        return albums;
    }

    @RequestMapping("insertOneAlbum")
    @ResponseBody
    public void insertOneAlbum(Album album){
        albumService.insertOneAlbum(album);
    }

    @RequestMapping("deleteOneAlbum")
    @ResponseBody
    public void deleteOneAlbum(String id){
        albumService.deleteOneAlbum(id);
    }



    @RequestMapping("insertOneChapter")
    @ResponseBody
    public  void insertOneChapter(Chapter chapter, MultipartFile music,HttpServletRequest request){
          /*
        * 1.文件传送位置
        * 2.文件覆盖
        * 3.上传
        * */
        String realPath = request.getSession().getServletContext().getRealPath("/");
        realPath=realPath+"mymusic";
        File file = new File(realPath);
        if(!file.exists()) {
            file.mkdir();
        }
        //旧的音乐名
        String originalFilename = music.getOriginalFilename();
        //拿到MP3 后缀名
        String extension = FilenameUtils.getExtension(originalFilename);
        UUID uuid = UUID.randomUUID();
        String s = uuid + "." + extension;
        String newName = realPath + "/" + s;
        try {
            music.transferTo(new File(newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        chapter.setUrl("/"+s);
        chapterService.insertOneChapter(chapter);
    }
}
