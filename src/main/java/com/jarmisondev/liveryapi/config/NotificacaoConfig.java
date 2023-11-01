package com.jarmisondev.liveryapi.config;

import com.jarmisondev.liveryapi.notificacao.NotificadorEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoConfig {
    @Bean
    public NotificadorEmail notificadordeEmail(){
        NotificadorEmail notificador = new NotificadorEmail("smtp.example.com.br");
        notificador.setCaixaAlta(true);

        return notificador;
    }
}
