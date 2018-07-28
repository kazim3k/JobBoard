package com.github.kazim3k.service.impl;

import com.github.kazim3k.entity.Ad;
import com.github.kazim3k.repository.AdRepository;
import com.github.kazim3k.repository.CategoryRepository;
import com.github.kazim3k.dto.AdDto;
import com.github.kazim3k.service.AdService;
import com.github.kazim3k.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {

    private AdRepository adRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    @Autowired
    public AdServiceImpl(AdRepository adRepository, CategoryRepository categoryRepository, UserRepository userRepository, UserRepository userRepository1) {
        this.adRepository = adRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<AdDto> findAll() {
        return adRepository.findAllBy().stream().map(AdDto::new).collect(Collectors.toSet());
    }

    @Override
    public Set<AdDto> findAllByCategoryId(Long categoryId) {

        return adRepository.findAllByCategoryId(categoryId).stream()
                .map(AdDto::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<AdDto> findAllByUserLogin(String login) {
        return adRepository.findAllByUserLogin(login).stream().
                map(AdDto::new).
                collect(Collectors.toSet());
    }

    @Override
    public void create(String header, String content, Long categoryId) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Ad ad = new Ad();
        ad.setCategory(categoryRepository.findOne(categoryId));
        ad.setHeader(header);
        ad.setContent(content);
        ad.setUser(userRepository.findOneByLogin(login));
        adRepository.save(ad);
    }
}
