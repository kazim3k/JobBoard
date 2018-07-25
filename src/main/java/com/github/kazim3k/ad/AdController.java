package com.github.kazim3k.ad;

import com.github.kazim3k.category.CategoryRepository;
import com.github.kazim3k.dto.AdDto;
import com.github.kazim3k.dto.PostAdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/ads")
public class AdController {

    private AdService adService;
    private CategoryRepository categoryRepository;

    @Autowired
    public AdController(AdService adService, CategoryRepository categoryRepository) {
        this.adService = adService;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    void create( PostAdDto postAdDto) {
        adService.create(postAdDto.getHeader(), postAdDto.getContent(),
                categoryRepository.findOneByName(postAdDto.getCategoryName()).getId() );
    }

    @GetMapping
    Set<AdDto> findAll(){
        return adService.findAll();
    }

    @GetMapping("/{categoryId}")
    Set<AdDto> findAllByCategory(@PathVariable Long categoryId){
        return adService.findAllByCategoryId(categoryId);
    }


}

