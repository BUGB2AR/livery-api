package com.jarmisondev.liveryapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cozinhas")
@Getter
@Setter
@EqualsAndHashCode
public class Cozinha {
    @Id
    private Long id;
    @Column(name = "nom_cozinha")
    private String nome;


}
