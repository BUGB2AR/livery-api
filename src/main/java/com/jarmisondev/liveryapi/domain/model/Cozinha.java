package com.jarmisondev.liveryapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "cozinha")
    //@JsonIgnore
    private List<Restaurante> restaurantes = new ArrayList<>();

}
