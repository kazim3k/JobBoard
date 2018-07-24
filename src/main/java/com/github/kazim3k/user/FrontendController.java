package com.github.kazim3k.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/views")
public class FrontendController {

    @RequestMapping("/admin")
    public ModelAndView admin(Model model){
        return new ModelAndView("/admin.html");
    }

    @RequestMapping("/user")
    public ModelAndView user(Model model){
        return new ModelAndView("/user.html");
    }

    @RequestMapping("/signup")
    public String signUp(Model model){

        model.addAttribute("dto", new CreateUserDto());
        return "SignUpForm";
    }

}
