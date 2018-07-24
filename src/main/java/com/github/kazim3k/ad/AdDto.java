package com.github.kazim3k.ad;

public class AdDto {

    private Long id;
    private String header;
    private String content;
    private String categoryName;

    public AdDto(Long id, String header, String content, String categoryName) {
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

    public String getContent() {
        return content;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
