package com.baizhi.lfq.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by 14832 on 2018/7/7.
 */
public class Album {
    private String id;
    private String title;
    private Double score;
    private String brodecast;
    private String author;
    private String description;
    private Date publicTime;
    private Integer count;
    private String coverImg;
    private Integer status;
    //关系属性

    private List<Chapter> children;

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getBrodecast() {
        return brodecast;
    }

    public void setBrodecast(String brodecast) {
        this.brodecast = brodecast;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", brodecast='" + brodecast + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publicTime=" + publicTime +
                ", count=" + count +
                ", coverImg='" + coverImg + '\'' +
                ", status=" + status +
                ", children=" + children +
                '}';
    }

    public Album(String id, String title, Double score, String brodecast, String author, String description, Date publicTime, Integer count, String coverImg, Integer status, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.brodecast = brodecast;
        this.author = author;
        this.description = description;
        this.publicTime = publicTime;
        this.count = count;
        this.coverImg = coverImg;
        this.status = status;
        this.children = children;
    }

    public Album(String id, String title, Double score, String brodecast, String author, String description, Date publicTime, Integer count, String coverImg, Integer status) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.brodecast = brodecast;
        this.author = author;
        this.description = description;
        this.publicTime = publicTime;
        this.count = count;
        this.coverImg = coverImg;
        this.status = status;
    }

    public Album() {
    }
}
