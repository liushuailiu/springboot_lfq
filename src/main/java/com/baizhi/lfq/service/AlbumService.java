package com.baizhi.lfq.service;

import com.baizhi.lfq.entity.Album;
import com.baizhi.lfq.entity.Chapter;

import java.util.List;

/**
 * Created by 14832 on 2018/7/7.
 */
public interface AlbumService {
    //查所有专辑
    public List<Album> queryAllAlbum();
    //添加专辑
    public void insertOneAlbum(Album album);
    //删除专辑
    public void deleteOneAlbum(String id);

}
