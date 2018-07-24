package com.github.kazim3k.ad;

public class AdNoCategoryDto {

    private Long id;
    private String header;
    private String content;

    public AdNoCategoryDto(Long id, String header, String content) {
        this.id = id;
        this.header = header;
        this.content = content;
    }

    public AdNoCategoryDto(Ad ad) {
        this.id = ad.getId();
        this.header = ad.getHeader();
        this.content = ad.getContent();
    }

    public Long getId() {
        return id;
    }

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
}
