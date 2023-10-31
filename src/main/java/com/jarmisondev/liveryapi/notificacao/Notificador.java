package com.jarmisondev.liveryapi.notificacao;

import com.jarmisondev.liveryapi.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
