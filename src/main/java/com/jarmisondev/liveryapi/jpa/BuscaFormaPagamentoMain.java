package com.jarmisondev.liveryapi.jpa;

import com.jarmisondev.liveryapi.LiveryApiApplication;
import com.jarmisondev.liveryapi.domain.model.Cozinha;
import com.jarmisondev.liveryapi.domain.model.FormaPagamento;
import com.jarmisondev.liveryapi.domain.repository.CozinhaRepository;
import com.jarmisondev.liveryapi.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.List;

public class BuscaFormaPagamentoMain {
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext applicationContext =  new SpringApplicationBuilder(LiveryApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository cozinhaRepository = applicationContext.getBean(FormaPagamentoRepository.class);
        List <FormaPagamento> formaPagamentos = cozinhaRepository.todos();

        for (FormaPagamento fp: formaPagamentos){
            System.out.println(fp.getId());
            System.out.println(fp.getDescricao());
        }
    }
}
