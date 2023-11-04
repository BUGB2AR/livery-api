package com.jarmisondev.liveryapi.notificacao;

import com.jarmisondev.liveryapi.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sms")
public class NotificadorSMS implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.printf("Notificando %s por SMS atráves do telefone %s: %s\n",
                cliente.getNome(),cliente.getEmail(),mensagem);
    }

}
