package com.github.kazim3k.category;


import com.github.kazim3k.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {

    Set<CategoryDto> findAll();
    void create(Category category);
    Category findOneByName(String name);
}
