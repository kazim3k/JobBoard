package com.github.kazim3k.dto;

import com.github.kazim3k.category.Category;
import com.github.kazim3k.user.User;

public class PostAdDto {

    private String header;
    private String content;
    private String categoryName;


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
