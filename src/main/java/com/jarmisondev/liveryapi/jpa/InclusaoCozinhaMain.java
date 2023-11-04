package com.jarmisondev.liveryapi.jpa;

import com.jarmisondev.liveryapi.LiveryApiApplication;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class InclusaoCozinhaMain {
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext applicationContext =  new SpringApplicationBuilder(LiveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        cozinha1 = cadastroCozinha.salvar(cozinha1);
        cozinha2 = cadastroCozinha.salvar(cozinha2);

        System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
        System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
    }
}