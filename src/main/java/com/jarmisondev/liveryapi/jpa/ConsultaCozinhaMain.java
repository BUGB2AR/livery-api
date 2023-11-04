package com.jarmisondev.liveryapi.jpa;

import com.jarmisondev.liveryapi.LiveryApiApplication;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext applicationContext =  new SpringApplicationBuilder(LiveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
        List<Cozinha> cozinhas = cadastroCozinha.listar();

        for (Cozinha cozinha: cozinhas){
            System.out.println(cozinha.getNome());
        }
    }
}
