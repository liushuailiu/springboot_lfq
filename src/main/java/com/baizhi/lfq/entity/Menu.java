package com.baizhi.lfq.entity;

import java.util.List;

/**
 * Created by 14832 on 2018/7/5.
 */
public class Menu {
    private String id;
    private String title;
    private String href;
    private String iconCls;
    private String parentId;

    //关系属性
    private List<Menu> children;

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                '}';
    }

    public Menu() {
    }

    public Menu(String id, String title, String href, String iconCls, String parentId, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.iconCls = iconCls;
        this.parentId = parentId;
        this.children = children;
    }
}
