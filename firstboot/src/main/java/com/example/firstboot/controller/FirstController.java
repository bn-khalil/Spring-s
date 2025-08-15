package com.example.firstboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @GetMapping("/home/{name}")
    public String home(@RequestParam String name,
                       @RequestParam String lastname,
                       Model page ) {
        page.addAttribute("name", name);
//        page.addAttribute("lastname", lastname);/
        return ("render.html");
    }
}
