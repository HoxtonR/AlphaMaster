package com.hoxtonr.robot.upbitblog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class upbitBlog {
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("================================================").append("\n")
                .append("公告标题：").append(getTitle()).append(",").append("\n")
                .append("公告发布时间：").append(getUpdatedAt()).append(",").append("\n")
                .append("公告创建时间：").append(getCreatedAt()).append(",").append("\n")
                .append("================================================").append("\n");
        return sb.toString();
    }
}
