package com.github.kazim3k.ad;


import java.util.Set;

public interface AdService {

    Set<AdDto> findAll();
    Set<AdDto> findAllByCategoryId(Long categoryId);
    void create(String header, StringBuilder content, Long categoryId);
}
