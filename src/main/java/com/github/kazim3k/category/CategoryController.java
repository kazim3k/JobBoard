package com.github.kazim3k.category;


import com.github.kazim3k.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Set<CategoryDto> findAllBy() {
        return categoryService.findAll();
    }

    @GetMapping("/{name}")
    public Category findOneByName(@PathVariable String name) {
        return categoryService.findOneByName(name);
    }

    @PostMapping
    public void create(@RequestParam String name) {
        Category category = new Category();
        category.setName(name);
        categoryService.create(category);

    }

}
