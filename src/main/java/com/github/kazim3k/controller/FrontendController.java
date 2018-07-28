package com.github.kazim3k.controller;

import com.github.kazim3k.dto.AdDto;
import com.github.kazim3k.dto.CreateUserDto;
import com.github.kazim3k.dto.PostAdDto;
import com.github.kazim3k.entity.Ad;
import com.github.kazim3k.entity.User;
import com.github.kazim3k.repository.AdRepository;
import com.github.kazim3k.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class FrontendController {

    private AdService adService;

    @Autowired
    public FrontendController(AdService adService) {
        this.adService = adService;

    }

    @RequestMapping("/admin")
    public ModelAndView admin(Model model){
        return new ModelAndView("/admin.html");
    }

    @RequestMapping("/login")
    public String login(Model model){

        return "login";
    }


    @GetMapping(value = "/user")
    public String user(Model model){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Set<AdDto> adDtos = adService.findAllByUserLogin(login);
        model.addAttribute("ads", adDtos);
        return "user";
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
