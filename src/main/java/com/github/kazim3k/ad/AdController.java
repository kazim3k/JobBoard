package com.github.kazim3k.ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/ads")
public class AdController {

    private AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping
    void create(@RequestParam Long categoryId, @RequestParam String header, @RequestParam String content) {
        adService.create(header, content, categoryId);
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

