package com.jarmisondev.liveryapi.notificacao;

import com.jarmisondev.liveryapi.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("prod")
@Component
@TipoDoNotificador(NivelUrgencia.URGENTE)
public class NotificadorEmail implements Notificador {

    public NotificadorEmail(){
        System.out.println("NOTIFICANDO PELO PROD");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.printf("Notificando %s através do e-mail usando SMTP %s: %s\n",
                cliente.getNome(),cliente.getEmail(),mensagem);
    }

}
