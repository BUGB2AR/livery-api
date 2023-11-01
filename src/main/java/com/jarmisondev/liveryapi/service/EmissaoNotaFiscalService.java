package com.jarmisondev.liveryapi.service;

import com.jarmisondev.liveryapi.modelo.Cliente;
import com.jarmisondev.liveryapi.modelo.Produto;
import com.jarmisondev.liveryapi.notificacao.Notificador;

public class EmissaoNotaFiscalService {
    private Notificador notificador;

    public EmissaoNotaFiscalService(Notificador notificador){
        this.notificador = notificador;
    }

    public void emitir(Cliente cliente, Produto produto){
        // TODO emite a nota fiscal aqui........

        this.notificador.notificar(cliente,"Nota fiscal do produto " + produto.getNome() + "foi emitida!");
    }
}
