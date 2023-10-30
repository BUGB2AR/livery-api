package com.jarmisondev.liveryapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeuPrimeiroController {
    @GetMapping
    public String helloWorld(){
        return "Olá Mundo";
    }
}
