package com.github.kazim3k.ad;


import com.github.kazim3k.dto.AdDto;
import com.github.kazim3k.dto.PostAdDto;

import java.util.Set;

public interface AdService {

    Set<AdDto> findAll();
    Set<AdDto> findAllByCategoryId(Long categoryId);
    void create(String header, String content, Long categoryId);
}
