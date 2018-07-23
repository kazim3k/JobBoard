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
    void create(@RequestParam Long categoryId, @RequestParam String header, @RequestParam StringBuilder content) {
        adService.create(header, content, categoryId);
    }

    @GetMapping
    Set<Ad> findAll(){
        return adService.findAll();
    }

    @GetMapping("/{com.github.kazim3k.category}")
    Set<Ad> findAllByCategory(@PathVariable Long categoryId){
        return adService.findAllByCategoryId(categoryId);
    }
}

