package com.freweyni.resourcemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "")
    public String home(){
        return "redirect:/Home/index";
    }
    @RequestMapping(value = "/Home/index")
    public String homedisplay(){
        return "Home/index";
    }

}
