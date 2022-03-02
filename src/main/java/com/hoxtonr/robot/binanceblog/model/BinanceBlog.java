package com.hoxtonr.robot.binanceblog.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class BinanceBlog {
    private String brief;
    private String title;
    private Long postTime;
    private String picUrl;
    private Long id;
    private Long createTime;

    public LocalDateTime getCreateTime() {
        Instant ins = Instant.ofEpochMilli(createTime);
        return LocalDateTime.ofInstant(ins, ZoneId.systemDefault());
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPostTime() {
        Instant ins = Instant.ofEpochMilli(postTime);
        return LocalDateTime.ofInstant(ins, ZoneId.systemDefault());
    }

    public void setPostTime(Long postTime) {
        this.postTime = postTime;
    }

    public String getPicUrl() {
        return picUrl.replace("\"bannerUrl\":","").replaceAll("\"","")
                .replace("{","").replace("}","");
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("================================================").append("\n")
                .append("公告标题：").append(getTitle()).append(",").append("\n")
                .append("公告摘要：").append(getBrief()).append(",").append("\n")
                .append("公告发布时间：").append(getPostTime()).append(",").append("\n")
                .append("公告创建时间：").append(getCreateTime()).append(",").append("\n")
                .append("公告封面：").append(getPicUrl()).append("\n")
                .append("================================================").append("\n");
        return sb.toString();
    }
}
