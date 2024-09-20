package com.prisao.Main.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "cela", cascade = CascadeType.ALL)
    @JsonManagedReference // Prevê a serialização da lista de presos
    private List<PresoEntity> presos = new ArrayList<>();
}
