package com.jarmisondev.liveryapi.config;

import com.jarmisondev.liveryapi.notificacao.Notificador;
import com.jarmisondev.liveryapi.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public AtivacaoClienteService ativacaoClienteService(Notificador notificador){
        return new AtivacaoClienteService(notificador);
    }
}
