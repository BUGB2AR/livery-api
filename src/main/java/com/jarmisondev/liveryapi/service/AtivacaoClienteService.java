package com.jarmisondev.liveryapi.service;

import com.jarmisondev.liveryapi.modelo.Cliente;
import com.jarmisondev.liveryapi.notificacao.Notificador;
import com.jarmisondev.liveryapi.notificacao.NotificadorEmail;

public class AtivacaoClienteService {

    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador){
        this.notificador = notificador;
        System.out.println("AtivacaoClienteService: " + notificador);
    }

    public void ativar(Cliente cliente){
        cliente.ativar();

        this.notificador.notificar(cliente,"Seu cadastro foi ativo!");
    }



}
