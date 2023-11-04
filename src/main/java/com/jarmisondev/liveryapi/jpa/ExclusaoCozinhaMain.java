package com.jarmisondev.liveryapi.jpa;

import com.jarmisondev.liveryapi.LiveryApiApplication;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ExclusaoCozinhaMain {
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext applicationContext =  new SpringApplicationBuilder(LiveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setId(1L);
        cozinhaRepository.remover(cozinha1);

    }
}
