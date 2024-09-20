package com.prisao.Main.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prisao.Main.enums.ComportamentoEnum;

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
@Table(name = "preso")
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

	@ManyToOne
	@JoinColumn(name = "cela_id")
	@JsonBackReference
	private CelaEntity cela;
}
