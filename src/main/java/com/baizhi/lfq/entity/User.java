package com.baizhi.lfq.entity;

import java.util.Date;

/**
 * Created by 14832 on 2018/7/8.
 */
public class User {
    private String id;
    private String photo;
    private String dharmName;
    private String name;
    private String sex;
    private String privoince;
    private String city;
    private String sign;
    private String phoneNum;
    private String password;
    private String salt;
    private Date createTime;
    private Integer stauts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDharmName() {
        return dharmName;
    }

    public void setDharmName(String dharmName) {
        this.dharmName = dharmName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPrivoince() {
        return privoince;
    }

    public void setPrivoince(String privoince) {
        this.privoince = privoince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", photo='" + photo + '\'' +
                ", dharmName='" + dharmName + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", privoince='" + privoince + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", createTime=" + createTime +
                ", stauts=" + stauts +
                '}';
    }

    public User() {
    }

    public User(String id, String photo, String dharmName, String name, String sex, String privoince, String city, String sign, String phoneNum, String password, String salt, Date createTime, Integer stauts) {
        this.id = id;
        this.photo = photo;
        this.dharmName = dharmName;
        this.name = name;
        this.sex = sex;
        this.privoince = privoince;
        this.city = city;
        this.sign = sign;
        this.phoneNum = phoneNum;
        this.password = password;
        this.salt = salt;
        this.createTime = createTime;
        this.stauts = stauts;
    }
}
