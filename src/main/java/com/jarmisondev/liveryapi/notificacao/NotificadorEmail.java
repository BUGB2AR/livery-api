package com.jarmisondev.liveryapi.notificacao;

import com.jarmisondev.liveryapi.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
@TipoDoNotificador(NivelUrgencia.URGENTE)
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem){


        System.out.printf("Notificando %s através do e-mail usando SMTP %s: %s\n",
                cliente.getNome(),cliente.getEmail(),mensagem);
    }

}
