package com.github.kazim3k.service;


import com.github.kazim3k.dto.CategoryDto;
import com.github.kazim3k.entity.Category;

import java.util.Set;

public interface CategoryService {

    Set<CategoryDto> findAll();
    void create(Category category);
    Category findOneByName(String name);
}
