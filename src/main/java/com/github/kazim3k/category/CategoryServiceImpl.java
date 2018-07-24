package com.github.kazim3k.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<CategoryDto> findAll() {
        return categoryRepository.findAllBy().stream()
                .map(CategoryDto::new).collect(Collectors.toSet());
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }
}
