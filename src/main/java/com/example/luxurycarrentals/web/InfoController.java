package com.example.luxurycarrentals.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {


    @GetMapping("/about")
    public String about() {

        return "about";
    }
}
