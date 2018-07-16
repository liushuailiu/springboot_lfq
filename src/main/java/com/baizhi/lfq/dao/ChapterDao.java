package com.baizhi.lfq.dao;

import com.baizhi.lfq.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 14832 on 2018/7/7.
 */
public interface ChapterDao {
    //根据id查所有章节
    public List<Chapter> selectOneChapter(@Param("ChapterId") String ChapterId);
    //添加
    public void insertOneChapter(Chapter chapter);


    //删除
    public void deleteOneChapter(String id);
    //修改
    public void updateOneChapter(Chapter chapter);
}
