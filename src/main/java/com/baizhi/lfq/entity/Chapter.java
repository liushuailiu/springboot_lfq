package com.baizhi.lfq.entity;

import java.util.Date;

/**
 * Created by 14832 on 2018/7/7.
 */
public class Chapter {
    private String id;
    private String title;
    private String url;
    private Double size;
    private Date length;
    private Date times;
    private Date cerateTime;
    private String albumId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Date getLength() {
        return length;
    }

    public void setLength(Date length) {
        this.length = length;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Date getCerateTime() {
        return cerateTime;
    }

    public void setCerateTime(Date cerateTime) {
        this.cerateTime = cerateTime;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", length=" + length +
                ", times=" + times +
                ", cerateTime=" + cerateTime +
                ", albumId='" + albumId + '\'' +
                '}';
    }

    public Chapter(String id, String title, String url, Double size, Date length, Date times, Date cerateTime, String albumId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.size = size;
        this.length = length;
        this.times = times;
        this.cerateTime = cerateTime;
        this.albumId = albumId;
    }

    public Chapter() {
    }
}