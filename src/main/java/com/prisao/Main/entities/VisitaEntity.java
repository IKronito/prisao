package com.prisao.Main.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visita")
public class VisitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Visitante não pode estar em branco")
    private String visitante;

    @NotNull(message = "Data e hora da visita não podem ser nulas")
    private LocalDateTime dataHoraVisita;

    @ManyToOne
    @JoinColumn(name = "preso_id")
    @JsonBackReference
    private PresoEntity preso;
}
