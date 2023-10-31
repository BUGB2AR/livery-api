package com.jarmisondev.liveryapi.notificacao;

import com.jarmisondev.liveryapi.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador {

    public NotificadorEmail(){
        System.out.println("NotificacaoEmail");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(),cliente.getEmail(),mensagem);
    }
}
