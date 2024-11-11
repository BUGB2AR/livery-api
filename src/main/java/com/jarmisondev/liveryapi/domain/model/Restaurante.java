package com.jarmisondev.liveryapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn(name = "cozinha_id",nullable = false)
    @JsonIgnore
    private Cozinha cozinha;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id", nullable = false)
    private FormaPagamento formaPagamento;




}
