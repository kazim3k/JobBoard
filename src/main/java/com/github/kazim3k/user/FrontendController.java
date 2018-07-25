package com.github.kazim3k.user;

import com.github.kazim3k.dto.CreateUserDto;
import com.github.kazim3k.dto.PostAdDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/views")
public class FrontendController {

    @RequestMapping("/admin")
    public ModelAndView admin(Model model){
        return new ModelAndView("/admin.html");
    }

    @RequestMapping("/user")
    public String user(Model model){

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
