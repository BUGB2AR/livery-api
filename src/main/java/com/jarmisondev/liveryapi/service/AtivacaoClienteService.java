package com.jarmisondev.liveryapi.service;

import com.jarmisondev.liveryapi.modelo.Cliente;
import com.jarmisondev.liveryapi.notificacao.NivelUrgencia;
import com.jarmisondev.liveryapi.notificacao.Notificador;
import com.jarmisondev.liveryapi.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {
    @TipoDoNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente){
        cliente.ativar();
        notificador.notificar(cliente,"Seu cadastro foi ativo!");
    }
}
