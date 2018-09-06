package com.github.kazim3k.controller;

import com.github.kazim3k.dto.AdDto;
import com.github.kazim3k.dto.CategoryDto;
import com.github.kazim3k.dto.CreateUserDto;
import com.github.kazim3k.dto.PostAdDto;
import com.github.kazim3k.service.AdService;
import com.github.kazim3k.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class FrontendController {

    private AdService adService;
    private CategoryService categoryService;

    @Autowired
    public FrontendController(AdService adService, CategoryService categoryService) {
        this.adService = adService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/admin")
    public ModelAndView admin(Model model){
        return new ModelAndView("/admin.html");
    }


    @GetMapping(value = {"/", ""})
    public String index(Model model){
        Set<AdDto> adDtos = adService.findAll();
        model.addAttribute("ads", adDtos);
        return "index";
    }


    @GetMapping(value = "/user")
    public String user(Model model){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Set<AdDto> adDtos = adService.findAllByUserLogin(login);
        model.addAttribute("ads", adDtos);
        return "user";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        Set<CategoryDto> categoryDtos = categoryService.findAll();
        model.addAttribute("categories", categoryDtos);
        return "categories";
    }

    @GetMapping("/categories/{name}")
    public String categoriesName(Model model,@PathVariable String name) {
        Set<AdDto> adDtos = adService.findAllByCategoryName(name);
        model.addAttribute("ads", adDtos);
        return "categoriesName";
    }

    @RequestMapping("/signup")
    public String signUp(Model model){

        model.addAttribute("dto", new CreateUserDto());
        return "SignUpForm";
    }

    @RequestMapping("/postAd")
    public String postAd(Model model){

        model.addAttribute("dto", new PostAdDto());
        return "PostAdForm";
    }

}
