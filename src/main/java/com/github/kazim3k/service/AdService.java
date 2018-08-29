package com.github.kazim3k.service;


import com.github.kazim3k.dto.AdDto;

import java.util.Set;

public interface AdService {

    Set<AdDto> findAll();
    Set<AdDto> findAllByCategoryId(Long categoryId);
    Set<AdDto> findAllByUserLogin(String login);
    Long create(String header, String content, Long categoryId);
    void deleteById(Long adId);
}
