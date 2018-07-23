package com.github.kazim3k.ad;


import java.util.Set;

public interface AdService {

    Set<Ad> findAll();
    Set<Ad> findAllByCategoryId(Long categoryId);
    void create(String header, StringBuilder content, Long categoryId);
}
