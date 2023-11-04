package com.jarmisondev.liveryapi.jpa;

import com.jarmisondev.liveryapi.LiveryApiApplication;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ExclusaoCozinhaMain {
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext applicationContext =  new SpringApplicationBuilder(LiveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setId(1L);
        cadastroCozinha.remover(cozinha1);

    }
}
