package com.jarmisondev.liveryapi.service;

import com.jarmisondev.liveryapi.modelo.Cliente;
import com.jarmisondev.liveryapi.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AtivacaoClienteService {
    @Autowired
    private Notificador notificador;


    public void ativar(Cliente cliente){
        cliente.ativar();
        notificador.notificar(cliente,"Seu cadastro foi ativo!");
    }
}
