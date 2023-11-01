package com.jarmisondev.liveryapi.notificacao;

import com.jarmisondev.liveryapi.modelo.Cliente;


public class NotificadorEmail implements Notificador {

    private boolean caixaAlta;
    private String hostSmtp;

    public NotificadorEmail(String hostSmtp){
        this.hostSmtp = hostSmtp;
        System.out.println("NotificacaoEmail");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){
        if (this.caixaAlta){
            mensagem = mensagem.toUpperCase();
        }

        System.out.printf("Notificando %s através do e-mail usando SMTP %s: %s\n",
                cliente.getNome(),cliente.getEmail(),this.hostSmtp + " " + mensagem);
    }

    public void setCaixaAlta(boolean caixaAlta) {
        this.caixaAlta = caixaAlta;
    }
}
