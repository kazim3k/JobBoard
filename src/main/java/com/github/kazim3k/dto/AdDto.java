package com.github.kazim3k.dto;

import com.github.kazim3k.ad.Ad;

public class AdDto {

    private Long id;
    private String header;
    private String content;
    private String categoryName;
    private String userEmail;

    public AdDto(Long id, String header, String content, String categoryName,String userEmail) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.categoryName = categoryName;
        this.userEmail = userEmail;
    }

    public AdDto (Ad ad) {
        this.id = ad.getId();
        this.header = ad.getHeader();
        this.content = ad.getContent();
        this.categoryName = ad.getCategory().getName();
        this.userEmail = ad.getUser().getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
