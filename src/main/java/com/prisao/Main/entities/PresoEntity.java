package com.prisao.Main.entities;

import java.util.ArrayList;
import java.util.List;

import com.prisao.Main.enums.ComportamentoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "preso")

public class PresoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cpf;
	private String dataNasc;

	private String crime;
	private String sentenca;

	@Enumerated(EnumType.STRING)
	private ComportamentoEnum type;

	@Column(name = "comportamento")
	private String comportamento;

	@ManyToMany(mappedBy = "presos")
	private List<AgenteEntity> agentes = new ArrayList<>();
}
