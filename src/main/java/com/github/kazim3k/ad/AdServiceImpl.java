package com.github.kazim3k.ad;

import com.github.kazim3k.category.Category;
import com.github.kazim3k.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {

    private AdRepository adRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public AdServiceImpl(AdRepository adRepository, CategoryRepository categoryRepository) {
        this.adRepository = adRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<AdDto> findAll() {
        return adRepository.findAllBy().stream().map(AdDto::new).collect(Collectors.toSet());
    }

    @Override
    public Set<AdDto> findAllByCategoryId(Long categoryId) {

        return adRepository.findAllByCategoryId(categoryId).stream().map(AdDto::new).collect(Collectors.toSet());
    }

    @Override
    public void create(String header, StringBuilder content, Long categoryId) {
        Ad ad = new Ad();
        ad.setCategory(categoryRepository.findOne(categoryId));
        ad.setHeader(header);
        ad.setContent(content);
        adRepository.save(ad);

    }
}
