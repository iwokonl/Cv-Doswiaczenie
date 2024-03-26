package com.example.taco.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class HomeCotroler {

    @GetMapping("/d")
    public String home(){
        return "1asd";
    }
}
