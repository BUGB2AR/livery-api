package com.jarmisondev.liveryapi.service;

import com.jarmisondev.liveryapi.modelo.Cliente;
import com.jarmisondev.liveryapi.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private NotificadorEmail notificador;

    public AtivacaoClienteService(NotificadorEmail notificador){
        this.notificador = notificador;
        System.out.println("AtivacaoClienteService: " + notificador);
    }

    public void ativar(Cliente cliente){
        cliente.ativar();

        this.notificador.notificar(cliente,"Seu cadastro foi ativo!");
    }



}
