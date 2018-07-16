package com.baizhi.lfq.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 14832 on 2018/7/9.
 */
public class Logging {
    private Integer id;
    private String name;
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String main;
    private String method;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Logging() {

    }

    public Logging(Integer id, String name, Date date, String main, String method) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.main = main;
        this.method = method;
    }

    @Override
    public String toString() {
        return "Logging{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", main='" + main + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
