package com.jarmisondev.liveryapi.notificacao;

import com.jarmisondev.liveryapi.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("dev")
@Component
@TipoDoNotificador(NivelUrgencia.URGENTE)
public class NotificadorEmailMock implements Notificador {

    public NotificadorEmailMock(){
        System.out.println("NOTIFICANDO PELO MOCK");
    }
    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.printf("MOCK: Notificando %s através do e-mail usando SMTP %s: %s\n",
                cliente.getNome(),cliente.getEmail(),mensagem);
    }

}
