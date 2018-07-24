package com.github.kazim3k.category;


import java.util.Set;

public interface CategoryService {

    Set<CategoryDto> findAll();
    void create(Category category);
}
