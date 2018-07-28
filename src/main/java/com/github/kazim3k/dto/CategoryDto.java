package com.github.kazim3k.dto;

import com.github.kazim3k.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto {

    private Long id;
    private String name;
    private List<AdNoCategoryDto> ads;

    public CategoryDto(Long id, String name, List<AdNoCategoryDto> ads) {
        this.id = id;
        this.name = name;
        this.ads = ads;
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.ads = category.getAds().stream()
                .map(AdNoCategoryDto::new)
                .collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AdNoCategoryDto> getAds() {
        return ads;
    }
}
