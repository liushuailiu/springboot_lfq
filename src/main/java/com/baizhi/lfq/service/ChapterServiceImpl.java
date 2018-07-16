package com.baizhi.lfq.service;

import com.baizhi.lfq.dao.ChapterDao;
import com.baizhi.lfq.entity.Chapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 14832 on 2018/7/11.
 */
@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements  ChapterService {
    @Resource
    ChapterDao chapterDao;

    @Override
    public void insertOneChapter(Chapter chapter) {
        chapterDao.insertOneChapter(chapter);

    }
}
