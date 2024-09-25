package com.prisao.Main.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prisao.Main.enums.ComportamentoEnum;
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
@Table(name = "preso")
public class PresoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome não pode estar em branco")
	private String nome;

	@NotBlank(message = "CPF não pode estar em branco")
	private String cpf;

	@NotBlank(message = "Data de nascimento não pode estar em branco")
	private String dataNasc;

	@NotBlank(message = "Crime não pode estar em branco")
	private String crime;

	@NotBlank(message = "Sentença não pode estar em branco")
	private String sentenca;

	@NotNull(message = "Comportamento não pode ser nulo")
	@Enumerated(EnumType.STRING)
	private ComportamentoEnum comportamento;

	@ManyToOne
	@JoinColumn(name = "cela_id")
	@JsonBackReference
	private CelaEntity cela;

	@OneToMany(mappedBy = "preso", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<VisitaEntity> visitas = new ArrayList<>();
}
