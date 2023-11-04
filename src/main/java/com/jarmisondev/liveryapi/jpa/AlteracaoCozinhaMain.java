package com.jarmisondev.liveryapi.jpa;

import com.jarmisondev.liveryapi.LiveryApiApplication;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class AlteracaoCozinhaMain {
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext applicationContext =  new SpringApplicationBuilder(LiveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        cozinha.setNome("Brasileira");

        cozinhaRepository.adicionar(cozinha);
    }
}
