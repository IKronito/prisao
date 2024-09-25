package com.prisao.Main.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    @NotBlank(message = "Número da cela não pode estar em branco")
    private String numero;

    @NotBlank(message = "Descrição não pode estar em branco")
    private String descricao;

    @NotNull(message = "Capacidade não pode ser nula")
    private int capacidade;

    @NotBlank(message = "Localização não pode estar em branco")
    private String localizacao;

    @OneToMany(mappedBy = "cela", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PresoEntity> presos = new ArrayList<>();

    public CelaEntity(long l, String descrição, int i, String localização) {
    }
}
