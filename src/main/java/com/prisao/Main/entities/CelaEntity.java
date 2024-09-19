package com.prisao.Main.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cela")
public class CelaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String descricao;
    private int capacidade;
    private String localizacao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cela_presos",
            joinColumns = @JoinColumn(name = "cela_id"),
            inverseJoinColumns = @JoinColumn(name = "preso_id")
    )
    private List<PresoEntity> presos = new ArrayList<>();
}
