package com.github.kazim3k.ad;

import com.github.kazim3k.category.Category;

public class AdDto {

    private Long id;
    private String header;
    private StringBuilder content;
    private String categoryName;

    public AdDto(Long id, String header, StringBuilder content, String categoryName) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.categoryName = categoryName;
    }

    public AdDto (Ad ad) {
        this.id = ad.getId();
        this.header = ad.getHeader();
        this.content = ad.getContent();
        this.categoryName = ad.getCategory().getName();
    }

    public Long getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public StringBuilder getContent() {
        return content;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
