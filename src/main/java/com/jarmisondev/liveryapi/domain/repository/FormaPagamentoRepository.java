package com.jarmisondev.liveryapi.domain.repository;

import com.jarmisondev.liveryapi.domain.model.FormaPagamento;
import java.util.List;

public interface FormaPagamentoRepository {
    List<FormaPagamento> todos();
    void remover(FormaPagamento formaPagamento);
    FormaPagamento adicionar(FormaPagamento formaPagamento);
    FormaPagamento porId(Long id);
}
