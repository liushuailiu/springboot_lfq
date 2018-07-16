package com.baizhi.lfq.service;

import com.baizhi.lfq.aop.LogAnnotation;
import com.baizhi.lfq.dao.AlbumDao;
import com.baizhi.lfq.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 14832 on 2018/7/7.
 */
@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    AlbumDao albumDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> queryAllAlbum() {
        List<Album> albums = albumDao.selectAllAlbum();
        return albums;
    }

    @Override
    public void insertOneAlbum(Album album) {
        albumDao.insertOneAlbum(album);
    }

    @Override
    public void deleteOneAlbum(String id) {
        albumDao.deleteOneAlbum(id);
    }

}
