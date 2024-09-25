package com.prisao.Main.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "agente")
@Table(name = "agente")
public class AgenteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome não pode estar em branco")
	private String nome;

	@NotBlank(message = "Data de nascimento não pode estar em branco")
	private String dataNasc;

	@NotBlank(message = "CPF não pode estar em branco")
	private String cpf;

	@NotBlank(message = "Telefone não pode estar em branco")
	private String telefone;

	@NotBlank(message = "Cargo não pode estar em branco")
	@Column(name = "cargo")
	private String cargo;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "preso_agente",
			joinColumns = @JoinColumn(name = "agente_id"),
			inverseJoinColumns = @JoinColumn(name = "preso_id"))
	private List<PresoEntity> presos = new ArrayList<>();
}
