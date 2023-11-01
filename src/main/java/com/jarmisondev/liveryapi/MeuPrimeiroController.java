package com.jarmisondev.liveryapi;

import com.jarmisondev.liveryapi.modelo.Cliente;
import com.jarmisondev.liveryapi.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService){
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/ola")
    public String helloWorld(){
        Cliente joabe = new Cliente("Joabe","joabe@gmail.com","343242424324");
        ativacaoClienteService.ativar(joabe);
        return "Hello";
    }
}
